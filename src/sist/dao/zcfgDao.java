package sist.dao;

import java.util.List;

import sist.bean.zcfgPagingBean;
import sist.domain.zcfg;

public interface zcfgDao extends Dao {

	zcfg getByMc(String zcmc)throws Exception;

	void add(zcfg z)throws Exception;

	int count(zcfgPagingBean page)throws Exception;

	List<zcfg> getList(zcfgPagingBean page)throws Exception;

	zcfg getById(int id)throws Exception;

	void update(zcfg z)throws Exception;

	void delete(int id)throws Exception;

	List<zcfg> getTop(int topsize)throws Exception;

	int countByKey(zcfgPagingBean page)throws Exception;

	List<zcfg> getByKey(zcfgPagingBean page)throws Exception;

	void addHits(int id)throws Exception;
	
}
