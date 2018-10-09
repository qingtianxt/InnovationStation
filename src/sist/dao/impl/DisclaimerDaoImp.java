package sist.dao.impl;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import own.dome.sqlutils.SQLUtil;
import own.dome.sqlutils.SQLUtil.SQLFactory;
import sist.dao.DisclaimerDao;
import sist.domain.Disclaimer;
import sist.utils.DataSourceUtils;

public class DisclaimerDaoImp implements DisclaimerDao {
	private String items = " mzsmid as id , mzsmcontent as content , time as time , publisher as publisher ";
	@Override
	public Integer getMaxId() {
		String sql = "select MAX(MZSMID) max from MZSM";
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		try {
			Object object = runner.query(sql, new ScalarHandler());
			
			return Integer.valueOf(object.toString());
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} 
	}

	@Override
	public boolean add(Disclaimer disclaimer) {
		SQLFactory factory = SQLUtil.getSQLFactory(disclaimer);
		String sql = factory.insertPreSql();
		Object[] params = factory.getParams();
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		try {
			int i = runner.update(sql, params);
			return i > 0;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	public Disclaimer getById(Integer id) {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		try {
			Disclaimer disc = runner.query("select"+items+"from mzsm where id=?", new BeanHandler<>(Disclaimer.class),id);
			return disc;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	public boolean update(Disclaimer disclaimer) {
		SQLFactory factory = SQLUtil.getSQLFactory(disclaimer);
		String sql = factory.updatePreSql();
		Object[] params = factory.getParams();
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		try {
			int i = runner.update(sql, params);
			return i > 0;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

}
