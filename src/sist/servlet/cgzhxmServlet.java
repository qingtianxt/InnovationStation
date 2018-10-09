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
 * �ɹ�ת����Ŀģ��
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
			cgzhxmUI(request, response);// Я���������¼������ͼ��������������Ϣ��ת���ɹ�ת����Ŀҳ��
		} else if ("checkXMc".equals(method)) {
			checkXMc(request, response);// (���ʱʹ��)���ɹ�ת����Ŀ�����Ƿ��Ѿ�����
		} else if ("addCgzhxm".equals(method)) {
			addCgzhxm(request, response);
		} else if ("checkMcUpdate".equals(method)) {
			checkMcUpdate(request, response);// (�޸�ʱʹ��)���ɹ�ת����Ŀ�����Ƿ��Ѿ�����
		} else if ("update".equals(method)) {
			update(request, response);
		}

	}

	/**
	 * �޸ĳɹ�ת����Ŀ��Ϣ�����޸ĿƼ��ɹ����е�����
	 * 
	 * @param request
	 * @param response
	 */
	private void update(HttpServletRequest request, HttpServletResponse response) {
		cgzhxm c = new cgzhxm();
		kjcg k = new kjcg();
		// ��ӵ��û���
		UserBean u = (UserBean) request.getSession().getAttribute("session_user");
		if (null != u) {
			c.setUsername(u.getUsername());
			k.setUsername(u.getUsername());
		}

		// ���ʱ��
		c.setTime(DateUtils.getDate());

		// ����Ӧ����ҵ
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
			k.setKm("�ɹ�ת����Ŀ");
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
			// ������������
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
			// �ɹ�������ʽ
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
			System.out.println("��װ����ʧ��");
			e.printStackTrace();
		}
	}

	/**
	 * �ж���Ҫ�޸ĵ�ҳ��ĳɹ�ת����Ŀ�Ƿ���ڣ�ע���޸ĵ�ʱ�����Ʋ��޸�Ҳ����
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
			cgzhxm c = cs.getById(id);// ����id��ȡ�����޸�֮ǰ�ĿƼ��ɹ���Ϣ
			cgzhxm c1 = cs.getByMc(mc);// �������ƻ�ȡ�����޸ĺ�������Ƿ������ݿ��д���

			String rst = "";
			if (c1 != null && c1.getMc().equals(c.getMc())) {// �����������ݿ��д����ҵ���ԭ��������
				rst = "{status:'OK'}";
			} else if (null == c1) {// �����������ݿ��в�����
				rst = "{status:'OK'}";
			} else {
				rst = "{status:'ERROR',msg:'����Ϣ�Ѿ�����'}";
			}
			response.getWriter().print(rst);
			response.getWriter().flush();
			response.getWriter().close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * ��ӳɹ�ת����Ŀ
	 * 
	 * @param request
	 * @param response
	 */
	private void addCgzhxm(HttpServletRequest request, HttpServletResponse response) {
		cgzhxm c = new cgzhxm();

		kjcg k = new kjcg();
		// ��ӵ��û���
		UserBean u = (UserBean) request.getSession().getAttribute("session_user");
		if (null != u) {
			c.setUsername(u.getUsername());
			k.setUsername(u.getUsername());
		}

		// ���ʱ��
		c.setTime(DateUtils.getDate());

		// ����Ӧ����ҵ
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
			k.setKm("�ɹ�ת����Ŀ");

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
			// ������������
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
			// �ɹ�������ʽ
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
				request.setAttribute(Constant.MSG, "��ӳɹ�");
				response.sendRedirect(request.getContextPath()+"/back/kjcg/cgzhxmServlet?method=cgzhxmUI&status=1");
			} catch (Exception e) {
				e.printStackTrace();
			}

		} catch (IllegalAccessException | InvocationTargetException e) {
			System.out.println("��װ����ʧ��");
			e.printStackTrace();
		}
	}

	/**
	 * ���ɹ�ת����Ŀ�����Ƿ��Ѿ�����
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
				rst += "{status:'ERROR',msg:'����Ϣ�Ѿ�����'}";
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
	 * Я���������¼������ͼ��������������Ϣ��ת���ɹ�ת����Ŀҳ��
	 * 
	 * @param request
	 * @param response
	 */
	private void cgzhxmUI(HttpServletRequest request, HttpServletResponse response) {
		getlbAndLy(request, response);
		try {
			int status = StringUtil.StringToInt(request.getParameter("status"));
			if(status==1){
				request.setAttribute(Constant.MSG, "��ӳɹ�");
			}
			request.getRequestDispatcher("back_kjcg.jsp").forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * ��ȡ���¼������ͼ�����������,�ͳɹ�������ʽ
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
