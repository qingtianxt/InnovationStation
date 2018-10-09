package sist.service;

import java.util.List;

import sist.bean.frontZjxxPagingBean;
import sist.bean.zjxxPagingBean;
import sist.domain.zjxx;

public interface zjxxService extends Service {

	void add(zjxx z)throws Exception;

	zjxxPagingBean getList(zjxxPagingBean page)throws Exception;

	zjxx getById(int id)throws Exception;

	void update(zjxx z)throws Exception;

	void delete(int id)throws Exception;

	frontZjxxPagingBean getFrontList(frontZjxxPagingBean page)throws Exception;

	void addHits(int id)throws Exception;

	frontZjxxPagingBean getListByUser(frontZjxxPagingBean page, String username)throws Exception;

	List<zjxx> getTop()throws Exception;

	zjxxPagingBean search(zjxxPagingBean page)throws Exception;

}
