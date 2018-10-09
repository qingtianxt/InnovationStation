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

import sist.bean.LibPageBean;
import sist.domain.SpecialLibrary;
import sist.factory.BasicFactory;
import sist.service.SpeLibService;
import sist.utils.StringUtil;

/**
 * Servlet implementation class LibarayServlet
 */
@WebServlet("/back/special_library/libraryServlet")
public class LibraryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SpeLibService service;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String method = request.getParameter("method");
		service = BasicFactory.getFactory().getService(SpeLibService.class);
		if("add".equals(method)){
			saveOrUpdate(request,response);
		}else if("list".equals(method)){
			list(request,response);
		}else if("getLib".equals(method)){
			getLibrary(request,response);
		}else if("del".equals(method)){
			delById(request,response);
		}else if("checkTitle".equals(method)){
			checkTitle(request,response);
		}
	}

	private void checkTitle(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String title = request.getParameter("title");
		boolean b = service.checkTitle(title);
		String result = request.getParameter("result");
		if("json".equals(result)){
			response.getWriter().print(b);
		}
	}

	private void delById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = StringUtil.StringToInt(request.getParameter("id"));
		boolean f = service.delById(id);
		request.getRequestDispatcher("libraryServlet?method=list&result=list&msg="+(f?3:4)).forward(request, response);
	}

	private void getLibrary(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = StringUtil.StringToInt(request.getParameter("id"));
		SpecialLibrary lib = service.getLibrary(id);
		request.setAttribute("library", lib);
		String result = request.getParameter("result");
		if("detail".equals(result)){
			request.getRequestDispatcher("detail.jsp").forward(request, response);
		}else if("edit".equals(result)){
			request.getRequestDispatcher("add_lib.jsp").forward(request, response);
		}
	}

	/**
	 * 专题库管理
	 * @param request
	 * @param response
	 */
	private void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LibPageBean page = new LibPageBean();
		int msg = StringUtil.StringToInt(request.getParameter("msg"));
		try {
			if(msg==0)
				BeanUtils.populate(page, request.getParameterMap());
			else{
				Object pagingBean = request.getSession().getAttribute("pagingBean");
				if(pagingBean!=null && pagingBean instanceof LibPageBean){
					page = (LibPageBean) pagingBean;
				}
			}
		} catch (IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}
		List<SpecialLibrary> list = service.getList(page);
		request.setAttribute("libraries", list);
		request.getSession().setAttribute("pagingBean", page);
		String result = request.getParameter("result");
		if("list".equals(result)){
			request.getRequestDispatcher("manage_lib.jsp").forward(request, response);
		}
	}

	/**
	 * 保存或者修改专题库信息
	 */
	private void saveOrUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SpecialLibrary lib = new SpecialLibrary();
		try {
			BeanUtils.populate(lib, request.getParameterMap());
		} catch (IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		boolean f = service.saveOrUpdate(lib);
		// 根据result参数判断跳转路径
		String result = request.getParameter("result");
		if("add".equals(result)){
			request.getRequestDispatcher("add_lib.jsp?msg="+(f?1:2)).forward(request, response);
		}else if("list".equals(result)){
			request.getRequestDispatcher("libraryServlet?method=list&result=list&msg="+(f?1:2)).forward(request, response);
		}
	}

}
