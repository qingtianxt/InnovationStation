package sist.service;

import sist.bean.PagingBean;
@Deprecated
public interface SearchService extends Service {

	/**
	 * È«¾ÖËÑË÷
	 * @param page
	 * @return
	 */
	Object search(PagingBean page);

}
