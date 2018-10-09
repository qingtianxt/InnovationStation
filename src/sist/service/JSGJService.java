package sist.service;

import java.util.List;

import sist.bean.SupplyPagingBean;
import sist.bean.TeachSearchPage;
import sist.domain.JSGJBean;

public interface JSGJService extends Service {

	/**
	 * ��������޸ļ�������
	 * @param bean
	 * @return
	 */
	boolean saveOrUpdate(JSGJBean bean);

	/**
	 * ��ҳ��ѯ����������Ϣ�б�
	 * @param pagingBean
	 * @return
	 */
	List<JSGJBean> getList(SupplyPagingBean pagingBean);

	/**
	 * ͨ��id���ҹ���
	 * @param id
	 * @return
	 */
	JSGJBean getSupply(int id);

	/**
	 * ͨ��������Ϣ��id��ɾ����Ϣ
	 * @param stringToInt
	 * @return
	 */
	boolean delById(int stringToInt);

	void search(TeachSearchPage page);

	/**
	 * ��鼼�������Ƿ��Ѿ�����
	 * @param name
	 * @return ������ڸ����Ƶļ�����Ϣ���򷵻�true�����򷵻�false
	 */
	boolean checkName(String name);

}
