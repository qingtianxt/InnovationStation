package sist.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import own.dome.sqlutils.SQLUtil;
import own.dome.sqlutils.SQLUtil.SQLFactory;
import sist.bean.RolePage;
import sist.bean.RolePagingBean;
import sist.bean.UserPage;
import sist.dao.RoleDao;
import sist.dao.UserDao;
import sist.domain.Role;
import sist.domain.UserBean;
import sist.utils.DataSourceUtils;

public class RoleDaoImp implements RoleDao {

	private static HashMap<String,String> map;
	static{
		map = new HashMap<>();
		map.put("PowerId", "id");
		map.put("PowerName", "roleName");
		map.put("Power", "power");
	}
	@Override
	public Role getById(Integer roleId) {
		String sql = "select "+sqlutil(map)+" from POWER where PowerId=?";
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		try {
			return runner.query(sql, new BeanHandler<>(Role.class), roleId);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	private String sqlutil(Map<String,String> map){
		StringBuffer sb  = new StringBuffer();
		Set<Entry<String,String>> entrySet = map.entrySet();
		for (Entry<String, String> entry : entrySet) {
			sb.append(entry.getKey()).append(" as ").append(entry.getValue()).append(",");
		}
		int length = sb.length();
		if(length > 0)
			sb.deleteCharAt(length-1);
		return sb.toString();
	}

	@Override
	public List<Role> getList(RolePagingBean pagingBean) {
		try {
			if(pagingBean==null){
				QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
				List<Role> list = runner.query("select "+sqlutil(map)+" from power", new BeanListHandler<>(Role.class));
				return list;
			}else{
				StringBuffer sb = new StringBuffer();
				String powerName = pagingBean.getRoleName();
				boolean isWhere = true;
				if(powerName!=null&&!powerName.trim().isEmpty()){
					String like = getLike(powerName);
					if(isWhere)
						sb.append(" where ");
					else
						sb.append(" and ");
					sb.append("powerName like '").append(like).append("'");
					isWhere = false;
				}
				String sql = "select top "+pagingBean.getPageSize()+" "+sqlutil(map)+" from power"+sb+(isWhere?" where ":" and ")
							+"powerid not in (select top "+(pagingBean.getPageSize()*pagingBean.getCurrentPage()-pagingBean.getPageSize())
							+" powerid from power"+sb+" order by powerid) order by powerid";
				QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
				List<Role> list = runner.query(sql, new BeanListHandler<>(Role.class));
				return list;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	private String getLike(String key){
		char[] charArray = key.toCharArray();
		StringBuffer sb = new StringBuffer("%");
		for (char c : charArray) {
			sb.append(c).append("%");
		}
		return sb.toString();
	}
	@Override
	public List<UserBean> getList(RolePage pagingBean) {
		/**HashMap<String,String> map = new HashMap<>();
		map.put("username", "username");
		map.put("pwd", "pwd");
		map.put("qymc", "name");
		map.put("qydz", "address");
		map.put("lxfs", "cellphone");
		map.put("yx", "email");
		map.put("powerid", "roleId");
		map.put("id", "id");
		StringBuffer sql = new StringBuffer();
		int pageSize = pagingBean.getPageSize();
		
		sql.append("select top ").append(pageSize).append(" ").append(sqlutil(map)).append(" from userinform");
		boolean isWhere = true;
		StringBuffer sb = new StringBuffer();
		Integer roleId = pagingBean.getRoleId();
		if(roleId!=null){
			append(sb,isWhere);
			sb.append("powerId = ").append(roleId);
			isWhere = false;
		}
		String username = pagingBean.getUsername();
		if(username!=null && !username.trim().isEmpty()){
			append(sb,isWhere);
			sb.append("username like '%").append(username).append("%'");
			isWhere = false;
		}
		String str = sb.toString();
		append(sb,isWhere);
		isWhere = false;
		sb.append("id not in ( select top ").append(pagingBean.getCurrentPage()*pageSize-pageSize)
		.append(" id from userinform").append(str).append(" order by id ) order by id");
		sql.append(sb);
		System.out.println(sql);
		
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		try {
			List<UserBean> list = runner.query(sql.toString(), new BeanListHandler<>(UserBean.class));
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}*/
		UserPage userPage = new UserPage();
		userPage.setUsername(pagingBean.getUsername());
		userPage.setRoleId(pagingBean.getRoleId());
		userPage.setCurrentPage(pagingBean.getCurrentPage());
		userPage.setPageSize(pagingBean.getPageSize());
		UserDao dao = new UserDaoImp();
		return dao.getList(userPage);
	}

	public int getCount(RolePage pagingBean){
		UserPage userPage = new UserPage();
		userPage.setUsername(pagingBean.getUsername());
		userPage.setRoleId(pagingBean.getRoleId());
		userPage.setCurrentPage(pagingBean.getCurrentPage());
		userPage.setPageSize(pagingBean.getPageSize());
		UserDao userDaoImp = new UserDaoImp();
		int count = userDaoImp.getCount(userPage);
		return count;
	}
	
	protected void append(StringBuffer sb,boolean isWhere){
		if(isWhere)
			sb.append(" where ");
		else
			sb.append(" and ");
	}

	@Override
	public boolean add(Role role) {
		SQLFactory factory = SQLUtil.getSQLFactory(role);
		factory.setField("powerid", role.getId());
		String sql = factory.insertPreSql();
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
	public boolean update(Role role) {
		SQLFactory factory = SQLUtil.getSQLFactory(role);
		factory.removeField("powerid");
		factory.addEqualRefer("powerid", role.getId());
		String sql = factory.updateSql();
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		try {
			int i = runner.update(sql);
			return i > 0;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	public Role getByName(String roleName) {
		String sql = "select "+sqlutil(map)+" from POWER where powername=?";
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		try {
			Role role = runner.query(sql, new BeanHandler<>(Role.class),roleName);
			return role;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	public Integer getMaxId() {
		String sql = "select max(powerid) as maxValue from POWER";
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		try {
			Integer max = runner.query(sql, new ResultSetHandler<Integer>(){

				@Override
				public Integer handle(ResultSet set) throws SQLException {
					if(set.next()){
						return set.getInt("maxValue");
					}
					return 0;
				}});
			return max;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	public Integer getCount(RolePagingBean pagingBean) {
		String sql = "select count(*) count from power";
		if(pagingBean==null){
			
		}else{
			StringBuffer sb = new StringBuffer();
			String powerName = pagingBean.getRoleName();
			boolean isWhere = true;
			if(powerName!=null&&!powerName.trim().isEmpty()){
				String like = getLike(powerName);
				if(isWhere)
					sb.append(" where ");
				else
					sb.append(" and ");
				sb.append("powerName like '").append(like).append("'");
				isWhere = false;
			}
			sql += sb;
		}
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		try {
			Integer integer = runner.query(sql, new ResultSetHandler<Integer>(){

				@Override
				public Integer handle(ResultSet arg0) throws SQLException {
					if(arg0.next())
						return arg0.getInt("count");
					return null;
				}});
			return integer;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	public boolean delById(Integer id) {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		try {
			int update = runner.update("delete from power where powerid=?",id);
			return 0< update;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
}
