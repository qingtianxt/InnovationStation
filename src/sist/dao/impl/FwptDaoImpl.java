package sist.dao.impl;

import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import sist.bean.FwptPagingBean;
import sist.dao.FwptDao;
import sist.domain.Fwpt;
import sist.utils.DataSourceUtils;

public class FwptDaoImpl implements FwptDao {

	@Override
	public List<Fwpt> getTop(int topsize) throws Exception {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select top " + topsize + " * from fwpt_view ";
		return qr.query(sql, new BeanListHandler<>(Fwpt.class));
	}

	@Override
	public int countByKey(FwptPagingBean page) throws Exception {


		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select count(*) from fwpt_view where";

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
			sql += " or km like '%" + s[i] + "%'";
		}
		for (int i = 0; i < s.length; i++) {
			sql += " or lxr like '%" + s[i] + "%'";
		}
		for (int i = 0; i < s.length; i++) {
			sql += " or dz like '%" + s[i] + "%'";
		}
		for (int i = 0; i < s.length; i++) {
			sql += " or gjc like '%" + s[i] + "%'";
		}
		for (int i = 0; i < s.length; i++) {
			sql += " or dh like '%" + s[i] + "%'";
		}
		
		System.out.println("Countsql:" + sql);
		return (int) qr.query(sql, new ScalarHandler());
	}

	@Override
	public List<Fwpt> getByKey(FwptPagingBean page) throws Exception {

		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select top " + page.getPageSize() + " * from fwpt_view where";
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
			sql += " or km like '%" + s[i] + "%'";
			sql1 += " or km like '%" + s[i] + "%'";
		}
		for (int i = 0; i < s.length; i++) {
			sql += " or lxr like '%" + s[i] + "%'";
			sql1 += " or lxr like '%" + s[i] + "%'";
		}
		for (int i = 0; i < s.length; i++) {
			sql += " or dz like '%" + s[i] + "%'";
			sql1 += " or dz like '%" + s[i] + "%'";
		}
		for (int i = 0; i < s.length; i++) {
			sql += " or gjc like '%" + s[i] + "%'";
			sql1 += " or gjc like '%" + s[i] + "%'";
		}
		for (int i = 0; i < s.length; i++) {
			sql += " or dh like '%" + s[i] + "%'";
			sql1 += " or dh like '%" + s[i] + "%'";
		}
		sql1 += ") ";

		sql += " )and mc not in (select top " + (page.getCurrentPage() - 1) * page.getPageSize()
				+ " mc from fwpt_view where " + sql1 + ")";
		System.out.println("sql:" + sql);
		return qr.query(sql, new BeanListHandler<>(Fwpt.class));
	}

	@Override
	public Fwpt getByKmAndMc(String km, String mc) throws Exception {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from fwpt_view where mc = ? and km = ?";
		return qr.query(sql, new BeanHandler<>(Fwpt.class),mc,km);
	}

	@Override
	public int count(FwptPagingBean page) throws Exception {




		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select count(*) from fwpt_view where 1=1";
		if (null != page.getMc() && !"".equals(page.getMc())) {
			sql += " and MC like '%" + page.getMc() + "%'";
		}
		if (null != page.getKm() && !"".equals(page.getKm())) {
			sql += " and km like '%" + page.getKm() + "%'";
		}
		if (null != page.getLxr() && !"".equals(page.getLxr())) {
			sql += " and lxr like '%" + page.getLxr() + "%'";
		}
		if (null != page.getGjc() && !"".equals(page.getGjc())) {
			sql += " and gjc like '%" + page.getGjc() + "%'";
		}
		System.out.println("Countsql:" + sql);
	
	
		return (int) qr.query(sql, new ScalarHandler());
	}

	@Override
	public List<Fwpt> getList(FwptPagingBean page) throws Exception {

		String sql1 = "";


		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select top " + page.getPageSize() + " * from fwpt_view where 1=1";
		if (null != page.getMc() && !"".equals(page.getMc())) {
			sql += " and MC like '%" + page.getMc() + "%'";
			sql1 += " and MC like '%" + page.getMc() + "%'";
		}
		if (null != page.getKm() && !"".equals(page.getKm())) {
			sql += " and km like '%" + page.getKm() + "%'";
			sql1 += " and km like '%" + page.getKm() + "%'";
		}
		if (null != page.getLxr() && !"".equals(page.getLxr())) {
			sql += " and lxr like '%" + page.getLxr() + "%'";
			sql1 += " and lxr like '%" + page.getLxr() + "%'";
		}
		if (null != page.getGjc() && !"".equals(page.getGjc())) {
			sql += " and gjc like '%" + page.getGjc() + "%'";
			sql1 += " and gjc like '%" + page.getGjc() + "%'";
		}
		sql += " and mc not in (select top " + (page.getCurrentPage() - 1) * page.getPageSize()
				+ " mc from fwpt_view where 1=1" + sql1 + ")";
		System.out.println("getsql:" + sql);
		return qr.query(sql, new BeanListHandler<>(Fwpt.class));
	
	}

}
