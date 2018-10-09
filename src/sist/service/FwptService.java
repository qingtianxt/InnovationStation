package sist.service;

import java.util.List;

import sist.bean.FwptPagingBean;
import sist.domain.Fwpt;

public interface FwptService extends Service {

	List<Fwpt> getTop() throws Exception;

	FwptPagingBean search(FwptPagingBean page)throws Exception;

	Fwpt getByKmAndMc(String km, String mc)throws Exception;

	FwptPagingBean getList(FwptPagingBean page)throws Exception;

}
