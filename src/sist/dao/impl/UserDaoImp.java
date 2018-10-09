package sist.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import own.dome.sqlutils.SQLUtil;
import own.dome.sqlutils.SQLUtil.SQLFactory;
import sist.bean.UserPage;
import sist.dao.UserDao;
import sist.domain.UserBean;
import sist.utils.DataSourceUtils;

public class UserDaoImp implements UserDao {
	private String preSql = "username,pwd,qymc as name,qydz as address,lxfs as cellphone,yx as email,powerid as roleId,id";
	public UserDaoImp() {
		super();
	}

	@Override
	public UserBean getUserById(Integer id) {
		String sql = "select "+preSql+" from userinform where id=?";
		System.out.println(sql);
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		try {
			return runner.query(sql, new BeanHandler<>(UserBean.class),id);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	public boolean update(UserBean userBean) {
		SQLFactory factory = SQLUtil.getSQLFactory(userBean);
		String sql = factory.updatePreSql();
		Object[] params = factory.getParams();
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		try {
			int i = runner.update(sql,params);
			return i > 0;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	public boolean addUser(UserBean userBean) {
		SQLFactory factory = SQLUtil.getSQLFactory(userBean);
		String sql = factory.insertPreSql();
		Object[] params = factory.getParams();
//		System.out.println(sql);
//		System.out.println(Arrays.toString(params));
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		try {
			int i = runner.update(sql,params);
			return i > 0;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}


	@Override
	public UserBean getUser(String userBean) {
		String sql ="select "+preSql+" from userinform where username=?";
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		try {
			UserBean bean = runner.query(sql, new BeanHandler<>(UserBean.class),userBean);
			return bean;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<UserBean> getList(UserPage pagingBean) {
		String sql=null;
		if (pagingBean!=null) {
			int currentPage = pagingBean.getCurrentPage();
			int pageSize = pagingBean.getPageSize();
			sql = "select top " + (pageSize) + " " + preSql + " from userinform";
			StringBuffer sb = new StringBuffer();
			boolean isWhere = true;
			String name = pagingBean.geteName();// 企业名称
			if (name != null && !name.trim().isEmpty()) {
				if (isWhere) {
					sb.append(" where ");
					isWhere = false;
				} else {
					sb.append(" and ");
				}
				sb.append("qymc").append(" like '%").append(name).append("%'");
			}
			String username = pagingBean.getUsername();
			if (username != null && !username.trim().isEmpty()) {
				if (isWhere) {
					sb.append(" where ");
					isWhere = false;
				} else {
					sb.append(" and ");
				}
				sb.append("username").append(" like '%").append(username).append("%'");
			}
			Integer roleId = pagingBean.getRoleId();
			if (roleId != null) {
				if (isWhere) {
					sb.append(" where ");
					isWhere = false;
				} else {
					sb.append(" and ");
				}
				sb.append("powerId = '").append(roleId).append("'");
			}
			String subselect = sb.toString();
			if (isWhere) {
				sb.append(" where ");
				isWhere = false;
			} else {
				sb.append(" and ");
			}
			sb.append("id not in ( select top ").append(currentPage * pageSize - pageSize).append(" id from userinform")
					.append(subselect).append(" order by id asc) order by id asc");
			sb.insert(0, sql);
			sql = sb.toString();
		}else{
			sql = "select "+preSql+" from userinform";
		}
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		try {
			return runner.query(sql, new BeanListHandler<>(UserBean.class));
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	public int getCount(UserPage pagingBean) {
		StringBuffer sb = new StringBuffer();
		if(pagingBean!=null){
			boolean isWhere = true;
			String name = pagingBean.geteName();// 企业名称
			if (name != null && !name.trim().isEmpty()) {
				if (isWhere) {
					sb.append(" where ");
					isWhere = false;
				} else {
					sb.append(" and ");
				}
				sb.append("qymc").append(" like '%").append(name).append("%'");
			}
			String username = pagingBean.getUsername();
			if (username != null && !username.trim().isEmpty()) {
				if (isWhere) {
					sb.append(" where ");
					isWhere = false;
				} else {
					sb.append(" and ");
				}
				sb.append("username").append(" like '%").append(username).append("%'");
			}
			Integer roleId = pagingBean.getRoleId();
			if (roleId != null) {
				if (isWhere) {
					sb.append(" where ");
					isWhere = false;
				} else {
					sb.append(" and ");
				}
				sb.append("powerId = '").append(roleId).append("'");
			}
		}
		
		String sql = "select count(*) count from userinform"+sb;
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		try {
			Object scalar = runner.query(sql, new ScalarHandler());
			return Integer.valueOf(scalar.toString());
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	public boolean delById(Integer id) {
		String sql = "delete from userinform where id=?";
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		try {
			int i = runner.update(sql,id);
			return i > 0;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<UserBean> getByRoleId(int id) {
		String sql = "select "+preSql+" from userinform where powerid=?";
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		try {
			List<UserBean> list = runner.query(sql, new BeanListHandler<>(UserBean.class),id);
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
}
