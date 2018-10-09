package sist.service;

import java.util.List;

import sist.bean.qyxqPagingBean;
import sist.domain.jsxq;

public interface qyxqService extends Service{

	void add(jsxq j) throws Exception;

	jsxq checkMc(String jsxqmc) throws Exception;

	qyxqPagingBean getShList(qyxqPagingBean page)throws Exception;

	qyxqPagingBean getGlList(qyxqPagingBean page)throws Exception;

	jsxq getInfo(int id)throws Exception;

	void update(jsxq j)throws Exception;

	void deleteById(int id)throws Exception;

	jsxq getById(int id)throws Exception;

	void addHits(int id)throws Exception;

	qyxqPagingBean getListByUser(qyxqPagingBean page, String username)throws Exception;

	List<jsxq> getTop()throws Exception;

	qyxqPagingBean search(qyxqPagingBean page)throws Exception;
	
}
