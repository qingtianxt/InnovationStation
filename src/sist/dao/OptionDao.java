package sist.dao;

import java.util.List;

public interface OptionDao extends Dao {

	/**
	 * ��ȡ����������ݱ��е���������
	 * @return
	 */
	List<Object[]> getJslbList();

	/**
	 * ��ȡ����������ʽ���ݱ��е���������
	 * @return
	 */
	List<Object[]> getJstxxsList();

	String getByIdOrName(Object idOrName);

}
