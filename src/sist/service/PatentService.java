package sist.service;

import java.util.List;

import sist.bean.PatentPage;
import sist.domain.Patent;

public interface PatentService extends Service {

	/**
	 * 获取专利信息
	 * @param page 封装了查询条件的JavaBean对象，如果为null则返回所有专利信息
	 * @return
	 */
	List<Patent> getList(PatentPage page);

	/**
	 * 添加数据
	 * @param list
	 * @return
	 */
	boolean addAll(List<Patent> list);

	/**
	 * 通过id查找专利
	 * @param id
	 * @return
	 */
	Patent getPatenet(int id);

	/**
	 * 保存或者修改专利信息
	 * @param patent
	 * @return
	 */
	boolean saveOrUpdate(Patent patent);

	/**
	 * 删除
	 * @param id
	 * @return
	 */
	boolean delById(int id);

}
