package sist.dao.impl;

import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import sist.bean.CgalPagingBean;
import sist.dao.cgalDao;
import sist.domain.cgal;
import sist.utils.DataSourceUtils;

public class cgalDaoImpl implements cgalDao {

	@Override
	public cgal getByMc(String mc) throws Exception {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from cgalk where mc=?";
		return qr.query(sql, new BeanHandler<>(cgal.class),mc);
	}

	@Override
	public void add(cgal c) throws Exception {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql ="insert into cgalk (mc,szd,dw,nr,gjc,time,username) values(?,?,?,?,?,?,?)";
		qr.update(sql,c.getMc(),c.getSzd(),c.getDw(),c.getNr(),c.getGjc(),c.getTime(),c.getUsername());
	}
/**
 * 根基名称删除成功案例的信息
 */
	@Override
	public void delete(String mc) throws Exception {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql ="delete from cgalk where mc =?";
		qr.update(sql,mc);
	}
/**
 * 通过id获取成功案例信息
 */
	@Override
	public cgal getById(int id) throws Exception {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from cgalk where id=?";
		return qr.query(sql, new BeanHandler<>(cgal.class),id);
	}
//mc,szd,dw,nr,gjc,time,username
	//c.getMc(),c.getSzd(),c.getDw(),c.getNr(),c.getGjc(),c.getTime(),c.getUsername()
	@Override
	public void update(cgal c) throws Exception {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "update cgalk set mc='"+c.getMc()+"',szd='"+c.getSzd()+"',dw='"+c.getDw()+"',"
				+ "nr='"+c.getNr()+"',gjc='"+c.getGjc()+"',time='"+c.getTime()+"',username='"+c.getUsername()+"' where id="+c.getId();
		qr.update(sql);
	}

	@Override
	public int countByKey(CgalPagingBean page) throws Exception {

		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select count(*) from cgalk where";
		
		String s[] = new String[page.getMc().length()];
		s = page.getMc().split("");

		if (s.length == 1) {
			sql += " mc like '%" + s[0] + "%'";
		} else {
			sql += " mc like '%" + s[0] + "%'";
			for (int i = 1; i < s.length; i++) {
				sql += " or mc like '%" + s[i] + "%'";
			}
		}

		
		for (int i = 0; i < s.length; i++) {
			sql += " or szd like '%" + s[i] + "%'";
		}
		for (int i = 0; i < s.length; i++) {
			sql += " or dw like '%" + s[i] + "%'";
		}
		for (int i = 0; i < s.length; i++) {
			sql += " or nr like '%" + s[i] + "%'";
		}
		for (int i = 0; i < s.length; i++) {
			sql += " or gjc like '%" + s[i] + "%'";
		}
		for (int i = 0; i < s.length; i++) {
			sql += " or time like '%" + s[i] + "%'";
		}
		for (int i = 0; i < s.length; i++) {
			sql += " or username like '%" + s[i] + "%'";
		}

		System.out.println("Countsql:"+sql);
		return (int) qr.query(sql, new ScalarHandler());
	
	}

	@Override
	public List<cgal> getByKey(CgalPagingBean page) throws Exception {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select top " + page.getPageSize() + " * from cgalk where";
		String sql1 = "";
		
		String s[] = new String[page.getMc().length()];
		s = page.getMc().split("");

		if (s.length == 1) {
			sql += " (mc like '%" + s[0] + "%'";
			sql1 += " (mc like '%" + s[0] + "%'";
		} else {
			sql += " (mc like '%" + s[0] + "%'";
			sql1 += " (mc like '%" + s[0] + "%'";
			for (int i = 1; i < s.length; i++) {
				sql += " or mc like '%" + s[i] + "%'";
				sql1 += " or mc like '%" + s[i] + "%'";
			}
		}

		
		for (int i = 0; i < s.length; i++) {
			sql += " or szd like '%" + s[i] + "%'";
			sql1 += " or szd like '%" + s[i] + "%'";
		}
		for (int i = 0; i < s.length; i++) {
			sql += " or dw like '%" + s[i] + "%'";
			sql1 += " or dw like '%" + s[i] + "%'";
		}
		for (int i = 0; i < s.length; i++) {
			sql += " or nr like '%" + s[i] + "%'";
			sql1 += " or nr like '%" + s[i] + "%'";
		}
		for (int i = 0; i < s.length; i++) {
			sql += " or gjc like '%" + s[i] + "%'";
			sql1 += " or gjc like '%" + s[i] + "%'";
		}
		for (int i = 0; i < s.length; i++) {
			sql += " or time like '%" + s[i] + "%'";
			sql1 += " or time like '%" + s[i] + "%'";
		}
		for (int i = 0; i < s.length; i++) {
			sql += " or username like '%" + s[i] + "%'";
			sql1 += " or username like '%" + s[i] + "%'";
		}
		sql1 += ") order by time desc";

		sql += " )and id not in (select top " + (page.getCurrentPage() - 1) * page.getPageSize()
				+ " id from cgalk where " + sql1 + ")";
		sql += " order by time desc";
		System.out.println("sql:"+sql);
		return qr.query(sql, new BeanListHandler<>(cgal.class));
	}

}
