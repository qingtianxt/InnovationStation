package sist.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import sist.bean.PatentPage;
import sist.dao.PatentDao;
import sist.domain.Patent;
import sist.utils.DataSourceUtils;
import sist.utils.SQLUtil;
import sist.utils.SQLUtil.SQLFactory;

public class PatentDaoImp implements PatentDao {

	@Override
	public List<Patent> getList(PatentPage page) {
		StringBuffer sb = new StringBuffer();
		if (page != null) {
			Integer libId = page.getLibId();
            if(libId != null)
                sb.append("and ztzlk_id = ").append(libId).append(" ");
			String name = page.getName();
			if (name != null && !name.trim().isEmpty()) {
				sb.append("and fmmc like '%").append(name).append("%' ");
			}
			String zlh = page.getPatentNumber();
			if (zlh != null && !zlh.trim().isEmpty()) {
				sb.append("and zlh like '%").append(zlh).append("%' ");
			}
			String zy = page.getSummary();
			if (zy != null && !zy.trim().isEmpty()) {
				sb.append("and zy like '%").append(zy).append("%' ");
			}
			String startTime = page.getStartTime();
			if (startTime != null && !startTime.trim().isEmpty()) {
				sb.append("and sqrq > '").append(startTime).append("' ");
			}
			String endTime = page.getEndTime();
			if (endTime != null && !endTime.trim().isEmpty()) {
				sb.append("and sqrq < '").append(endTime).append("' ");
			}
			String str = "";
			if (sb.toString().startsWith("and")) {
				sb.delete(0, 3);
				str = "where " + sb.toString();
				sb.append("and");
			}
			sb.insert(0, "where");
			sb.append(" id not in ( select top ").append((page.getCurrentPage() - 1) * page.getPageSize())
					.append(" id from ZTZL ").append(str)
					.append(" order by sqrq desc,id asc ) order by sqrq desc,id asc");
			sb.insert(0, " * from ZTZL ").insert(0, page.getPageSize()).insert(0, "select top ");
		}
		else {
			sb.append("select * from ztzl");
		}
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		try {
//			System.out.println(sb);
			List<Patent> list = runner.query(sb.toString(), new BeanListHandler<>(Patent.class));
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	public int getCount(PatentPage page) {
		StringBuffer sb = new StringBuffer();
		if(page!=null){
			Integer libId = page.getLibId();
            if(libId != null)
                sb.append("and ztzlk_id = ").append(libId).append(" ");
			String name = page.getName();
			if (name != null && !name.trim().isEmpty()) {
				sb.append("and fmmc like '%").append(name).append("%' ");
			}
			String zlh = page.getPatentNumber();
			if (zlh != null && !zlh.trim().isEmpty()) {
				sb.append("and zlh like '%").append(zlh).append("%' ");
			}
			String zy = page.getSummary();
			if (zy != null && !zy.trim().isEmpty()) {
				sb.append("and zy like '%").append(zy).append("%' ");
			}
			String startTime = page.getStartTime();
			if (startTime != null && !startTime.trim().isEmpty()) {
				sb.append("and sqrq > '").append(startTime).append("' ");
			}
			String endTime = page.getEndTime();
			if (endTime != null && !endTime.trim().isEmpty()) {
				sb.append("and sqrq < '").append(endTime).append("' ");
			}
			
			if(sb.toString().startsWith("and"))
			{
				sb.delete(0, 3);
				sb.insert(0,"where");
			}
		}
		sb.insert(0,"select count(*) count from ztzl ");
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
//		System.out.println(sb);
		try {
			String num = runner.query(sb.toString(), new ScalarHandler()).toString();
			return Integer.parseInt(num);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	public boolean addAll(List<Patent> list) {
		Connection con = null;
		Statement st = null;
		try {
			con = DataSourceUtils.getDataSource().getConnection();
			st = con.createStatement();
			int count = 0;
			for (Patent patent : list) {
				String insert = SQLUtil.insert(patent, "ztzl");
				st.addBatch(insert);
				if(count==100)
				{
					st.executeBatch();
					st.clearBatch();
					count=0;
				}
				count++;
			}
			st.executeBatch();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			try {st.close();} catch (SQLException e) {	}
			try {con.close();} catch (SQLException e) {e.printStackTrace();}
		}
	}

	@Override
	public Patent getPatent(int id) {
		String sql = "select * from ztzl where id=?";
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		try {
			return runner.query(sql, new BeanHandler<>(Patent.class),id);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}


	@Override
	public boolean addPatent(Patent patent) {
		SQLFactory factory = SQLUtil.getSQLFactory("ztzl", patent, "id");
		String insertSql = factory.insertSql();
		Object[] params = factory.getParams();
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		try {
			int i = runner.update(insertSql,params);
			return i > 0;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	public boolean updatePatent(Patent patent) {
		SQLFactory factory = SQLUtil.getSQLFactory("ztzl",patent, "id");
		String sql = factory.updateSql();
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
	public boolean delById(int id) {
		String sql = "delete from ztzl where id=?";
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		try {
			int i = runner.update(sql,id);
			return i > 0;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

}
