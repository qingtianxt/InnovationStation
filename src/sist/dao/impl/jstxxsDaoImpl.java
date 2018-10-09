package sist.dao.impl;

import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import sist.dao.jstxxsDao;
import sist.domain.jstxxs;
import sist.utils.DataSourceUtils;

public class jstxxsDaoImpl implements jstxxsDao {

	@Override
	public List<jstxxs> getAll() throws Exception {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql ="select * from jstxxs";
		return qr.query(sql, new BeanListHandler<>(jstxxs.class));
	}
	
}
