package sist.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import sist.bean.CoopSitePage;
import sist.dao.CoopSiteDao;
import sist.domain.CoopSite;
import sist.factory.BasicFactory;
import sist.service.CoopSiteService;
import sist.utils.URLUtil;

public class CoopSiteServiceImp implements CoopSiteService {

	CoopSiteDao dao = BasicFactory.getFactory().getDao(CoopSiteDao.class);
	@Override
	public boolean saveOrUpdate(CoopSite site) {
		if(dao.findSiteById(site.getId())==null)
		{
			String date = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date());
			site.setDate(date);
			site.setHites(0);
			return dao.addSite(site);
		}
		else
		{
			return dao.updateSite(site);
		}
	}
	@Override
	public List<CoopSite> getList(CoopSitePage sitePage) {
		int currentPage = sitePage.getCurrentPage();
		if(currentPage <= 0)
		{
			currentPage = 1;
			sitePage.setCurrentPage(currentPage);
		}
		int pageSize = sitePage.getPageSize();
		if(pageSize <= 0)
		{
			pageSize = 10;
			sitePage.setPageSize(pageSize);
		}
		List<CoopSite> list = dao.getList(sitePage);
		int count = dao.getCount(sitePage);
		sitePage.setTotalCount(count);
		sitePage.setTotalPage(count%pageSize==0?count/pageSize:count/pageSize+1);
		sitePage.setPreUrl("coopSiteServlet?method=list&result=list&"+URLUtil.preUrl(sitePage));
		sitePage.setAnd(true);
		return list;
	}
	@Override
	public CoopSite getCoopSite(int id) {
		CoopSite site = dao.getCoopSite(id);
		return site;
	}
	@Override
	public boolean delById(int id) {
		
		return dao.delById(id);
	}
	@Override
	public boolean checkSiteName(String name) {
		CoopSite byName = dao.getByName(name);
		return byName==null;
	}

}
