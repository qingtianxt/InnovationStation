package sist.service.impl;

import java.util.List;

import sist.bean.PagingBean;
import sist.dao.ZtzlxxkDao;
import sist.domain.Ztzlxxk;
import sist.factory.BasicFactory;
import sist.service.ZtzlxxkService;

public class ZtzlxxkServiceImpl implements ZtzlxxkService {

	@Override
	public List<Ztzlxxk> search(PagingBean page) {
		ZtzlxxkDao dao = BasicFactory.getFactory().getDao(ZtzlxxkDao.class);
		if(page!=null){
			int currentPage = page.getCurrentPage();
			if(currentPage==0)
				currentPage = 1;
			int pageSize = page.getPageSize();
			if(pageSize==0)
				pageSize = 5;
			page.setCurrentPage(currentPage);
			page.setPageSize(pageSize);
			Integer integer = dao.searchCount(page);
			page.setTotalCount(integer);
			page.setTotalPage(integer%pageSize==0? integer/pageSize : integer/pageSize+1);
		}
		List<Ztzlxxk> list = dao.search(page);
		return list;
	}

}
