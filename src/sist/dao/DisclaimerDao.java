package sist.dao;

import sist.domain.Disclaimer;

public interface DisclaimerDao extends Dao {

	/**
	 * 获取最大id
	 * 
	 * @return
	 */
	Integer getMaxId();

	/**
	 * 添加免责声明
	 * @param disclaimer
	 * @return
	 */
	boolean add(Disclaimer disclaimer);

	Disclaimer getById(Integer id);

	boolean update(Disclaimer disclaimer);

}
