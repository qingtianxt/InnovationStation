package sist.service;

import java.util.List;

import sist.bean.PagingBean;
import sist.domain.Ztzlxxk;

public interface ZtzlxxkService extends Service {

	/**
	 * 根据关键字模糊查询
	 * @param page
	 * @return
	 */
	List<Ztzlxxk> search(PagingBean page);

}
