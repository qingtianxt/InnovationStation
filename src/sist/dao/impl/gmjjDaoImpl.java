package sist.dao.impl;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import sist.dao.gmjjDao;
import sist.domain.gmjj;
import sist.utils.DataSourceUtils;

public class gmjjDaoImpl implements gmjjDao {

	@Override
	public gmjj getByCode(String yyhy) throws Exception {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from gmjj where code=?";
		return qr.query(sql, new BeanHandler<>(gmjj.class),yyhy);
	}

}
