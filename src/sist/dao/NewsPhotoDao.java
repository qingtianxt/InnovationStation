package sist.dao;

import java.util.List;

import sist.bean.NewsPhotoPage;
import sist.domain.NewsPhoto;

public interface NewsPhotoDao extends Dao{

	/**
	 * ͨ��ͼƬ���ŵ�id�Ų���ͼƬ����
	 * @param id	ͼƬ���ŵ�id
	 * @return		������ҵ���Ӧid��ͼƬ���ţ����ط�װ��ͼƬ��Ϣ��Javabean����
	 * 				���򷵻�null
	 */
	NewsPhoto findNewsPhoto(Integer id);

	/**
	 * �����ݿ������ͼƬ����
	 * @param newsPhoto	��װ��������Ϣ��Javabean����
	 * @return			��ӳɹ�����true�����ʧ�ܷ���false
	 */
	boolean addNewsPhoto(NewsPhoto newsPhoto);

	/**
	 * �������ݿ��ܵ�������Ϣ
	 * @param newsPhoto	��װ�˴����µ�������Ϣ
	 * @return			���³ɹ�����true������ʧ�ܷ���false
	 */
	boolean updateNewsPhoto(NewsPhoto newsPhoto);

	/**
	 * ��ѯ���ݱ��е�������Ϣ
	 * @param photoPage ��װ�˲�ѯ������Javabean����
	 * @return			list���϶���
	 */
	List<NewsPhoto> getList(NewsPhotoPage photoPage);

	/**
	 * ��ѯ���ݱ��з������������ŵļ�¼����
	 * @param photoPage	��װ�˲�ѯ������Javabean����
	 * @return			Integer���ͱ���
	 */
	int getCount(NewsPhotoPage photoPage);

	/**
	 * ͨ��ͼƬ���ŵ�id��ȡͼƬ���ŵ���Ϣ
	 * @param id
	 * @return
	 */
	NewsPhoto getNewsPhoto(int id);

	/**
	 * ͨ��idɾ��
	 * @param id
	 * @return
	 */
	boolean delById(int id);

	/**
	 * ͨ�����ű������ƾ�ȷ����������Ϣ
	 * @param title	���ű��������
	 * @return		
	 */
	NewsPhoto getByTitle(String title);

}
