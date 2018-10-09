package sist.dao;

import sist.domain.cgzhxm;

public interface cgzhxmDao extends Dao {

	cgzhxm getByMc(String mc)throws Exception;

	void add(cgzhxm c)throws Exception;

	void delete(String mc)throws Exception;

	cgzhxm getById(int id)throws Exception;

	void update(cgzhxm c)throws Exception;


}
