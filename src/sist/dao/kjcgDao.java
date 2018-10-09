package sist.dao;

import java.util.List;

import sist.bean.kjcgPagingBean;
import sist.domain.kjcg;

public interface kjcgDao extends Dao {

	void add(kjcg k) throws Exception;

	int count(kjcgPagingBean page) throws Exception;

	List<kjcg> getByPage(kjcgPagingBean page)throws Exception;

	kjcg getByMc(String mc)throws Exception;

	void delete(String mc)throws Exception;

	kjcg getById(int id)throws Exception;

	void update(kjcg k)throws Exception;

	int countByUser(kjcgPagingBean page, String username)throws Exception;

	List<kjcg> getByPageAndUser(kjcgPagingBean page, String username)throws Exception;

	void addHits(int id)throws Exception;

	List<kjcg> getTop(int topsize)throws Exception;

	int countByKey(kjcgPagingBean page)throws Exception;

	List<kjcg> getByKey(kjcgPagingBean page)throws Exception;

	int getId(String mc)throws Exception;

}
