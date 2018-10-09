package front.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

import sist.domain.NewsPhoto;
import sist.factory.BasicFactory;
import sist.service.NewsPhotoService;
import sist.utils.StringUtil;

/**
 * Servlet implementation class PhotoNewsServlet
 */
@WebServlet("/front/news/photoNewsServlet")
public class PhotoNewsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String method = request.getParameter("method");
		if("all".equals(method)){
			getAll(request,response);
		}else if("detail".equals(method)){
			getItem(request,response);
		}
	}

	private void getItem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = StringUtil.StringToInt(request.getParameter("id"));
		NewsPhotoService service = BasicFactory.getFactory().getService(NewsPhotoService.class);
		NewsPhoto newsBean = service.getNewsPhoto(id);
		request.setAttribute("newsBean", newsBean);
		request.getRequestDispatcher("/front/news/photo_news_detail.jsp").forward(request, response);
	}

	private void getAll(HttpServletRequest request, HttpServletResponse response) throws IOException {
		NewsPhotoService service = BasicFactory.getFactory().getService(NewsPhotoService.class);
		List<NewsPhoto> list = service.getList(null);
		Object json = JSON.toJSON(list);
		response.getWriter().println(json);
	}

}
