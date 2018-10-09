package sist.dao;

import java.util.List;

import sist.domain.jstxxs;

public interface jstxxsDao extends Dao {

	List<jstxxs> getAll() throws Exception;
	
}
