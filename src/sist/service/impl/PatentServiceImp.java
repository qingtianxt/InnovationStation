package sist.service.impl;

import java.util.List;

import sist.bean.PatentPage;
import sist.dao.PatentDao;
import sist.domain.Patent;
import sist.factory.BasicFactory;
import sist.service.PatentService;
import sist.utils.URLUtil;

public class PatentServiceImp implements PatentService {

	private PatentDao dao = BasicFactory.getFactory().getDao(PatentDao.class);
	@Override
	public List<Patent> getList(PatentPage page) {
		int currentPage = page.getCurrentPage();
		if(currentPage==0){
			currentPage = 1;
			page.setCurrentPage(1);
		}
		int pageSize = page.getPageSize();
		if(pageSize==0){
			page.setPageSize(10);
			pageSize= 10;
		}
		
		List<Patent> list = dao.getList(page);
		int count = dao.getCount(page);
		page.setTotalCount(count);
		page.setTotalPage(count%pageSize==0? count/pageSize:count/pageSize+1);
		page.setPreUrl("patentServlet?method=list&result=list&"+URLUtil.preUrl(page));
		page.setAnd(true);
		return list;
	}
	@Override
	public boolean addAll(List<Patent> list) {
		
		
		return dao.addAll(list);
	}
	
	
	
	@Override
	public Patent getPatenet(int id) {
		return dao.getPatent(id);
	}
	@Override
	public boolean saveOrUpdate(Patent patent) {
		// 先查找是否存在这条信息
		if(dao.getPatent(patent.getId())==null)
		{
			return dao.addPatent(patent);
		}
		else
		{
			return dao.updatePatent(patent);
		}
	}
	@Override
	public boolean delById(int id) {
		
		return dao.delById(id);
	}

}
