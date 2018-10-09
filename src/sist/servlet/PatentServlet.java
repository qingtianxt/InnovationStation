package sist.servlet;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.jspsmart.upload.File;
import com.jspsmart.upload.Files;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import sist.bean.PatentPage;
import sist.domain.Excel;
import sist.domain.Patent;
import sist.domain.UserBean;
import sist.factory.BasicFactory;
import sist.service.PatentService;
import sist.utils.Constant;
import sist.utils.StreamUtil;
import sist.utils.StringUtil;
import sist.utils.UploadUtils;

/**
 * ר�������servlet
 */
@WebServlet({ "/back/special_library/patentServlet", "/back/patent/patentServlet" })
public class PatentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PatentService service;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String method = request.getParameter("method");
		service = BasicFactory.getFactory().getService(PatentService.class);
		if("list".equals(method))
		{
			list(request,response);
		}
		else if("import".equals(method))
		{
			importPatent2(request,response);
		}
		else if("getPatent".equals(method))
		{
			getPatent(request,response);
		}
		else if("save".equals(method))
		{
			saveOrUpdate(request,response);
		}
		else if("del".equals(method))
		{
			delById(request,response);
		}else if("import2".equals(method)){
			saveAll(request,response);
		}
	}

	/**
	 * ��Excel�ļ��е���Ϣ���뵽���ݿ���
	 * �˴���Ҫ��Excel�ļ��е�ר����¼��װΪPatent����
	 * ��Excel�ļ��Ѿ�����������ʱ�ļ�����
	 */
	private void saveAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Patent> list = new ArrayList<>();
		String[] sheetNames = request.getParameterValues("sheet");
		int ztzlk_id = StringUtil.StringToInt(request.getParameter("ztzlk_id"));
		
		UserBean user = (UserBean) request.getSession().getAttribute(Constant.SESSION_USER);
		if(user==null)
			return;
		String username = user.getUsername();
		String path = request.getParameter("path");
		java.io.File file = new java.io.File(path);
		if(sheetNames!=null && file.exists()){
			try {
				// ��ȡExcel�ļ�
				Workbook workbook = Workbook.getWorkbook(file);
				for (String string : sheetNames) {
					// ��ǰ̨���ڴ˱����ֶ���Ϣ��װ��һ��map��
					Map<String, Integer> order = getOrder(string,request.getParameterMap());
					Integer start = order.get("start");
					Integer end = order.get("end");
					// ��ȡ������
					Sheet sheet = workbook.getSheet(string);
					// �ù�����������������
					int rows = sheet.getRows();
					if(end==0)
						end = rows;
					for(int i = start-1; i < end; i++){
						Patent patent = new Patent();
						// ��i��
						Cell[] row = sheet.getRow(i);
						// ����i�е����ݷ�װ��һ��map��
						Map<String, String> p = populate(order,row);
						// TODO �жϼ����Ƿ�Ϊ��
						Set<String> values = new HashSet<>(p.values());
						values.remove("");
						boolean empty = values.isEmpty();
						if(empty)
							break;
						BeanUtils.populate(patent, p);
						
						patent.setZtzlk_id(ztzlk_id);
						patent.setUsername(username);
						patent.setHits(0);// ���õ����Ϊ0
						list.add(patent);
					}
					
				}
				boolean i = service.addAll(list);
				request.getRequestDispatcher("/back/special_library/libraryServlet?method=list&result=list&msg="+(i?"999":"1000")).forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
				request.getRequestDispatcher("/back/special_library/import_patent.jsp?msg=�������&status="+e.getMessage()).forward(request, response);
//				throw new RuntimeException(e);
			} finally {
				file.delete();
			}
		}
	}

	private void delById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = StringUtil.StringToInt(request.getParameter("id"));
		boolean f = service.delById(id);
		request.getRequestDispatcher("/back/special_library/patentServlet?method=list&result=list&msg="+(f?3:4)).forward(request, response);
	}

	private void saveOrUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Patent patent = new Patent();
		try {
			BeanUtils.populate(patent, request.getParameterMap());
		} catch (IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}
		boolean f = service.saveOrUpdate(patent);
		String result = request.getParameter("result");
		
		if("list".equals(result))
		{
			request.getRequestDispatcher("/back/special_library/patentServlet?method=list&result=list&msg="+(f?1:2)).forward(request, response);;
		}
		else if("save".equals(result))
		{
			request.getRequestDispatcher("/back/special_library/edit_patent.jsp?msg="+(f?1:2)).forward(request, response);
		}
	}

	/**
	 * ��ȡָ��id��ר����Ϣ����������ת����ָ��ҳ��
	 */
	private void getPatent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = StringUtil.StringToInt(request.getParameter("id"));
		Patent patent = service.getPatenet(id);
		request.setAttribute("patent", patent);
		String result = request.getParameter("result");
		if("edit".equals(result))
		{
			request.getRequestDispatcher("/back/special_library/edit_patent.jsp").forward(request, response);
		}
		else if("detail".equals(result))
		{
			request.getRequestDispatcher("/back/special_library/detail_patent.jsp").forward(request, response);
		}
	}

	/**
	 * �ϴ�Excel�ļ������ļ���������ʱ�ļ����У�Ȼ�����Excel��񣬽����������ҳ��
	 * Ȼ����ҳ�����ñ��������ר���ֶ����Ӧ
	 * @param request
	 * @param response
	 */
	@Deprecated
	@SuppressWarnings("all")
	private void importPatent(HttpServletRequest request, HttpServletResponse response) {
		// �ļ��ϴ�����
		SmartUpload su = new SmartUpload();
		java.io.File file2 = new java.io.File(request.getServletContext().getRealPath("temp"));
		if(!file2.exists())
			file2.mkdirs();
		try {
			// ��ʼ���ϴ�����
			su.initialize(getServletConfig(),request,response);
			// ���������ϴ��ļ�����
			su.setAllowedFilesList("xls");
			su.setMaxFileSize(2*1024*1024);
			// �ϴ�
			su.upload();
			// ��ȡר���������ĸ�ר�����id
			Integer ztzlk_id = StringUtil.StringToInt(su.getRequest().getParameter("ztzlk_id"));
			String username = su.getRequest().getParameter("username");
			Files files = su.getFiles();
			Excel excel = new Excel();
			excel.setZtzlk_id(ztzlk_id);
			excel.setUsername(username);
			for(int i = 0; i < files.getCount(); i++){
				File file = files.getFile(i);
				String fieldName = file.getFileName();
				fieldName = new String(fieldName.getBytes("gbk"),"utf-8");
				fieldName = UUID.randomUUID().toString()+"-"+fieldName;
				System.out.println("�ļ����ƣ�"+fieldName);
				file.saveAs("temp\\"+fieldName,SmartUpload.SAVE_VIRTUAL);
				file2 = new java.io.File(request.getServletContext().getRealPath("temp/"+fieldName));
				excel.setPath(file2.getAbsolutePath());
				Workbook workbook = Workbook.getWorkbook(file2);
				Sheet[] sheets = workbook.getSheets();
				System.out.println("һ����"+sheets.length+"��������");
				for (Sheet sheet : sheets) {
					String name = sheet.getName();
					int rows = sheet.getRows();
					int columns = sheet.getColumns();
					System.out.println(name+"����"+rows+"��"+columns+"��");
					Cell[] row = sheet.getRow(0);
					sist.domain.Excel.Sheet sheet2 = excel.addSheet();
					sheet2.setName(name);
					for (Cell cell : row) {
						String contents = cell.getContents();
						sheet2.getHandNames().add(contents);
					}
				}
			}
			
			request.setAttribute("excel2", excel);
			request.getRequestDispatcher("/back/special_library/import_patent.jsp").forward(request, response);
			
		} catch (ServletException | IOException | SmartUploadException | BiffException e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("all")
	private void importPatent2(HttpServletRequest request,HttpServletResponse response) throws ServletException{
		DiskFileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
		Map<String,String> map = new HashMap<>();
		try {
			Excel excel = new Excel();
			UserBean user = (UserBean) request.getSession().getAttribute(Constant.SESSION_USER);
			if(user!=null)
				excel.setUsername(user.getUsername());
			else
				return;
			List<FileItem> items = upload.parseRequest(request);
			for (FileItem fileItem : items) {
				boolean isFormField = fileItem.isFormField();
				if(isFormField){
					String fieldName = fileItem.getFieldName();
					String value = fileItem.getString("utf-8");
					map.put(fieldName, value);
				}else{
					String name = UploadUtils.getRealName(fileItem.getName());
					String uuidName = UploadUtils.getUUIDName(name);
					java.io.File file = new java.io.File(request.getServletContext().getRealPath("WEB-INF/temp"+UploadUtils.getDir(name)));
					if(!file.exists()){
						file.mkdirs();
					}
					java.io.File file2 = new java.io.File(file,uuidName);
					OutputStream os = new FileOutputStream(file2);
					InputStream is = fileItem.getInputStream();
					StreamUtil.inToOut(is, os);
					is.close();
					os.flush();
					os.close();
					parseExcelFile(file2,excel);
					request.setAttribute("excel2", excel);
				}
			}
			BeanUtils.populate(excel, map);
			request.getRequestDispatcher("/back/special_library/import_patent.jsp").forward(request, response);
		} catch (FileUploadException | IOException | BiffException | IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}
	}
	
	private void parseExcelFile(java.io.File file,Excel excel) throws BiffException, IOException{
		excel.setPath(file.getAbsolutePath());				// ����Excel�ļ��ľ���·��
		Workbook workbook = Workbook.getWorkbook(file);		// �����ļ�
		Sheet[] sheets = workbook.getSheets();				// ��ȡ����������
		for (Sheet sheet : sheets) {						// ����������
			sist.domain.Excel.Sheet book = excel.addSheet();// Ϊexcel�������һ������������
			book.setName(sheet.getName());					// ���ù�����������
			Cell[] row = sheet.getRow(0);					// ��ȡ�������ĵ�һ�е�Ԫ��
			for(Cell cell : row){							// ������һ�е�Ԫ��
				String contents = cell.getContents();		// ��ȡ��Ԫ�������
				book.getHandNames().add(contents);			// ����һ�еĵ�Ԫ������Ϊ��ͷ
			}
		}
	}
	
	/**
	 * ��ҳ��ѯ��ʾר��
	 */
	private void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PatentPage page = new PatentPage();
		int msg = StringUtil.StringToInt(request.getParameter("msg"));
		try {
			if(msg==0){
				BeanUtils.populate(page, request.getParameterMap());
			}
			else {
				Object object = request.getSession().getAttribute("pagingBean");
				if(object instanceof PatentPage)
					page = (PatentPage) object;
			}
		} catch (IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
		List<Patent> list = service.getList(page);
		request.setAttribute("patents", list);
		request.getSession().setAttribute("pagingBean", page);
		String result = request.getParameter("result");
		if("list".equals(result)){
			request.getRequestDispatcher("/back/special_library/manage_patent.jsp").forward(request, response);
		}else if("json".equals(result)){
			Gson gson = new Gson();
			JsonElement jsonTree = gson.toJsonTree(page);
			JsonObject json = jsonTree.getAsJsonObject();
			json.add("data", gson.toJsonTree(list));
			response.getWriter().println(json);
		}
	}

//	private boolean isEmpty(Patent patent){
//		try {
//			return patent.getFlzt().isEmpty()&&patent.getFmmc().isEmpty()&&patent.getFmr().isEmpty()&&
//			patent.getGkh().isEmpty()&&patent.getGkr().isEmpty()&&patent.getIpc_flh().isEmpty()&&
//			patent.getSqr().isEmpty()&&patent.getSqrdz().isEmpty()&&patent.getSqrq().isEmpty()&&
//			patent.getYxqh().isEmpty()&&patent.getYxqr().isEmpty()&&patent.getZlh().isEmpty()&&
//			patent.getZy().isEmpty();
//		} catch (Exception e) {
//			e.printStackTrace();
//			return true;
//		}
//	}
	/**
	 * ����request���ݵĲ����б�־Excel�ļ��й��е���Ϣ
	 * @param tableName
	 * @param map
	 * @return
	 */
	private Map<String,Integer> getOrder(String tableName,Map<String,? extends Object> map){
		Map<String,Integer> map2 = new HashMap<>();
		Set<String> keySet = map.keySet();
		for (String string : keySet) {
			if(string.endsWith("_"+tableName)){
				try {
					int indexOf = string.lastIndexOf("_");
					String key = string.substring(0, indexOf);
					Object obj = map.get(string);
					if(obj.getClass().isArray())
						obj = ((Object[])obj)[0];
					int index = StringUtil.StringToInt(obj.toString());
					map2.put(key, index);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return map2;
	}
	
	/**
	 * ��Excel�ļ��е�һ�м�¼��װ��һ��map�����У���map���ϵļ�ֵ��ʾ
	 * Excel�еĺ��壬ֵ��ʾ���ж�Ӧ�е�����
	 * @param map	���ָ����������������±��map
	 * @param cell	Excel��Ԫ����ɵ����ݣ�
	 * @return
	 */
	private Map<String,String> populate(Map<String,Integer> map,Cell[] cell){
		Map<String,String> map2 = new HashMap<>();
		Set<Entry<String,Integer>> entrySet = map.entrySet();
		for (Entry<String, Integer> entry : entrySet) {
			String key = entry.getKey();
			Integer value = entry.getValue();
			int length = cell.length;
			if(value<length&&value>-1){
				map2.put(key, cell[value].getContents());
			}
		}
		return map2;
	}
}
