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
	 * �������ƻ�ȡ�ɹ�������Ϣ
	 */
	@Override
	public cgal getByMc(String mc) throws Exception {

		cgalDao cd = BasicFactory.getFactory().getDao(cgalDao.class);

		return cd.getByMc(mc);
	}

	/**
	 * ��ӳɹ�����
	 */
	@Override
	public void add(cgal c) throws Exception {
		cgalDao cd = BasicFactory.getFactory().getDao(cgalDao.class);
		cd.add(c);
	}

	/**
	 * ͨ��id��ȡ�ɹ�������Ϣ
	 */
	@Override
	public cgal getById(int id) throws Exception {
		cgalDao cd = BasicFactory.getFactory().getDao(cgalDao.class);

		return cd.getById(id);
	}

	/**
	 * �޸ĳɹ�������Ϣ
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
		
		// ����ÿҳ��ʾ������
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
