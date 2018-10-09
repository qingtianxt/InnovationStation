package front.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import sist.bean.GlobalSearchPage;
import sist.bean.NewsPaging;
import sist.bean.PagingBean;
import sist.dao.NewsDao;
import sist.domain.NewsBean;
import sist.factory.BasicFactory;
import sist.service.NewsService;
import sist.utils.MarkKeyWords;
import sist.utils.StringUtil;

/**
 * Servlet implementation class NewsServlet
 */
@WebServlet(name = "front/news/newsServlet", urlPatterns = { "/front/news/newsServlet" })
public class NewsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String method = request.getParameter("method");
		if("list".equals(method)){
			list(request,response);
		}else if("visit".equals(method)){
			visit(request,response);
		}else if("search".equals(method)){
			search(request,response);
		}
	}

	private void search(HttpServletRequest request, HttpServletResponse response) throws IOException {
		PagingBean pagingBean = new GlobalSearchPage();
		try {
			BeanUtils.populate(pagingBean, request.getParameterMap());
		} catch (IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}
		NewsService service = BasicFactory.getFactory().getService(NewsService.class);
		List<NewsBean> list = service.search(pagingBean);
		Gson gson = new Gson();
		JsonObject jsonObject = gson.toJsonTree(pagingBean).getAsJsonObject();
		jsonObject.add("list", gson.toJsonTree(list));
		response.getWriter().println(jsonObject);
	}

	/**
	 * 用户在前台点击访问了某条信息
	 */
	private void visit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = StringUtil.StringToInt(request.getParameter("id"));
		NewsDao dao = BasicFactory.getFactory().getDao(NewsDao.class);
		NewsBean newsBean = dao.findById(id);
		if(newsBean!=null){
			int hits = newsBean.getHits();
			newsBean.setHits(hits+1);
			dao.updateNews(newsBean);
		}
		String key = request.getParameter("key");
		MarkKeyWords.Mark(newsBean, key);
		request.setAttribute("newsBean", newsBean);
		request.getRequestDispatcher("detail.jsp").forward(request, response);
	}

	private void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		NewsPaging newsPaging = new NewsPaging();
		try {
			BeanUtils.populate(newsPaging, request.getParameterMap());
			// 调用业务成的相关方法
			NewsService service = BasicFactory.getFactory().getService(NewsService.class);
			List<NewsBean> list = service.getList(newsPaging);
			String result = request.getParameter("result");
			if("json".equals(result)){
				Gson gson = new Gson();
				JsonObject jsonObject = gson.toJsonTree(newsPaging).getAsJsonObject();
				jsonObject.add("data", gson.toJsonTree(list));
				response.getWriter().println(jsonObject);
				return;
			}
			request.setAttribute("newsPaging", newsPaging);
			request.setAttribute("newsBeans", list);
			request.getRequestDispatcher("news.jsp").forward(request, response);
		} catch (IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

}
