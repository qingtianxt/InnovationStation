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

import sist.bean.RolePage;
import sist.bean.RolePagingBean;
import sist.domain.Role;
import sist.domain.UserBean;
import sist.factory.BasicFactory;
import sist.service.RoleService;
import sist.utils.StringUtil;

/**
 * Servlet implementation class RoleServlet
 */
@WebServlet("/back/role/roleServlet")
public class RoleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String method = request.getParameter("method");
    	if("list".equals(method)){// 获取角色列表
    		list(request,response);
    	}else if("pageList".equals(method)){// 获取用户列表,此方法废弃
    		getList(request,response);
    	}else if("getRole".equals(method)){// 获取一个角色
    		getRoleById(request,response);
    	}else if("add".equals(method)){		// 添加角色
    		addOrUpdate(request,response);
    	}else if("checkName".equals(method)){// 检查角色名是否已经存在
    		checkName(request,response);
    	}else if("edit".equals(method)){	// 编辑角色
    		getRoleById(request,response);	
    	}else if("del".equals(method)){		// 删除角色
    		del(request,response);
    	}
    }

    

	private void del(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = StringUtil.StringToInt(request.getParameter("id"));
		RoleService service = BasicFactory.getFactory().getService(RoleService.class);
		int code = service.delById(id);
		request.getRequestDispatcher("roleServlet?method=list&result=list&msg="+code).forward(request, response);
	}



	/**
     * 添加新角色的时候检查角色名称是否已经存在
     */
	private void checkName(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String roleName = request.getParameter("roleName");
		RoleService service = BasicFactory.getFactory().getService(RoleService.class);
		boolean b = service.checkName(roleName);
		String result = request.getParameter("result");
		if("json".equals(result)){
			response.getWriter().print(b);
		}
	}

	private void addOrUpdate(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Role role = new Role();
		try {
			BeanUtils.populate(role, request.getParameterMap());
		} catch (IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}
		RoleService service = BasicFactory.getFactory().getService(RoleService.class);
		boolean b = service.addOrUpdate(role);
		String result = request.getParameter("result");
		if("json".equals(result)){
			response.getWriter().print(b);
		}
	}

	private void getRoleById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idstr = request.getParameter("id");
		int id = StringUtil.StringToInt(idstr);
		RoleService service = BasicFactory.getFactory().getService(RoleService.class);
		Role role = service.getRole(id);
		request.setAttribute("role", role);
		String result = request.getParameter("result");
		if("detail".equals(result)){
			request.getRequestDispatcher("detail.jsp").forward(request, response);
		}else if("edit".equals(result)){
			request.getRequestDispatcher("edit.jsp").forward(request, response);
		}
	}

	@SuppressWarnings("all")
	private void getList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int msg = StringUtil.StringToInt(request.getParameter("msg"));
		RolePage pagingBean = new RolePage();
		if(msg==0){
			String roleId = request.getParameter("roleId");
			if(roleId!=null && !roleId.trim().isEmpty()){
				pagingBean.setRoleId(StringUtil.StringToInt(roleId));
			}
			pagingBean.setUsername(request.getParameter("username"));
			pagingBean.setCurrentPage(StringUtil.StringToInt(request.getParameter("currentPage")));
			pagingBean.setPageSize(StringUtil.StringToInt(request.getParameter("pageSize")));
		}else{
			pagingBean = (RolePage) request.getSession().getAttribute("pagingBean");
		}
		RoleService service = BasicFactory.getFactory().getService(RoleService.class);
		List<UserBean> list = service.getList(pagingBean);
		request.getSession().setAttribute("pagingBean", pagingBean);
		request.setAttribute("userBeans", list);
		String result = request.getParameter("result");
		if("list".equals(result)){
			request.getRequestDispatcher("list_role.jsp").forward(request, response);
		}
	}

	private void list(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String result = request.getParameter("result");
		RoleService service = BasicFactory.getFactory().getService(RoleService.class);
		if("json".equals(result)){
			List<Role> list = service.getList2(null);
			Object json = JSON.toJSON(list);
			response.getWriter().println(json);
		}else if("list".equals(result)){
			RolePagingBean pagingBean = new RolePagingBean();
			int msg = StringUtil.StringToInt(request.getParameter("msg"));
			if(msg==0)
				try {
					BeanUtils.populate(pagingBean, request.getParameterMap());
				} catch (Exception e) {
					e.printStackTrace();
				}
			else{
				Object page = request.getSession().getAttribute("pagingBean");
				if(page instanceof RolePagingBean)
					pagingBean = (RolePagingBean) page;
			}
			List<Role> list2 = service.getList2(pagingBean);
			request.getSession().setAttribute("pagingBean", pagingBean);
			request.setAttribute("roles", list2);
			request.getRequestDispatcher("list_role2.jsp").forward(request, response);
		}
	}
}
