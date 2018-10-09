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

import sist.bean.zcfgPagingBean;
import sist.dao.zyzddxDao;
import sist.domain.zcfg;
import sist.domain.zyzddx;
import sist.factory.BasicFactory;
import sist.service.zcfgService;
import sist.utils.Constant;
import sist.utils.StringUtil;

/**
 * Servlet implementation class zcfgFrontServlet
 */
@WebServlet("/front/zcfg/zcfgFrontServlet")
public class zcfgFrontServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");

		String method = request.getParameter("method");
		if ("getList".equals(method)) {
			getList(request, response);
		} else if ("getById".equals(method)) {
			getById(request, response);
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

			zcfgService zs = BasicFactory.getFactory().getService(zcfgService.class);

			int currentPage = StringUtil.StringToInt(request.getParameter("currentPage"));
			if (currentPage == 0) {
				currentPage = 1;
			}
			zcfgPagingBean page = new zcfgPagingBean();
			page.setCurrentPage(currentPage);

			page.setZcmc(key);

			try {
				page = zs.search(page);

//				int i = 0;
//				for (zcfg j : page.getList()) {
//					i++;
//					System.out.println(i + "---" + j.toString());
//				}
				String preUrl = request.getContextPath() + "/front/zcfg/zcfgFrontServlet?method=search&key=" + key;

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
		zcfgService zs = BasicFactory.getFactory().getService(zcfgService.class);
		List<zcfg> list;
		try {
			list = zs.getTop();

			request.setAttribute(Constant.ZCFGBEANS, list);
//
//			int i = 0;
//			for (zcfg j : list) {
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

	private void getById(HttpServletRequest request, HttpServletResponse response) {
		int id = StringUtil.StringToInt(request.getParameter("id"));
		zyzddxDao zd = BasicFactory.getFactory().getDao(zyzddxDao.class);

		zcfgService zs = BasicFactory.getFactory().getService(zcfgService.class);
		try {
			zcfg z = zs.getById(id);
			
			zs.addHits(id);
			String zyzddx = "";
			try {
				List<zyzddx> list = zd.getAll();

				if (z.getTtzlymc() != null) {
					String[] z1 = z.getTtzlymc().split(",");

					for (String z2 : z1) {
						for (zyzddx l : list) {
							if (l.getZyzddxid() == StringUtil.StringToInt(z2)) {

								if (zyzddx.equals("")) {
									zyzddx = l.getZyzddxmc();
								} else {
									zyzddx += "," + l.getZyzddxmc();
								}

							}
						}

					}
					request.setAttribute(Constant.ZYZDDX, zyzddx);
				}

			} catch (Exception e) {
				e.printStackTrace();
			}

			request.setAttribute(Constant.ZCFGBEAN, z);
			request.getRequestDispatcher("zcfg_info.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * 获取已征集的政策法规信息。
	 * 
	 * @param request
	 * @param response
	 */
	private void getList(HttpServletRequest request, HttpServletResponse response) {

		int currentPage = StringUtil.StringToInt(request.getParameter("currentPage"));

		zcfgPagingBean page = new zcfgPagingBean();

		try {
			BeanUtils.populate(page, request.getParameterMap());

			page.setCurrentPage(currentPage);
			zcfgService zs = BasicFactory.getFactory().getService(zcfgService.class);
			try {
				page = zs.getList(page);

				page.setAnd(true);
				String url = request.getContextPath() + "/front/zcfg/zcfgFrontServlet?method=getList";
				if (null != page.getZcmc() && !"".equals(page.getZcmc())) {
					url += "&zcmc=" + page.getZcmc();
				}
				if (null != page.getTime1() && !"".equals(page.getTime1())) {
					url += "&time1=" + page.getTime1();
				}
				if (null != page.getTime2() && !"".equals(page.getTime2())) {
					url += "&time2=" + page.getTime2();
				}
				System.out.println(url);
				page.setPreUrl(url);

				request.setAttribute(Constant.ZCFGPAGINGBEAN, page);

				int msg = StringUtil.StringToInt(request.getParameter("msg"));
				String msg1 = null;
				if (msg == 1) {
					msg1 = "删除成功";
				} else if (msg == 2) {
					msg1 = "修改成功";
				}
				request.setAttribute(Constant.MSG, msg1);

				request.getRequestDispatcher("zcfg_yzj.jsp").forward(request, response);

			} catch (Exception e) {
				e.printStackTrace();
			}

		} catch (IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}

	}
}
