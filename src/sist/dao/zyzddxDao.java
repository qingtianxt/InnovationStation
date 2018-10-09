package sist.dao;

import java.util.List;

import sist.domain.zyzddx;

public interface zyzddxDao extends Dao {

	List<zyzddx> getAll() throws Exception;
	
}
