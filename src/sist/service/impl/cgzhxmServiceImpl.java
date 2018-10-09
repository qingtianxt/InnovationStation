package sist.service.impl;

import sist.dao.cgzhxmDao;
import sist.domain.cgzhxm;
import sist.factory.BasicFactory;
import sist.service.cgzhxmService;

public class cgzhxmServiceImpl implements cgzhxmService {
/**
 * �������ƻ�ȡ�ɹ�ת����Ŀ����
 */
	@Override
	public cgzhxm getByMc(String mc) throws Exception {
		cgzhxmDao cd = BasicFactory.getFactory().getDao(cgzhxmDao.class);
		return cd.getByMc(mc);
	}
/**
 * ��Ƽ��ɹ���ͳɹ�ת����Ŀ���в�������
 */
	@Override
	public void add(cgzhxm c) throws Exception {
		cgzhxmDao cd = BasicFactory.getFactory().getDao(cgzhxmDao.class);
		cd.add(c);
	}
	/**
	 * ����id��ȡ�ɹ�ת����Ŀ��Ϣ
	 */
	@Override
	public cgzhxm getById(int id) throws Exception {
		cgzhxmDao cd = BasicFactory.getFactory().getDao(cgzhxmDao.class);
		return cd.getById(id);
	}
	/**
	 * �޸ĳɹ�ת����Ŀ��Ϣ
	 */
	@Override
	public void update(cgzhxm  c) throws Exception {
		cgzhxmDao cd = BasicFactory.getFactory().getDao(cgzhxmDao.class);
		cd.update(c);
	}
	
}
