package sist.service;

import java.util.List;

import sist.bean.PatentPage;
import sist.domain.Patent;

public interface PatentService extends Service {

	/**
	 * ��ȡר����Ϣ
	 * @param page ��װ�˲�ѯ������JavaBean�������Ϊnull�򷵻�����ר����Ϣ
	 * @return
	 */
	List<Patent> getList(PatentPage page);

	/**
	 * �������
	 * @param list
	 * @return
	 */
	boolean addAll(List<Patent> list);

	/**
	 * ͨ��id����ר��
	 * @param id
	 * @return
	 */
	Patent getPatenet(int id);

	/**
	 * ��������޸�ר����Ϣ
	 * @param patent
	 * @return
	 */
	boolean saveOrUpdate(Patent patent);

	/**
	 * ɾ��
	 * @param id
	 * @return
	 */
	boolean delById(int id);

}
