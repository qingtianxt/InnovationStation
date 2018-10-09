package sist.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import sist.bean.zjxxPagingBean;
import sist.domain.UserBean;
import sist.domain.zjxx;
import sist.factory.BasicFactory;
import sist.service.zjxxService;
import sist.utils.Constant;
import sist.utils.StringUtil;

/**
 * 专家信息模块
 */
@WebServlet("/back/zjxx/zjxxServlet")
public class zjxxServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");

		String method = request.getParameter("method");
		if ("add".equals(method)) {
			add(request, response);
		} else if ("getList".equals(method)) {
			getList(request, response);
		} else if ("look".equals(method)) {
			look(request, response);
		} else if ("editUI".equals(method)) {
			editUI(request, response);
		} else if ("update".equals(method)) {
			update(request, response);
		} else if ("delete".equals(method)) {
			delete(request, response);
		}
	}

	private void delete(HttpServletRequest request, HttpServletResponse response) {
		int id = StringUtil.StringToInt(request.getParameter("id"));
		System.out.println(id);
		zjxxService zs = BasicFactory.getFactory().getService(zjxxService.class);
		try {
			zs.delete(id);
			response.sendRedirect(
					request.getContextPath() + "/back/zjxx/zjxxServlet?method=getList&currentPage=1&msg=1");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 修改专家信息
	 * 
	 * @param request
	 * @param response
	 */
	private void update(HttpServletRequest request, HttpServletResponse response) {
		zjxx z = new zjxx();
		try {
			BeanUtils.populate(z, request.getParameterMap());

			UserBean u = (UserBean) request.getSession().getAttribute(Constant.SESSION_USER);
			if (null != u) {
				z.setUsername(u.getUsername());
			}
			zjxxService zs = BasicFactory.getFactory().getService(zjxxService.class);
			try {
				zs.update(z);
				response.sendRedirect(
						request.getContextPath() + "/back/zjxx/zjxxServlet?method=getList&currentPage=1&msg=2");
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 携带专家信息跳转到修改页面
	 * 
	 * @param request
	 * @param response
	 */
	private void editUI(HttpServletRequest request, HttpServletResponse response) {
		int id = StringUtil.StringToInt(request.getParameter("id"));
		zjxxService zs = BasicFactory.getFactory().getService(zjxxService.class);
		try {
			zjxx z = zs.getById(id);
			request.setAttribute(Constant.ZJXXBEAN, z);

			request.getRequestDispatcher("back_zjxx_update.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 根据id查看专家信息
	 * 
	 * @param request
	 * @param response
	 */
	private void look(HttpServletRequest request, HttpServletResponse response) {
		int id = StringUtil.StringToInt(request.getParameter("id"));
		zjxxService zs = BasicFactory.getFactory().getService(zjxxService.class);
		try {
			zjxx z = zs.getById(id);
			request.setAttribute(Constant.ZJXXBEAN, z);

			request.getRequestDispatcher("back_zjxx_look.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 根据条件分页获取专家信息
	 * 
	 * @param request
	 * @param response
	 */
	private void getList(HttpServletRequest request, HttpServletResponse response) {

		zjxxPagingBean page = new zjxxPagingBean();

		int msg = StringUtil.StringToInt(request.getParameter("msg"));
		String msg1 = null;

		if (msg == 0) {

			try {
				BeanUtils.populate(page, request.getParameterMap());
				int currentPage = StringUtil.StringToInt(request.getParameter("currentPage"));
				page.setCurrentPage(currentPage);
			} catch (IllegalAccessException | InvocationTargetException e) {
				e.printStackTrace();
			}
		} else {
			if (msg == 1) {
				msg1 = "删除成功";
			} else if (msg == 2) {
				msg1 = "修改成功";
			}
			request.setAttribute(Constant.MSG, msg1);
			
			Object page1 = request.getSession().getAttribute(Constant.ZJXXPAGINGBEAN);
			if(page1!=null){
				page=(zjxxPagingBean) page1;
			}
		}

		zjxxService zs = BasicFactory.getFactory().getService(zjxxService.class);
		try {
			page = zs.getList(page);

		} catch (Exception e1) {
			e1.printStackTrace();
		}

		page.setAnd(true);
		String url = request.getContextPath() + "/back/zjxx/zjxxServlet?method=getList";

		if (null != page.getXm() && !"".equals(page.getXm())) {
			url += "&xm =" + page.getXm();
		}
		if (null != page.getZc_zy() && !"".equals(page.getZc_zy())) {
			url += "&zc_zy =" + page.getZc_zy();
		}
		if (null != page.getMc_szs() && !"".equals(page.getMc_szs())) {
			url += "&MC_SZS =" + page.getMc_szs();
		}
		if (null != page.getXkly() && !"".equals(page.getXkly())) {
			url += "&XKLY = " + page.getXkly();
		}
		if (null != page.getYjfx() && !"".equals(page.getYjfx())) {
			url += "&YJFX =" + page.getYjfx();
		}

		page.setPreUrl(url);

		request.getSession().setAttribute(Constant.ZJXXPAGINGBEAN, page);
		try {
			request.getRequestDispatcher("back_zjxx_gl.jsp").forward(request, response);

		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * 添加专家信息
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
				request.getRequestDispatcher("back_zjxx.jsp").forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}

	}
}
