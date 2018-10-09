package sist.dao;

import java.util.List;

import sist.domain.jsssly;

public interface jssslyDao  extends Dao{

	List<jsssly> getAll() throws Exception;

	jsssly getById(int id)throws Exception;
	
}
