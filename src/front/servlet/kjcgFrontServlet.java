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

import sist.bean.kjcgPagingBean;
import sist.dao.jssslyDao;
import sist.dao.jstxxsDao;
import sist.dao.ssgxjslbDao;
import sist.domain.Fwpt;
import sist.domain.UserBean;
import sist.domain.cgal;
import sist.domain.cgzhxm;
import sist.domain.jsssly;
import sist.domain.jstxxs;
import sist.domain.kjcg;
import sist.domain.ssgxjslb;
import sist.factory.BasicFactory;
import sist.service.FwptService;
import sist.service.cgalService;
import sist.service.cgzhxmService;
import sist.service.kjcgService;
import sist.utils.Constant;
import sist.utils.DateUtils;
import sist.utils.GetNum;
import sist.utils.StringUtil;

/**
 * Servlet implementation class kjcgFrontServlet
 */
@WebServlet("/front/kjcg/kjcgFrontServlet")
public class kjcgFrontServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");

		String method = request.getParameter("method");
		if ("getList".equals(method)) {
			getList(request, response);
		} else if ("getById".equals(method)) {
			try {
				getById(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if ("addUI".equals(method)) {
			addUI(request, response);
		} else if ("add".equals(method)) {
			add(request, response);
		} else if ("checkXMc".equals(method)) {
			checkXMc(request, response);// (添加时使用)检查成果转化项目名称是否已经存在
		} else if ("getListByUser".equals(method)) {
			getListByUser(request, response);
		} else if ("getTop".equals(method)) {
			getTop(request, response);
		} else if ("search".equals(method)) {// 模糊查询
			search(request, response);
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

			kjcgService ks = BasicFactory.getFactory().getService(kjcgService.class);
			int currentPage = StringUtil.StringToInt(request.getParameter("currentPage"));
			if (currentPage == 0) {
				currentPage = 1;
			}
			kjcgPagingBean page = new kjcgPagingBean();
			page.setCurrentPage(currentPage);

			page.setMc(key);

			try {
				page = ks.search(page);

				// int i = 0;
				// for (kjcg j : page.getList()) {
				// i++;
				// System.out.println(i + "---" + j.toString());
				// }

				String preUrl = request.getContextPath() + "/front/kjcg/kjcgFrontServlet?method=search&key=" + key;

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
		kjcgService fs = BasicFactory.getFactory().getService(kjcgService.class);
		try {
			List<kjcg> list = fs.getTop();

			request.setAttribute(Constant.FWPTBEANS, list);
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

	private void getListByUser(HttpServletRequest request, HttpServletResponse response) {

		UserBean u = (UserBean) request.getSession().getAttribute("session_user");

		if (u == null) {
			request.setAttribute(Constant.MSG, "你还没有登录，请先登录");

		} else {

			String currentPage1 = request.getParameter("currentPage");

			int currentPage = StringUtil.StringToInt(currentPage1);
			kjcgPagingBean page = new kjcgPagingBean();
			kjcgService ks = BasicFactory.getFactory().getService(kjcgService.class);

			try {

				BeanUtils.populate(page, request.getParameterMap());

				page.setCurrentPage(currentPage);
				page = ks.getListByUser(page, u.getUsername());
				System.out.println(page);
				page.setAnd(true);
				String url = request.getContextPath() + "/front/kjcg/kjcgFrontServlet?method=getListByUser";
				if (null != page.getMc() && !"".equals(page.getMc())) {
					url += "&mc=" + page.getMc();
				}
				if (null != page.getTime1() && !"".equals(page.getTime1())) {
					url += "&time1=" + page.getTime1();
				}
				if (null != page.getTime2() && !"".equals(page.getTime2())) {
					url += "&time2=" + page.getTime2();
				}
				System.out.println("url:" + url);
				page.setPreUrl(url);
				request.setAttribute(Constant.KJCGPAGINGBEAN, page);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		try {
			request.getRequestDispatcher("kjcg_wyjfb.jsp").forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}

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

	private void add(HttpServletRequest request, HttpServletResponse response) {

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
				getlbAndLy(request, response);
				request.getRequestDispatcher("kjcg_wyfb.jsp").forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}

		} catch (IllegalAccessException | InvocationTargetException e) {
			System.out.println("封装数据失败");
			e.printStackTrace();
		}

	}

	private void addUI(HttpServletRequest request, HttpServletResponse response) {
		getlbAndLy(request, response);
		try {
			request.getRequestDispatcher("kjcg_wyfb.jsp").forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}

	private void getById(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int id = StringUtil.StringToInt(request.getParameter("id"));
		kjcgService ks = BasicFactory.getFactory().getService(kjcgService.class);
		kjcg k = null;
		try {
			k = ks.getById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (k != null) {
			if (k.getKm().equals("成果转化项目")) {
				cgzhxmService cs = BasicFactory.getFactory().getService(cgzhxmService.class);
				cgzhxm c = null;
				try {
					c = cs.getByMc(k.getMc());
				} catch (Exception e) {
					e.printStackTrace();
				}
				/*
				 * if (!"".equals(c.getYyhy())) { GetNum g = new GetNum();
				 * String yyhy = g.select(c.getYyhy());
				 * request.setAttribute(Constant.YYHY, yyhy); }
				 */
				jssslyDao jd = BasicFactory.getFactory().getDao(jssslyDao.class);

				request.setAttribute("page", "1");

				// 处理技术所属领域信息
				if (c.getJsssly() != null) {

					String[] j1 = c.getJsssly().split(",");
					String j = "";
					for (String s : j1) {
						int id1 = StringUtil.StringToInt(s);
						jsssly jsssly = jd.getById(id1);
						if (j.equals("")) {
							j = jsssly.getLymc();
						} else {
							j += "," + jsssly.getLymc();
						}
					}
					request.setAttribute("jsssly", j);
				}

				request.setAttribute(Constant.CGZHXMBEAN, c);

				kjcgService ks1 = BasicFactory.getFactory().getService(kjcgService.class);
				ks1.addHits(id);

				try {
					request.getRequestDispatcher("kjcg_info.jsp").forward(request, response);
				} catch (ServletException | IOException e) {
					e.printStackTrace();
				}
			} else if (k.getKm().equals("成功案例")) {
				cgalService cs = BasicFactory.getFactory().getService(cgalService.class);
				try {
					cgal c = cs.getByMc(k.getMc());
					request.setAttribute(Constant.CGALBEAN, c);
				} catch (Exception e) {
					e.printStackTrace();
				}
				try {
					request.setAttribute("page", "2");
					request.getRequestDispatcher("kjcg_info.jsp").forward(request, response);
				} catch (ServletException | IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * 获取科技成果信息
	 * 
	 * @param request
	 * @param response
	 */
	private void getList(HttpServletRequest request, HttpServletResponse response) {
		String currentPage1 = request.getParameter("currentPage");

		int currentPage = StringUtil.StringToInt(currentPage1);
		kjcgPagingBean page = new kjcgPagingBean();
		kjcgService ks = BasicFactory.getFactory().getService(kjcgService.class);

		try {

			BeanUtils.populate(page, request.getParameterMap());

			page.setCurrentPage(currentPage);
			try {
				page = ks.getList(page);
				System.out.println(page);
				page.setAnd(true);
				String url = request.getContextPath() + "/front/kjcg/kjcgFrontServlet?method=getList";
				if (null != page.getMc() && !"".equals(page.getMc())) {
					url += "&mc=" + page.getMc();
				}
				if (null != page.getTime1() && !"".equals(page.getTime1())) {
					url += "&time1=" + page.getTime1();
				}
				if (null != page.getTime2() && !"".equals(page.getTime2())) {
					url += "&time2=" + page.getTime2();
				}
				System.out.println("url:" + url);
				page.setPreUrl(url);
				request.setAttribute(Constant.KJCGPAGINGBEAN, page);

				int msg = StringUtil.StringToInt(request.getParameter("msg"));
				String msg1 = null;
				if (msg == 1) {
					msg1 = "删除成功";
				} else if (msg == 2) {
					msg1 = "修改成功";
				}
				request.setAttribute(Constant.MSG, msg1);
				request.getRequestDispatcher("kjcg_yzj.jsp").forward(request, response);
			} catch (Exception e) {
				System.out.println("获取分页信息异常");
				e.printStackTrace();
			}

		} catch (IllegalAccessException | InvocationTargetException e) {
			System.out.println("封裝数据异常");
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
