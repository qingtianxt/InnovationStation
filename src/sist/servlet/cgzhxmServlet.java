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

import sist.dao.jssslyDao;
import sist.dao.jstxxsDao;
import sist.dao.ssgxjslbDao;
import sist.domain.cgzhxm;
import sist.domain.jsssly;
import sist.domain.jstxxs;
import sist.domain.kjcg;
import sist.domain.ssgxjslb;
import sist.domain.UserBean;
import sist.factory.BasicFactory;
import sist.service.cgzhxmService;
import sist.service.kjcgService;
import sist.utils.Constant;
import sist.utils.DateUtils;
import sist.utils.GetNum;
import sist.utils.StringUtil;

/**
 * 成果转化项目模块
 */
@WebServlet("/back/kjcg/cgzhxmServlet")
public class cgzhxmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");

		String method = request.getParameter("method");
		if ("cgzhxmUI".equals(method)) {
			cgzhxmUI(request, response);// 携带所属高新技术类别和技术所属领域的信息跳转到成果转化项目页面
		} else if ("checkXMc".equals(method)) {
			checkXMc(request, response);// (添加时使用)检查成果转化项目名称是否已经存在
		} else if ("addCgzhxm".equals(method)) {
			addCgzhxm(request, response);
		} else if ("checkMcUpdate".equals(method)) {
			checkMcUpdate(request, response);// (修改时使用)检查成果转化项目名称是否已经存在
		} else if ("update".equals(method)) {
			update(request, response);
		}

	}

	/**
	 * 修改成果转化项目信息，并修改科技成果表中的内容
	 * 
	 * @param request
	 * @param response
	 */
	private void update(HttpServletRequest request, HttpServletResponse response) {
		cgzhxm c = new cgzhxm();
		kjcg k = new kjcg();
		// 添加的用户名
		UserBean u = (UserBean) request.getSession().getAttribute("session_user");
		if (null != u) {
			c.setUsername(u.getUsername());
			k.setUsername(u.getUsername());
		}

		// 添加时间
		c.setTime(DateUtils.getDate());

		// 处理应用行业
		String selectgm1 = request.getParameter("selectgm1");
		String selectgm2 = request.getParameter("selectgm2");
		String selectgm3 = request.getParameter("selectgm3");

		System.out.println("selectgm1:" + selectgm1);
		System.out.println("selectgm2:" + selectgm2);
		System.out.println("selectgm3:" + selectgm3);
		GetNum getNum1 = new GetNum(selectgm1, selectgm2, selectgm3, "T_GMJJ");
		String cgyyhy = "";
		String gmbh = "";
		gmbh = getNum1.Getvalue();
		if (gmbh != null) {
			cgyyhy = gmbh;
		} else {
			GetNum getNum2 = new GetNum("", "", "", "T_GMJJ");
			cgyyhy = getNum2.Getvalue();
		}

		try {
			BeanUtils.populate(k, request.getParameterMap());
			k.setTime(DateUtils.getDate());
			k.setKm("成果转化项目");
			System.out.println(k);

			kjcgService ks = BasicFactory.getFactory().getService(kjcgService.class);
			try {
				kjcg k1 = ks.getByMc(k.getMc());
				k.setId(k1.getId());
				ks.update(k);
			} catch (Exception e) {
				e.printStackTrace();
			}

			// return;

		} catch (IllegalAccessException | InvocationTargetException e1) {
			e1.printStackTrace();
		}
		try {
			BeanUtils.populate(c, request.getParameterMap());
			System.out.println(c);
			// 技术所属领域
			String[] jsssly1 = request.getParameterValues("jsssly");
			String jsssly = "";
			int s1 = 0;
			for (String s : jsssly1) {
				if (null != s) {
					if (s1 == 0) {
						jsssly = s;
						s1++;
					} else {
						jsssly += "," + s;
					}
				}

			}
			c.setJsssly(jsssly);
			// 成果体现形式
			String[] xs1 = request.getParameterValues("xs_js");
			String xs = "";
			int s2 = 0;
			for (String s : xs1) {
				if (null != s) {
					if (s2 == 0) {
						xs = s;
						s2++;
					} else {
						xs += "," + s;
					}
				}
			}
			c.setXs(xs);
			c.setYyhy(cgyyhy);
			cgzhxmService cs = BasicFactory.getFactory().getService(cgzhxmService.class);
			try {
				cgzhxm c1 = cs.getByMc(c.getMc());
				c.setId(c1.getId());

				cs.update(c);
				response.sendRedirect(
						request.getContextPath() + "/back/kjcg/kjcgServlet?method=getList&currentPage=1&msg=2");
			} catch (Exception e) {
				e.printStackTrace();
			}

		} catch (IllegalAccessException | InvocationTargetException e) {
			System.out.println("封装数据失败");
			e.printStackTrace();
		}
	}

	/**
	 * 判断需要修改的页面的成果转化项目是否存在，注意修改的时候，名称不修改也可以
	 * 
	 * @param request
	 * @param response
	 */
	private void checkMcUpdate(HttpServletRequest request, HttpServletResponse response) {
		int id = StringUtil.StringToInt(request.getParameter("id"));
		String mc = request.getParameter("mc");

		System.out.println(id + "    mc" + mc);

		cgzhxmService cs = BasicFactory.getFactory().getService(cgzhxmService.class);
		try {
			cgzhxm c = cs.getById(id);// 根据id获取的是修改之前的科技成果信息
			cgzhxm c1 = cs.getByMc(mc);// 根据名称获取的是修改后的名称是否在数据库中存在

			String rst = "";
			if (c1 != null && c1.getMc().equals(c.getMc())) {// 新名称在数据库中存在且等于原来的名称
				rst = "{status:'OK'}";
			} else if (null == c1) {// 新名称在数据库中不存在
				rst = "{status:'OK'}";
			} else {
				rst = "{status:'ERROR',msg:'此信息已经存在'}";
			}
			response.getWriter().print(rst);
			response.getWriter().flush();
			response.getWriter().close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 添加成果转化项目
	 * 
	 * @param request
	 * @param response
	 */
	private void addCgzhxm(HttpServletRequest request, HttpServletResponse response) {
		cgzhxm c = new cgzhxm();

		kjcg k = new kjcg();
		// 添加的用户名
		UserBean u = (UserBean) request.getSession().getAttribute("session_user");
		if (null != u) {
			c.setUsername(u.getUsername());
			k.setUsername(u.getUsername());
		}

		// 添加时间
		c.setTime(DateUtils.getDate());

		// 处理应用行业
		String selectgm1 = request.getParameter("selectgm1");
		String selectgm2 = request.getParameter("selectgm2");
		String selectgm3 = request.getParameter("selectgm3");

		System.out.println("selectgm1:" + selectgm1);
		System.out.println("selectgm2:" + selectgm2);
		System.out.println("selectgm3:" + selectgm3);
		GetNum getNum1 = new GetNum(selectgm1, selectgm2, selectgm3, "T_GMJJ");
		String cgyyhy = "";
		String gmbh = "";
		gmbh = getNum1.Getvalue();
		if (gmbh != null) {
			cgyyhy = gmbh;
		} else {
			GetNum getNum2 = new GetNum("", "", "", "T_GMJJ");
			cgyyhy = getNum2.Getvalue();
		}

		try {
			BeanUtils.populate(k, request.getParameterMap());
			k.setTime(DateUtils.getDate());
			k.setKm("成果转化项目");

			kjcgService ks = BasicFactory.getFactory().getService(kjcgService.class);
			try {
				ks.add(k);
			} catch (Exception e) {
				e.printStackTrace();
			}

			// return;

		} catch (IllegalAccessException | InvocationTargetException e1) {
			e1.printStackTrace();
		}
		try {
			BeanUtils.populate(c, request.getParameterMap());
			System.out.println(c);
			// 技术所属领域
			String[] jsssly1 = request.getParameterValues("jsssly");
			String jsssly = "";
			int s1 = 0;
			for (String s : jsssly1) {
				if (null != s) {
					if (s1 == 0) {
						jsssly = s;
						s1++;
					} else {
						jsssly += "," + s;
					}
				}

			}
			c.setJsssly(jsssly);
			// 成果体现形式
			String[] xs1 = request.getParameterValues("xs");
			String xs = "";
			int s2 = 0;
			for (String s : xs1) {
				if (null != s) {
					if (s2 == 0) {
						xs = s;
						s2++;
					} else {
						xs += "," + s;
					}
				}
			}
			c.setXs(xs);
			c.setYyhy(cgyyhy);

			cgzhxmService cs = BasicFactory.getFactory().getService(cgzhxmService.class);
			try {
				cs.add(c);
				request.setAttribute(Constant.MSG, "添加成功");
				response.sendRedirect(request.getContextPath()+"/back/kjcg/cgzhxmServlet?method=cgzhxmUI&status=1");
			} catch (Exception e) {
				e.printStackTrace();
			}

		} catch (IllegalAccessException | InvocationTargetException e) {
			System.out.println("封装数据失败");
			e.printStackTrace();
		}
	}

	/**
	 * 检查成果转化项目名称是否已经存在
	 * 
	 * @param request
	 * @param response
	 */
	private void checkXMc(HttpServletRequest request, HttpServletResponse response) {
		String mc = request.getParameter("mc");
		cgzhxmService cs = BasicFactory.getFactory().getService(cgzhxmService.class);
		try {
			cgzhxm c = cs.getByMc(mc);
			String rst = "";
			if (null != c) {
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
	 * 携带所属高新技术类别和技术所属领域的信息跳转到成果转化项目页面
	 * 
	 * @param request
	 * @param response
	 */
	private void cgzhxmUI(HttpServletRequest request, HttpServletResponse response) {
		getlbAndLy(request, response);
		try {
			int status = StringUtil.StringToInt(request.getParameter("status"));
			if(status==1){
				request.setAttribute(Constant.MSG, "添加成功");
			}
			request.getRequestDispatcher("back_kjcg.jsp").forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 获取高新技术类别和技术所属领域,和成果体现形式
	 */
	public void getlbAndLy(HttpServletRequest request, HttpServletResponse response) {
		ssgxjslbDao sd = BasicFactory.getFactory().getDao(ssgxjslbDao.class);
		try {
			List<ssgxjslb> list = sd.getAll();

			request.setAttribute(Constant.SSGXJSLB, list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		jssslyDao jd = BasicFactory.getFactory().getDao(jssslyDao.class);
		try {
			List<jsssly> list = jd.getAll();

			request.setAttribute(Constant.JSSSLY, list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		jstxxsDao js = BasicFactory.getFactory().getDao(jstxxsDao.class);
		try {
			List<jstxxs> list = js.getAll();

			request.setAttribute(Constant.JSTXXS, list);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
