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

import sist.bean.qyxqPagingBean;
import sist.dao.jssslyDao;
import sist.domain.jsssly;
import sist.domain.jsxq;
import sist.domain.UserBean;
import sist.factory.BasicFactory;
import sist.service.qyxqService;
import sist.utils.Constant;
import sist.utils.DateUtils;
import sist.utils.StringUtil;

/**
 * Servlet implementation class qyxqServlet
 */
@WebServlet("/back/jsxq/qyxq")
public class qyxqServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String method = request.getParameter("method");
		if (!"".equals(method)) {
			if ("addUI".equals(method)) {// 携带技术所属领域的信息跳转到添加页面
				addUI(request, response);
			} else if ("add".equals(method)) {// 添加企业需求信息
				add(request, response);
			} else if ("checkMc".equals(method)) {
				checkMc(request, response);
			} else if ("getShList".equals(method)) {
				getShList(request, response);
			} else if ("getGlList".equals(method)) {
				getGlList(request, response);
			} else if ("getInfo".equals(method)) {
				getInfo(request, response);
			} else if ("auditUI".equals(method)) {
				auditUI(request, response);
			} else if ("audit".equals(method)) {
				audit(request, response);
			} else if ("delete".equals(method)) {
				delete(request, response);
			}
		}
	}

	/**
	 * 删除单个已审核的信息
	 * 
	 * @param request
	 * @param response
	 */
	private void delete(HttpServletRequest request, HttpServletResponse response) {
		int id = StringUtil.StringToInt(request.getParameter("id"));

		qyxqService qs = BasicFactory.getFactory().getService(qyxqService.class);
		try {
			qs.deleteById(id);
			System.out.println("删除成功，删除的id是" + id);
			response.sendRedirect(request.getContextPath() + "/back/jsxq/qyxq?method=getGlList&currentPage=1&msg=1");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * 审核
	 * 
	 * @param request
	 * @param response
	 */
	private void audit(HttpServletRequest request, HttpServletResponse response) {
		int id = StringUtil.StringToInt(request.getParameter("id"));
		String status = request.getParameter("status");
		String shyj = request.getParameter("shyj");
		System.out.println("id:" + id + "  status:" + status);
		qyxqService qs = BasicFactory.getFactory().getService(qyxqService.class);
		try {
			jsxq j = qs.getInfo(id);

			j.setShyj(shyj);
			if ("通过".equals(status)) {
				j.setSh(1);
			} else if ("退回".equals(status)) {
				j.setSh(-1);
			}

			qs.update(j);
			System.out.println("审核成功");

			response.sendRedirect(request.getContextPath() + "/back/jsxq/qyxq?method=getShList&currentPage=1&msg=1");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * 携带需要审核的内容跳转到审核页面
	 * 
	 * @param request
	 * @param response
	 */
	private void auditUI(HttpServletRequest request, HttpServletResponse response) {
		int id = StringUtil.StringToInt(request.getParameter("id"));
		qyxqService qs = BasicFactory.getFactory().getService(qyxqService.class);

		jssslyDao jd = BasicFactory.getFactory().getDao(jssslyDao.class);
		try {
			jsxq js = qs.getInfo(id);
			System.out.println("获取 id是" + id + "的信息成功");
			request.setAttribute(Constant.JSXQBEAN, js);

			List<jsssly> list = jd.getAll();
			request.setAttribute(Constant.JSSSLY, list);

			request.getRequestDispatcher("back_jsxq_xxsh.jsp").forward(request, response);
		} catch (Exception e) {
			System.out.println("获取信息失败,id是" + id);
			e.printStackTrace();
		}
	}

	/**
	 * 查看一个需求的详细信息
	 * 
	 * @param request
	 * @param response
	 */
	private void getInfo(HttpServletRequest request, HttpServletResponse response) {
		int id = StringUtil.StringToInt(request.getParameter("id"));
		qyxqService qs = BasicFactory.getFactory().getService(qyxqService.class);

		jssslyDao jd = BasicFactory.getFactory().getDao(jssslyDao.class);
		try {
			jsxq js = qs.getInfo(id);
			System.out.println("获取 id是" + id + "的信息成功");
			request.setAttribute(Constant.JSXQBEAN, js);
			
			if(js.getSh()==1){
				request.setAttribute(Constant.MSG, "查看");
			}else{
				request.setAttribute(Constant.MSG, "审核");
			}
			
			List<jsssly> list = jd.getAll();
			request.setAttribute(Constant.JSSSLY, list);

			request.getRequestDispatcher("back_jsxq_look.jsp").forward(request, response);
		} catch (Exception e) {
			System.out.println("获取信息失败,id是" + id);
			e.printStackTrace();
		}
	}

	/**
	 * 携带技术所属领域的信息和已审核的信息跳转到管理页面
	 * 
	 * @param request
	 * @param response
	 */
	private void getGlList(HttpServletRequest request, HttpServletResponse response) {
		
		qyxqPagingBean page = new qyxqPagingBean();
		int msg = StringUtil.StringToInt(request.getParameter("msg"));
		if (msg == 0) {
			try {
				BeanUtils.populate(page, request.getParameterMap());
				String currPage1 = request.getParameter("currentPage");
				int currPage = StringUtil.StringToInt(currPage1);

				
				page.setCurrentPage(currPage);
				// 审核状态为空时封装默认封装值为0，导致错误需要单独获取处理
				String sh = request.getParameter("sh");
				if ("".equals(sh)) {
					page.setSh(null);
				}
			} catch (IllegalAccessException | InvocationTargetException e) {
				System.out.println("封装数据异常");
				e.printStackTrace();
			}
			

		} else {
			Object page1 = request.getSession().getAttribute(Constant.QYXQPAGINGBEAN);

			if (page1 != null) {
				page = (qyxqPagingBean) page1;
			}
			if(msg!=7){//7代表是从查看详细信息的页面传过来的
				request.setAttribute(Constant.MSG, "修改成功");
			}
			
		}

		
		
		
		qyxqService qy = BasicFactory.getFactory().getService(qyxqService.class);


			try {
				page = qy.getGlList(page);

				page.setAnd(true);

				String url = request.getContextPath() + "/back/jsxq/qyxq?method=getGlList";
				if (null != page.getMc() && !"".equals(page.getMc())) {
					url += "&mc=" + page.getMc();
				}
				url += "&sh=1";
				if (null != page.getNr_xq() && !"".equals(page.getNr_xq())) {
					url += "&nr_xq=" + page.getNr_xq();
				}
				if (null != page.getTime1() && !"".equals(page.getTime1())) {
					url += "&time1=" + page.getTime1();
				}
				if (null != page.getTime2() && !"".equals(page.getTime2())) {
					url += "&time2=" + page.getTime2();
				}
				if (null != page.getJsssly() && !"".equals(page.getJsssly())) {
					url += "&jsssly=" + page.getJsssly();
				}
				System.out.println("url:" + url);
				page.setPreUrl(url);

				request.getSession().setAttribute(Constant.QYXQPAGINGBEAN, page);
				
				jssslyDao jd = BasicFactory.getFactory().getDao(jssslyDao.class);
				List<jsssly> list = jd.getAll();
				request.setAttribute(Constant.JSSSLY, list);

				request.getRequestDispatcher("back_jsxq_gl.jsp").forward(request, response);
			} catch (Exception e) {
				System.out.println("获取分页信息异常");
				e.printStackTrace();
			}
	}

	/**
	 * 携带技术所属领域的信息和未审核和被退回的信息跳转到审核页面
	 * 
	 * @param request
	 * @param response
	 */
	private void getShList(HttpServletRequest request, HttpServletResponse response) {
		String currPage1 = request.getParameter("currentPage");
		int currPage = StringUtil.StringToInt(currPage1);
		qyxqPagingBean page = new qyxqPagingBean();
		int msg = StringUtil.StringToInt(request.getParameter("msg"));
		if (msg == 0) {
			try {
				BeanUtils.populate(page, request.getParameterMap());
				
				page.setCurrentPage(currPage);
				// 审核状态为空时封装默认封装值为0，导致错误需要单独获取处理
				String sh = request.getParameter("sh");
				if ("".equals(sh)) {
					page.setSh(null);
				}
			} catch (IllegalAccessException | InvocationTargetException e) {
				e.printStackTrace();
			}
			

		} else {
			Object page1 = request.getSession().getAttribute(Constant.QYXQPAGINGBEAN);

			if (page1 != null) {
				page = (qyxqPagingBean) page1;
			}
			if(msg!=7){//7代表是从查看详细信息的页面传过来的
				request.setAttribute(Constant.MSG, "修改成功");
			}
			
		}

		qyxqService qy = BasicFactory.getFactory().getService(qyxqService.class);

		try {
			page = qy.getShList(page);

			page.setAnd(true);

			String url = request.getContextPath() + "/back/jsxq/qyxq?method=getShList";
			if (null != page.getMc() && !"".equals(page.getMc())) {
				url += "&mc=" + page.getMc();
			}
			if (null != page.getSh() && !"".equals(page.getSh())) {
				url += "&sh=" + page.getSh();
			}
			if (null != page.getNr_xq() && !"".equals(page.getNr_xq())) {
				url += "&nr_xq=" + page.getNr_xq();
			}
			if (null != page.getTime1() && !"".equals(page.getTime1())) {
				url += "&time1=" + page.getTime1();
			}
			if (null != page.getTime2() && !"".equals(page.getTime2())) {
				url += "&time2=" + page.getTime2();
			}
			if (null != page.getJsssly() && !"".equals(page.getJsssly())) {
				url += "&jsssly=" + page.getJsssly();
			}
			System.out.println("url:" + url);
			page.setPreUrl(url);

			request.getSession().setAttribute(Constant.QYXQPAGINGBEAN, page);

			jssslyDao jd = BasicFactory.getFactory().getDao(jssslyDao.class);
			List<jsssly> list = jd.getAll();
			request.setAttribute(Constant.JSSSLY, list);

			request.getRequestDispatcher("back_jsxq_sh.jsp").forward(request, response);
		} catch (Exception e) {
			System.out.println("获取分页信息异常");
			e.printStackTrace();
		}
	}

	/**
	 * 检查名称是否存在
	 * 
	 * @param request
	 * @param response
	 */
	private void checkMc(HttpServletRequest request, HttpServletResponse response) {
		System.out.println(1);
		String jsxqmc = request.getParameter("mc");
		System.out.println(jsxqmc);
		qyxqService qs = BasicFactory.getFactory().getService(qyxqService.class);
		try {
			jsxq j = qs.checkMc(jsxqmc);
			String rst = "";
			if (null != j) {
				rst += "{status:'ERROR',msg:'此信息已经存在'}";
				System.out.println(2);
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
	 * 添加企业需求信息
	 * 
	 * @param request
	 * @param response
	 */
	private void add(HttpServletRequest request, HttpServletResponse response) {
		jsxq j = new jsxq();
		try {
			BeanUtils.populate(j, request.getParameterMap());
			// 处理技术所属领域
			String[] jsssly1 = request.getParameterValues("ly_js");
			String jsssly = "";
			int s1 = 0;
			for (String s : jsssly1) {
				if (s1 == 0) {
					jsssly = s;
					s1++;
				} else {
					jsssly += "," + s;
				}
			}
			j.setLy_js(jsssly);

			// 添加的用户名
			UserBean u = (UserBean) request.getSession().getAttribute("session_user");
			if (null != u) {
				j.setUsername(u.getUsername());
			}

			// 添加时间
			j.setTime(DateUtils.getDate());
			// 审核状态
			j.setSh(0);

			qyxqService qs = BasicFactory.getFactory().getService(qyxqService.class);
			qs.add(j);
			response.sendRedirect(request.getContextPath()+"/back/jsxq/qyxq?method=addUI&msg=1");
			
		} catch (Exception e) {
			System.out.println("封装数据异常");
			e.printStackTrace();
		}
	}

	/**
	 * 携带技术所属领域的信息跳转到添加页面
	 * 
	 * @param request
	 * @param response
	 */
	private void addUI(HttpServletRequest request, HttpServletResponse response) {
		int msg = StringUtil.StringToInt(request.getParameter("msg"));
		if(msg!=0){
			request.setAttribute(Constant.MSG, "添加成功");
		}
		jssslyDao dao = BasicFactory.getFactory().getDao(jssslyDao.class);
		try {
			List<jsssly> list = dao.getAll();
			System.out.println("获取成功");
			request.setAttribute(Constant.JSSSLY, list);

			request.getRequestDispatcher("/back/jsxq/back_jsxq.jsp").forward(request, response);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
