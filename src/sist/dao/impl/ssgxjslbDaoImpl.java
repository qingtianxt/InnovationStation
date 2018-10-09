package sist.dao.impl;

import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import sist.dao.ssgxjslbDao;
import sist.domain.ssgxjslb;
import sist.utils.DataSourceUtils;

public class ssgxjslbDaoImpl implements ssgxjslbDao {
	/**
	 * 获取所有的高新技术类别
	 */
	@Override
	public List<ssgxjslb> getAll() throws Exception {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from SSGXJSLB";
		return qr.query(sql, new BeanListHandler<>(ssgxjslb.class));
	}

}
