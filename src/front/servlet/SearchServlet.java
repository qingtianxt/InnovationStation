package front.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import sist.bean.GlobalSearchPage;
import sist.factory.BasicFactory;
import sist.service.SearchService;

/**
 * Servlet implementation class SearchServlet
 */
@WebServlet("/front/searchServlet")
@Deprecated
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SearchService service = BasicFactory.getFactory().getService(SearchService.class);
		
		GlobalSearchPage page = new GlobalSearchPage();
		try {
			BeanUtils.populate(page, request.getParameterMap());
		} catch ( Exception e) {
			e.printStackTrace();
		}
		Object search = service.search(page);
		response.getWriter().print(search);
	}

}
