package sist.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

import sist.dao.OptionDao;
import sist.factory.BasicFactory;

/**
 * Servlet implementation class SelectionServlet
 */
@WebServlet("/back/selectionServlet")
public class SelectionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String method = request.getParameter("method");
		
		if("getJslbList".equals(method)){
			getJslbList(request,response);
		}else if("getJstxxsList".equals(method)){
			getJstxxsList(request,response);
		}
	}

	private void getJstxxsList(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String result = request.getParameter("result");
		OptionDao dao = BasicFactory.getFactory().getDao(OptionDao.class);
		List<Object[]> list = dao.getJstxxsList();
		if("json".equals(result)){
			String jsonString = JSON.toJSONString(list);
			response.getWriter().write(jsonString);
		}
	}

	private void getJslbList(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String result = request.getParameter("result");
		OptionDao dao = BasicFactory.getFactory().getDao(OptionDao.class);
		List<Object[]> list = dao.getJslbList();
		if("json".equals(result)){
			String jsonString = JSON.toJSONString(list);
			response.getWriter().write(jsonString);
		}else if("include".equals(result)){
			request.setAttribute("category", list);
		}
		
	}

}
