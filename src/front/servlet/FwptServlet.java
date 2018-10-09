package front.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.alibaba.fastjson.JSON;

import sist.bean.FwptPagingBean;
import sist.domain.Fwpt;
import sist.domain.kjcg;
import sist.factory.BasicFactory;
import sist.service.FwptService;
import sist.service.kjcgService;
import sist.utils.Constant;
import sist.utils.StringUtil;

/**
 * Servlet implementation class FwptServlet
 */
@WebServlet("/front/fwpt/FwptServlet")
public class FwptServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");

		String method = request.getParameter("method");
		if ("search".equals(method)) {
			search(request, response);
		} else if ("getTop".equals(method)) {
			getTop(request, response);
		}else if("getBykmAndMc".equals(method)){
			getBykmAndMc(request,response);
		}else if("getList".equals(method)){
			getList(request,response);
		}
	}
/**分页获取服务平台信息
 * 获取
 * @param request
 * @param response
 */
	private void getList(HttpServletRequest request, HttpServletResponse response) {

		FwptPagingBean page = new FwptPagingBean();
			try {
				BeanUtils.populate(page, request.getParameterMap());
				
				int currentPage = StringUtil.StringToInt(request.getParameter("currentPage"));
				if(currentPage ==0){
					currentPage = 1;
				}
				page.setCurrentPage(currentPage);
			} catch (IllegalAccessException | InvocationTargetException e) {
				e.printStackTrace();
			}

		FwptService fs = BasicFactory.getFactory().getService(FwptService.class);
		
		try {
			page =fs.getList(page);
			
			String url = request.getContextPath() + "/front/fwpt/FwptServlet?method=getList";
			page.setAnd(true);
			if (null != page.getMc() && !"".equals(page.getMc())) {
				url += "&mc="+page.getMc();
			}
			page.setPreUrl(url);
			request.getSession().setAttribute(Constant.FWPTPAGINGBEAN, page);

			request.getRequestDispatcher("fwpt_yzj.jsp").forward(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	
	}

	private void getBykmAndMc(HttpServletRequest request, HttpServletResponse response) {
		String mc = request.getParameter("mc");
		String km = request.getParameter("km");
		FwptService fs = BasicFactory.getFactory().getService(FwptService.class);
		try {
			Fwpt f=fs.getByKmAndMc(km,mc);
			request.setAttribute(Constant.FWPTBEAN, f);
			request.getRequestDispatcher("fwpt_info.jsp").forward(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
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

			FwptService fs = BasicFactory.getFactory().getService(FwptService.class);
			int currentPage = StringUtil.StringToInt(request.getParameter("currentPage"));
			if (currentPage == 0) {
				currentPage = 1;
			}
			FwptPagingBean page = new FwptPagingBean();
			page.setCurrentPage(currentPage);

			page.setMc(key);

			try {
				page = fs.search(page);

				// int i = 0;
				// for (kjcg j : page.getList()) {
				// i++;
				// System.out.println(i + "---" + j.toString());
				// }

				String preUrl = request.getContextPath() + "/front/fwpt/FwptServlet?method=search&key=" + key;

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

	private void getTop(HttpServletRequest request, HttpServletResponse response) {

		FwptService ks = BasicFactory.getFactory().getService(FwptService.class);
		try {
			List<Fwpt> list = ks.getTop();

			request.setAttribute(Constant.KJCGBEANS, list);
			// int i = 0;
			// for (kjcg j : list) {
			// i++;
			// System.out.println(i + "---" + j.toString());
			// }
			PrintWriter out = response.getWriter();
			out.println(JSON.toJSON(list));
			out.flush();
			out.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
