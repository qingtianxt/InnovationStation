package front.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.alibaba.fastjson.JSON;

import sist.bean.qyxqPagingBean;
import sist.dao.jssslyDao;
import sist.domain.UserBean;
import sist.domain.jsssly;
import sist.domain.jsxq;
import sist.factory.BasicFactory;
import sist.service.qyxqService;
import sist.utils.Constant;
import sist.utils.DateUtils;
import sist.utils.StringUtil;

/**
 * Servlet implementation class qyxqFrontServlet
 */
@WebServlet("/front/qyxq/qyxqFrontServlet")
public class qyxqFrontServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		String method = request.getParameter("method");
		if (!"".equals(method)) {
			if ("getList".equals(method)) {
				getList(request, response);
			} else if ("getById".equals(method)) {
				getById(request, response);
			} else if ("addUI".equals(method)) {
				addUI(request, response);
			} else if ("checkMc".equals(method)) {
				checkMc(request, response);
			} else if ("add".equals(method)) {
				add(request, response);
			} else if ("getListByUser".equals(method)) {
				getListByUser(request, response);
			} else if ("getTop".equals(method)) {// ��ȡǰ����
				getTop(request, response);
			} else if ("search".equals(method)) {// ģ����ѯ
				search(request, response);
			}
		}

	}

	/**
	 * ģ����ѯ
	 * 
	 * @param request
	 * @param response
	 */
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

			qyxqService qs = BasicFactory.getFactory().getService(qyxqService.class);
			int currentPage = StringUtil.StringToInt(request.getParameter("currentPage"));
			if (currentPage == 0) {
				currentPage = 1;
			}
			qyxqPagingBean page = new qyxqPagingBean();
			page.setCurrentPage(currentPage);

			page.setMc(key);

			try {
				page = qs.search(page);

				/*int i = 0;
				for (jsxq j : page.getList()) {
					i++;
					System.out.println(i + "---" + j.toString());
				}*/
				String preUrl = request.getContextPath() + "/front/qyxq/qyxqFrontServlet?method=search&key=" + key;
				System.out.println(JSON.toJSONString(page.getList()));
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

	/**
	 * ��ȡǰ����
	 * 
	 * @param request
	 * @param response
	 */
	private void getTop(HttpServletRequest request, HttpServletResponse response) {
		qyxqService qs = BasicFactory.getFactory().getService(qyxqService.class);

		List<jsxq> list = new ArrayList<>();
		try {
			list = qs.getTop();

			request.setAttribute(Constant.JSXQBEANS, list);
//			int i = 0;
//			for (jsxq j : list) {
//				i++;
//				System.out.println(i + "---" + j.toString());
//			}

			PrintWriter out = response.getWriter();
			out.println(JSON.toJSON(list));
			out.flush();
			out.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * �����û���ȡ������Ϣ
	 * 
	 * @param request
	 * @param response
	 */
	private void getListByUser(HttpServletRequest request, HttpServletResponse response) {
		
		 UserBean u = (UserBean) request.getSession().getAttribute("session_user");
		 
		 if (u == null) { 
			 request.setAttribute(Constant.MSG, "�㻹δ��¼,���ȵ�¼");
		 }
		 else {
		
		String currPage1 = request.getParameter("currentPage");
		int currPage = StringUtil.StringToInt(currPage1);

		qyxqPagingBean page = new qyxqPagingBean();
		qyxqService qy = BasicFactory.getFactory().getService(qyxqService.class);

		try {
			BeanUtils.populate(page, request.getParameterMap());

			// ���״̬Ϊ��ʱ��װĬ�Ϸ�װֵΪ0�����´�����Ҫ������ȡ����
			String sh = request.getParameter("sh");
			if ("".equals(sh)) {
				page.setSh(null);
			}

			page.setCurrentPage(currPage);
			try {
				page = qy.getListByUser(page, u.getUsername());

				page.setAnd(true);

				String url = request.getContextPath() + "/front/qyxq/qyxqFrontServlet?method=getListByUser";
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

				request.setAttribute(Constant.QYXQPAGINGBEAN, page);

			} catch (Exception e) {
				System.out.println("��ȡ��ҳ��Ϣ�쳣");
				e.printStackTrace();
			}
		} catch (IllegalAccessException | InvocationTargetException e) {
			System.out.println("��װ�����쳣");
			e.printStackTrace();
		}
		 }
		try {
			request.getRequestDispatcher("qyxq_wyjfb.jsp").forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
		
	}

	/**
	 * ǰ̨���
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
			request.setAttribute(Constant.MSG, "��ӳɹ�");
			response.sendRedirect(request.getContextPath()+"/front/qyxq/qyxqFrontServlet?method=addUI&msg=1");
			
		} catch (Exception e) {
			System.out.println("��װ�����쳣");
			e.printStackTrace();
		}
	}

	/**
	 * ��������Ƿ�ռ��
	 * 
	 * @param request
	 * @param response
	 */
	private void checkMc(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-genSystem.out.println(1);
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
	 * Я����������������ת�����ҳ��
	 * 
	 * @param request
	 * @param response
	 */
	private void addUI(HttpServletRequest request, HttpServletResponse response) {
		jssslyDao dao = BasicFactory.getFactory().getDao(jssslyDao.class);
		int msg = StringUtil.StringToInt(request.getParameter("msg"));
		if(msg!=0){
			request.setAttribute(Constant.MSG, "��ӳɹ�");
		}
		try {
			List<jsssly> list = dao.getAll();
			request.setAttribute(Constant.JSSSLY, list);
			
			request.getRequestDispatcher("qyxq_wyfb.jsp").forward(request, response);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * ����id��ȡ��Ϣ�����ӵ����
	 * 
	 * @param request
	 * @param response
	 */
	private void getById(HttpServletRequest request, HttpServletResponse response) {
		int id = StringUtil.StringToInt(request.getParameter("id"));
		qyxqService qs = BasicFactory.getFactory().getService(qyxqService.class);
		try {
			jsxq j = qs.getById(id);

			qs.addHits(id);

			jssslyDao jd = BasicFactory.getFactory().getDao(jssslyDao.class);
			if (j.getLy_js() != null) {
				String[] j1 = j.getLy_js().split(",");
				String jsssly = "";
				for (String s : j1) {
					int s1 = StringUtil.StringToInt(s);
					jsssly ly = jd.getById(s1);
					if (jsssly.equals("")) {
						jsssly = ly.getLymc();
					} else {
						jsssly += "," + ly.getLymc();
					}
				}
				request.setAttribute("jsssly", jsssly);
			}

			request.setAttribute(Constant.JSXQBEAN, j);
			request.getRequestDispatcher("qyxq_info.jsp").forward(request, response);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * ��ҳ��ѯ����������Ϣ��
	 * 
	 * @param request
	 * @param response
	 */
	private void getList(HttpServletRequest request, HttpServletResponse response) {
		String currPage1 = request.getParameter("currentPage");
		int currPage = StringUtil.StringToInt(currPage1);

		qyxqPagingBean page = new qyxqPagingBean();
		qyxqService qy = BasicFactory.getFactory().getService(qyxqService.class);

		try {
			BeanUtils.populate(page, request.getParameterMap());
			// ���״̬Ϊ��ʱ��װĬ�Ϸ�װֵΪ0�����´�����Ҫ������ȡ����
			String sh = request.getParameter("sh");
			if ("".equals(sh)) {
				page.setSh(null);
			}

			page.setCurrentPage(currPage);
			try {
				page = qy.getGlList(page);
				page.setAnd(true);

				String url = request.getContextPath() + "/front/qyxq/qyxqFrontServlet?method=getList";
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

				request.setAttribute(Constant.QYXQPAGINGBEAN, page);

				jssslyDao jd = BasicFactory.getFactory().getDao(jssslyDao.class);
				List<jsssly> list = jd.getAll();
				request.setAttribute(Constant.JSSSLY, list);

				int msg = StringUtil.StringToInt(request.getParameter("msg"));
				if (msg != 0) {
					request.setAttribute(Constant.MSG, "ɾ���ɹ�");
				}

				request.getRequestDispatcher("qyxq_yzj.jsp").forward(request, response);
			} catch (Exception e) {
				System.out.println("��ȡ��ҳ��Ϣ�쳣");
				e.printStackTrace();
			}
		} catch (IllegalAccessException | InvocationTargetException e) {
			System.out.println("��װ�����쳣");
			e.printStackTrace();
		}
	}
}
