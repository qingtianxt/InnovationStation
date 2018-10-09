package sist.servlet;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import sist.bean.NewsPhotoPage;
import sist.domain.NewsPhoto;
import sist.factory.BasicFactory;
import sist.service.NewsPhotoService;
import sist.utils.StringUtil;
import sist.utils.UploadUtils;

/**
 * @author 悦尔
 * 图片新闻servlet
 *
 */
@WebServlet("/back/news/newsPhotoServlet")
public class NewsPhotoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String method = request.getParameter("method");
		if("save".equals(method)){
			save(request,response);
		}else if("list".equals(method)){
			getList(request,response);
		}else if("get".equals(method)){
			getNewsPhoto(request,response);
		}else if("del".equals(method)){
			del(request,response);
		}else if("checkName".equals(method)){
			checkTitle(request,response);
		}
	}
	private void checkTitle(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String title = request.getParameter("title");
		NewsPhotoService service = BasicFactory.getFactory().getService(NewsPhotoService.class);
		boolean b = service.checkTitle(title);
		response.getWriter().print(b);
	}
	private void del(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 删除图片新闻
		int id = StringUtil.StringToInt(request.getParameter("id"));
		NewsPhotoService service = BasicFactory.getFactory().getService(NewsPhotoService.class);
		boolean f = service.delById(id);
		String result = request.getParameter("result");
		if("json".equals(result)){
			// 响应ajxs请求
			response.getWriter().print(f);
		}else{
			// 重新查询结果
			request.getRequestDispatcher("newsPhotoServlet?method=list&result=list&msg="+(f?3:4)).forward(request, response);
		}
	}
	/**
	 * 获取指定id图片新闻信息
	 */
	private void getNewsPhoto(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 获取业务层对象
		NewsPhotoService service = BasicFactory.getFactory().getService(NewsPhotoService.class);
		int id = StringUtil.StringToInt(request.getParameter("id"));
		// 调用业务层方法处理业务方法
		NewsPhoto newsPhoto = service.getNewsPhoto(id);
		request.setAttribute("newsPhoto", newsPhoto);
		String result = request.getParameter("result");
		// 根据请求参数判断转发的资源
		if("edit".equals(result)){
			request.getRequestDispatcher("add_photo_news.jsp").forward(request, response);
		}else if("detail".equals(result)){
			request.getRequestDispatcher("detail_photo_news.jsp").forward(request, response);
		}
		
	}
	/**
	 * 分页获取记录
	 */
	private void getList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		NewsPhotoPage photoPage = new NewsPhotoPage();
		int msg = StringUtil.StringToInt(request.getParameter("msg"));
		try {
			if(msg==0){
				// 如若msg等于0说明此请求是冲页面传递而来
				// 封装查询信息
				BeanUtils.populate(photoPage, request.getParameterMap());
			}else{
				// 如果msg不等于0说明次请求是冲其他servlet方法中转发而来
				// 获取上一次分页查询时存放在session中的查询条件
				Object page = request.getSession().getAttribute("pagingBean");
				if(page!=null)
					photoPage = (NewsPhotoPage) page;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 获取服务调用业务层的方法
		NewsPhotoService service = BasicFactory.getFactory().getService(NewsPhotoService.class);
		service.getList(photoPage);
		// 保存查询结果和查询信息
		request.getSession().setAttribute("pagingBean", photoPage);
		String result = request.getParameter("result");
		if("list".equals(result)){
			request.getRequestDispatcher("list_photo_news.jsp").forward(request, response);
		}
	}
	/**
	 * 保存或者修改图片新闻
	 */
	private void save(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String result = request.getParameter("result");
		boolean f;
		// TODO 添加用户名
		try {
			// 用来存放页面参数的map集合
			Map<String,Object> map = new HashMap<String,Object>();
			// 处理文件的各种类
			DiskFileItemFactory factory = new DiskFileItemFactory();
			ServletFileUpload upload = new ServletFileUpload(factory);
			// 解析request，获取封装后的数组
			@SuppressWarnings("unchecked")
			List<FileItem> list = upload.parseRequest(request);
			// 遍历各个元素
			for(FileItem fileItem : list){
				boolean isForm = fileItem.isFormField();
				if(isForm){
					// 表单项
					String name = fileItem.getFieldName();
					String value = fileItem.getString("utf-8");
					map.put(name, value);
				}else{
					// 文件项
					String fileName = fileItem.getName();
					if(fileName==null||fileName.trim().isEmpty())
						continue;
					String dir = "/upload"+UploadUtils.getDir(fileName);
					String realName = UploadUtils.getRealName(fileName);
					File file = new File(request.getServletContext().getRealPath("/")+dir);
					if(!file.exists())
						file.mkdirs();
					fileItem.write(new File(file,realName));
					map.put("image", dir+"/"+realName);
				}
			}
			
			
			NewsPhoto newsPhoto = new NewsPhoto();
			BeanUtils.populate(newsPhoto, map);
			NewsPhotoService service = BasicFactory.getFactory().getService(NewsPhotoService.class);
			f = service.saveOrUpdate(newsPhoto);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
		if("add".equals(result)){
			request.getRequestDispatcher("add_photo_news.jsp?msg="+(f?1:2)).forward(request, response);
		}else if("update".equals(result)){
			request.getRequestDispatcher("newsPhotoServlet?method=list&result=list&msg="+(f?1:2)).forward(request, response);;
		}
	}

}
