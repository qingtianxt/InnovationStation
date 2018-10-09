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
 * 技术供给管理
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
	 * 处理删除供给信息的请求
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void del(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		JSGJService service = factory.getService(JSGJService.class);
		boolean f = service.delById(StringUtil.StringToInt(request.getParameter("id")));
		
		// result参数表示处理后访问的地址
		String result = request.getParameter("result");
		if("list".equals(result)){
			// 从审核页面删除，删除后需要跳转到审核页面
			request.getRequestDispatcher("supplyServlet?method=list&result=list&status=sh in (-1,0)&msg="+(f?3:4)).forward(request, response);
		}else if("list2".equals(result)){
			// 从管理页面删除，删除后跳转到管理页面
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
			// 查看技术供给详情需要跳转的页面
			request.getRequestDispatcher("detail_supply.jsp").forward(request, response);
		}else if("sh".equals(result)){
			// 审核页面
			request.getRequestDispatcher("approval_supply.jsp").forward(request, response);
		}
	}

	/**
	 * 显示技术供给列表
	 */
	private void listSupply(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 存放查询信息的Javabean
		SupplyPagingBean pagingBean = new SupplyPagingBean();
		// 封装查询条件
		try {
			int msg = StringUtil.StringToInt(request.getParameter("msg"));
			if(msg==0){
				// 此请求是从页面发来
				BeanUtils.populate(pagingBean, request.getParameterMap());
			}else{
				// 此请求是从servlet转发而来
				Object page = request.getSession().getAttribute("supplyPageBean");
				if(page!=null)
					pagingBean = (SupplyPagingBean) page;
			}
		} catch (IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
		JSGJService service = factory.getService(JSGJService.class);
		// 调用查询的业务逻辑
		List<JSGJBean> list = service.getList(pagingBean);
		// 包含此路径中的相应
		request.getRequestDispatcher("/back/selectionServlet?method=getJslbList&result=include").include(request, response);
		String result = request.getParameter("result");
		request.setAttribute("SupplyList", list);
		request.getSession().setAttribute("supplyPageBean", pagingBean);
		if("list".equals(result)){
			// 返回审核管理页面
			request.getRequestDispatcher("list_supply.jsp").forward(request, response);
		}else if("list2".equals(result)){
			// 返回信息管理页面
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
	 * 添加技术供给或者保存技术供给
	 */
	private void saveOrUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 封装数据
		JSGJBean bean = new JSGJBean();
		try {
			BeanUtils.populate(bean, request.getParameterMap());
		} catch (IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}
		JSGJService service = factory.getService(JSGJService.class);
		// 如果数据存在则更新，否则保存数据
		boolean f = service.saveOrUpdate(bean);
		String result = request.getParameter("result");
		if("add".equals(result)){
			// 跳转到添加页面
			request.getRequestDispatcher("add_supply.jsp?msg="+(f ? 1:2)).forward(request, response);
		}else if("list".equals(result)){
			// 跳转到查询页面
			request.getRequestDispatcher("supplyServlet?method=list&result=list&status=sh in (-1,0)&msg="+(f? 1:2)).forward(request, response);
		}
	}

}
