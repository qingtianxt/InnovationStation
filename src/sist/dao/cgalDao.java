package sist.dao;

import java.util.List;

import sist.bean.CgalPagingBean;
import sist.domain.cgal;

public interface cgalDao extends Dao {

	cgal getByMc(String mc) throws Exception ;

	void add(cgal c) throws Exception ;

	void delete(String mc)throws Exception;

	cgal getById(int id)throws Exception;

	void update(cgal c)throws Exception;

	int countByKey(CgalPagingBean page)throws Exception;

	List<cgal> getByKey(CgalPagingBean page)throws Exception;

}
