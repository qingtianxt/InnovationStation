package sist.service;

import sist.bean.PagingBean;
@Deprecated
public interface SearchService extends Service {

	/**
	 * ȫ������
	 * @param page
	 * @return
	 */
	Object search(PagingBean page);

}
