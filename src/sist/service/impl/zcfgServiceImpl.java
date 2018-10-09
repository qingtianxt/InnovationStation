package sist.service.impl;

import java.util.List;

import sist.bean.zcfgPagingBean;
import sist.dao.zcfgDao;
import sist.domain.zcfg;
import sist.factory.BasicFactory;
import sist.service.zcfgService;
import sist.utils.Constant;

public class zcfgServiceImpl implements zcfgService {

	@Override
	public zcfg getByMc(String zcmc) throws Exception {
		zcfgDao zd = BasicFactory.getFactory().getDao(zcfgDao.class);

		return zd.getByMc(zcmc);
	}

	/**
	 * 添加政策法规信息
	 */
	@Override
	public void add(zcfg z) throws Exception {
		zcfgDao zd = BasicFactory.getFactory().getDao(zcfgDao.class);
		zd.add(z);
	}

	/**
	 * 根据条件分页获取政策法令
	 */
	@Override
	public zcfgPagingBean getList(zcfgPagingBean page) throws Exception {
		zcfgDao zd = BasicFactory.getFactory().getDao(zcfgDao.class);

		int totalCount = zd.count(page);
		page.setTotalCount(totalCount);

		// 处理每页显示数据量
		int pageSize = page.getPageSize();
		if (pageSize == 0) {
			pageSize = Constant.KJCGPAGESIZE;
			page.setPageSize(pageSize);
		}
		page.setTotalPage((int) Math.ceil(totalCount * 1.0 / pageSize));

		List<zcfg> list = zd.getList(page);
		page.setList(list);

		return page;
	}

	@Override
	public zcfg getById(int id) throws Exception {
		zcfgDao zd = BasicFactory.getFactory().getDao(zcfgDao.class);

		return zd.getById(id);
	}

	@Override
	public void update(zcfg z) throws Exception {
		zcfgDao zd = BasicFactory.getFactory().getDao(zcfgDao.class);
		zd.update(z);
	}

	@Override
	public void delete(int id) throws Exception {
		zcfgDao zd = BasicFactory.getFactory().getDao(zcfgDao.class);
		zd.delete(id);
	}

	@Override
	public List<zcfg> getTop() throws Exception {
		zcfgDao zd = BasicFactory.getFactory().getDao(zcfgDao.class);
		int topsize = Constant.TOPSIZE;
		return zd.getTop(topsize);
	}

	@Override
	public zcfgPagingBean search(zcfgPagingBean page) throws Exception {
		zcfgDao zd = BasicFactory.getFactory().getDao(zcfgDao.class);
		int totalCount = zd.countByKey(page);

		// 处理每页显示数据量
		int pageSize = page.getPageSize();
		if (pageSize == 0) {
			pageSize = Constant.KEY_ZCFGPAGESIZE;
			page.setPageSize(pageSize);
		}
		List<zcfg> list = zd.getByKey(page);
		page.setList(list);
		page.setTotalCount(totalCount);
		page.setTotalPage((int) Math.ceil(totalCount * 1.0 / pageSize));

		return page;

	}
/**
 * 增加
 */
	@Override
	public void addHits(int id) throws Exception {
		zcfgDao zd = BasicFactory.getFactory().getDao(zcfgDao.class);
		zd.addHits(id);
	}

}
