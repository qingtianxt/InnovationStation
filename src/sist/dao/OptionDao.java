package sist.dao;

import java.util.List;

public interface OptionDao extends Dao {

	/**
	 * 获取技术类别数据表中的所有数据
	 * @return
	 */
	List<Object[]> getJslbList();

	/**
	 * 获取技术体现形式数据表中的所有数据
	 * @return
	 */
	List<Object[]> getJstxxsList();

	String getByIdOrName(Object idOrName);

}
