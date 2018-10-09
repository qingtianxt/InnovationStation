package sist.service.impl;

import sist.dao.cgzhxmDao;
import sist.domain.cgzhxm;
import sist.factory.BasicFactory;
import sist.service.cgzhxmService;

public class cgzhxmServiceImpl implements cgzhxmService {
/**
 * 根据名称获取成果转化项目内容
 */
	@Override
	public cgzhxm getByMc(String mc) throws Exception {
		cgzhxmDao cd = BasicFactory.getFactory().getDao(cgzhxmDao.class);
		return cd.getByMc(mc);
	}
/**
 * 向科技成果表和成果转化项目表中插入内容
 */
	@Override
	public void add(cgzhxm c) throws Exception {
		cgzhxmDao cd = BasicFactory.getFactory().getDao(cgzhxmDao.class);
		cd.add(c);
	}
	/**
	 * 根据id获取成果转化项目信息
	 */
	@Override
	public cgzhxm getById(int id) throws Exception {
		cgzhxmDao cd = BasicFactory.getFactory().getDao(cgzhxmDao.class);
		return cd.getById(id);
	}
	/**
	 * 修改成果转化项目信息
	 */
	@Override
	public void update(cgzhxm  c) throws Exception {
		cgzhxmDao cd = BasicFactory.getFactory().getDao(cgzhxmDao.class);
		cd.update(c);
	}
	
}
