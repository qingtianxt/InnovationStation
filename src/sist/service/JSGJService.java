package sist.service;

import java.util.List;

import sist.bean.SupplyPagingBean;
import sist.bean.TeachSearchPage;
import sist.domain.JSGJBean;

public interface JSGJService extends Service {

	/**
	 * 保存或者修改技术供给
	 * @param bean
	 * @return
	 */
	boolean saveOrUpdate(JSGJBean bean);

	/**
	 * 分页查询技术供给信息列表
	 * @param pagingBean
	 * @return
	 */
	List<JSGJBean> getList(SupplyPagingBean pagingBean);

	/**
	 * 通过id查找供给
	 * @param id
	 * @return
	 */
	JSGJBean getSupply(int id);

	/**
	 * 通过供给信息的id号删除信息
	 * @param stringToInt
	 * @return
	 */
	boolean delById(int stringToInt);

	void search(TeachSearchPage page);

	/**
	 * 检查技术名称是否已经存在
	 * @param name
	 * @return 如果存在该名称的技术信息，则返回true，否则返回false
	 */
	boolean checkName(String name);

}
