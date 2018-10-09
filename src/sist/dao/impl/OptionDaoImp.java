package sist.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import sist.dao.OptionDao;
import sist.utils.DataSourceUtils;

public class OptionDaoImp implements OptionDao {

	/* (non-Javadoc)
	 * @see sist.dao.OptionDao#getJslbList()
	 */
	@Override
	public List<Object[]> getJslbList() {
		String sql = "select * from ssgxjslb order by jslbid asc";
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		try {
			List<Object[]> list = runner.query(sql, new ArrayListHandler());
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	/* (non-Javadoc)
	 * @see sist.dao.OptionDao#getJstxxsList()
	 */
	@Override
	public List<Object[]> getJstxxsList() {
		String sql = "select * from jstxxs order by jstxxsid asc";
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		try {
			List<Object[]> list = runner.query(sql, new ArrayListHandler());
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	public String getByIdOrName(Object idOrName) {
		String sql = null;
		if(idOrName.toString().matches("[0-9]+"))
			sql = "select jstxxsmc from jstxxs where jstxxsid=?";
		else
			return idOrName.toString();
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		try {
			Object object = runner.query(sql, new ScalarHandler(), idOrName);
			return object.toString();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

}
