package sist.dao;

import java.util.List;

import sist.bean.PagingBean;
import sist.domain.NewsBean;

public interface NewsDao extends Dao {

	public abstract NewsBean findById(Integer integer);

    public abstract boolean addNews(NewsBean newsbean);

    public abstract boolean updateNews(NewsBean newsbean);

    public abstract List<NewsBean> getList(PagingBean pagingbean);

    public abstract int getCount(PagingBean pagingbean);

    public abstract boolean delById(int i);

    public abstract List<NewsBean> search(PagingBean pagingbean);

    public abstract Integer serchCount(PagingBean pagingbean);

	/**
	 * ͨ�����ű��⾫ȷ������Ϣ
	 * @param title	���ű���
	 * @return		��������Ŵ��ڷ���������Ϣ�����򷵻�null
	 */
	public abstract NewsBean getByTitle(String title);
}
