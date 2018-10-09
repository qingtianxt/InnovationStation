package sist.service.impl;

import java.util.List;

import sist.bean.FwptPagingBean;
import sist.dao.FwptDao;
import sist.domain.Fwpt;
import sist.factory.BasicFactory;
import sist.service.FwptService;
import sist.utils.Constant;

public class FwptServiceImpl implements FwptService {

	@Override
	public List<Fwpt> getTop() throws Exception {
		FwptDao fd = BasicFactory.getFactory().getDao(FwptDao.class);
		int topsize = Constant.TOPSIZE;
		return fd.getTop(topsize);
	}

	@Override
	public FwptPagingBean search(FwptPagingBean page) throws Exception {
		FwptDao fd = BasicFactory.getFactory().getDao(FwptDao.class);
		int totalCount = fd.countByKey(page);

		// 处理每页显示数据量
		int pageSize = page.getPageSize();
		if (pageSize == 0) {
			pageSize = Constant.KJCG_KEY_PAGESIZE;
			page.setPageSize(pageSize);
		}
		List<Fwpt> list = fd.getByKey(page);
		page.setList(list);
		page.setTotalCount(totalCount);
		page.setTotalPage((int) Math.ceil(totalCount * 1.0 / pageSize));

		return page;

	}

	@Override
	public Fwpt getByKmAndMc(String km, String mc) throws Exception {
		FwptDao fd = BasicFactory.getFactory().getDao(FwptDao.class);
		
		return fd.getByKmAndMc(km,mc);
	}

	@Override
	public FwptPagingBean getList(FwptPagingBean page) throws Exception {
		FwptDao fd = BasicFactory.getFactory().getDao(FwptDao.class);
		int totalCount = fd.count(page);

		// 处理每页显示数据量
		int pageSize = page.getPageSize();
		if (pageSize == 0) {
			pageSize = Constant.FWPTPAGESIZE;
			page.setPageSize(pageSize);
		}
		List<Fwpt> list = fd.getList(page);
		page.setList(list);
		page.setTotalCount(totalCount);
		page.setTotalPage((int) Math.ceil(totalCount * 1.0 / pageSize));

		return page;

	}

}
