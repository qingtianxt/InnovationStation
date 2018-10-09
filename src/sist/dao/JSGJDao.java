package sist.dao;

import java.util.List;

import sist.bean.PagingBean;
import sist.domain.JSGJBean;

public interface JSGJDao extends Dao {
	public abstract JSGJBean findById(Integer integer);

	public abstract boolean add(JSGJBean jsgjbean);

	public abstract boolean update(JSGJBean jsgjbean);

	/**
	 * ��ѯ����ָ�������������£�pagingBean�з�װ�˲�ѯ�����Ͳ�ѯ��¼����
	 * ���pagingBeanΪnull���򷵻����м�¼��pagingBean�е��������ӷ�ʽ Ϊand
	 * 
	 * @param pagingbean
	 *            ��װ�˲�ѯ��Ϣ���ҳ��Ϣ��pagingBean����
	 * @return JSGJBean��list����
	 */
	public abstract List<JSGJBean> getList(PagingBean pagingbean);

	/**
	 * ��ȡ����ָ�������ļ�¼�����������getListʵ�ַ�ҳ��ѯ
	 * 
	 * @param pagingbean
	 *            ��װ�˷�ҳ��Ϣ�Ͳ�ѯ������pagingBean����
	 * @return ���pagingBean����Ϊ�գ����ط� pagingBean�з�װ�������ļ�¼�������򷵻ؼ�¼����
	 */
	public abstract int getCount(PagingBean pagingbean);

	/**
	 * ͨ��idɾ��������Ϣ
	 * 
	 * @param i
	 *            ��ɾ������Ϣ������
	 * @return ɾ���ɹ�����true�����򷵻�false
	 */
	public abstract boolean delById(int i);

	/**
	 * ģ����ѯ�����ݹؼ���ģ��ƥ�����ֶ� ���pagingBeanΪnull�����������м�¼��Ϣ
	 * 
	 * @param pagingbean
	 *            ��װ�˲�ѯ��Ϣ�ͷ�ҳ��Ϣ��PagingBean����
	 * @return ��ѯ�����list����
	 */
	public abstract List<JSGJBean> search(PagingBean pagingbean);

	/**
	 * ģ����ѯ��¼���������ݹؼ���ģ��ƥ�似���������е������ֶΡ� ���searchʵ�ַ�ҳ
	 * 
	 * @param pagingbean
	 *            ��װ�˷�ҳ��Ϣ�͹ؼ���
	 * @return ��Ϣ����
	 */
	public abstract Integer searchCount(PagingBean pagingbean);

	/**
	 * ͨ���������ƾ�ȷ���Ҽ�����Ϣ
	 * 
	 * @param name
	 *            ��������
	 * @return ������ڷ��ؼ�����Ϣ�����򷵻�null
	 */
	public abstract JSGJBean getByName(String name);

}
