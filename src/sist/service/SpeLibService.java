package sist.service;

import java.util.List;

import sist.bean.LibPageBean;
import sist.domain.SpecialLibrary;

public interface SpeLibService extends Service {

	/**
	 * 保存或修改专题库信息
	 * @param lib	封装了专题库信息的Javabean
	 * @return		保存或者修改成功返回true，否则返回false
	 */
	boolean saveOrUpdate(SpecialLibrary lib);

	/**
	 * 查找专题库信息
	 * @param page 封装了专题库查询信息的Javabean对象
	 * @return		
	 */
	List<SpecialLibrary> getList(LibPageBean page);

	/**
	 * 查找指定id的专题库
	 * @param id
	 * @return
	 */
	SpecialLibrary getLibrary(int id);

	/**
	 * 通过id删除专题库
	 * @param id
	 * @return
	 */
	boolean delById(int id);

	boolean checkTitle(String title);

}
