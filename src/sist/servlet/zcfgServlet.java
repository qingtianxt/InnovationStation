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

import sist.bean.zcfgPagingBean;
import sist.dao.zyzddxDao;
import sist.domain.UserBean;
import sist.domain.zcfg;
import sist.domain.zyzddx;
import sist.factory.BasicFactory;
import sist.service.zcfgService;
import sist.utils.Constant;
import sist.utils.StringUtil;

/**
 * 政策法规模块
 */
@WebServlet("/back/zcfg/zcfgServlet")
public class zcfgServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		String method = request.getParameter("method");
		if (null != method) {
			if ("addUI".equals(method)) {
				addUI(request, response);
			} else if ("checkMc".equals(method)) {
				checkMc(request, response);
			} else if ("add".equals(method)) {
				add(request, response);
			} else if ("getList".equals(method)) {
				getList(request, response);
			} else if ("look".equals(method)) {
				look(request, response);
			} else if ("editUI".equals(method)) {
				editUI(request, response);
			} else if ("checkMcUpdate".equals(method)) {
				checkMcUpdate(request, response);
			} else if ("update".equals(method)) {
				update(request, response);
			} else if ("delete".equals(method)) {
				delete(request, response);
			}
		}
	}

	/**
	 * 根据id删除政策法规
	 * 
	 * @param request
	 * @param response
	 */
	private void delete(HttpServletRequest request, HttpServletResponse response) {
		int id = StringUtil.StringToInt(request.getParameter("id"));
		System.out.println(id);
		zcfgService zs = BasicFactory.getFactory().getService(zcfgService.class);
		try {
			zs.delete(id);
			response.sendRedirect(
					request.getContextPath() + "/back/zcfg/zcfgServlet?method=getList&currentPage=1&msg=1");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 修改政策法规内容
	 * 
	 * @param request
	 * @param response
	 */
	private void update(HttpServletRequest request, HttpServletResponse response) {
		zcfg z = new zcfg();
		try {
			BeanUtils.populate(z, request.getParameterMap());

			System.out.println(z);
			String[] ttzlymc1 = request.getParameterValues("ttzlymc");
			String ttzlymc = "";
			for (String t : ttzlymc1) {
				if (t != null && !"".equals(t)) {
					if ("".equals(ttzlymc)) {
						ttzlymc = t;
					} else {
						ttzlymc += "," + t;
					}
				}
			}
			z.setTtzlymc(ttzlymc);

			UserBean u = (UserBean) request.getSession().getAttribute(Constant.SESSION_USER);
			if (u != null) {
				z.setUsername(u.getUsername());
			}
			zcfgService zs = BasicFactory.getFactory().getService(zcfgService.class);
			try {
				zs.update(z);
				response.sendRedirect(
						request.getContextPath() + "/back/zcfg/zcfgServlet?method=getList&currentPage=1&msg=2");

			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (IllegalAccessException | InvocationTargetException e) {

			e.printStackTrace();
		}
	}

	private void checkMcUpdate(HttpServletRequest request, HttpServletResponse response) {
		int id = StringUtil.StringToInt(request.getParameter("id"));
		String zcmc = request.getParameter("zcmc");
		zcfgService zs = BasicFactory.getFactory().getService(zcfgService.class);
		try {

			zcfg z = zs.getByMc(zcmc);

			zcfg z1 = zs.getById(id);

			String rst = "";
			if (null == z) {
				rst += "{status:'OK'}";
			} else if (z != null && z.getZcmc().equals(z1.getZcmc())) {
				rst += "{status:'OK'}";
			} else {
				rst += "{status:'ERROR',msg:'此信息已经存在'}";
			}
			response.getWriter().print(rst);
			response.getWriter().flush();
			response.getWriter().close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 携带数据跳转到修改页面
	 * 
	 * @param request
	 * @param response
	 */
	private void editUI(HttpServletRequest request, HttpServletResponse response) {
		int id = StringUtil.StringToInt(request.getParameter("id"));
		zcfgService zs = BasicFactory.getFactory().getService(zcfgService.class);
		zcfg z = null;
		try {
			z = zs.getById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		zyzddxDao d = BasicFactory.getFactory().getDao(zyzddxDao.class);
		try {
			List<zyzddx> list = d.getAll();
			request.setAttribute(Constant.ZYZDDX, list);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		request.setAttribute(Constant.ZCFGBEAN, z);
		try {
			request.getRequestDispatcher("back_zcfg_update.jsp").forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * 根据id查询政策法规信息
	 * 
	 * @param request
	 * @param response
	 */
	private void look(HttpServletRequest request, HttpServletResponse response) {
		int id = StringUtil.StringToInt(request.getParameter("id"));
		zcfgService zs = BasicFactory.getFactory().getService(zcfgService.class);
		zcfg z = null;
		try {
			z = zs.getById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		zyzddxDao d = BasicFactory.getFactory().getDao(zyzddxDao.class);
		try {
			List<zyzddx> list = d.getAll();
			request.setAttribute(Constant.ZYZDDX, list);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		request.setAttribute(Constant.ZCFGBEAN, z);
		try {
			request.getRequestDispatcher("back_zcfg_look.jsp").forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * 根据条件分页获取政策法规信息
	 * 
	 * @param request
	 * @param response
	 */
	private void getList(HttpServletRequest request, HttpServletResponse response) {
		zcfgPagingBean page = new zcfgPagingBean();
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
			
			Object page1 = request.getSession().getAttribute(Constant.ZCFGPAGINGBEAN);
			if(page1!=null){
				page=(zcfgPagingBean) page1;
			}
			
		}

		zcfgService zs = BasicFactory.getFactory().getService(zcfgService.class);
		try {
			page = zs.getList(page);

			page.setAnd(true);
			String url = request.getContextPath() + "/back/zcfg/zcfgServlet?method=getList";
			if (null != page.getZcmc() && !"".equals(page.getZcmc())) {
				url += "&zcmc=" + page.getZcmc();
			}
			if (null != page.getZcflmc() && !"".equals(page.getZcflmc())) {
				url += "&zcflmc=" + page.getZcflmc();
			}
			if (null != page.getZtcmc() && !"".equals(page.getZtcmc())) {
				url += "&ztcmc =" + page.getZtcmc() + "%' ";
			}
			if (null != page.getZcwh() && !"".equals(page.getZcwh())) {
				url += "&zcwh=" + page.getZcwh();
			}
			if (null != page.getTime1() && !"".equals(page.getTime1())) {
				url += "&time1=" + page.getTime1();
			}
			if (null != page.getTime2() && !"".equals(page.getTime2())) {
				url += "&time2=" + page.getTime2();
			}
			System.out.println(url);
			page.setPreUrl(url);

			request.getSession().setAttribute(Constant.ZCFGPAGINGBEAN, page);
			
			request.getRequestDispatcher("back_zcfg_gl.jsp").forward(request, response);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * 添加政策法规模块
	 * 
	 * @param request
	 * @param response
	 */
	private void add(HttpServletRequest request, HttpServletResponse response) {
		zcfg z = new zcfg();
		try {
			BeanUtils.populate(z, request.getParameterMap());

			System.out.println(z);
			String[] ttzlymc1 = request.getParameterValues("ttzlymc");
			String ttzlymc = "";
			if (null != ttzlymc1) {
				for (String t : ttzlymc1) {
					if (t != null && !"".equals(t)) {
						if ("".equals(ttzlymc)) {
							ttzlymc = t;
						} else {
							ttzlymc += "," + t;
						}
					}
				}
			}

			System.out.println(ttzlymc);
			z.setTtzlymc(ttzlymc);

			UserBean u = (UserBean) request.getSession().getAttribute(Constant.SESSION_USER);
			if (u != null) {
				z.setUsername(u.getUsername());
			}
			zcfgService zs = BasicFactory.getFactory().getService(zcfgService.class);
			try {
				zs.add(z);
				request.setAttribute(Constant.MSG, "添加成功");
				request.getRequestDispatcher("back_zcfg.jsp").forward(request, response);

			} catch (Exception e) {
				e.printStackTrace();
			}

		} catch (IllegalAccessException | InvocationTargetException e) {

			e.printStackTrace();
		}
	}

	/**
	 * 检查名称是否被占用
	 * 
	 * @param request
	 * @param response
	 */
	private void checkMc(HttpServletRequest request, HttpServletResponse response) {
		String zcmc = request.getParameter("zcmc");
		zcfgService zs = BasicFactory.getFactory().getService(zcfgService.class);
		zcfg z = null;
		try {
			z = zs.getByMc(zcmc);
			String rst = "";
			if (null != z) {
				rst += "{status:'ERROR',msg:'此信息已经存在'}";
			} else {
				rst += "{status:'OK'}";
			}
			response.getWriter().print(rst);
			response.getWriter().flush();
			response.getWriter().close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * 携带
	 * 
	 * @param request
	 * @param response
	 */
	private void addUI(HttpServletRequest request, HttpServletResponse response) {
		zyzddxDao zd = BasicFactory.getFactory().getDao(zyzddxDao.class);
		List<zyzddx> list = null;
		try {
			list = zd.getAll();
			request.setAttribute(Constant.ZYZDDX, list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			request.getRequestDispatcher("back_zcfg.jsp").forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}

}
