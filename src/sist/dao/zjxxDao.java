package sist.dao;

import java.util.List;

import sist.bean.frontZjxxPagingBean;
import sist.bean.zjxxPagingBean;
import sist.domain.zjxx;

public interface zjxxDao extends Dao {

	void add(zjxx z)throws Exception;

	int count(zjxxPagingBean page)throws Exception;

	List<zjxx> getList(zjxxPagingBean page)throws Exception;

	zjxx getById(int id)throws Exception;

	void update(zjxx z)throws Exception;

	void delete(int id)throws Exception;

	int frontCount(frontZjxxPagingBean page)throws Exception;

	List<zjxx> getFrontList(frontZjxxPagingBean page)throws Exception;

	void addHits(int id)throws Exception;

	int CountByUser(frontZjxxPagingBean page, String username)throws Exception;

	List<zjxx> getListByUser(frontZjxxPagingBean page, String username)throws Exception;

	List<zjxx> getTop(int topsize)throws Exception;

	int countByKey(zjxxPagingBean page)throws Exception;

	List<zjxx> getByKey(zjxxPagingBean page)throws Exception;

}
