package sist.dao;

import java.util.List;

import sist.bean.PagingBean;
import sist.domain.Ztzlxxk;

public interface ZtzlxxkDao extends Dao {

	List<Ztzlxxk> search(PagingBean page);

	Integer searchCount(PagingBean page);

}
