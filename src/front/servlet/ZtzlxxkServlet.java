package front.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

import sist.bean.CgalPagingBean;
import sist.domain.cgal;
import sist.factory.BasicFactory;
import sist.service.cgalService;
import sist.utils.StringUtil;

/**
 * Servlet implementation class ZtzlxxkServlet
 */
@WebServlet("/front/ztzl/ZtzlxxkServlet")
public class ZtzlxxkServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String method = request.getParameter("method");
		
		if("search".equals(method)){
			search(request,response);
		}else if("visit".equals(method)){
			visit(request,response);
		}
	}

	private void search(HttpServletRequest request, HttpServletResponse response) {
		String key = request.getParameter("key");
		if (key.equals("") || key == null) {
			try {
				PrintWriter out = response.getWriter();

				out.println(JSON.toJSON(null));

			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {

			cgalService cs = BasicFactory.getFactory().getService(cgalService.class);
			int currentPage = StringUtil.StringToInt(request.getParameter("currentPage"));
			if (currentPage == 0) {
				currentPage = 1;
			}
			CgalPagingBean page = new CgalPagingBean();
			page.setCurrentPage(currentPage);

			page.setMc(key);

			try {
				page = cs.search(page);

				String preUrl = request.getContextPath() + "/front/cgalFrontServlet?method=search&key=" + key;

				PrintWriter out = response.getWriter();
				page.setAnd(true);
				page.setPreUrl(preUrl);
				Object json = JSON.toJSON(page);
				out.print(json);
				out.flush();
				out.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	private void visit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = StringUtil.StringToInt(request.getParameter("id"));
		cgalService service = BasicFactory.getFactory().getService(cgalService.class);
		cgal Cgal=null;
		try {
			Cgal = service.getById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("cgal", Cgal);
		request.getRequestDispatcher("/front/cgal/cgal.jsp").forward(request, response);
	}

/*	private void search(HttpServletRequest request, HttpServletResponse response) throws IOException {
		GlobalSearchPage page = new GlobalSearchPage();
		try {
			BeanUtils.populate(page, request.getParameterMap());
		} catch (IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}
//		ZtzlxxkService service = BasicFactory.getFactory().getService(ZtzlxxkService.class);
		cgalService cgalService = BasicFactory.getFactory().getService(cgalService.class);
		List<cgal> search = cgalService.search(page);
//		List<Ztzlxxk> list = service.search(page);
		Gson gson = new Gson();
		JsonObject object = gson.toJsonTree(page).getAsJsonObject();
		object.add("list", gson.toJsonTree(search));
		response.getWriter().println(object);
	}*/
	

}
