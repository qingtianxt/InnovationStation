package sist.service.impl;

import java.util.List;

import com.alibaba.fastjson.JSONObject;

import sist.bean.PagingBean;
import sist.dao.JSGJDao;
import sist.dao.NewsDao;
import sist.domain.JSGJBean;
import sist.domain.NewsBean;
import sist.factory.BasicFactory;
import sist.service.SearchService;
@Deprecated
public class SearchServiceImp implements SearchService {

	@Override
	public Object search(PagingBean keys) {
		NewsDao dao = BasicFactory.getFactory().getDao(NewsDao.class);
		if(keys!=null){
			int currentPage = keys.getCurrentPage();
			if(currentPage==0){
				keys.setCurrentPage(1);
				currentPage = 1;
			}
			int pageSize = keys.getPageSize();
			if(pageSize==0){
				keys.setPageSize(10);
				pageSize = 10;
			}
//			dao.getCount2(page);
		}
		
		
		JSONObject jsonObject = new JSONObject();
		// 查找新闻
		List<NewsBean> newsBean = dao.search(keys);
		// 查找技术
		 JSGJDao dao2 = BasicFactory.getFactory().getDao(sist.dao.JSGJDao.class);
		 List<JSGJBean> js = dao2.search(keys);
		jsonObject.put("news", newsBean);
		jsonObject.put("teachnology", js);
		return jsonObject;
	}

}
