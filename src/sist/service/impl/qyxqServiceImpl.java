package sist.service.impl;

import java.util.List;

import sist.bean.qyxqPagingBean;
import sist.dao.qyxqDao;
import sist.domain.jsxq;
import sist.factory.BasicFactory;
import sist.service.qyxqService;
import sist.utils.Constant;

public class qyxqServiceImpl implements qyxqService {

	@Override
	public void add(jsxq j) throws Exception {
		qyxqDao dao = BasicFactory.getFactory().getDao(qyxqDao.class);
		dao.add(j);
	}

	/**
	 * ��������Ƿ�ռ��
	 */
	@Override
	public jsxq checkMc(String jsxqmc) throws Exception {
		qyxqDao dao = BasicFactory.getFactory().getDao(qyxqDao.class);
		return dao.checkMc(jsxqmc);
	}

	/**
	 * ��ҳ��ȡ��˺ͱ��˻ص���Ϣ
	 */
	@Override
	public qyxqPagingBean getShList(qyxqPagingBean page) throws Exception {
		qyxqDao qd = BasicFactory.getFactory().getDao(qyxqDao.class);
		int totalCount = qd.countSh(page);
		// ����ÿҳ��ʾ������
		int pageSize = page.getPageSize();
		if (pageSize == 0) {
			pageSize = 10;
			page.setPageSize(10);
		}
		List<jsxq> list = qd.getShList(page);
		page.setList(list);
		page.setTotalCount(totalCount);
		page.setTotalPage((int) Math.ceil(totalCount * 1.0 / pageSize));
		return page;
	}

	@Override
	public qyxqPagingBean getGlList(qyxqPagingBean page) throws Exception {
		qyxqDao qd = BasicFactory.getFactory().getDao(qyxqDao.class);
		int totalCount = qd.countGl(page);
		// ����ÿҳ��ʾ������
		int pageSize = page.getPageSize();
		if (pageSize == 0) {
			pageSize = Constant.QYXQ_SH_PAGESIZE;
			page.setPageSize(pageSize);
		}

		List<jsxq> list = qd.getGlList(page);
		page.setList(list);
		page.setTotalCount(totalCount);
		page.setTotalPage((int) Math.ceil(totalCount * 1.0 / pageSize));
		return page;
	}

	@Override
	public jsxq getInfo(int id) throws Exception {
		qyxqDao qd = BasicFactory.getFactory().getDao(qyxqDao.class);

		return qd.getById(id);
	}

	/**
	 * �޸��������Ϣ
	 */
	@Override
	public void update(jsxq j) throws Exception {
		qyxqDao qd = BasicFactory.getFactory().getDao(qyxqDao.class);
		qd.update(j);
	}

	@Override
	public void deleteById(int id) throws Exception {
		qyxqDao qd = BasicFactory.getFactory().getDao(qyxqDao.class);
		qd.deleteById(id);
	}

	/**
	 * ����id��ȡ������Ϣ
	 */
	@Override
	public jsxq getById(int id) throws Exception {
		qyxqDao qd = BasicFactory.getFactory().getDao(qyxqDao.class);
		return qd.getById(id);
	}

	/**
	 * ǰ̨�鿴������Ϣʱ���������1
	 */
	@Override
	public void addHits(int id) throws Exception {
		qyxqDao qd = BasicFactory.getFactory().getDao(qyxqDao.class);
		qd.addHits(id);
	}

	@Override
	public qyxqPagingBean getListByUser(qyxqPagingBean page, String username) throws Exception {
		qyxqDao qd = BasicFactory.getFactory().getDao(qyxqDao.class);
		int totalCount = qd.countByUser(page, username);
		// ����ÿҳ��ʾ������
		int pageSize = page.getPageSize();
		if (pageSize == 0) {
			pageSize = Constant.QYXQ_SH_PAGESIZE;
			page.setPageSize(pageSize);
		}

		List<jsxq> list = qd.getListByUser(page, username);
		page.setList(list);
		page.setTotalCount(totalCount);
		page.setTotalPage((int) Math.ceil(totalCount * 1.0 / pageSize));
		return page;
	}

	@Override
	public List<jsxq> getTop() throws Exception {
		qyxqDao qd = BasicFactory.getFactory().getDao(qyxqDao.class);
		int topSize = Constant.TOPSIZE;
		return qd.getTop(topSize);
	}

	@Override
	public qyxqPagingBean search(qyxqPagingBean page) throws Exception {
		qyxqDao qd = BasicFactory.getFactory().getDao(qyxqDao.class);
		int totalCount = qd.countByKey(page);
		
		// ����ÿҳ��ʾ������
		int pageSize = page.getPageSize();
		if (pageSize == 0) {
			pageSize = Constant.QYXQ_KEY_PAGESIZE;
			page.setPageSize(pageSize);
		}
		List<jsxq> list =qd.getByKey(page);
		page.setList(list);
		page.setTotalCount(totalCount);
		page.setTotalPage((int) Math.ceil(totalCount * 1.0 / pageSize));
		
		return page;
	}

}
