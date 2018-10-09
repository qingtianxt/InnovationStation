package sist.service.impl;

import java.util.List;

import sist.bean.NewsPhotoPage;
import sist.dao.NewsPhotoDao;
import sist.domain.NewsPhoto;
import sist.factory.BasicFactory;
import sist.service.NewsPhotoService;
import sist.utils.URLUtil;

public class NewsPhotoServiceImp implements NewsPhotoService {

	/* (non-Javadoc)
	 * @see sist.service.NewsPhotoService#saveOrUpdate(sist.domain.NewsPhoto)
	 */
	@Override
	public boolean saveOrUpdate(NewsPhoto newsPhoto) {
		NewsPhotoDao dao = BasicFactory.getFactory().getDao(NewsPhotoDao.class);
		if(dao.findNewsPhoto(newsPhoto.getId())==null){
			// Ìí¼Ó
			return dao.addNewsPhoto(newsPhoto);
		}else{
			// ÐÞ¸Ä
			return dao.updateNewsPhoto(newsPhoto);
		}
	}

	/* (non-Javadoc)
	 * @see sist.service.NewsPhotoService#getList(sist.bean.NewsPhotoPage)
	 */
	@Override
	public List<NewsPhoto> getList(NewsPhotoPage photoPage) {
		 NewsPhotoDao dao = BasicFactory.getFactory().getDao(NewsPhotoDao.class);
	        if(photoPage != null)
	        {
	            int currentPage = photoPage.getCurrentPage();
	            int pageSize = photoPage.getPageSize();
	            if(currentPage == 0)
	            {
	                currentPage = 1;
	                photoPage.setCurrentPage(1);
	            }
	            if(pageSize == 0)
	            {
	                pageSize = 10;
	                photoPage.setPageSize(10);
	            }
	            int count = dao.getCount(photoPage);
	            photoPage.setTotalCount(count);
	            photoPage.setTotalPage(count % pageSize != 0 ? count / pageSize + 1 : count / pageSize);
	            String preUrl = (new StringBuilder("newsPhotoServlet?method=list&result=list&")).append(URLUtil.preUrl(photoPage)).toString();
	            photoPage.setPreUrl(preUrl);
	            photoPage.setAnd(!preUrl.trim().isEmpty());
	        }
	        List<NewsPhoto> list = dao.getList(photoPage);
	        if(photoPage != null)
	            photoPage.setList(list);
	        return list;
	}

	/* (non-Javadoc)
	 * @see sist.service.NewsPhotoService#getNewsPhoto(int)
	 */
	@Override
	public NewsPhoto getNewsPhoto(int id) {
		NewsPhotoDao dao = BasicFactory.getFactory().getDao(NewsPhotoDao.class);
		
		return dao.getNewsPhoto(id);
	}

	/* (non-Javadoc)
	 * @see sist.service.NewsPhotoService#delById(int)
	 */
	@Override
	public boolean delById(int id) {
		NewsPhotoDao dao = BasicFactory.getFactory().getDao(NewsPhotoDao.class);
		
		return dao.delById(id);
	}

	@Override
	public boolean checkTitle(String title) {
		NewsPhotoDao dao = BasicFactory.getFactory().getDao(NewsPhotoDao.class);
		NewsPhoto newsPhoto = dao.getByTitle(title);
		return newsPhoto == null;
	}

}
