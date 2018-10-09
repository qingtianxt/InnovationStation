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

import sist.bean.kjcgPagingBean;
import sist.dao.gmjjDao;
import sist.dao.jssslyDao;
import sist.dao.jstxxsDao;
import sist.dao.ssgxjslbDao;
import sist.domain.cgal;
import sist.domain.cgzhxm;
import sist.domain.gmjj;
import sist.domain.jsssly;
import sist.domain.jstxxs;
import sist.domain.kjcg;
import sist.domain.ssgxjslb;
import sist.factory.BasicFactory;
import sist.service.cgalService;
import sist.service.cgzhxmService;
import sist.service.kjcgService;
import sist.utils.Constant;
import sist.utils.StringUtil;

/**
 * �Ƽ��ɹ�ģ��
 */
@WebServlet("/back/kjcg/kjcgServlet")
public class kjcgServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");

		String method = request.getParameter("method");
		if ("getList".equals(method)) {
			getList(request, response);
		} else if ("delete".equals(method)) {
			delete(request, response);
		} else if ("look".equals(method)) {
			look(request, response);
		} else if ("editUI".equals(method)) {
			editUI(request, response);
		} 
	}
	/**
	 * ����id��ѯ�Ƽ��ɹ���Ϣ����Я�����¼������ͼ�����������,�ͳɹ�������ʽ��ת���޸�ҳ��
	 * 
	 * @param request
	 * @param response
	 */
	private void editUI(HttpServletRequest request, HttpServletResponse response) {
		int id = StringUtil.StringToInt(request.getParameter("id"));
		kjcgService ks = BasicFactory.getFactory().getService(kjcgService.class);
		kjcg k = null;
		try {
			k = ks.getById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (k != null) {
			if (k.getKm().equals("�ɹ�ת����Ŀ")) {
				cgzhxmService cs = BasicFactory.getFactory().getService(cgzhxmService.class);
				cgzhxm c = null;
				try {
					c = cs.getByMc(k.getMc());
				} catch (Exception e) {
					e.printStackTrace();
				}

				// ��ȡ��������������Ϣ�ͳɹ�������ʽ��Ϣ
				getlbAndLy(request, response);

				request.setAttribute(Constant.CGZHXMBEAN, c);
				try {
					request.getRequestDispatcher("back_kjcg_update.jsp").forward(request, response);
				} catch (ServletException | IOException e) {
					e.printStackTrace();
				}
			} else if (k.getKm().equals("�ɹ�����")) {
				cgalService cs = BasicFactory.getFactory().getService(cgalService.class);
				try {
					cgal c = cs.getByMc(k.getMc());
					request.setAttribute(Constant.CGALBEAN, c);
				} catch (Exception e) {
					e.printStackTrace();
				}
				try {
					request.getRequestDispatcher("back_cgal_update.jsp").forward(request, response);
				} catch (ServletException | IOException e) {
					e.printStackTrace();
				}
			}
		}

	}

	/**
	 * ����id��ѯ�Ƽ��ɹ������ж��ǳɹ�ת����Ŀ���ǳɹ�����������ת����Ӧҳ��չʾ��Ϣ��
	 * 
	 * @param request
	 * @param response
	 */
	private void look(HttpServletRequest request, HttpServletResponse response) {
		int id = StringUtil.StringToInt(request.getParameter("id"));
		kjcgService ks = BasicFactory.getFactory().getService(kjcgService.class);
		kjcg k = null;
		try {
			k = ks.getById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (k != null) {
			if (k.getKm().equals("�ɹ�ת����Ŀ")) {
				cgzhxmService cs = BasicFactory.getFactory().getService(cgzhxmService.class);
				cgzhxm c = null;
				try {
					c = cs.getByMc(k.getMc());
				} catch (Exception e) {
					e.printStackTrace();
				}
				if (!"".equals(c.getYyhy())) {
					gmjjDao gd = BasicFactory.getFactory().getDao(gmjjDao.class);
					gmjj g;
					try {
						g = gd.getByCode(c.getYyhy());

						request.setAttribute(Constant.YYHY, g.getTitle());
					} catch (Exception e) {
						e.printStackTrace();
					}

				}

				// ��ȡ��������������Ϣ�ͳɹ�������ʽ��Ϣ
				getlbAndLy(request, response);

				request.setAttribute(Constant.CGZHXMBEAN, c);
				try {
					request.getRequestDispatcher("back_kjcg_look.jsp").forward(request, response);
				} catch (ServletException | IOException e) {
					e.printStackTrace();
				}
			} else if (k.getKm().equals("�ɹ�����")) {
				cgalService cs = BasicFactory.getFactory().getService(cgalService.class);
				try {
					cgal c = cs.getByMc(k.getMc());
					request.setAttribute(Constant.CGALBEAN, c);
				} catch (Exception e) {
					e.printStackTrace();
				}
				try {
					request.getRequestDispatcher("back_cgal_look.jsp").forward(request, response);
				} catch (ServletException | IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * ��������ɾ���Ƽ��ɹ������ݣ���ɾ�����ĳɹ��������ڱ����Ϣ��Ȼ���ض���getList
	 * 
	 * @param request
	 * @param response
	 */
	private void delete(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		System.out.println(id);
		kjcgService ks = BasicFactory.getFactory().getService(kjcgService.class);
		try {
			ks.delete(id);
			response.sendRedirect(
					request.getContextPath() + "/back/kjcg/kjcgServlet?method=getList&currentPage=1&msg=1");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void getList(HttpServletRequest request, HttpServletResponse response) {
		kjcgPagingBean page = new kjcgPagingBean();
		int msg = StringUtil.StringToInt(request.getParameter("msg"));
		String msg1 = null;
		
		if(msg==0){

			try {
				BeanUtils.populate(page, request.getParameterMap());
				
				String currentPage1 = request.getParameter("currentPage");

				int currentPage = StringUtil.StringToInt(currentPage1);
				page.setCurrentPage(currentPage);
			}  catch (IllegalAccessException | InvocationTargetException e) {
				System.out.println("���b�����쳣");
				e.printStackTrace();
			} 
			
		}else{
			if (msg == 1) {
				msg1 = "ɾ���ɹ�";
			} else if (msg == 2) {
				msg1 = "�޸ĳɹ�";
			}
			request.setAttribute(Constant.MSG, msg1);
			
			Object page1 = request.getSession().getAttribute(Constant.KJCGPAGINGBEAN);
			if(page1!=null){
				page= (kjcgPagingBean) page1;
			}
			
		}
		
		kjcgService ks = BasicFactory.getFactory().getService(kjcgService.class);

			try {
				page = ks.getList(page);
				page.setAnd(true);
				String url = request.getContextPath() + "/back/kjcg/kjcgServlet?method=getList";
				if (null != page.getMc() && !"".equals(page.getMc())) {
					url += "&mc=" + page.getMc();
				}
				if (null != page.getKm() && !"".equals(page.getKm())) {
					url += "&km=" + page.getKm();

				}
				if (null != page.getDw() && !"".equals(page.getDw())) {
					url += "&dw=" + page.getDw();
				}
				if (null != page.getTime1() && !"".equals(page.getTime1())) {
					url += "&time1=" + page.getTime1();
				}
				if (null != page.getTime2() && !"".equals(page.getTime2())) {
					url += "&time2=" + page.getTime2();
				}
				System.out.println("url:" + url);
				page.setPreUrl(url);
				request.getSession().setAttribute(Constant.KJCGPAGINGBEAN, page);
				
				request.getRequestDispatcher("back_kjcg_gl.jsp").forward(request, response);
			} catch (Exception e) {
				System.out.println("��ȡ��ҳ��Ϣ�쳣");
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
