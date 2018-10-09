package sist.service;

import sist.domain.cgzhxm;

public interface cgzhxmService extends Service {

	cgzhxm getByMc(String mc) throws Exception;

	void add(cgzhxm c)throws Exception;

	cgzhxm getById(int id)throws Exception;

	void update(cgzhxm c)throws Exception;
	
}
