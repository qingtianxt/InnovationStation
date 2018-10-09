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

import sist.bean.CoopSitePage;
import sist.domain.CoopSite;
import sist.factory.BasicFactory;
import sist.service.CoopSiteService;

/**
 * Servlet implementation class SiteServlet
 */
@WebServlet("/front/site/siteServlet")
public class SiteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String method = request.getParameter("method");
		if("list".equals(method)){
			list(request,response);
		}
	}


	private void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CoopSitePage sitePage = new CoopSitePage();
		try {
			BeanUtils.populate(sitePage, request.getParameterMap());
		} catch (IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}
		CoopSiteService service = BasicFactory.getFactory().getService(CoopSiteService.class);
		List<CoopSite> list = service.getList(sitePage);
		request.setAttribute("pagingBean", sitePage);
		request.setAttribute("sites", list);
		request.getRequestDispatcher("main.jsp").forward(request, response);
	}

}
