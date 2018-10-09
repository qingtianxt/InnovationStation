package sist.dao;

import java.util.List;

import sist.bean.PatentPage;
import sist.domain.Patent;

public interface PatentDao extends Dao {

	/**
	 * 查询
	 * @param page
	 * @return
	 */
	List<Patent> getList(PatentPage page);

	/**
	 * 查询记录条数
	 * @param page
	 * @return
	 */
	int getCount(PatentPage page);

	/**
	 * 项数据看中添加数据
	 * @param list
	 * @return
	 */
	boolean addAll(List<Patent> list);

	/**
	 * 通过专利号查找专利信息
	 * @param id
	 * @return
	 */
	Patent getPatent(int id);


	/**
	 * 添加专利信息
	 * @param patent
	 * @return
	 */
	boolean addPatent(Patent patent);

	/**
	 * 修改专利
	 * @param patent
	 * @return
	 */
	boolean updatePatent(Patent patent);

	/**
	 * 通过id删除信息
	 * @param id
	 * @return
	 */
	boolean delById(int id);

}
