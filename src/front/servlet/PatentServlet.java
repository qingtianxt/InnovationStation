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

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import sist.bean.PatentPage;
import sist.dao.PatentDao;
import sist.domain.Patent;
import sist.factory.BasicFactory;
import sist.service.PatentService;
import sist.utils.StringUtil;

/**
 * Servlet implementation class PatentServlet
 */
@WebServlet(name = "patentServlet", urlPatterns = { "/front/patent/patentServlet" })
public class PatentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String method = request.getParameter("method");
		if("list".equals(method)){
			list(request,response);
		}else if("visit".equals(method)){
			visit(request,response);
		}
	}

	private void visit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = StringUtil.StringToInt(request.getParameter("id"));
		Patent patenet = null;
		PatentDao dao = BasicFactory.getFactory().getDao(PatentDao.class);
		patenet = dao.getPatent(id);
		if(patenet!=null){
			if(patenet.getHits()==null){
				patenet.setHits(0);
			}
			patenet.setHits(patenet.getHits()+1);
			dao.updatePatent(patenet);
		}
		request.setAttribute("patent", patenet);
		request.getRequestDispatcher("/front/special_library/detail.jsp").forward(request, response);
	}

	private void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PatentPage page = new PatentPage();
		try {
			BeanUtils.populate(page, request.getParameterMap());
		} catch (IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}
		PatentService service = BasicFactory.getFactory().getService(PatentService.class);
		List<Patent> list = service.getList(page);
		String result = request.getParameter("result");
		if("json".equals(result)){
			Gson gson = new Gson();
			JsonElement jsonTree = gson.toJsonTree(page);
			JsonObject json = jsonTree.getAsJsonObject();
			json.add("data", gson.toJsonTree(list));
			response.getWriter().println(json);
			return;
		}
		request.setAttribute("patents", list);
		request.setAttribute("pagingBean", page);
	};
}
