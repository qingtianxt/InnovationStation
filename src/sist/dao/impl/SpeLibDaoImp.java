package sist.dao.impl;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import sist.bean.LibPageBean;
import sist.dao.SpeLibDao;
import sist.domain.SpecialLibrary;
import sist.utils.DataSourceUtils;
import sist.utils.SQLUtil;
import sist.utils.SQLUtil.SQLFactory;

public class SpeLibDaoImp implements SpeLibDao {

	@Override
	public SpecialLibrary findById(Integer id) {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		try {
			return runner.query("select id,title,publisher,date,abstract as intro from ZTZL_MANAGER where id=?", new BeanHandler<>(SpecialLibrary.class),id);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	public boolean add(SpecialLibrary lib) {
		String sql = "insert into ztzl_manager (title,publisher,date,abstract) values(?,?,?,?)";
		Object[] params = new Object[]{lib.getTitle(),lib.getPublisher(),lib.getDate(),lib.getIntro()};
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		// TODO 记得删除此处
		System.out.println(sql);
		System.out.println(Arrays.toString(params));
		try {
			int i = runner.update(sql,params);
			return i > 0;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	public boolean update(SpecialLibrary lib) {
		SQLFactory factory = SQLUtil.getSQLFactory("ZTZL_MANAGER", lib, "id");
		String sql = factory.updateSql().replace("intro", "abstract");
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
	public List<SpecialLibrary> getList(LibPageBean page) {
		StringBuffer sb = new StringBuffer();
		if(page!=null){
			String name = page.getName();
			if(name!=null && !name.trim().isEmpty()){
				sb.append("and title like '%").append(name).append("%' ");
			}
			String publisher = page.getPublisher();
			if(publisher!=null && !publisher.trim().isEmpty()){
				sb.append("and publisher like '%").append(publisher).append("%' ");
			}
			String startTime = page.getStartTime();
			if(startTime!=null && !startTime.trim().isEmpty()){
				sb.append("and date > '").append(startTime).append("' ");
			}
			String endTime = page.getEndTime();
			if(endTime!=null && !endTime.trim().isEmpty()){
				sb.append("and date < '").append(endTime).append("' ");
			}
			String intro = page.getIntro();
			if(intro!=null && !intro.trim().isEmpty()){
				sb.append("and abstract like '%").append(intro).append("%' ");
			}
			String str = "";
			if(sb.toString().startsWith("and")){
				sb.delete(0, 3);
				str = "where "+sb.toString();
				sb.append("and");
			}
			sb.insert(0, "where");
			sb.append(" id not in ( select top ").append((page.getCurrentPage()-1)*page.getPageSize())
				.append(" id from ZTZL_MANAGER ").append(str)
				.append(" order by date desc,id asc ) order by date desc,id asc");
			sb.insert(0, " id,title,publisher,date,abstract as intro from ZTZL_MANAGER ").insert(0, page.getPageSize()).insert(0, "select top ");
		}else{
			sb.append("select id,title,publisher,date,abstract as intro from ZTZL_MANAGER");
		}
//		System.out.println(sb);
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		try {
			List<SpecialLibrary> list = runner.query(sb.toString(), new BeanListHandler<>(SpecialLibrary.class));
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	public int getCount(LibPageBean page) {
		StringBuffer sb = new StringBuffer();
		if(page!=null){
			String name = page.getName();
			if(name!=null && !name.trim().isEmpty()){
				sb.append("and title like '%").append(name).append("%' ");
			}
			String publisher = page.getPublisher();
			if(publisher!=null && !publisher.trim().isEmpty()){
				sb.append("and publisher like '%").append(publisher).append("%' ");
			}
			String startTime = page.getStartTime();
			if(startTime!=null && !startTime.trim().isEmpty()){
				sb.append("and date > '").append(startTime).append("' ");
			}
			String endTime = page.getEndTime();
			if(endTime!=null && !endTime.trim().isEmpty()){
				sb.append("and date < '").append(endTime).append("' ");
			}
			String intro = page.getIntro();
			if(intro!=null && !intro.trim().isEmpty()){
				sb.append("and abstract like '%").append(intro).append("%' ");
			}
			
			if(sb.toString().startsWith("and")){
				sb.delete(0, 3);
				sb.insert(0,"where");
			}
		}
		sb.insert(0, "select count(*) count from ZTZL_MANAGER ");
//		System.out.println(sb);
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		try {
			Object query = runner.query(sb.toString(), new ScalarHandler(1));
			return Integer.parseInt(query.toString());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	public boolean delById(int id) {
		String sql = "delete from ZTZL_MANAGER where id=?";
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		try {
			int i = runner.update(sql,id);
			return i>0;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	public SpecialLibrary getByTitle(String title) {
		String sql = "select id,title,publisher,date,abstract as intro from ZTZL_MANAGER where title=?";
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		try {
			SpecialLibrary library = runner.query(sql, new BeanHandler<>(SpecialLibrary.class), title);
			return library;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

}
