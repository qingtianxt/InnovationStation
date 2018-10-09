package sist.dao;

import java.util.List;

import sist.bean.LibPageBean;
import sist.domain.SpecialLibrary;

/**
 * @author 悦尔
 *
 */
public interface SpeLibDao extends Dao {

	/**
	 * 根据专题库的id查找专题库信息
	 * @param id
	 * @return
	 */
	SpecialLibrary findById(Integer id);

	/**
	 * 添加专题库信息
	 * @param lib	封装了专题库信息的Javabean对象
	 * @return		添加成功返回true，否则返回false
	 */
	boolean add(SpecialLibrary lib);

	/**
	 * 更新专题库信息
	 * @param lib	封装了专题信息的Javabean对象，注意主键id不能修改
	 * @return
	 */
	boolean update(SpecialLibrary lib);

	/**
	 * 根据条件查询专题库信息
	 * @param page
	 * @return
	 */
	List<SpecialLibrary> getList(LibPageBean page);

	/**
	 * 查询书库中符合条件的数据条数，page为封装了查询条件的Javabean对象，如果page为null，则返回
	 * 数据库中所有数据总条数
	 * @param page	
	 * @return
	 */
	int getCount(LibPageBean page);

	/**
	 * 通过id删除专题库
	 * @param id
	 * @return
	 */
	boolean delById(int id);

	/**
	 * 通过标题名称查找专题库
	 * @param title
	 * @return
	 */
	SpecialLibrary getByTitle(String title);

}
