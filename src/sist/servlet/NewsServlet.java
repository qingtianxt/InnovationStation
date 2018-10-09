package sist.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import sist.bean.NewsPaging;
import sist.domain.NewsBean;
import sist.factory.BasicFactory;
import sist.service.NewsService;
import sist.utils.StringUtil;

/**
 * Servlet implementation class NewsServlet
 */
@WebServlet("/back/news/newsServlet")
public class NewsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String method = request.getParameter("method");
		
		if("save".equals(method)){
			saveOrUpdate(request,response);
		}else if("list".equals(method)){
			getList(request,response);
		}else if("get".equals(method)){
			getNews(request,response);
		}else if("del".equals(method)){
			delNews(request,response);
		}else if("checkName".equalsIgnoreCase(method)){
			checkName(request,response);
		}
		else{
			response.getWriter().println("请选择操作项...");
		}
	}

	private void checkName(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String title = request.getParameter("title");
		NewsService service = BasicFactory.getFactory().getService(NewsService.class);
		boolean b = service.checkTitle(title);
		
		response.getWriter().print(b);
	}

	/**
	 * 通过id删除一条新闻纪录
	 */
	private void delNews(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		int id = StringUtil.StringToInt(request.getParameter("id"));
		NewsService service = BasicFactory.getFactory().getService(NewsService.class);
		boolean f = service.delById(id);
		String result = request.getParameter("result");
		if("json".equals(result)){
			response.getWriter().print(f);
		}else if("list".equals(result)){
			request.getRequestDispatcher("newsServlet?method=list&msg="+(f?3:4)).forward(request, response);;
		}
	}

	/**
	 * 获取一条新闻
	 */
	private void getNews(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = StringUtil.StringToInt(request.getParameter("id"));
		NewsService service = BasicFactory.getFactory().getService(NewsService.class);
		NewsBean newsBean = service.getNews(id);
		String result = request.getParameter("result");
		if("json".equals(result)){
			// 
		}else if("detail".equals(result)){
			request.setAttribute("newsBean", newsBean);
			request.getRequestDispatcher("detail_news.jsp").forward(request, response);
		}else if("edit".equals(result)){
			request.setAttribute("newsBean", newsBean);
			request.getRequestDispatcher("add_news.jsp").forward(request, response);
		}
	}

	/**
	 * 获取新闻信息数组
	 */
	private void getList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String result = request.getParameter("result");
		NewsPaging newsPaging = new NewsPaging();
		try {
			int msg = StringUtil.StringToInt(request.getParameter("msg"));
			if(msg==0){
				// 如果msg等于0，那么次请求是冲页面发来的
				// 封装从页面传递而来的查询参数
				BeanUtils.populate(newsPaging, request.getParameterMap());
			}else{
				// 如果msg不等于0，那么此请求是从servlet转发而来
				// 获取上一次调用此方法是存放在session中的查询条件
				Object page = request.getSession().getAttribute("newsPaging");
				if(page!=null)
					newsPaging = (NewsPaging) page;
			}
			// 调用业务成的相关方法
			NewsService service = BasicFactory.getFactory().getService(NewsService.class);
			List<NewsBean> list = service.getList(newsPaging);
			
			if("list".equals(result)){
				// 转发到显示页面
				request.setAttribute("newsBeans", list);
				request.getSession().setAttribute("newsPaging", newsPaging);
				request.getRequestDispatcher("list_news.jsp").forward(request, response);
			}
			
		} catch (IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	/**
	 * 保存或者修改一条新闻
	 */
	private void saveOrUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String result = request.getParameter("result");
		
		NewsBean newsBean = new NewsBean();
		try {
			// 封装数据
			BeanUtils.populate(newsBean, request.getParameterMap());
			NewsService service = BasicFactory.getFactory().getService(NewsService.class);
			// 调用业务逻辑方法
			boolean f = service.saveOrUpdate(newsBean);
			if("add".equals(result)){
				request.getRequestDispatcher("add_news.jsp?msg="+(f?1:2)).forward(request, response);
			}else if("update".equals(result)){
				request.getRequestDispatcher("newsServlet?method=list&result=list&msg="+(f?1:2)).forward(request, response);
			}
		} catch (IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

}
