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
 * @author �ö�
 * ͼƬ����servlet
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
		// ɾ��ͼƬ����
		int id = StringUtil.StringToInt(request.getParameter("id"));
		NewsPhotoService service = BasicFactory.getFactory().getService(NewsPhotoService.class);
		boolean f = service.delById(id);
		String result = request.getParameter("result");
		if("json".equals(result)){
			// ��Ӧajxs����
			response.getWriter().print(f);
		}else{
			// ���²�ѯ���
			request.getRequestDispatcher("newsPhotoServlet?method=list&result=list&msg="+(f?3:4)).forward(request, response);
		}
	}
	/**
	 * ��ȡָ��idͼƬ������Ϣ
	 */
	private void getNewsPhoto(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// ��ȡҵ������
		NewsPhotoService service = BasicFactory.getFactory().getService(NewsPhotoService.class);
		int id = StringUtil.StringToInt(request.getParameter("id"));
		// ����ҵ��㷽������ҵ�񷽷�
		NewsPhoto newsPhoto = service.getNewsPhoto(id);
		request.setAttribute("newsPhoto", newsPhoto);
		String result = request.getParameter("result");
		// ������������ж�ת������Դ
		if("edit".equals(result)){
			request.getRequestDispatcher("add_photo_news.jsp").forward(request, response);
		}else if("detail".equals(result)){
			request.getRequestDispatcher("detail_photo_news.jsp").forward(request, response);
		}
		
	}
	/**
	 * ��ҳ��ȡ��¼
	 */
	private void getList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		NewsPhotoPage photoPage = new NewsPhotoPage();
		int msg = StringUtil.StringToInt(request.getParameter("msg"));
		try {
			if(msg==0){
				// ����msg����0˵���������ǳ�ҳ�洫�ݶ���
				// ��װ��ѯ��Ϣ
				BeanUtils.populate(photoPage, request.getParameterMap());
			}else{
				// ���msg������0˵���������ǳ�����servlet������ת������
				// ��ȡ��һ�η�ҳ��ѯʱ�����session�еĲ�ѯ����
				Object page = request.getSession().getAttribute("pagingBean");
				if(page!=null)
					photoPage = (NewsPhotoPage) page;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		// ��ȡ�������ҵ���ķ���
		NewsPhotoService service = BasicFactory.getFactory().getService(NewsPhotoService.class);
		service.getList(photoPage);
		// �����ѯ����Ͳ�ѯ��Ϣ
		request.getSession().setAttribute("pagingBean", photoPage);
		String result = request.getParameter("result");
		if("list".equals(result)){
			request.getRequestDispatcher("list_photo_news.jsp").forward(request, response);
		}
	}
	/**
	 * ��������޸�ͼƬ����
	 */
	private void save(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String result = request.getParameter("result");
		boolean f;
		// TODO ����û���
		try {
			// �������ҳ�������map����
			Map<String,Object> map = new HashMap<String,Object>();
			// �����ļ��ĸ�����
			DiskFileItemFactory factory = new DiskFileItemFactory();
			ServletFileUpload upload = new ServletFileUpload(factory);
			// ����request����ȡ��װ�������
			@SuppressWarnings("unchecked")
			List<FileItem> list = upload.parseRequest(request);
			// ��������Ԫ��
			for(FileItem fileItem : list){
				boolean isForm = fileItem.isFormField();
				if(isForm){
					// ����
					String name = fileItem.getFieldName();
					String value = fileItem.getString("utf-8");
					map.put(name, value);
				}else{
					// �ļ���
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
