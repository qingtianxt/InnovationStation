package sist.service;

import java.util.List;

import sist.bean.PagingBean;
import sist.domain.Ztzlxxk;

public interface ZtzlxxkService extends Service {

	/**
	 * ���ݹؼ���ģ����ѯ
	 * @param page
	 * @return
	 */
	List<Ztzlxxk> search(PagingBean page);

}
