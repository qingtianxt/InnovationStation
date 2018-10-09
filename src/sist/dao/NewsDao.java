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
	 * 通过新闻标题精确查找信息
	 * @param title	新闻标题
	 * @return		如果该新闻存在返回新闻信息，否则返回null
	 */
	public abstract NewsBean getByTitle(String title);
}
