package front.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sist.domain.SpecialLibrary;
import sist.factory.BasicFactory;
import sist.service.SpeLibService;

/**
 * Servlet implementation class LibraryServlet
 */
@WebServlet(name = "libraryServlet", urlPatterns = { "/front/special_library/libraryServlet" })
public class LibraryServlet extends HttpServlet {
	
	private static final long serialVersionUID = -3982003307695772241L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String method = request.getParameter("method");
		if("list".equals(method)){
			list(request,response);
		}
	}

	private void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SpeLibService service = BasicFactory.getFactory().getService(SpeLibService.class);
		
		List<SpecialLibrary> list = service.getList(null);
		
		request.setAttribute("librarys", list);
		request.getRequestDispatcher("/front/patent/patentServlet?method=list").include(request, response);
		request.getRequestDispatcher("main.jsp").forward(request, response);
	}

}
