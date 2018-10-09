package sist.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;

import sist.bean.UserPage;
import sist.domain.UserBean;
import sist.factory.BasicFactory;
import sist.service.UserService;
import sist.utils.Constant;
import sist.utils.StringUtil;

/**
 * @author �ö�
 *�û�����
 */
@WebServlet(urlPatterns={"/back/user/userServlet","/front/user/userServlet"})
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BasicFactory factory = BasicFactory.getFactory();
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String method = request.getParameter("method");
		if("modify".equals(method)){
			modifyPwd(request,response);
		}else if("login".equals(method)){
			login(request,response);
		}else if("list".equals(method)){
			list(request,response);
		}else if("checkUsername".equals(method)){
			checkUsername(request,response);
		}else if("add".equals(method)){
			addOrUpdate(request,response);
		}else if("getUser".equals(method)){
			getUser(request,response);
		}else if("del".equals(method)){
			del(request,response);
		}else if("logout".equals(method)){
			logout(request,response);
		}
	}
	
	private void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();
		UserBean userBean = (UserBean) session.getAttribute(Constant.SESSION_USER);
		if(userBean!=null){
			Cookie cookie = new Cookie("autoLogin",userBean.getUsername()+"&"+userBean.getPwd());
			cookie.setMaxAge(0);
			cookie.setPath("/");
			response.addCookie(cookie);
		}
		session.invalidate();
		response.sendRedirect(request.getContextPath()+"/front/index.jsp");
	}

	private void del(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// ��ȡɾ�����ݵ�id
		int id = StringUtil.StringToInt(request.getParameter("id"));
		// ��ȡҵ�����󣬵���ҵ��㷽��ɾ���û�
		UserService service = factory.getService(UserService.class);
		boolean b = service.delById(id);
		String result = request.getParameter("result");
		if("list".equals(result)){
			request.getRequestDispatcher("userServlet?method=list&result=list&msg="+(b?1:2)).forward(request, response);
		}
	}

	private void getUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = StringUtil.StringToInt(request.getParameter("id"));
		UserService service = factory.getService(UserService.class);
		UserBean user = service.getUser(id);
		String result = request.getParameter("result");
		request.setAttribute("userBean", user);
		if("update".equals(result)||"sh".equals(result)){
			request.getRequestDispatcher("add_user.jsp").forward(request, response);
		}
	}

	/**
	 * ��ӻ����޸��û�
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void addOrUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserBean userbean = new UserBean();
		try {
			BeanUtils.populate(userbean, request.getParameterMap());
		} catch (IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}
		UserService service = factory.getService(UserService.class);
		boolean b = service.saveOrUpdate(userbean);
		String result = request.getParameter("result");
		if("add".equals(result)){
			request.getRequestDispatcher("/back/user/add_user.jsp?msg="+( b ? 1 : 2)).forward(request, response);
		}else if("list".equals(result)){
			// �ύ�޸���Ϣ����ת���б�ҳ��
			request.getRequestDispatcher("userServlet?method=list&result=list&msg="+(b?1:2)).forward(request, response);
		}
	}

	// ����û����Ƿ������
	private void checkUsername(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String username = request.getParameter("username");
		UserService service = factory.getService(UserService.class);
		UserBean bean = new UserBean();
		bean.setUsername(username);
		int i = service.checkUser(bean);
		// i����2��ʾ�û���������
		response.getWriter().print(i==2);
	}
	private void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserPage pagingBean = new UserPage();
		
		int msg = StringUtil.StringToInt(request.getParameter("msg"));
		if(msg==0){
			try {
				BeanUtils.populate(pagingBean, request.getParameterMap());
				String roleId = request.getParameter("roleId");
				if(roleId==null||roleId.trim().isEmpty())
					pagingBean.setRoleId(null);
			} catch (IllegalAccessException | InvocationTargetException e) {
				e.printStackTrace();
			}
		}else{
			pagingBean = (UserPage) request.getSession().getAttribute("pagingBean");
		}
		
		UserService service = factory.getService(UserService.class);
		List<UserBean> page = service.getPage(pagingBean);
		request.setAttribute("pageBeans", page);
		request.getSession().setAttribute("pagingBean", pagingBean);
		String result = request.getParameter("result");
		if("list".equals(result)){
			request.getRequestDispatcher("/back/user/list.jsp").forward(request, response);
		}else if("list_role".equals(result)){
			request.getRequestDispatcher("/back/role/list_role.jsp").forward(request, response);
		}
	}
	private void login(HttpServletRequest request, HttpServletResponse response) throws IOException {
		PrintWriter out = response.getWriter();
		String username = request.getParameter("username");// �û���
		String pwd = request.getParameter("pwd");		// ����
		String valCode = request.getParameter("validateCode");// ��֤��
		HttpSession session = request.getSession();
		String sessionValCode = (String) session.getAttribute("validateCode");// �����session�е���֤��
		
		if(valCode.equalsIgnoreCase(sessionValCode)){
			UserBean userBean = new UserBean();
			userBean.setUsername(username);
			userBean.setPwd(pwd);
			// ��ȡҵ������
			UserService service = factory.getService(UserService.class);
			// ����û��������Ϣ
			int checkUser = service.checkUser(userBean);
			if(checkUser==0){
				// ��֤�ɹ�
				session.setAttribute(Constant.SESSION_USER, userBean);
				String autoLogin = request.getParameter("autoLogin");
				if("��".equals(autoLogin)){
					Cookie cookie = new Cookie("autoLogin",username+"&"+pwd);
					cookie.setMaxAge(30*24*60*60);
					cookie.setPath("/");
					response.addCookie(cookie);
				}
			}
			
			out.print(checkUser);
		}else{
			// ��֤�����
			out.print("1");
		}
	}
	private void modifyPwd(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		String validateCode = (String) session.getAttribute("validateCode");
		UserBean userBean = (UserBean) session.getAttribute(Constant.SESSION_USER);
		if(!validateCode.equalsIgnoreCase(request.getParameter("validateCode"))){
			// ��֤�����
			out.print("1");
			return;
		}
		if(userBean!=null){
			String oldpwd = request.getParameter("oldpwd");
			if(userBean.getPwd().equals(oldpwd)){
				// ������ȷ
				userBean.setPwd(request.getParameter("newpwd"));
				UserService service = factory.getService(UserService.class);
				boolean b = service.saveOrUpdate(userBean);
				out.print( ( b ? 3 : 4) );
			}else{
				// �������
				out.print(2);
			}
		}else{
			out.print(5);
		}
	}

}
