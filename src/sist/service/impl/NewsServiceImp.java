package sist.service.impl;

import java.util.List;

import sist.bean.NewsPaging;
import sist.bean.PagingBean;
import sist.dao.NewsDao;
import sist.domain.NewsBean;
import sist.factory.BasicFactory;
import sist.service.NewsService;
import sist.utils.URLUtil;

public class NewsServiceImp implements NewsService {

	/* (non-Javadoc)
	 * @see sist.service.NewsService#saveOrUpdate(sist.domain.NewsBean)
	 */
	@Override
	public boolean saveOrUpdate(NewsBean newsBean) {
		NewsDao dao = BasicFactory.getFactory().getDao(NewsDao.class);
		// 查找数据库中是否存在这条数据
		if(dao.findById(newsBean.getId())==null){
			// 如果不存在则添加这条数据
			return dao.addNews(newsBean);
		}else{
			// 存在则更新这条数据
			return dao.updateNews(newsBean);
		}
	}

	/* (non-Javadoc)
	 * @see sist.service.NewsService#getList(sist.bean.NewsPaging)
	 */
	@Override
	public List<NewsBean> getList(NewsPaging newsPaging) {
		NewsDao dao = BasicFactory.getFactory().getDao(NewsDao.class);
		int currentPage = newsPaging.getCurrentPage();
		int pageSize = newsPaging.getPageSize();
		if(currentPage==0){
			currentPage = 1;
			newsPaging.setCurrentPage(currentPage);
		}
		if(pageSize==0){
			pageSize = 10;
			newsPaging.setPageSize(pageSize);
		}
		
		
		List<NewsBean> list = dao.getList(newsPaging);
		int count = dao.getCount(newsPaging);
		newsPaging.setTotalCount(count);
		newsPaging.setTotalPage(count%pageSize==0 ? count/pageSize : count/pageSize+1);
		String preUrl = "newsServlet?method=list&result=list&"+URLUtil.preUrl(newsPaging);
		newsPaging.setAnd(true);
		newsPaging.setPreUrl(preUrl);
		return list;
	}

	/* (non-Javadoc)
	 * @see sist.service.NewsService#delById(int)
	 */
	@Override
	public boolean delById(int id) {
		NewsDao dao = BasicFactory.getFactory().getDao(NewsDao.class);
		return dao.delById(id);
	}

	/* (non-Javadoc)
	 * @see sist.service.NewsService#getNews(int)
	 */
	@Override
	public NewsBean getNews(int id) {
		NewsDao dao = BasicFactory.getFactory().getDao(NewsDao.class);
		NewsBean newsBean = dao.findById(id);
		return newsBean;
	}

	@Override
	public List<NewsBean> search(PagingBean pagingBean) {
		 NewsDao dao = (NewsDao)BasicFactory.getFactory().getDao(NewsDao.class);
	        if(pagingBean != null)
	        {
	            int currentPage = pagingBean.getCurrentPage();
	            if(currentPage == 0)
	            {
	                currentPage = 1;
	                pagingBean.setCurrentPage(1);
	            }
	            int pageSize = pagingBean.getPageSize();
	            if(pageSize == 0)
	            {
	                pageSize = 5;
	                pagingBean.setPageSize(5);
	            }
	            Integer integer = dao.serchCount(pagingBean);
	            pagingBean.setTotalCount(integer.intValue());
	            pagingBean.setTotalPage(integer.intValue() % pageSize != 0 ? integer.intValue() / pageSize + 1 : integer.intValue() / pageSize);
	        }
	        List<NewsBean> list = dao.search(pagingBean);
	        

	        return list;
	}

	@Override
	public boolean checkTitle(String title) {
		NewsDao dao = BasicFactory.getFactory().getDao(NewsDao.class);
		NewsBean newsBean = dao.getByTitle(title);
		return newsBean==null;
	}

}
