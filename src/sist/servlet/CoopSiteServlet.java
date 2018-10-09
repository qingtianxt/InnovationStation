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

import sist.bean.CoopSitePage;
import sist.domain.CoopSite;
import sist.factory.BasicFactory;
import sist.service.CoopSiteService;
import sist.utils.StringUtil;

/**
 * Servlet implementation class CoopSiteServlet
 */
@WebServlet("/back/cooperation_site/coopSiteServlet")
public class CoopSiteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String method = request.getParameter("method");
		if("add".equals(method)){
			addOrUpdate(request,response);
		}else if("list".equals(method)){
			list(request,response);
		}else if("getCoopSite".equals(method)){
			getCoopSite(request,response);
		}else if("del".equals(method)){
			delById(request,response);
		}else if("checkSiteName".equals(method)){
			checkSiteName(request,response);
		}
	}
	/*
	 * ������վ��������Ƿ��Ѿ�����,��Ҫ����ҳ����Ӻ���վ���ʱ�����
	 */
	private void checkSiteName(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String name = request.getParameter("name");
		boolean b = service.checkSiteName(name);
		response.getWriter().print(b);
	}

	/*
	 * ɾ������վ��
	 */
	private void delById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = StringUtil.StringToInt(request.getParameter("id"));
		boolean f = service.delById(id);
		request.getRequestDispatcher("coopSiteServlet?method=list&result=list&msg="+(f?3:4)).forward(request, response);
	}

	private void getCoopSite(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String result = request.getParameter("result");
		
		int id = StringUtil.StringToInt(request.getParameter("id"));
		CoopSite site = service.getCoopSite(id);
		request.setAttribute("site", site);
		if("detail".equals(result)){
			request.getRequestDispatcher("detail_site.jsp").forward(request, response);
		}else if("edit".equals(result)){
			request.getRequestDispatcher("add_site.jsp").forward(request, response);
		}
	}

	/*
	 * ��ҳ��ʾ����վ����Ϣ
	 */
	private void list(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		CoopSitePage sitePage = null;
		/// ��ȡmsg����
		int msg = StringUtil.StringToInt(request.getParameter("msg"));
		if(msg==0){// ���msg=0��˵����ѯ�µ���Ϣ��ʾ
			sitePage = new CoopSitePage(request.getParameter("siteName"),request.getParameter("siteLink"));
			sitePage.setCurrentPage(StringUtil.StringToInt(request.getParameter("currentPage")));
			sitePage.setPageSize(StringUtil.StringToInt(request.getParameter("pageSize")));
		}
		else{// �����Ƕ����ݽ��в�������ʾ��һ�εļ�¼
			Object page = request.getSession().getAttribute("pagingBean");
			if(page instanceof CoopSitePage)
				sitePage = (CoopSitePage) page;
		}
		
		List<CoopSite> list = service.getList(sitePage);
		request.setAttribute("coopSites", list);
		request.getSession().setAttribute("pagingBean", sitePage);
		
		request.getRequestDispatcher("list_site.jsp").forward(request, response);
	}
	/*
	 * ��ӻ����޸ĺ���վ����Ϣ
	 */
	private void addOrUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CoopSite site = new CoopSite();// ��װ��Ϣ��Javabean����
		try {
			BeanUtils.populate(site, request.getParameterMap());
		} catch (IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}
		boolean f = service.saveOrUpdate(site);
		String result = request.getParameter("result");
		if("add".contentEquals(result))
		{	// ���֮����ת�����ҳ����ʾ
			request.getRequestDispatcher("add_site.jsp?msg="+(f?1:2)).forward(request, response);
		}
		else if("list".equals(result))
		{
			// �޸�֮����ת��CoopSiteServlet����list����
			request.getRequestDispatcher("coopSiteServlet?method=list&result=list&msg="+(f?1:2)).forward(request, response);
		}
	}
	CoopSiteService service = BasicFactory.getFactory().getService(CoopSiteService.class);

}
