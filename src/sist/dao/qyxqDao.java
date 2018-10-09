package sist.dao;

import java.util.List;

import sist.bean.qyxqPagingBean;
import sist.domain.jsxq;

public interface qyxqDao extends Dao {

	void add(jsxq j) throws Exception;

	jsxq checkMc(String jsxqmc)throws Exception;

	List<jsxq> getShList(qyxqPagingBean page)throws Exception;

	int countSh(qyxqPagingBean page)throws Exception;

	int countGl(qyxqPagingBean page)throws Exception;

	List<jsxq> getGlList(qyxqPagingBean page)throws Exception;

	jsxq getById(int id)throws Exception;

	void update(jsxq j)throws Exception;

	void deleteById(int id)throws Exception;

	void addHits(int id)throws Exception;

	List<jsxq> getListByUser(qyxqPagingBean page, String username)throws Exception;

	int countByUser(qyxqPagingBean page, String username)throws Exception;

	List<jsxq> getTop(int topSize)throws Exception;

	int countByKey(qyxqPagingBean page)throws Exception;

	List<jsxq> getByKey(qyxqPagingBean page)throws Exception;
	
}
