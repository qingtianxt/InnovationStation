package sist.dao.impl;

import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import sist.dao.zyzddxDao;
import sist.domain.zyzddx;
import sist.utils.DataSourceUtils;

public class zyzddxDaoImpl implements zyzddxDao {

	@Override
	public List<zyzddx> getAll() throws Exception {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from ZYZDDX";
		return qr.query(sql, new BeanListHandler<>(zyzddx.class));
	}
	
}
