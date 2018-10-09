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
			response.getWriter().println("��ѡ�������...");
		}
	}

	private void checkName(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String title = request.getParameter("title");
		NewsService service = BasicFactory.getFactory().getService(NewsService.class);
		boolean b = service.checkTitle(title);
		
		response.getWriter().print(b);
	}

	/**
	 * ͨ��idɾ��һ�����ż�¼
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
	 * ��ȡһ������
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
	 * ��ȡ������Ϣ����
	 */
	private void getList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String result = request.getParameter("result");
		NewsPaging newsPaging = new NewsPaging();
		try {
			int msg = StringUtil.StringToInt(request.getParameter("msg"));
			if(msg==0){
				// ���msg����0����ô�������ǳ�ҳ�淢����
				// ��װ��ҳ�洫�ݶ����Ĳ�ѯ����
				BeanUtils.populate(newsPaging, request.getParameterMap());
			}else{
				// ���msg������0����ô�������Ǵ�servletת������
				// ��ȡ��һ�ε��ô˷����Ǵ����session�еĲ�ѯ����
				Object page = request.getSession().getAttribute("newsPaging");
				if(page!=null)
					newsPaging = (NewsPaging) page;
			}
			// ����ҵ��ɵ���ط���
			NewsService service = BasicFactory.getFactory().getService(NewsService.class);
			List<NewsBean> list = service.getList(newsPaging);
			
			if("list".equals(result)){
				// ת������ʾҳ��
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
	 * ��������޸�һ������
	 */
	private void saveOrUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String result = request.getParameter("result");
		
		NewsBean newsBean = new NewsBean();
		try {
			// ��װ����
			BeanUtils.populate(newsBean, request.getParameterMap());
			NewsService service = BasicFactory.getFactory().getService(NewsService.class);
			// ����ҵ���߼�����
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
