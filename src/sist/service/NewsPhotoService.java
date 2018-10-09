package sist.service;

import java.util.List;

import sist.bean.NewsPhotoPage;
import sist.domain.NewsPhoto;

public interface NewsPhotoService extends Service {

	/**
	 * ��������޸�ͼƬ����
	 * @param newsPhoto
	 * @return
	 */
	boolean saveOrUpdate(NewsPhoto newsPhoto);

	/**
	 * ��ѯͼƬ����
	 * @param photoPage ��װ��ͼƬ������Ϣ��Javabean
	 * @return			ͼƬ���ŵ�list����
	 */
	List<NewsPhoto> getList(NewsPhotoPage photoPage);

	/**
	 * ͨ��ͼƬ���ŵ�id��ȡͼƬ����
	 * @param id
	 * @return
	 */
	NewsPhoto getNewsPhoto(int id);

	/**
	 * ����idɾ��ͼƬ����
	 * @param id
	 * @return
	 */
	boolean delById(int id);

	/**
	 * ���ͼƬ���ŵı����Ƿ��Ѿ�����
	 * @param title	���������ű���
	 * @return		������ű�����ڷ���false�����򷵻�true
	 */
	boolean checkTitle(String title);

}
