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

import sist.bean.frontZjxxPagingBean;
import sist.bean.zjxxPagingBean;
import sist.domain.UserBean;
import sist.domain.zjxx;
import sist.factory.BasicFactory;
import sist.service.zjxxService;
import sist.utils.Constant;
import sist.utils.StringUtil;

/**
 * Servlet implementation class zjxxFrontServlet
 */
@WebServlet("/front/zjxx/zjxxFrontServlet")
public class zjxxFrontServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		String method = request.getParameter("method");
		if (!"".equals(method)) {
			if ("getFrontList".equals(method)) {
				getFrontList(request, response);
			} else if ("getById".equals(method)) {
				getById(request, response);
			} else if ("add".equals(method)) {
				add(request, response);
			} else if ("getListByUser".equals(method)) {
				getListByUser(request, response);
			} else if ("getTop".equals(method)) {
				getTop(request, response);
			} else if ("search".equals(method)) {// 模糊查询
				search(request, response);
			}
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

			zjxxService zs = BasicFactory.getFactory().getService(zjxxService.class);

			int currentPage = StringUtil.StringToInt(request.getParameter("currentPage"));
			if (currentPage == 0) {
				currentPage = 1;
			}
			zjxxPagingBean page = new zjxxPagingBean();
			page.setCurrentPage(currentPage);

			page.setXm(key);

			try {
				page = zs.search(page);

				// int i = 0;
				// for (zjxx j : page.getList()) {
				// i++;
				// System.out.println(i + "---" + j.toString());
				// }
				String preUrl = request.getContextPath() + "/front/zjxx/zjxxFrontServlet?method=search&key=" + key;

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
		zjxxService zs = BasicFactory.getFactory().getService(zjxxService.class);
		try {
			List<zjxx> list = zs.getTop();

			request.setAttribute(Constant.ZJXXBEANS, list);

			// int i = 0;
			// for (zjxx j : list) {
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

	/**
	 * 根据用户获取发布信息
	 * 
	 * @param request
	 * @param response
	 */
	private void getListByUser(HttpServletRequest request, HttpServletResponse response) {

		int currentPage = StringUtil.StringToInt(request.getParameter("currentPage"));

		UserBean u = (UserBean) request.getSession().getAttribute("session_user");

		if (u == null) {
			request.setAttribute("msg", "你还没有登录，请先登录");

		} else {

			frontZjxxPagingBean page = new frontZjxxPagingBean();
			page.setCurrentPage(currentPage);

			try {
				BeanUtils.populate(page, request.getParameterMap());

				zjxxService zs = BasicFactory.getFactory().getService(zjxxService.class);
				try {
					page = zs.getListByUser(page, u.getUsername());

				} catch (Exception e1) {
					e1.printStackTrace();
				}

				page.setAnd(true);
				String url = request.getContextPath() + "/front/zjxx/zjxxFrontServlet?method=getListByUser";
				if (null != page.getXm() && !"".equals(page.getXm())) {
					url += "&xm =" + page.getXm();
				}
				if (null != page.getTime1() && !"".equals(page.getTime1())) {
					url += "&time1=" + page.getTime1();
				}
				if (null != page.getTime2() && !"".equals(page.getTime2())) {
					url += "&time2=" + page.getTime2();
				}
				page.setPreUrl(url);

				request.setAttribute(Constant.ZJXXPAGINGBEAN, page);

			} catch (IllegalAccessException | InvocationTargetException e) {
				e.printStackTrace();
			}

		}
		try {
			request.getRequestDispatcher("zjxx_wyjfb.jsp").forward(request, response);

		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 前台添加
	 * 
	 * @param request
	 * @param response
	 */
	private void add(HttpServletRequest request, HttpServletResponse response) {

		zjxx z = new zjxx();
		try {
			BeanUtils.populate(z, request.getParameterMap());

			UserBean u = (UserBean) request.getSession().getAttribute(Constant.SESSION_USER);
			if (null != u) {
				z.setUsername(u.getUsername());
			}
			zjxxService zs = BasicFactory.getFactory().getService(zjxxService.class);
			try {
				zs.add(z);
				request.setAttribute(Constant.MSG, "添加成功");
				request.getRequestDispatcher("zjxx_wyfb.jsp").forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}

	}

	/**
	 * 根据id获取信息并增加点击量
	 * 
	 * @param request
	 * @param response
	 */
	private void getById(HttpServletRequest request, HttpServletResponse response) {
		int id = StringUtil.StringToInt(request.getParameter("id"));
		zjxxService zs = BasicFactory.getFactory().getService(zjxxService.class);
		try {
			zjxx z = zs.getById(id);

			request.setAttribute(Constant.ZJXXBEAN, z);

			zs.addHits(id);

			request.getRequestDispatcher("zjxx_info.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * 分页查询已征集的信息。
	 * 
	 * @param request
	 * @param response
	 */
	private void getFrontList(HttpServletRequest request, HttpServletResponse response) {
		int currentPage = StringUtil.StringToInt(request.getParameter("currentPage"));
		frontZjxxPagingBean page = new frontZjxxPagingBean();
		page.setCurrentPage(currentPage);

		try {
			BeanUtils.populate(page, request.getParameterMap());

			zjxxService zs = BasicFactory.getFactory().getService(zjxxService.class);
			try {
				page = zs.getFrontList(page);

			} catch (Exception e1) {
				e1.printStackTrace();
			}

			page.setAnd(true);
			String url = request.getContextPath() + "/front/zjxx/zjxxFrontServlet?method=getFrontList";

			if (null != page.getXm() && !"".equals(page.getXm())) {
				url += "&xm =" + page.getXm();
			}
			if (null != page.getTime1() && !"".equals(page.getTime1())) {
				url += "&time1=" + page.getTime1();
			}
			if (null != page.getTime2() && !"".equals(page.getTime2())) {
				url += "&time2=" + page.getTime2();
			}

			page.setPreUrl(url);

			request.setAttribute(Constant.ZJXXPAGINGBEAN, page);

			System.out.println(1);

			try {

				request.getRequestDispatcher("zjxx_yzj.jsp").forward(request, response);

			} catch (ServletException | IOException e) {
				e.printStackTrace();
			}
		} catch (IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}

	}
}
