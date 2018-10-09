package sist.service;

import java.util.List;

import sist.bean.zcfgPagingBean;
import sist.domain.zcfg;

public interface zcfgService extends Service {

	zcfg getByMc(String zcmc)throws Exception;

	void add(zcfg z)throws Exception;

	zcfgPagingBean getList(zcfgPagingBean page)throws Exception;

	zcfg getById(int id)throws Exception;

	void update(zcfg z)throws Exception;

	void delete(int id)throws Exception;

	List<zcfg> getTop()throws Exception;

	zcfgPagingBean search(zcfgPagingBean page)throws Exception;

	void addHits(int id)throws Exception;
	
}
