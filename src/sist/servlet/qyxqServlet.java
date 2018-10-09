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
			if ("addUI".equals(method)) {// Я�����������������Ϣ��ת�����ҳ��
				addUI(request, response);
			} else if ("add".equals(method)) {// �����ҵ������Ϣ
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
	 * ɾ����������˵���Ϣ
	 * 
	 * @param request
	 * @param response
	 */
	private void delete(HttpServletRequest request, HttpServletResponse response) {
		int id = StringUtil.StringToInt(request.getParameter("id"));

		qyxqService qs = BasicFactory.getFactory().getService(qyxqService.class);
		try {
			qs.deleteById(id);
			System.out.println("ɾ���ɹ���ɾ����id��" + id);
			response.sendRedirect(request.getContextPath() + "/back/jsxq/qyxq?method=getGlList&currentPage=1&msg=1");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * ���
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
			if ("ͨ��".equals(status)) {
				j.setSh(1);
			} else if ("�˻�".equals(status)) {
				j.setSh(-1);
			}

			qs.update(j);
			System.out.println("��˳ɹ�");

			response.sendRedirect(request.getContextPath() + "/back/jsxq/qyxq?method=getShList&currentPage=1&msg=1");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * Я����Ҫ��˵�������ת�����ҳ��
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
			System.out.println("��ȡ id��" + id + "����Ϣ�ɹ�");
			request.setAttribute(Constant.JSXQBEAN, js);

			List<jsssly> list = jd.getAll();
			request.setAttribute(Constant.JSSSLY, list);

			request.getRequestDispatcher("back_jsxq_xxsh.jsp").forward(request, response);
		} catch (Exception e) {
			System.out.println("��ȡ��Ϣʧ��,id��" + id);
			e.printStackTrace();
		}
	}

	/**
	 * �鿴һ���������ϸ��Ϣ
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
			System.out.println("��ȡ id��" + id + "����Ϣ�ɹ�");
			request.setAttribute(Constant.JSXQBEAN, js);
			
			if(js.getSh()==1){
				request.setAttribute(Constant.MSG, "�鿴");
			}else{
				request.setAttribute(Constant.MSG, "���");
			}
			
			List<jsssly> list = jd.getAll();
			request.setAttribute(Constant.JSSSLY, list);

			request.getRequestDispatcher("back_jsxq_look.jsp").forward(request, response);
		} catch (Exception e) {
			System.out.println("��ȡ��Ϣʧ��,id��" + id);
			e.printStackTrace();
		}
	}

	/**
	 * Я�����������������Ϣ������˵���Ϣ��ת������ҳ��
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
				// ���״̬Ϊ��ʱ��װĬ�Ϸ�װֵΪ0�����´�����Ҫ������ȡ����
				String sh = request.getParameter("sh");
				if ("".equals(sh)) {
					page.setSh(null);
				}
			} catch (IllegalAccessException | InvocationTargetException e) {
				System.out.println("��װ�����쳣");
				e.printStackTrace();
			}
			

		} else {
			Object page1 = request.getSession().getAttribute(Constant.QYXQPAGINGBEAN);

			if (page1 != null) {
				page = (qyxqPagingBean) page1;
			}
			if(msg!=7){//7�����ǴӲ鿴��ϸ��Ϣ��ҳ�洫������
				request.setAttribute(Constant.MSG, "�޸ĳɹ�");
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
				System.out.println("��ȡ��ҳ��Ϣ�쳣");
				e.printStackTrace();
			}
	}

	/**
	 * Я�����������������Ϣ��δ��˺ͱ��˻ص���Ϣ��ת�����ҳ��
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
				// ���״̬Ϊ��ʱ��װĬ�Ϸ�װֵΪ0�����´�����Ҫ������ȡ����
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
			if(msg!=7){//7�����ǴӲ鿴��ϸ��Ϣ��ҳ�洫������
				request.setAttribute(Constant.MSG, "�޸ĳɹ�");
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
			System.out.println("��ȡ��ҳ��Ϣ�쳣");
			e.printStackTrace();
		}
	}

	/**
	 * ��������Ƿ����
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
				rst += "{status:'ERROR',msg:'����Ϣ�Ѿ�����'}";
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
	 * �����ҵ������Ϣ
	 * 
	 * @param request
	 * @param response
	 */
	private void add(HttpServletRequest request, HttpServletResponse response) {
		jsxq j = new jsxq();
		try {
			BeanUtils.populate(j, request.getParameterMap());
			// ��������������
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

			// ��ӵ��û���
			UserBean u = (UserBean) request.getSession().getAttribute("session_user");
			if (null != u) {
				j.setUsername(u.getUsername());
			}

			// ���ʱ��
			j.setTime(DateUtils.getDate());
			// ���״̬
			j.setSh(0);

			qyxqService qs = BasicFactory.getFactory().getService(qyxqService.class);
			qs.add(j);
			response.sendRedirect(request.getContextPath()+"/back/jsxq/qyxq?method=addUI&msg=1");
			
		} catch (Exception e) {
			System.out.println("��װ�����쳣");
			e.printStackTrace();
		}
	}

	/**
	 * Я�����������������Ϣ��ת�����ҳ��
	 * 
	 * @param request
	 * @param response
	 */
	private void addUI(HttpServletRequest request, HttpServletResponse response) {
		int msg = StringUtil.StringToInt(request.getParameter("msg"));
		if(msg!=0){
			request.setAttribute(Constant.MSG, "��ӳɹ�");
		}
		jssslyDao dao = BasicFactory.getFactory().getDao(jssslyDao.class);
		try {
			List<jsssly> list = dao.getAll();
			System.out.println("��ȡ�ɹ�");
			request.setAttribute(Constant.JSSSLY, list);

			request.getRequestDispatcher("/back/jsxq/back_jsxq.jsp").forward(request, response);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
