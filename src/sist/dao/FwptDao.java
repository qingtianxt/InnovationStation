package sist.dao;

import java.util.List;

import sist.bean.FwptPagingBean;
import sist.domain.Fwpt;

public interface FwptDao extends Dao {

	List<Fwpt> getTop(int topsize)throws Exception ;

	int countByKey(FwptPagingBean page)throws Exception;

	List<Fwpt> getByKey(FwptPagingBean page)throws Exception;

	Fwpt getByKmAndMc(String km, String mc)throws Exception;

	int count(FwptPagingBean page)throws Exception;

	List<Fwpt> getList(FwptPagingBean page)throws Exception;

}
