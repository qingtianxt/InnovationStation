package sist.service.impl;

import java.util.List;

import sist.bean.kjcgPagingBean;
import sist.dao.cgalDao;
import sist.dao.cgzhxmDao;
import sist.dao.kjcgDao;
import sist.domain.kjcg;
import sist.factory.BasicFactory;
import sist.service.kjcgService;
import sist.utils.Constant;
import sist.utils.StringUtil;

public class kjcgServiceImpl implements kjcgService {

	@Override
	public void add(kjcg k) throws Exception {
		kjcgDao kd = BasicFactory.getFactory().getDao(kjcgDao.class);
		kd.add(k);
	}

	/**
	 * 分页获取科技成果信息
	 */
	@Override
	public kjcgPagingBean getList(kjcgPagingBean page) throws Exception {
		kjcgDao kd = BasicFactory.getFactory().getDao(kjcgDao.class);

		int totalCount = kd.count(page);
		// 处理每页显示数据量
		int pageSize = page.getPageSize();
		if (pageSize == 0) {
			pageSize = Constant.KJCGPAGESIZE;
			page.setPageSize(pageSize);
		}

		List<kjcg> list = kd.getByPage(page);
		page.setList(list);
		page.setTotalCount(totalCount);
		page.setTotalPage((int) Math.ceil(totalCount * 1.0 / pageSize));
		return page;
	}

	/**
	 * 根据id删除科技成果信息，根据查询出来的名称删除成功案例或者成果转化项目内的内容
	 */
	@Override
	public void delete(String id) throws Exception {
		kjcgDao kd = BasicFactory.getFactory().getDao(kjcgDao.class);
		kjcg k = kd.getById(StringUtil.StringToInt(id));
		if ("成果转化项目".equals(k.getKm())) {
			cgzhxmDao cd = BasicFactory.getFactory().getDao(cgzhxmDao.class);
			cd.delete(k.getMc());
		} else if ("成功案例".equals(k.getKm())) {
			cgalDao cda = BasicFactory.getFactory().getDao(cgalDao.class);
			cda.delete(k.getMc());
		}
		kd.delete(id);
	}

	/**
	 * 通过id获取科技成果信息
	 */
	@Override
	public kjcg getById(int id) throws Exception {
		kjcgDao kd = BasicFactory.getFactory().getDao(kjcgDao.class);
		return kd.getById(id);
	}

	@Override
	public void update(kjcg k) throws Exception {
		kjcgDao kd = BasicFactory.getFactory().getDao(kjcgDao.class);
		kd.update(k);
	}

	/**
	 * 通过名称获取科技成果信息
	 */
	@Override
	public kjcg getByMc(String mc) throws Exception {
		kjcgDao kd = BasicFactory.getFactory().getDao(kjcgDao.class);
		return kd.getByMc(mc);
	}

	@Override
	public kjcgPagingBean getListByUser(kjcgPagingBean page, String username) throws Exception {
		kjcgDao kd = BasicFactory.getFactory().getDao(kjcgDao.class);

		int totalCount = kd.countByUser(page,username);
		// 处理每页显示数据量
		int pageSize = page.getPageSize();
		if (pageSize == 0) {
			pageSize = Constant.KJCGPAGESIZE;
			page.setPageSize(pageSize);
		}

		List<kjcg> list = kd.getByPageAndUser(page,username);
		page.setList(list);
		page.setTotalCount(totalCount);
		page.setTotalPage((int) Math.ceil(totalCount * 1.0 / pageSize));
		return page;
	}

	@Override
	public void addHits(int id) throws Exception {
		kjcgDao kd = BasicFactory.getFactory().getDao(kjcgDao.class);
		kd.addHits(id);
	}

	@Override
	public List<kjcg> getTop() throws Exception {
		kjcgDao kd = BasicFactory.getFactory().getDao(kjcgDao.class);
		int topsize = Constant.TOPSIZE;
		return kd.getTop(topsize);
	}

	@Override
	public kjcgPagingBean search(kjcgPagingBean page) throws Exception {

		kjcgDao kd = BasicFactory.getFactory().getDao(kjcgDao.class);
		int totalCount = kd.countByKey(page);
		
		// 处理每页显示数据量
		int pageSize = page.getPageSize();
		if (pageSize == 0) {
			pageSize = Constant.KJCG_KEY_PAGESIZE;
			page.setPageSize(pageSize);
		}
		List<kjcg> list =kd.getByKey(page);
		page.setList(list);
		page.setTotalCount(totalCount);
		page.setTotalPage((int) Math.ceil(totalCount * 1.0 / pageSize));
		
		return page;
	
	}

}
