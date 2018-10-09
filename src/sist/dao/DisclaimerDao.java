package sist.dao;

import sist.domain.Disclaimer;

public interface DisclaimerDao extends Dao {

	/**
	 * ��ȡ���id
	 * 
	 * @return
	 */
	Integer getMaxId();

	/**
	 * �����������
	 * @param disclaimer
	 * @return
	 */
	boolean add(Disclaimer disclaimer);

	Disclaimer getById(Integer id);

	boolean update(Disclaimer disclaimer);

}
