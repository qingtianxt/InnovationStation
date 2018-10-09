package sist.dao;

import java.util.List;

import sist.bean.LibPageBean;
import sist.domain.SpecialLibrary;

/**
 * @author �ö�
 *
 */
public interface SpeLibDao extends Dao {

	/**
	 * ����ר����id����ר�����Ϣ
	 * @param id
	 * @return
	 */
	SpecialLibrary findById(Integer id);

	/**
	 * ���ר�����Ϣ
	 * @param lib	��װ��ר�����Ϣ��Javabean����
	 * @return		��ӳɹ�����true�����򷵻�false
	 */
	boolean add(SpecialLibrary lib);

	/**
	 * ����ר�����Ϣ
	 * @param lib	��װ��ר����Ϣ��Javabean����ע������id�����޸�
	 * @return
	 */
	boolean update(SpecialLibrary lib);

	/**
	 * ����������ѯר�����Ϣ
	 * @param page
	 * @return
	 */
	List<SpecialLibrary> getList(LibPageBean page);

	/**
	 * ��ѯ����з�������������������pageΪ��װ�˲�ѯ������Javabean�������pageΪnull���򷵻�
	 * ���ݿ�����������������
	 * @param page	
	 * @return
	 */
	int getCount(LibPageBean page);

	/**
	 * ͨ��idɾ��ר���
	 * @param id
	 * @return
	 */
	boolean delById(int id);

	/**
	 * ͨ���������Ʋ���ר���
	 * @param title
	 * @return
	 */
	SpecialLibrary getByTitle(String title);

}
