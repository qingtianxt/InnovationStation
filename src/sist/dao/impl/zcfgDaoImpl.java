package sist.dao.impl;

import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import sist.bean.zcfgPagingBean;
import sist.dao.zcfgDao;
import sist.domain.kjcg;
import sist.domain.zcfg;
import sist.utils.DataSourceUtils;

public class zcfgDaoImpl implements zcfgDao {
	/**
	 * 根据名称获取政策法规信息
	 */
	@Override
	public zcfg getByMc(String zcmc) throws Exception {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from zcxxk where zcmc = ?";
		return qr.query(sql, new BeanHandler<>(zcfg.class), zcmc);
	}

	@Override
	public void add(zcfg z) throws Exception {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "insert into zcxxk ( zcmc,bgbrq,bsxrq,zcflmc,ttzlymc," + "bbbxsmc,zcwh,zcnr,bzdjgmc,bsxfwmc,"
				+ "ztcmc,gjzmc,username,hits) values ( ?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		qr.update(sql, z.getZcmc(), z.getBgbrq(), z.getBsxrq(), z.getZcflmc(), z.getTtzlymc(), z.getBbbxsmc(),
				z.getZcwh(), z.getZcnr(), z.getBzdjgmc(), z.getBsxfwmc(), z.getZtcmc(), z.getGjzmc(), z.getUsername(),
				0);
	}

	/**
	 * 根据条件获取总条数
	 */
	@Override
	public int count(zcfgPagingBean page) throws Exception {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select count(*) from zcxxk where 1=1 ";
		if (null != page.getZcmc() && !"".equals(page.getZcmc())) {
			sql += " and zcmc like '%" + page.getZcmc() + "%' ";
		}
		if (null != page.getZcflmc() && !"".equals(page.getZcflmc())) {
			sql += " and zcflmc like '%" + page.getZcflmc() + "%' ";
		}
		if (null != page.getZtcmc() && !"".equals(page.getZtcmc())) {
			sql += " and ztcmc like '%" + page.getZtcmc() + "%' ";
		}
		if (null != page.getZcwh() && !"".equals(page.getZcwh())) {
			sql += " and zcwh like '%" + page.getZcwh() + "%' ";
		}
		if (null != page.getTime1() && !"".equals(page.getTime1())) {
			sql += " and convert(varchar(10),BGBRQ,120)>='" + page.getTime1() + "'";
		}
		if (null != page.getTime2() && !"".equals(page.getTime2())) {
			sql += " and convert(varchar(10),BGBRQ,120)<='" + page.getTime2() + "'";
		}
		System.out.println("countSql" + sql);
		return (int) qr.query(sql, new ScalarHandler());
	}

	/**
	 * 根据条件分页获取政策法规信息
	 */
	@Override
	public List<zcfg> getList(zcfgPagingBean page) throws Exception {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select top " + page.getPageSize() + " * from ZCXXK where 1=1 ";
		String sql1 = "";
		if (null != page.getZcmc() && !"".equals(page.getZcmc())) {
			sql += " and zcmc like '%" + page.getZcmc() + "%' ";
			sql1 += " and zcmc like '%" + page.getZcmc() + "%' ";
		}
		if (null != page.getZcflmc() && !"".equals(page.getZcflmc())) {
			sql += " and zcflmc like '%" + page.getZcflmc() + "%' ";
			sql1 += " and zcflmc like '%" + page.getZcflmc() + "%' ";
		}
		if (null != page.getZtcmc() && !"".equals(page.getZtcmc())) {
			sql += " and ztcmc like '%" + page.getZtcmc() + "%' ";
			sql1 += " and ztcmc like '%" + page.getZtcmc() + "%' ";
		}
		if (null != page.getZcwh() && !"".equals(page.getZcwh())) {
			sql += " and zcwh like '%" + page.getZcwh() + "%' ";
			sql1 += " and zcwh like '%" + page.getZcwh() + "%' ";
		}
		if (null != page.getTime1() && !"".equals(page.getTime1())) {
			sql += " and convert(varchar(10),BGBRQ,120)>='" + page.getTime1() + "'";
			sql1 += "and convert(varchar(10),BGBRQ,120)>='" + page.getTime1() + "'";
		}
		if (null != page.getTime2() && !"".equals(page.getTime2())) {
			sql += " and convert(varchar(10),BGBRQ,120)<='" + page.getTime2() + "'";
			sql1 += "and convert(varchar(10),BGBRQ,120)<='" + page.getTime2() + "'";
		}
		sql1 += "order by BGBRQ desc";
		sql += " and id not in (select top " + (page.getCurrentPage() - 1) * page.getPageSize()
				+ " id from ZCXXK where 1=1 " + sql1 + ") ";
		sql += " order by BGBRQ desc";
		System.out.println("getsql" + sql);

		return qr.query(sql, new BeanListHandler<>(zcfg.class));
	}

	/**
	 * 根据id获取政策法规信息
	 */
	@Override
	public zcfg getById(int id) throws Exception {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from ZCXXK where id = ?";
		return qr.query(sql, new BeanHandler<>(zcfg.class), id);
	}

	/**
	 * "insert into zcxxk ( zcmc,bgbrq,bsxrq,zcflmc,ttzlymc," +
	 * "bbbxsmc,zcwh,zcnr,bzdjgmc,bsxfwmc," + "ztcmc,gjzmc,username)
	 */
	/**
	 * z.getZcmc(),z.getBgbrq(),z.getBsxrq(),z.getZcflmc(),z.getTtzlymc(),
	 * z.getBbbxsmc(),z.getZcwh(),z.getZcnr(),z.getBzdjgmc(),z.getBsxfwmc(),
	 * z.getZtcmc(),z.getGjzmc(),z.getUsername()
	 */
	@Override
	public void update(zcfg z) throws Exception {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "update ZCXXK set zcmc= ? , bgbrq= ? , bsxrq= ? , zcflmc= ? , ttzlymc= ? ,"
				+ " bbbxsmc= ? , zcwh= ? , zcnr= ? , bzdjgmc=? , bsxfwmc=? ,"
				+ " ztcmc=? , gjzmc=? , username=? where id = ?";
		qr.update(sql, z.getZcmc(), z.getBgbrq(), z.getBsxrq(), z.getZcflmc(), z.getTtzlymc(), z.getBbbxsmc(),
				z.getZcwh(), z.getZcnr(), z.getBzdjgmc(), z.getBsxfwmc(), z.getZtcmc(), z.getGjzmc(), z.getUsername(),
				z.getId());
	}

	@Override
	public void delete(int id) throws Exception {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "delete from ZCXXK where id =?";
		qr.update(sql, id);
	}

	@Override
	public List<zcfg> getTop(int topsize) throws Exception {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select top " + topsize + " * from ZCXXK order by BGBRQ desc";
		return qr.query(sql, new BeanListHandler<>(zcfg.class));
	}

	@Override
	public int countByKey(zcfgPagingBean page) throws Exception {

		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select count(*) from ZCXXK where";

		String s[] = new String[page.getZcmc().length()];
		s = page.getZcmc().split("");
		if (s.length <= 1) {
			sql += " (zcmc like '%" + s[0] + "%'";
		} else {
			sql += " (zcmc like '%" + s[0] + "%'";
			for (int i = 1; i < s.length; i++) {
				sql += " or zcmc like '%" + s[i] + "%'";
			}
		}
		for (int i = 0; i < s.length; i++) {
			sql += " or bgbrq like '%" + s[i] + "%'";
		}
		for (int i = 0; i < s.length; i++) {
			sql += " or bsxrq like '%" + s[i] + "%'";
		}
		for (int i = 0; i < s.length; i++) {
			sql += " or zcflmc like '%" + s[i] + "%'";
		}
		for (int i = 0; i < s.length; i++) {
			sql += " or ttzlymc like '%" + s[i] + "%'";
		}
		for (int i = 0; i < s.length; i++) {
			sql += " or bbbxsmc like '%" + s[i] + "%'";
		}
		for (int i = 0; i < s.length; i++) {
			sql += " or zcwh like '%" + s[i] + "%'";
		}
		for (int i = 0; i < s.length; i++) {
			sql += " or zcnr like '%" + s[i] + "%'";
		}
		for (int i = 0; i < s.length; i++) {
			sql += " or bzdjgmc like '%" + s[i] + "%'";
		}
		for (int i = 0; i < s.length; i++) {
			sql += " or bsxfwmc like '%" + s[i] + "%'";
		}
		for (int i = 0; i < s.length; i++) {
			sql += " or ztcmc like '%" + s[i] + "%'";
		}
		for (int i = 0; i < s.length; i++) {
			sql += " or gjzmc like '%" + s[i] + "%'";
		}
		for (int i = 0; i < s.length; i++) {
			sql += " or username like '%" + s[i] + "%'";
		}
		sql += ")";
		System.out.println("Countsql:" + sql);

		return (int) qr.query(sql, new ScalarHandler());
	}

	@Override
	public List<zcfg> getByKey(zcfgPagingBean page) throws Exception {

		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select top " + page.getPageSize() + " * from ZCXXK where";
		String sql1 = "";

		String s[] = new String[page.getZcmc().length()];
		s = page.getZcmc().split("");
		if (s.length <= 1) {
			sql += " (zcmc like '%" + s[0] + "%'";
			sql1 += " (zcmc like '%" + s[0] + "%'";
		} else {
			sql += " (zcmc like '%" + s[0] + "%'";
			sql1 += " (zcmc like '%" + s[0] + "%'";
			for (int i = 1; i < s.length; i++) {
				sql += " or zcmc like '%" + s[i] + "%'";
				sql1 += " or zcmc like '%" + s[i] + "%'";
			}
		}
		for (int i = 0; i < s.length; i++) {
			sql += " or bgbrq like '%" + s[i] + "%'";
			sql1 += " or bgbrq like '%" + s[i] + "%'";
		}
		for (int i = 0; i < s.length; i++) {
			sql += " or bsxrq like '%" + s[i] + "%'";
			sql1 += " or bsxrq like '%" + s[i] + "%'";
		}
		for (int i = 0; i < s.length; i++) {
			sql += " or zcflmc like '%" + s[i] + "%'";
			sql1 += " or zcflmc like '%" + s[i] + "%'";
		}
		for (int i = 0; i < s.length; i++) {
			sql += " or ttzlymc like '%" + s[i] + "%'";
			sql1 += " or ttzlymc like '%" + s[i] + "%'";
		}
		for (int i = 0; i < s.length; i++) {
			sql += " or bbbxsmc like '%" + s[i] + "%'";
			sql1 += " or bbbxsmc like '%" + s[i] + "%'";
		}
		for (int i = 0; i < s.length; i++) {
			sql += " or zcwh like '%" + s[i] + "%'";
			sql1 += " or zcwh like '%" + s[i] + "%'";
		}
		for (int i = 0; i < s.length; i++) {
			sql += " or zcnr like '%" + s[i] + "%'";
			sql1 += " or zcnr like '%" + s[i] + "%'";
		}
		for (int i = 0; i < s.length; i++) {
			sql += " or bzdjgmc like '%" + s[i] + "%'";
			sql1 += " or bzdjgmc like '%" + s[i] + "%'";
		}
		for (int i = 0; i < s.length; i++) {
			sql += " or bsxfwmc like '%" + s[i] + "%'";
			sql1 += " or bsxfwmc like '%" + s[i] + "%'";
		}
		for (int i = 0; i < s.length; i++) {
			sql += " or ztcmc like '%" + s[i] + "%'";
			sql1 += " or ztcmc like '%" + s[i] + "%'";
		}
		for (int i = 0; i < s.length; i++) {
			sql += " or gjzmc like '%" + s[i] + "%'";
			sql1 += " or gjzmc like '%" + s[i] + "%'";
		}
		for (int i = 0; i < s.length; i++) {
			sql += " or username like '%" + s[i] + "%'";
			sql1 += " or username like '%" + s[i] + "%'";
		}
		sql1 += ") order by BGBRQ desc";

		sql += " )and id not in (select top " + (page.getCurrentPage() - 1) * page.getPageSize()
				+ " id from ZCXXK where " + sql1 + ")";
		sql += " order by BGBRQ desc";
		System.out.println("sql:" + sql);
		return qr.query(sql, new BeanListHandler<>(zcfg.class));
	}

	@Override
	public void addHits(int id) throws Exception {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "update ZCXXK set hits=hits+1 where id= ?";
		qr.update(sql,id);
	}

}
