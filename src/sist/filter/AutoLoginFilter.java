package sist.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sist.domain.UserBean;
import sist.factory.BasicFactory;
import sist.service.UserService;
import sist.utils.Constant;

/**
 * 自动登录过滤器
 */
@WebFilter("/*")
public class AutoLoginFilter implements Filter {

    /**
     * Default constructor. 
     */
    public AutoLoginFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		String url = req.getRequestURI();
		System.err.println("访问路径:"+url);
		UserBean userBean = (UserBean) req.getSession().getAttribute(Constant.SESSION_USER);
		if(userBean==null){
			System.out.println("自动登录......");
			Cookie[] cookies = req.getCookies();
			if(cookies!=null){
				
				for (Cookie cookie : cookies) {
					String name = cookie.getName();
					if("autoLogin".equals(name)){
						try {
							String[] split = cookie.getValue().split("&");
							userBean = new UserBean();
							userBean.setUsername(split[0]);
							userBean.setPwd(split[1]);
							UserService service = BasicFactory.getFactory().getService(UserService.class);
							int checkUser = service.checkUser(userBean);
							if(checkUser==0){
								req.getSession().setAttribute(Constant.SESSION_USER, userBean);
								System.out.println("自动登录成功......");
								String uri = req.getRequestURI();
								if((req.getContextPath()+"/back/login.jsp").equals(uri)){
									HttpServletResponse res = (HttpServletResponse) response;
									res.sendRedirect(req.getContextPath()+"/back/index.jsp");
									return;
								}
							}
						} catch (Exception e) {
							e.printStackTrace();
						}
						break;
					}
				}
			}
		}
		
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
