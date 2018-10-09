package sist.dao;

import sist.domain.gmjj;

public interface gmjjDao extends Dao {

	gmjj getByCode(String yyhy) throws Exception;

}
