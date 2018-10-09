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
import sist.factory.BasicFactory;
import sist.service.cgalService;
import sist.utils.StringUtil;

/**
 * Servlet implementation class cgalFrontServlet
 */
@WebServlet("/front/cgalFrontServlet")
public class cgalFrontServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");

		String method = request.getParameter("method");
		if ("search".equals(method)) {
			search(request, response);
		} else if ("addUI".equals(method)) {
			//addUI(request, response);
		} 
	}
	/**
	 * Ä£ºý²éÑ¯
	 * @param request
	 * @param response
	 */
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

//				int i = 0;
//				for (kjcg j : page.getList()) {
//					i++;
//					System.out.println(i + "---" + j.toString());
//				}

				String preUrl = request.getContextPath() + "/front/cgalFrontServlet?method=search&key=" + key;

				PrintWriter out = response.getWriter();
				/*
				 * out.println("{'and':" + JSON.toJSONString(true) +
				 * ",'totalPage':" + JSON.toJSONString(page.getTotalPage()) +
				 * ",'preUrl':" + JSON.toJSONString(preUrl) + ",'pageSize':" +
				 * JSON.toJSONString(page.getCurrentPage()) + ",'totalCount':" +
				 * JSON.toJSONString(page.getTotalCount()) + ",'key':" +
				 * JSON.toJSONString(key) + ",'list':" +
				 * JSON.toJSONString(page.getList()) + "}");
				 */
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
	
}
