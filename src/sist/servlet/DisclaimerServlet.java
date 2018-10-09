package sist.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import sist.domain.Disclaimer;
import sist.factory.BasicFactory;
import sist.service.DisclaimerService;

/**
 * Servlet implementation class DisclaimerServlet
 */
@WebServlet("/back/disclaimer/disclaimerServlet")
public class DisclaimerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String method = request.getParameter("method");
		
		if("add".equals(method)){
			add(request,response);
		}
	}

	private void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Disclaimer disclaimer = new Disclaimer();
		try {
			 Map<String, String[]> map = request.getParameterMap();
			BeanUtils.populate(disclaimer,map);
		} catch (IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}
		DisclaimerService service = BasicFactory.getFactory().getService(DisclaimerService.class);
		boolean b = service.addOrUpdate(disclaimer);
		String result = request.getParameter("result");
		if("add".equals(result)){
			
			request.getRequestDispatcher("add.jsp?msg="+(b?1:2)).forward(request, response);
		}
	}

}
