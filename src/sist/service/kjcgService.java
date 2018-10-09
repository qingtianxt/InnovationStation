package sist.service;

import java.util.List;

import sist.bean.kjcgPagingBean;
import sist.domain.kjcg;

public interface kjcgService extends Service {

	void add(kjcg k)throws Exception;

	kjcgPagingBean getList(kjcgPagingBean page)throws Exception;

	void delete(String mc)throws Exception;

	kjcg getById(int id)throws Exception;

	void update(kjcg k)throws Exception;

	kjcg getByMc(String mc)throws Exception;

	kjcgPagingBean getListByUser(kjcgPagingBean page, String username)throws Exception;

	void addHits(int id)throws Exception;

	List<kjcg> getTop()throws Exception;

	kjcgPagingBean search(kjcgPagingBean page)throws Exception;
	
}
