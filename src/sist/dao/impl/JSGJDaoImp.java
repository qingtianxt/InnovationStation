// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   JSGJDaoImp.java

package sist.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import sist.bean.PagingBean;
import sist.bean.SupplyPagingBean;
import sist.bean.TeachSearchPage;
import sist.dao.JSGJDao;
import sist.domain.JSGJBean;
import sist.utils.DataSourceUtils;
import sist.utils.SQLUtil;

public class JSGJDaoImp implements JSGJDao {

	public JSGJDaoImp() {
	}

	public JSGJBean findById(Integer id) {
		String sql = "select * from JSGJK where id=?";
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		try {
			JSGJBean bean = runner.query(sql, new BeanHandler<>(JSGJBean.class), new Object[] { id });
			return bean;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public boolean add(JSGJBean bean) {
		sist.utils.SQLUtil.SQLFactory factory = SQLUtil.getSQLFactory("jsgjk", bean, new String[] { "id" });
		String insertSql = factory.insertSql();
		Object params[] = factory.getParams();
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		try {
			int i = runner.update(insertSql, params);
			return i > 0;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public boolean update(JSGJBean bean) {
		sist.utils.SQLUtil.SQLFactory factory = SQLUtil.getSQLFactory("jsgjk", bean, new String[] { "id" });
		String updateSql = factory.updateSql();
		Object params[] = factory.getParams();
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		try {
			int i = runner.update(updateSql, params);
			return i > 0;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public List<JSGJBean> getList(PagingBean p) {
		// 如果pagebean是null,直接查询所有内容
		if (p == null) {
			QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
			try {
				List<JSGJBean> list = runner.query("select * from JSGJK", new BeanListHandler<>(JSGJBean.class));
				return list;
			} catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			}
		}
		SupplyPagingBean pagingBean = (SupplyPagingBean) p;
		StringBuffer sb = new StringBuffer();
		String category = pagingBean.getCategory();
		if (category != null && !category.trim().isEmpty())
			sb.append("and jslb='").append(category).append("'");
		String techName = pagingBean.getTechName();
		if (techName != null && !techName.trim().isEmpty())
			sb.append(" and mc like '%").append(techName).append("%'");
		String keyWord = pagingBean.getKeyWord();
		if (keyWord != null && !keyWord.trim().isEmpty())
			sb.append(" and gjc like '%").append(keyWord).append("%'");
		String startTime = pagingBean.getStartTime();
		if (startTime != null && !startTime.trim().isEmpty())
			sb.append(" and time > '").append(startTime).append("'");
		String endTime = pagingBean.getEndTime();
		if (endTime != null && !endTime.trim().isEmpty())
			sb.append(" and time < '").append(endTime).append("'");
		String status = pagingBean.getStatus();
		if (status != null && !status.trim().isEmpty())
			sb.append(" and ").append(status);
		int and = sb.indexOf("and");
		if (and > -1)
			sb.delete(and, and + 3);
		if (!sb.toString().trim().isEmpty())
			sb.insert(0, " where ");
		StringBuffer order = new StringBuffer();
		String orderBy = pagingBean.getOrderBy();
		String sortBy = pagingBean.getSortBy();
		if (orderBy != null && sortBy != null && !orderBy.trim().isEmpty() && !sortBy.trim().isEmpty()) {
			order.append(orderBy).append(" ").append(sortBy).append(" , id asc");
		} else
			order.append(" id asc");
		String sql = (new StringBuilder("select top ")).append(pagingBean.getPageSize()).append(" * from JSGJK ")
				.append(sb).append(sb.toString().isEmpty() ? "where" : "and").append(" id not in (select top ")
				.append((pagingBean.getCurrentPage() - 1) * pagingBean.getPageSize()).append(" id from JSGJK ")
				.append(sb).append(" order by ").append(order).append(") order by ").append(order).toString();
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		try {
			return runner.query(sql, new BeanListHandler<>(JSGJBean.class));
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public int getCount(PagingBean p) {
		SupplyPagingBean pagingBean = (SupplyPagingBean) p;
		String sql;
		StringBuffer sb = new StringBuffer();
		if (pagingBean != null) {
			String category = pagingBean.getCategory();
			if (category != null && !category.trim().isEmpty())
				sb.append("and jslb='").append(category).append("'");
			String techName = pagingBean.getTechName();
			if (techName != null && !techName.trim().isEmpty())
				sb.append(" and mc like '%").append(techName).append("%'");
			String keyWord = pagingBean.getKeyWord();
			if (keyWord != null && !keyWord.trim().isEmpty())
				sb.append(" and gjc like '%").append(keyWord).append("%'");
			String startTime = pagingBean.getStartTime();
			if (startTime != null && !startTime.trim().isEmpty())
				sb.append(" and time > '").append(startTime).append("'");
			String endTime = pagingBean.getEndTime();
			if (endTime != null && !endTime.trim().isEmpty())
				sb.append(" and time < '").append(endTime).append("'");
			String status = pagingBean.getStatus();
			if (status != null && !status.trim().isEmpty())
				sb.append(" and ").append(status);
			int and = sb.indexOf("and");
			if (and > -1)
				sb.delete(and, and + 3);
			if (!sb.toString().trim().isEmpty())
				sb.insert(0, " where ");
			sql = (new StringBuilder("select count(*) from JSGJK ")).append(sb).toString();
		} else {
			sql = "select count(*) from jsgjk";
		}
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		try {
			Integer count = Integer.valueOf(Integer.parseInt(runner.query(sql, new ScalarHandler(1)).toString()));
			return count.intValue();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public boolean delById(int id) {
		String sql = "delete from jsgjk where id = ?";
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		try {
			int i = runner.update(sql, Integer.valueOf(id));
			return i > 0;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public List<JSGJBean> search(PagingBean keys) {
		String sql = null;
		StringBuffer sb = new StringBuffer();
		TeachSearchPage page = (TeachSearchPage) keys;
		if (page != null) {
			String like = getLike(page.getKey());
			sb.append("cgsx like '").append(like).append("' ");
			sb.append("or dw like '").append(like).append("' ");
			sb.append("or mc like '").append(like).append("' ");
			sb.append("or gjc like '").append(like).append("' ");
			sb.append("or gbnr like '").append(like).append("' ");
			sql = (new StringBuilder("select top ")).append(keys.getPageSize()).append(" * from jsgjk where (")
					.append(sb.toString().isEmpty() ? "1=1" : ((Object) (sb))).append(") and id not in ( select top ")
					.append(keys.getCurrentPage() * keys.getPageSize() - keys.getPageSize())
					.append(" id from jsgjk where ").append(sb.toString().isEmpty() ? "1=1" : ((Object) (sb)))
					.append(" order by time desc,id asc ) order by time desc,id asc").toString();
		} else {
			sql = "select * from jsgjk";
		}
		System.err.println(sql);
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		try {
			List<JSGJBean> query = runner.query(sql, new BeanListHandler<>(JSGJBean.class));
			return query;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public Integer searchCount(PagingBean keys) {
		String sql = null;
		StringBuffer sb = new StringBuffer();
		TeachSearchPage page = (TeachSearchPage) keys;
		if (page != null) {
			String like = getLike(page.getKey());
			sb.append("cgsx like '").append(like).append("' ");
			sb.append("or dw like '").append(like).append("' ");
			sb.append("or mc like '").append(like).append("' ");
			sb.append("or gjc like '").append(like).append("' ");
			sb.append("or gbnr like '").append(like).append("' ");
			sql = (new StringBuilder("select count(*) as count from jsgjk where "))
					.append(sb.toString().isEmpty() ? "1=1" : ((Object) (sb))).toString();
		} else {
			sql = "select count(*) as count from jsgjk";
		}
		System.err.println(sql);
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		try {
			Object object = runner.query(sql, new ScalarHandler());
			Integer integer = Integer.valueOf(object.toString());
			return integer;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	private String getLike(String keys) {
		if (keys != null) {
			char array[] = keys.toCharArray();
			StringBuffer sb = new StringBuffer("%");
			char ac[];
			int j = (ac = array).length;
			for (int i = 0; i < j; i++) {
				char c = ac[i];
				sb.append(c).append("%");
			}

			return sb.toString();
		} else {
			return null;
		}
	}

	@Override
	public JSGJBean getByName(String name) {
		String sql = "select * from jsgjk where mc=?";
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		try {
			JSGJBean bean = runner.query(sql, new BeanHandler<>(JSGJBean.class), name);
			return bean;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

}
