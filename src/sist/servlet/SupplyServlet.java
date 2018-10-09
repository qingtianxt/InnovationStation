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

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import sist.bean.SupplyPagingBean;
import sist.domain.JSGJBean;
import sist.factory.BasicFactory;
import sist.service.JSGJService;
import sist.utils.StringUtil;
import sist.utils.URLUtil;

/**
 * ������������
 */
@WebServlet("/back/technology_supply/supplyServlet")
public class SupplyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BasicFactory factory = BasicFactory.getFactory();
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String method = request.getParameter("method");
		if("add".equalsIgnoreCase(method)){
			saveOrUpdate(request,response);
		}else if("list".equalsIgnoreCase(method)){
			listSupply(request,response);
		}else if("getSupply".equals(method)){
			getSupply(request,response);
		}else if("update".equalsIgnoreCase(method)){
			saveOrUpdate(request,response);
		}else if("del".equalsIgnoreCase(method)){
			del(request,response);
		}else if("checkName".equalsIgnoreCase(method)){
			checkName(request,response);
		}
	}

	private void checkName(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String name = request.getParameter("name");
		
		JSGJService service = factory.getService(JSGJService.class);
		boolean b = service.checkName(name);
		String json = request.getParameter("result");
		if("json".equalsIgnoreCase(json)){
			response.getWriter().print(b);
		}
	}

	/**
	 * ����ɾ��������Ϣ������
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void del(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		JSGJService service = factory.getService(JSGJService.class);
		boolean f = service.delById(StringUtil.StringToInt(request.getParameter("id")));
		
		// result������ʾ�������ʵĵ�ַ
		String result = request.getParameter("result");
		if("list".equals(result)){
			// �����ҳ��ɾ����ɾ������Ҫ��ת�����ҳ��
			request.getRequestDispatcher("supplyServlet?method=list&result=list&status=sh in (-1,0)&msg="+(f?3:4)).forward(request, response);
		}else if("list2".equals(result)){
			// �ӹ���ҳ��ɾ����ɾ������ת������ҳ��
			request.getRequestDispatcher("supplyServlet?method=list&result=list2&status=sh in (1)&msg="+(f?3:4)).forward(request, response);
		}
	}

	private void getSupply(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = StringUtil.StringToInt(request.getParameter("id"));
		String result = request.getParameter("result");
		JSGJService service = factory.getService(JSGJService.class);
		JSGJBean bean = service.getSupply(id);
		request.setAttribute("supply", bean);
		if("detail".equals(result)){
			// �鿴��������������Ҫ��ת��ҳ��
			request.getRequestDispatcher("detail_supply.jsp").forward(request, response);
		}else if("sh".equals(result)){
			// ���ҳ��
			request.getRequestDispatcher("approval_supply.jsp").forward(request, response);
		}
	}

	/**
	 * ��ʾ���������б�
	 */
	private void listSupply(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// ��Ų�ѯ��Ϣ��Javabean
		SupplyPagingBean pagingBean = new SupplyPagingBean();
		// ��װ��ѯ����
		try {
			int msg = StringUtil.StringToInt(request.getParameter("msg"));
			if(msg==0){
				// �������Ǵ�ҳ�淢��
				BeanUtils.populate(pagingBean, request.getParameterMap());
			}else{
				// �������Ǵ�servletת������
				Object page = request.getSession().getAttribute("supplyPageBean");
				if(page!=null)
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
		request.getRequestDispatcher("/back/selectionServlet?method=getJslbList&result=include").include(request, response);
		String result = request.getParameter("result");
		request.setAttribute("SupplyList", list);
		request.getSession().setAttribute("supplyPageBean", pagingBean);
		if("list".equals(result)){
			// ������˹���ҳ��
			request.getRequestDispatcher("list_supply.jsp").forward(request, response);
		}else if("list2".equals(result)){
			// ������Ϣ����ҳ��
			pagingBean.setPreUrl("supplyServlet?method=list&result=list2&"+URLUtil.preUrl(pagingBean));
			request.getRequestDispatcher("list_supply2.jsp").forward(request, response);
		}else if("json".equals(result)){
//			JsonElement jsonTree = gson.toJsonTree(pagingBean);
//			JsonObject object = new JsonObject();
			JSONObject json = new JSONObject();
			json.put("data", JSON.toJSON(list));
			json.put("page", pagingBean);
			response.getWriter().print(json);
		}
	}

	/**
	 * ��Ӽ����������߱��漼������
	 */
	private void saveOrUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// ��װ����
		JSGJBean bean = new JSGJBean();
		try {
			BeanUtils.populate(bean, request.getParameterMap());
		} catch (IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}
		JSGJService service = factory.getService(JSGJService.class);
		// ������ݴ�������£����򱣴�����
		boolean f = service.saveOrUpdate(bean);
		String result = request.getParameter("result");
		if("add".equals(result)){
			// ��ת�����ҳ��
			request.getRequestDispatcher("add_supply.jsp?msg="+(f ? 1:2)).forward(request, response);
		}else if("list".equals(result)){
			// ��ת����ѯҳ��
			request.getRequestDispatcher("supplyServlet?method=list&result=list&status=sh in (-1,0)&msg="+(f? 1:2)).forward(request, response);
		}
	}

}
