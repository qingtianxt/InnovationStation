package sist.dao;

import java.util.List;

import sist.bean.PatentPage;
import sist.domain.Patent;

public interface PatentDao extends Dao {

	/**
	 * ��ѯ
	 * @param page
	 * @return
	 */
	List<Patent> getList(PatentPage page);

	/**
	 * ��ѯ��¼����
	 * @param page
	 * @return
	 */
	int getCount(PatentPage page);

	/**
	 * �����ݿ����������
	 * @param list
	 * @return
	 */
	boolean addAll(List<Patent> list);

	/**
	 * ͨ��ר���Ų���ר����Ϣ
	 * @param id
	 * @return
	 */
	Patent getPatent(int id);


	/**
	 * ���ר����Ϣ
	 * @param patent
	 * @return
	 */
	boolean addPatent(Patent patent);

	/**
	 * �޸�ר��
	 * @param patent
	 * @return
	 */
	boolean updatePatent(Patent patent);

	/**
	 * ͨ��idɾ����Ϣ
	 * @param id
	 * @return
	 */
	boolean delById(int id);

}
