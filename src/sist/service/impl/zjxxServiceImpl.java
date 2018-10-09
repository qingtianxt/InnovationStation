package sist.service.impl;

import java.util.List;

import sist.bean.frontZjxxPagingBean;
import sist.bean.zjxxPagingBean;
import sist.dao.zjxxDao;
import sist.domain.zjxx;
import sist.factory.BasicFactory;
import sist.service.zjxxService;
import sist.utils.Constant;

public class zjxxServiceImpl implements zjxxService {

	@Override
	public void add(zjxx z) throws Exception {
		zjxxDao zd = BasicFactory.getFactory().getDao(zjxxDao.class);
		zd.add(z);
	}

	/**
	 * 根据条件 分页获取
	 */
	@Override
	public zjxxPagingBean getList(zjxxPagingBean page) throws Exception {
		zjxxDao zd = BasicFactory.getFactory().getDao(zjxxDao.class);

		int totalCount = zd.count(page);
		page.setTotalCount(totalCount);
		// 处理每页显示数据量
		int pageSize = page.getPageSize();
		if (pageSize == 0) {
			pageSize = Constant.KJCGPAGESIZE;
			page.setPageSize(pageSize);
		}

		List<zjxx> list = zd.getList(page);
		page.setList(list);
		page.setTotalPage((int) Math.ceil(totalCount * 1.0 / pageSize));
		return page;
	}

	/**
	 * 根据id获取专家信息
	 */
	@Override
	public zjxx getById(int id) throws Exception {
		zjxxDao zd = BasicFactory.getFactory().getDao(zjxxDao.class);
		return zd.getById(id);
	}

	/**
	 * 修改专家信息
	 */
	@Override
	public void update(zjxx z) throws Exception {
		zjxxDao zd = BasicFactory.getFactory().getDao(zjxxDao.class);
		zd.update(z);
	}

	@Override
	public void delete(int id) throws Exception {
		zjxxDao zd = BasicFactory.getFactory().getDao(zjxxDao.class);
		zd.delete(id);
	}

	@Override
	public frontZjxxPagingBean getFrontList(frontZjxxPagingBean page) throws Exception {
		zjxxDao zd = BasicFactory.getFactory().getDao(zjxxDao.class);

		int totalCount = zd.frontCount(page);
		page.setTotalCount(totalCount);
		// 处理每页显示数据量
		int pageSize = page.getPageSize();
		if (pageSize == 0) {
			pageSize = Constant.ZJXXPAGESIZE;
			page.setPageSize(pageSize);
		}

		List<zjxx> list = zd.getFrontList(page);
		page.setList(list);
		page.setTotalPage((int) Math.ceil(totalCount * 1.0 / pageSize));
		return page;
	}

	@Override
	public void addHits(int id) throws Exception {
		zjxxDao zd = BasicFactory.getFactory().getDao(zjxxDao.class);
		zd.addHits(id);
	}

	@Override
	public frontZjxxPagingBean getListByUser(frontZjxxPagingBean page, String username) throws Exception {
		zjxxDao zd = BasicFactory.getFactory().getDao(zjxxDao.class);

		int totalCount = zd.CountByUser(page,username);
		page.setTotalCount(totalCount);
		// 处理每页显示数据量
		int pageSize = page.getPageSize();
		if (pageSize == 0) {
			pageSize = Constant.ZJXXPAGESIZE;
			page.setPageSize(pageSize);
		}

		List<zjxx> list = zd.getListByUser(page,username);
		page.setList(list);
		page.setTotalPage((int) Math.ceil(totalCount * 1.0 / pageSize));
		return page;
	}

	@Override
	public List<zjxx> getTop() throws Exception {
		zjxxDao zd = BasicFactory.getFactory().getDao(zjxxDao.class);
		int topsize = Constant.TOPSIZE;
		
		return zd.getTop(topsize);
	}

	@Override
	public zjxxPagingBean search(zjxxPagingBean page) throws Exception {

		zjxxDao zd = BasicFactory.getFactory().getDao(zjxxDao.class);
		int totalCount = zd.countByKey(page);

		// 处理每页显示数据量
		int pageSize = page.getPageSize();
		if (pageSize == 0) {
			pageSize = Constant.KEY_ZJXXPAGESIZE;
			page.setPageSize(pageSize);
		}
		List<zjxx> list = zd.getByKey(page);
		page.setList(list);
		page.setTotalCount(totalCount);
		page.setTotalPage((int) Math.ceil(totalCount * 1.0 / pageSize));

		return page;

	
	}

}
