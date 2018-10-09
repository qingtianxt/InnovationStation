package front.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;

import sist.domain.UserBean;
import sist.factory.BasicFactory;
import sist.service.UserService;
import sist.utils.Constant;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet(name = "userServlet", urlPatterns = { "/userServlet" })
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String method = request.getParameter("method");
		if("login".equals(method)){
			login(request,response);
		}else if("logout".equals(method)){
			logout(request,response);
		}else if("register".equals(method)){
			register(request,response);
		}
	}

	private void register(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String validate = request.getParameter("validataCode");
		HttpSession session = request.getSession();
		String validateCode = (String) session.getAttribute("validateCode");
		if(validateCode.equalsIgnoreCase(validate)){
			UserBean userBean = new UserBean();
			try {
				BeanUtils.populate(userBean, request.getParameterMap());
				userBean.setRoleId(0);
			} catch (IllegalAccessException | InvocationTargetException e) {
				e.printStackTrace();
			}
			UserService service = BasicFactory.getFactory().getService(UserService.class);
			boolean b = service.saveOrUpdate(userBean);
			if(b){
				session.setAttribute(Constant.SESSION_USER, userBean);
			}
			request.getRequestDispatcher("/front/register.jsp?msg="+(b?"ע��ɹ�!":"ע��ʧ��!")).forward(request, response);
		}else{
			request.getRequestDispatcher("/front/register.jsp?msg=��֤�����!").forward(request, response);
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

	private void login(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String username = request.getParameter("username");// �û���
		String pwd = request.getParameter("password");		// ����
		String valCode = request.getParameter("validateCode");// ��֤��
		HttpSession session = request.getSession();
		String sessionValCode = (String) session.getAttribute("validateCode");// �����session�е���֤��
		String msg = null;
		if(valCode.equalsIgnoreCase(sessionValCode)){
			UserBean userBean = new UserBean();
			userBean.setUsername(username);
			userBean.setPwd(pwd);
			// ��ȡҵ������
			UserService service = BasicFactory.getFactory().getService(UserService.class);
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
				msg = "�𾴵�"+username+",����,��ӭ��¼�ӱ�ʡ������վ!";
				response.sendRedirect(request.getContextPath()+"/front/index.jsp");
				return;
			}
			else{
				msg = "�������!";
			}
		}else{
			// ��֤�����
			msg="��֤�����!";
		}
		request.getRequestDispatcher("/front/index.jsp?msg="+msg).forward(request, response);
	}

}
