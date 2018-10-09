package sist.dao.impl;

import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import sist.dao.jssslyDao;
import sist.domain.jsssly;
import sist.utils.DataSourceUtils;

public class jssslyDaoImpl implements jssslyDao {
	/**
	 * 获取技术所属领域的所有内容
	 */
	@Override
	public List<jsssly> getAll() throws Exception {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql ="select * from JSSSLY";
		return qr.query(sql, new BeanListHandler<>(jsssly.class));
	}

	@Override
	public jsssly getById(int id) throws Exception {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql ="select * from JSSSLY where lyid = ?";
		return qr.query(sql, new BeanHandler<>(jsssly.class),id);
	}
	
}
