package sist.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import sist.domain.cgal;
import sist.domain.kjcg;
import sist.domain.UserBean;
import sist.factory.BasicFactory;
import sist.service.cgalService;
import sist.service.kjcgService;
import sist.utils.Constant;
import sist.utils.DateUtils;
import sist.utils.StringUtil;

/**
 * �ɹ�����ģ��
 */
@WebServlet("/back/kjcg/cgalServlet")
public class cgalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

		@Override
		protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			response.setContentType("text/html;charset=utf-8");
			request.setCharacterEncoding("utf-8");
			String method = request.getParameter("method");
			if(!"".equals(method)){
				if("checkXMg".equals(method)){
					checkXMg(request,response);
				}else if("add".equals(method)){
					add(request,response);
				}else if("checkXMgUpdate".equals(method)){
					checkXMgUpdate(request,response);
				}else if("update".equals(method)){
					update(request,response);
				}
			}
		}
		/**
		 * �޸ĳɹ�������Ϣ
		 * @param request
		 * @param response
		 */
		private void update(HttpServletRequest request, HttpServletResponse response) {
			cgal c = new cgal();
kjcg k =new kjcg();
			
			try {
				BeanUtils.populate(k, request.getParameterMap());
				k.setKm("�ɹ�����");
				k.setTime(DateUtils.getDate());
			} catch (IllegalAccessException | InvocationTargetException e1) {
				e1.printStackTrace();
			}
			
			try {
				BeanUtils.populate(c, request.getParameterMap());
				c.setTime(DateUtils.getDate());
				UserBean u =(UserBean) request.getSession().getAttribute(Constant.SESSION_USER);
				if(null!=u){
					c.setUsername(u.getUsername());
					k.setUsername(u.getUsername());
				}
				System.out.println(c);
				System.out.println(k);
				
				kjcgService ks = BasicFactory.getFactory().getService(kjcgService.class);
				cgalService cs = BasicFactory.getFactory().getService(cgalService.class);
				
				try {
					kjcg k1 = ks.getByMc(k.getMc());
					k.setId(k1.getId());
					
					ks.update(k);
				} catch (Exception e) {
					e.printStackTrace();
				}
				try {
					cgal c1 = cs.getByMc(c.getMc());
					c.setId(c1.getId());
					cs.update(c);
				} catch (Exception e) {
					e.printStackTrace();
				}
				try {
					response.sendRedirect(request.getContextPath()+"/back/kjcg/kjcgServlet?method=getList&currentPage=1&msg=2");
				} catch (IOException e) {
					e.printStackTrace();
				}
				
			} catch (IllegalAccessException | InvocationTargetException e) {
				e.printStackTrace();
			}
		}
		/**
		 * ���޸ĳɹ�������Ϣʱ��������Ƿ����
		 * @param request
		 * @param response
		 */
		private void checkXMgUpdate(HttpServletRequest request, HttpServletResponse response) {
			String mc = request.getParameter("mc");
			int id = StringUtil.StringToInt(request.getParameter("id"));
			cgalService cs = BasicFactory.getFactory().getService(cgalService.class);
			try {
				cgal c = cs.getByMc(mc);
				cgal c1=cs.getById(id);
				String rst = "";
				
				if(c!=null&&c.getMc().equals(c1.getMc())){//�����������ݿ��д����ҵ���ԭ��������
					rst = "{status:'OK'}";
				}else if(null==c){//�����������ݿ��в�����
					rst = "{status:'OK'}";
				}
				else{
					rst = "{status:'ERROR',msg:'����Ϣ�Ѿ�����'}";
				}
				response.getWriter().print(rst);
				response.getWriter().flush();
				response.getWriter().close();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		/**
		 * ��ӳɹ�������Ϣ
		 * @param request
		 * @param response
		 */
		private void add(HttpServletRequest request, HttpServletResponse response) {
			cgal c = new cgal();
			kjcg k =new kjcg();
			
			try {
				BeanUtils.populate(k, request.getParameterMap());
				k.setKm("�ɹ�����");
				k.setTime(DateUtils.getDate());
			} catch (IllegalAccessException | InvocationTargetException e1) {
				e1.printStackTrace();
			}
			
			try {
				BeanUtils.populate(c, request.getParameterMap());
				c.setTime(DateUtils.getDate());
				UserBean u =(UserBean) request.getSession().getAttribute(Constant.SESSION_USER);
				if(null!=u){
					c.setUsername(u.getUsername());
					k.setUsername(u.getUsername());
				}
				System.out.println(c);
				System.out.println(k);
				
				kjcgService ks = BasicFactory.getFactory().getService(kjcgService.class);
				cgalService cs = BasicFactory.getFactory().getService(cgalService.class);
				
				try {
					ks.add(k);
				} catch (Exception e) {
					e.printStackTrace();
				}
				try {
					cs.add(c);
				} catch (Exception e) {
					e.printStackTrace();
				}
				request.setAttribute(Constant.MSG, "��ӳɹ�");
				try {
					request.getRequestDispatcher("back_cgal.jsp").forward(request, response);
				} catch (ServletException | IOException e) {
					e.printStackTrace();
				}
			} catch (IllegalAccessException | InvocationTargetException e) {
				e.printStackTrace();
			}
			
		}
		/**
		 * ���ɹ������Ƿ��Ѵ��ڣ�ͨ�����Ʋ�ѯ
		 * @param request
		 * @param response
		 */
		private void checkXMg(HttpServletRequest request, HttpServletResponse response) {
			String mc = request.getParameter("mc");
			cgalService cs = BasicFactory.getFactory().getService(cgalService.class);
			cgal c;
			try {
				c = cs.getByMc(mc);
				
				String rst = "";
				if (null != c) {
					rst += "{status:'ERROR',msg:'����Ϣ�Ѿ�����'}";
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

}
