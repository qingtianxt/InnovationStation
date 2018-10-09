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

import sist.bean.FwptPagingBean;
import sist.bean.NewsPaging;
import sist.bean.PatentPage;
import sist.bean.SupplyPagingBean;
import sist.bean.kjcgPagingBean;
import sist.bean.qyxqPagingBean;
import sist.bean.zcfgPagingBean;
import sist.bean.zjxxPagingBean;
import sist.dao.gmjjDao;
import sist.dao.jssslyDao;
import sist.dao.jstxxsDao;
import sist.dao.ssgxjslbDao;
import sist.dao.zyzddxDao;
import sist.domain.Fwpt;
import sist.domain.JSGJBean;
import sist.domain.NewsBean;
import sist.domain.Patent;
import sist.domain.cgal;
import sist.domain.cgzhxm;
import sist.domain.gmjj;
import sist.domain.jsssly;
import sist.domain.jstxxs;
import sist.domain.jsxq;
import sist.domain.kjcg;
import sist.domain.ssgxjslb;
import sist.domain.zcfg;
import sist.domain.zjxx;
import sist.domain.zyzddx;
import sist.factory.BasicFactory;
import sist.service.FwptService;
import sist.service.JSGJService;
import sist.service.NewsService;
import sist.service.PatentService;
import sist.service.cgalService;
import sist.service.cgzhxmService;
import sist.service.kjcgService;
import sist.service.qyxqService;
import sist.service.zcfgService;
import sist.service.zjxxService;
import sist.utils.Constant;
import sist.utils.StringUtil;
import sist.utils.URLUtil;

/**
 * Servlet implementation class xxjsServlet
 */
@WebServlet("/back/xxjs/xxjsServlet")
public class xxjsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BasicFactory factory = BasicFactory.getFactory();
	private PatentService service;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");

		String method = request.getParameter("method");
		if ("searchNews".equals(method)) {
			searchNews(request, response);
		} else if ("getNewsById".equals(method)) {
			getNewsById(request, response);
		} else if ("searchXuqiu".equals(method)) {
			searchXuqiu(request, response);
		} else if ("searchJishu".equals(method)) {
			searchJishu(request, response);
		} else if ("getSupplyById".equals(method)) {
			getSupplyById(request, response);
		} else if ("searchChengguo".equals(method)) {
			searchChengguo(request, response);
		} else if ("searchZhuanli".equals(method)) {
			searchZhuanli(request, response);
		} else if ("getZhuanliById".equals(method)) {
			getZhuanliById(request, response);
		} else if ("searchZhuanJia".equals(method)) {
			searchZhuanJia(request, response);
		} else if ("searchZhengce".equals(method)) {
			searchZhengce(request, response);
		} else if ("searchPingtai".equals(method)) {
			searchPingtai(request, response);
		} else if ("getPingTaiByKmAndMc".equals(method)) {
			getPingTaiByKmAndMc(request, response);
		} else if ("getChengguoById".equals(method)) {
			getChengguoById(request, response);
		} else if ("getXuqiuById".equals(method)) {
			getXuqiuById(request, response);
		} else if ("getZhengceById".equals(method)) {
			getZhengceById(request, response);
		}else if("getZhuanjiaById".equals(method)){
			getZhuanjiaById(request,response);
		}
	}

	private void getZhuanjiaById(HttpServletRequest request, HttpServletResponse response) {

		int id = StringUtil.StringToInt(request.getParameter("id"));
		zjxxService zs = BasicFactory.getFactory().getService(zjxxService.class);
		try {
			zjxx z = zs.getById(id);
			request.setAttribute(Constant.ZJXXBEAN, z);

			request.getRequestDispatcher("detailZhuanjia.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}

	private void getZhengceById(HttpServletRequest request, HttpServletResponse response) {

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
			request.getRequestDispatcher("detailZhengce.jsp").forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}

	}

	private void getXuqiuById(HttpServletRequest request, HttpServletResponse response) {

		int id = StringUtil.StringToInt(request.getParameter("id"));
		qyxqService qs = BasicFactory.getFactory().getService(qyxqService.class);

		jssslyDao jd = BasicFactory.getFactory().getDao(jssslyDao.class);
		try {
			jsxq js = qs.getInfo(id);
			System.out.println("��ȡ id��" + id + "����Ϣ�ɹ�");
			request.setAttribute(Constant.JSXQBEAN, js);
			List<jsssly> list = jd.getAll();
			request.setAttribute(Constant.JSSSLY, list);

			request.getRequestDispatcher("detailXuqiu.jsp").forward(request, response);
		} catch (Exception e) {
			System.out.println("��ȡ��Ϣʧ��,id��" + id);
			e.printStackTrace();
		}

	}

	private void getChengguoById(HttpServletRequest request, HttpServletResponse response) {

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
					request.getRequestDispatcher("detailChengguo.jsp").forward(request, response);
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
					request.getRequestDispatcher("detailAnli.jsp").forward(request, response);
				} catch (ServletException | IOException e) {
					e.printStackTrace();
				}
			}
		}

	}

	/**
	 * ��ȡƽ̨��Ϣ
	 * 
	 * @param request
	 * @param response
	 */
	private void getPingTaiByKmAndMc(HttpServletRequest request, HttpServletResponse response) {

		String mc = request.getParameter("mc");
		String km = request.getParameter("km");
		System.out.println(mc + "   " + km);
		FwptService fs = BasicFactory.getFactory().getService(FwptService.class);
		try {
			Fwpt f = fs.getByKmAndMc(km, mc);
			request.setAttribute(Constant.FWPTBEAN, f);
			System.out.println(f.toString());
			request.getRequestDispatcher("detailPingtai.jsp").forward(request, response);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * ��ƽ̨
	 * 
	 * @param request
	 * @param response
	 */
	private void searchPingtai(HttpServletRequest request, HttpServletResponse response) {
		FwptPagingBean page = new FwptPagingBean();
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
				msg1 = "ɾ���ɹ�";
			} else if (msg == 2) {
				msg1 = "�޸ĳɹ�";
			}
			request.setAttribute(Constant.MSG, msg1);

			Object page1 = request.getSession().getAttribute(Constant.FWPTPAGINGBEAN);
			if (page1 != null) {
				page = (FwptPagingBean) page1;
			}

		}
		FwptService fs = BasicFactory.getFactory().getService(FwptService.class);

		try {
			page = fs.getList(page);

			String url = request.getContextPath() + "/back/xxjs/xxjsServlet?method=searchPingtai";
			page.setAnd(true);
			if (null != page.getMc() && !"".equals(page.getMc())) {
				url += "&mc=" + page.getMc();
			}
			if (null != page.getKm() && !"".equals(page.getKm())) {
				url += "&km=" + page.getKm();
			}
			if (null != page.getLxr() && !"".equals(page.getLxr())) {
				url += " &lxr=" + page.getLxr();
			}
			if (null != page.getGjc() && !"".equals(page.getGjc())) {
				url += "&gjc=" + page.getGjc();
			}
			page.setPreUrl(url);
			System.out.println(page);
			request.getSession().setAttribute(Constant.FWPTPAGINGBEAN, page);

			request.getRequestDispatcher("searchPingtai.jsp").forward(request, response);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void searchZhengce(HttpServletRequest request, HttpServletResponse response) {

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
				msg1 = "ɾ���ɹ�";
			} else if (msg == 2) {
				msg1 = "�޸ĳɹ�";
			}
			request.setAttribute(Constant.MSG, msg1);

			Object page1 = request.getSession().getAttribute(Constant.ZCFGPAGINGBEAN);
			if (page1 != null) {
				page = (zcfgPagingBean) page1;
			}

		}

		zcfgService zs = BasicFactory.getFactory().getService(zcfgService.class);
		try {
			page = zs.getList(page);

			page.setAnd(true);
			String url = request.getContextPath() + "/back/xxjs/xxjsServlet?method=searchZhengce";
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

			request.getRequestDispatcher("searchZhengce.jsp").forward(request, response);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * ��ר��
	 * 
	 * @param request
	 * @param response
	 */
	private void searchZhuanJia(HttpServletRequest request, HttpServletResponse response) {

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
				msg1 = "ɾ���ɹ�";
			} else if (msg == 2) {
				msg1 = "�޸ĳɹ�";
			}
			request.setAttribute(Constant.MSG, msg1);

			Object page1 = request.getSession().getAttribute(Constant.ZJXXPAGINGBEAN);
			if (page1 != null) {
				page = (zjxxPagingBean) page1;
			}
		}

		zjxxService zs = BasicFactory.getFactory().getService(zjxxService.class);
		try {
			page = zs.getList(page);

		} catch (Exception e1) {
			e1.printStackTrace();
		}

		page.setAnd(true);
		String url = request.getContextPath() + "/back/xxjs/xxjsServlet?method=searchZhuanJia";

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
			request.getRequestDispatcher("searchZhuanJia.jsp").forward(request, response);

		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}

	}

	private void getZhuanliById(HttpServletRequest request, HttpServletResponse response) {
		int id = StringUtil.StringToInt(request.getParameter("id"));
		Patent patent = service.getPatenet(id);
		request.setAttribute("patent", patent);
		try {
			request.getRequestDispatcher("detailZhuanli.jsp").forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * ��ר��
	 * 
	 * @param request
	 * @param response
	 */
	private void searchZhuanli(HttpServletRequest request, HttpServletResponse response) {
		service = BasicFactory.getFactory().getService(PatentService.class);
		PatentPage page = new PatentPage();
		int msg = StringUtil.StringToInt(request.getParameter("msg"));
		try {
			if (msg == 0) {
				BeanUtils.populate(page, request.getParameterMap());
			} else {
				Object object = request.getSession().getAttribute("pagingBean");
				if (object instanceof PatentPage)
					page = (PatentPage) object;
			}
		} catch (IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		List<Patent> list = service.getList(page);
		System.out.println(list);
		request.setAttribute("patents", list);
		page.setPreUrl(
				request.getContextPath() + "/back/xxjs/xxjsServlet?method=searchZhuanli&" + URLUtil.preUrl(page));
		request.getSession().setAttribute("pagingBean", page);

		try {
			request.getRequestDispatcher("searchZhuanli.jsp").forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * �ҳɹ�
	 * 
	 * @param request
	 * @param response
	 */
	private void searchChengguo(HttpServletRequest request, HttpServletResponse response) {

		kjcgPagingBean page = new kjcgPagingBean();
		int msg = StringUtil.StringToInt(request.getParameter("msg"));
		String msg1 = null;

		if (msg == 0) {

			try {
				BeanUtils.populate(page, request.getParameterMap());

				System.out.println(page.getKm());
				String currentPage1 = request.getParameter("currentPage");

				int currentPage = StringUtil.StringToInt(currentPage1);
				page.setCurrentPage(currentPage);
			} catch (IllegalAccessException | InvocationTargetException e) {
				System.out.println("���b�����쳣");
				e.printStackTrace();
			}

		} else {
			if (msg == 1) {
				msg1 = "ɾ���ɹ�";
			} else if (msg == 2) {
				msg1 = "�޸ĳɹ�";
			}
			request.setAttribute(Constant.MSG, msg1);

			Object page1 = request.getSession().getAttribute(Constant.KJCGPAGINGBEAN);
			if (page1 != null) {
				page = (kjcgPagingBean) page1;
			}

		}

		kjcgService ks = BasicFactory.getFactory().getService(kjcgService.class);

		try {
			page = ks.getList(page);
			page.setAnd(true);
			String url = request.getContextPath() + "/back/xxjs/xxjsServlet?method=searchChengguo";
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

			request.getRequestDispatcher("searchChengguo.jsp").forward(request, response);
		} catch (Exception e) {
			System.out.println("��ȡ��ҳ��Ϣ�쳣");
			e.printStackTrace();
		}

	}

	/**
	 * ����id��ȡ������Ϣ
	 * 
	 * @param request
	 * @param response
	 */
	private void getSupplyById(HttpServletRequest request, HttpServletResponse response) {
		int id = StringUtil.StringToInt(request.getParameter("id"));
		JSGJService service = factory.getService(JSGJService.class);
		JSGJBean bean = service.getSupply(id);
		request.setAttribute("supply", bean);
		try {
			request.getRequestDispatcher("detailSupply.jsp").forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * �Ҽ���
	 * 
	 * @param request
	 * @param response
	 */
	private void searchJishu(HttpServletRequest request, HttpServletResponse response) {

		// ��Ų�ѯ��Ϣ��Javabean
		SupplyPagingBean pagingBean = new SupplyPagingBean();
		// ��װ��ѯ����
		try {
			int msg = StringUtil.StringToInt(request.getParameter("msg"));
			if (msg == 0) {
				// �������Ǵ�ҳ�淢��
				BeanUtils.populate(pagingBean, request.getParameterMap());
			} else {
				// �������Ǵ�servletת������
				Object page = request.getSession().getAttribute("supplyPageBean");
				if (page != null)
					pagingBean = (SupplyPagingBean) page;
			}
		} catch (IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}

		JSGJService service = factory.getService(JSGJService.class);
		// ���ò�ѯ��ҵ���߼�
		List<JSGJBean> list = service.getList(pagingBean);
		// ������·���е���Ӧ
		try {

			request.getRequestDispatcher("/back/selectionServlet?method=getJslbList&result=include").include(request,
					response);

			request.setAttribute("SupplyList", list);
			request.getSession().setAttribute("supplyPageBean", pagingBean);

			pagingBean.setPreUrl(request.getContextPath() + "/back/xxjs/xxjsServlet?method=searchJishu&"
					+ URLUtil.preUrl(pagingBean));
			request.getRequestDispatcher("searchJishu.jsp").forward(request, response);

		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * ������
	 * 
	 * @param request
	 * @param response
	 */
	private void searchXuqiu(HttpServletRequest request, HttpServletResponse response) {

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
			if (msg != 7) {// 7�����ǴӲ鿴��ϸ��Ϣ��ҳ�洫������
				request.setAttribute(Constant.MSG, "�޸ĳɹ�");
			}

		}

		qyxqService qy = BasicFactory.getFactory().getService(qyxqService.class);

		try {
			page = qy.getGlList(page);

			page.setAnd(true);

			String url = request.getContextPath() + "/back/xxjs/xxjsServlet?method=searchXuqiu";
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

			request.getRequestDispatcher("searchXuqiu.jsp").forward(request, response);
		} catch (Exception e) {
			System.out.println("��ȡ��ҳ��Ϣ�쳣");
			e.printStackTrace();
		}

	}

	private void getNewsById(HttpServletRequest request, HttpServletResponse response) {
		int id = StringUtil.StringToInt(request.getParameter("id"));
		NewsService service = BasicFactory.getFactory().getService(NewsService.class);
		NewsBean newsBean = service.getNews(id);

		request.setAttribute("newsBean", newsBean);
		try {
			request.getRequestDispatcher("detailNews.jsp").forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * ������
	 * 
	 * @param request
	 * @param response
	 */
	private void searchNews(HttpServletRequest request, HttpServletResponse response) {
		NewsPaging newsPaging = new NewsPaging();
		try {
			int msg = StringUtil.StringToInt(request.getParameter("msg"));
			if (msg == 0) {
				BeanUtils.populate(newsPaging, request.getParameterMap());
			} else {
				Object page = request.getSession().getAttribute("newsPaging");
				if (page != null)
					newsPaging = (NewsPaging) page;
			}
			NewsService service = BasicFactory.getFactory().getService(NewsService.class);
			List<NewsBean> list = service.getList(newsPaging);
			String preUrl = request.getContextPath() + "/back/xxjs/xxjsServlet?method=searchNews&"
					+ URLUtil.preUrl(newsPaging);
			newsPaging.setPreUrl(preUrl);
			// ת������ʾҳ��
			request.setAttribute("newsBeans", list);
			request.getSession().setAttribute("newsPaging", newsPaging);
			try {
				request.getRequestDispatcher("searchNews.jsp").forward(request, response);
			} catch (ServletException | IOException e) {
				e.printStackTrace();
			}

		} catch (IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
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
