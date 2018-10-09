package sist.service;

import sist.bean.CgalPagingBean;
import sist.domain.cgal;

public interface cgalService extends Service {

	cgal getByMc(String mc)throws Exception;

	void add(cgal c)throws Exception;

	cgal getById(int id)throws Exception;

	void update(cgal c)throws Exception;

	CgalPagingBean search(CgalPagingBean page)throws Exception;
}
