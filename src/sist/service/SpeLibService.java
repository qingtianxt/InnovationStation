package sist.service;

import java.util.List;

import sist.bean.LibPageBean;
import sist.domain.SpecialLibrary;

public interface SpeLibService extends Service {

	/**
	 * ������޸�ר�����Ϣ
	 * @param lib	��װ��ר�����Ϣ��Javabean
	 * @return		��������޸ĳɹ�����true�����򷵻�false
	 */
	boolean saveOrUpdate(SpecialLibrary lib);

	/**
	 * ����ר�����Ϣ
	 * @param page ��װ��ר����ѯ��Ϣ��Javabean����
	 * @return		
	 */
	List<SpecialLibrary> getList(LibPageBean page);

	/**
	 * ����ָ��id��ר���
	 * @param id
	 * @return
	 */
	SpecialLibrary getLibrary(int id);

	/**
	 * ͨ��idɾ��ר���
	 * @param id
	 * @return
	 */
	boolean delById(int id);

	boolean checkTitle(String title);

}
