package sist.service.impl;

import java.util.List;

import sist.bean.CgalPagingBean;
import sist.dao.cgalDao;
import sist.domain.cgal;
import sist.factory.BasicFactory;
import sist.service.cgalService;
import sist.utils.Constant;

public class cgalServiceImpl implements cgalService {
	/**
	 * 根据名称获取成果案例信息
	 */
	@Override
	public cgal getByMc(String mc) throws Exception {

		cgalDao cd = BasicFactory.getFactory().getDao(cgalDao.class);

		return cd.getByMc(mc);
	}

	/**
	 * 添加成功案例
	 */
	@Override
	public void add(cgal c) throws Exception {
		cgalDao cd = BasicFactory.getFactory().getDao(cgalDao.class);
		cd.add(c);
	}

	/**
	 * 通过id获取成功案例信息
	 */
	@Override
	public cgal getById(int id) throws Exception {
		cgalDao cd = BasicFactory.getFactory().getDao(cgalDao.class);

		return cd.getById(id);
	}

	/**
	 * 修改成功案例信息
	 */
	@Override
	public void update(cgal c) throws Exception {
		cgalDao cd = BasicFactory.getFactory().getDao(cgalDao.class);
		cd.update(c);
	}

	@Override
	public CgalPagingBean search(CgalPagingBean page) throws Exception {


		cgalDao kd = BasicFactory.getFactory().getDao(cgalDao.class);
		int totalCount = kd.countByKey(page);
		
		// 处理每页显示数据量
		int pageSize = page.getPageSize();
		if (pageSize == 0) {
			pageSize = Constant.CGAL_KEY_PAGESIZE;
			page.setPageSize(pageSize);
		}
		List<cgal> list =kd.getByKey(page);
		page.setList(list);
		page.setTotalCount(totalCount);
		page.setTotalPage((int) Math.ceil(totalCount * 1.0 / pageSize));
		
		return page;
	
	
	}

	
}
