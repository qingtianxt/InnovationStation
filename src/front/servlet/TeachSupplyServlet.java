package front.servlet;

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
import sist.bean.TeachSearchPage;
import sist.dao.JSGJDao;
import sist.dao.OptionDao;
import sist.domain.JSGJBean;
import sist.domain.UserBean;
import sist.factory.BasicFactory;
import sist.service.JSGJService;
import sist.utils.MarkKeyWords;
import sist.utils.StringUtil;

/**
 * Servlet implementation class TeachSupplyServlet
 */
@WebServlet(description = "前台访问技术供给", urlPatterns = { "/front/technology_supply/supplyServlet" })
public class TeachSupplyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String method = request.getParameter("method");
		if("list".equals(method)){
			list(request,response);
		}else if("visit".equals(method)){
			visit(request,response);
		}else if("add".equals(method)){
			add(request,response);
		}else if("search".equals(method)){
			search(request,response);
		}
	}

	private void search(HttpServletRequest request, HttpServletResponse response) throws IOException {
		TeachSearchPage page = new TeachSearchPage();
		try {
			BeanUtils.populate(page, request.getParameterMap());
		} catch (IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}
		JSGJService service = BasicFactory.getFactory().getService(JSGJService.class);
		service.search(page);
		page.setPreUrl(request.getContextPath()+"/front/technology_supply/supplyServlet?method=search&key="+page.getKey());
		page.setAnd(true);
		Object json = JSON.toJSON(page);
		response.getWriter().println(MarkKeyWords.replace(json.toString(),page.getKey()));
	}

	private void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserBean user = (UserBean) request.getSession().getAttribute("session_user");
		if(user==null){
			request.getRequestDispatcher("/front/technology_supply/add.jsp?msg=您还没有登录,请先登录!").forward(request, response);
			return;
		}
		// 封装数据
		JSGJBean bean = new JSGJBean();
		try {
			BeanUtils.populate(bean, request.getParameterMap());
		} catch (IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}
		JSGJService service = BasicFactory.getFactory().getService(JSGJService.class);
		// 如果数据存在则更新，否则保存数据
		boolean f = service.saveOrUpdate(bean);
		request.getRequestDispatcher("/front/technology_supply/add.jsp?msg="+(f?"添加成功!":"添加失败!")).forward(request, response);;
	}

	private void visit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = StringUtil.StringToInt(request.getParameter("id"));
		JSGJDao dao = BasicFactory.getFactory().getDao(JSGJDao.class);
		JSGJBean bean = dao.findById(id);
		if(bean!=null){
			bean.setHits(bean.getHits()+1);
			dao.update(bean);
			String byIdOrName = BasicFactory.getFactory().getDao(OptionDao.class).getByIdOrName(bean.getXs());
			bean.setXs(byIdOrName);
		}
		MarkKeyWords.Mark(bean, request.getParameter("key"));
		request.setAttribute("TeachSupplyBean", bean);
		request.getRequestDispatcher("detail.jsp").forward(request, response);
	}

	private void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		
		SupplyPagingBean pageBean = new SupplyPagingBean();
		try {
			BeanUtils.populate(pageBean, request.getParameterMap());
			pageBean.setStatus("sh in (1) ");
		} catch (IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}
		JSGJService service = BasicFactory.getFactory().getService(JSGJService.class);
		List<JSGJBean> list = service.getList(pageBean);
		
		String result = request.getParameter("result");
		if("json".equals(result)){
			JSONObject json = new JSONObject();
			json.put("data", JSON.toJSON(list));
			json.put("page", pageBean);
			response.getWriter().print(json);
			return ;
		}
		
		request.setAttribute("supplyPageBean", pageBean);
		request.setAttribute("SupplyList", list);
		request.getRequestDispatcher("supply.jsp"+("".equals(username)?"?msg=您还没有登录,请先登录!":"")).forward(request, response);
	}

}
