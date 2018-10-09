package sist.service;

import java.util.List;

import sist.bean.NewsPaging;
import sist.bean.PagingBean;
import sist.domain.NewsBean;

public interface NewsService extends Service {

	/**
	 * 保存或者修改新闻公告
	 * @param newsBean
	 * @return
	 */
	boolean saveOrUpdate(NewsBean newsBean);

	/**
	 * 查询新闻信息
	 * @param newsPaging
	 * @return
	 */
	List<NewsBean> getList(NewsPaging newsPaging);

	/**
	 * 通过新闻的id删除一条新闻纪录
	 * @param id
	 * @return
	 */
	boolean delById(int id);

	/**
	 * 根据id查找指定的新闻信息
	 * @param id
	 * @return
	 */
	NewsBean getNews(int id);

	List<NewsBean> search(PagingBean pagingBean);

	/**
	 * 验证新闻标题是否已经存在了
	 * @param title	待验证的标题
	 * @return		如果标题存在返回false，否则返回true
	 */
	boolean checkTitle(String title);


}
