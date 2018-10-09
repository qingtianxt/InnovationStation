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
 * 专利管理的servlet
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
	 * 将Excel文件中的信息导入到数据库中
	 * 此处主要将Excel文件中的专利记录封装为Patent对象
	 * 该Excel文件已经保存在了临时文件夹中
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
				// 读取Excel文件
				Workbook workbook = Workbook.getWorkbook(file);
				for (String string : sheetNames) {
					// 将前台关于此表格的字段信息封装到一个map中
					Map<String, Integer> order = getOrder(string,request.getParameterMap());
					Integer start = order.get("start");
					Integer end = order.get("end");
					// 获取工作簿
					Sheet sheet = workbook.getSheet(string);
					// 该工作簿包含数据行数
					int rows = sheet.getRows();
					if(end==0)
						end = rows;
					for(int i = start-1; i < end; i++){
						Patent patent = new Patent();
						// 第i行
						Cell[] row = sheet.getRow(i);
						// 将第i行的数据封装到一个map中
						Map<String, String> p = populate(order,row);
						// TODO 判断集合是否为空
						Set<String> values = new HashSet<>(p.values());
						values.remove("");
						boolean empty = values.isEmpty();
						if(empty)
							break;
						BeanUtils.populate(patent, p);
						
						patent.setZtzlk_id(ztzlk_id);
						patent.setUsername(username);
						patent.setHits(0);// 设置点击率为0
						list.add(patent);
					}
					
				}
				boolean i = service.addAll(list);
				request.getRequestDispatcher("/back/special_library/libraryServlet?method=list&result=list&msg="+(i?"999":"1000")).forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
				request.getRequestDispatcher("/back/special_library/import_patent.jsp?msg=导入错误！&status="+e.getMessage()).forward(request, response);
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
	 * 获取指定id的专利信息，根据需求转发到指定页面
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
	 * 上传Excel文件，将文件保存在临时文件夹中，然后解析Excel表格，将结果反馈到页面
	 * 然后由页面设置表格中列与专利字段相对应
	 * @param request
	 * @param response
	 */
	@Deprecated
	@SuppressWarnings("all")
	private void importPatent(HttpServletRequest request, HttpServletResponse response) {
		// 文件上传对象
		SmartUpload su = new SmartUpload();
		java.io.File file2 = new java.io.File(request.getServletContext().getRealPath("temp"));
		if(!file2.exists())
			file2.mkdirs();
		try {
			// 初始化上传对象
			su.initialize(getServletConfig(),request,response);
			// 设置允许上传文件类型
			su.setAllowedFilesList("xls");
			su.setMaxFileSize(2*1024*1024);
			// 上传
			su.upload();
			// 获取专利保存在哪个专利库的id
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
				System.out.println("文件名称："+fieldName);
				file.saveAs("temp\\"+fieldName,SmartUpload.SAVE_VIRTUAL);
				file2 = new java.io.File(request.getServletContext().getRealPath("temp/"+fieldName));
				excel.setPath(file2.getAbsolutePath());
				Workbook workbook = Workbook.getWorkbook(file2);
				Sheet[] sheets = workbook.getSheets();
				System.out.println("一共有"+sheets.length+"个工作簿");
				for (Sheet sheet : sheets) {
					String name = sheet.getName();
					int rows = sheet.getRows();
					int columns = sheet.getColumns();
					System.out.println(name+"共有"+rows+"行"+columns+"列");
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
		excel.setPath(file.getAbsolutePath());				// 设置Excel文件的绝对路径
		Workbook workbook = Workbook.getWorkbook(file);		// 解析文件
		Sheet[] sheets = workbook.getSheets();				// 获取工作簿数组
		for (Sheet sheet : sheets) {						// 遍历工作簿
			sist.domain.Excel.Sheet book = excel.addSheet();// 为excel对象添加一个工作簿对象
			book.setName(sheet.getName());					// 设置工作簿的名称
			Cell[] row = sheet.getRow(0);					// 获取工作簿的第一行单元格
			for(Cell cell : row){							// 遍历第一行单元格
				String contents = cell.getContents();		// 获取单元格的内容
				book.getHandNames().add(contents);			// 将第一行的单元格设置为表头
			}
		}
	}
	
	/**
	 * 分页查询显示专利
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
	 * 解析request传递的参数中标志Excel文件有关列的信息
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
	 * 将Excel文件中的一行记录封装到一个map集合中，该map集合的键值表示
	 * Excel列的含义，值表示改行对应列的内容
	 * @param map	存放指定含义的列所在列下标的map
	 * @param cell	Excel单元格组成的数据，
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
