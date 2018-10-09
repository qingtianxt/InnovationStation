package sist.dao.impl;

import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import sist.bean.frontZjxxPagingBean;
import sist.bean.zjxxPagingBean;
import sist.dao.zjxxDao;
import sist.domain.kjcg;
import sist.domain.zcfg;
import sist.domain.zjxx;
import sist.utils.DataSourceUtils;

public class zjxxDaoImpl implements zjxxDao {
	/**
	 * 添加专家信息
	 */
	@Override
	public void add(zjxx z) throws Exception {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "insert into zjrck (XM,MC_SZS,XB,GJ,ZC_ZY," + "XL,XW,DW_GZ,CH,CH_QT,"
				+ "XKLY,RQ_CS,DH_BG,SJ,XCSHY," + "BZ,GJC,BYYX,YJFX,YSLB,"
				+ "username,hits) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		qr.update(sql, z.getXm(), z.getMc_szs(), z.getXb(), z.getGj(), z.getZc_zy(), z.getXl(), z.getXw(), z.getDw_gz(),
				z.getCh(), z.getCh_qt(), z.getXkly(), z.getRq_cs(), z.getDh_bg(), z.getSj(), z.getXcshy(), z.getBz(),
				z.getGjc(), z.getByyx(), z.getYjfx(), z.getYslb(), z.getUsername(), 0);
	}

	/**
	 * 根据条件获取总条数
	 */
	@Override
	public int count(zjxxPagingBean page) throws Exception {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select count(*) from zjrck where 1=1";
		if (null != page.getXm() && !"".equals(page.getXm())) {
			sql += " and xm like '%" + page.getXm() + "%' ";
		}
		if (null != page.getZc_zy() && !"".equals(page.getZc_zy())) {
			sql += " and zc_zy like '%" + page.getZc_zy() + "%' ";
		}
		if (null != page.getMc_szs() && !"".equals(page.getMc_szs())) {
			sql += " and MC_SZS like '%" + page.getMc_szs() + "%' ";
		}
		if (null != page.getXkly() && !"".equals(page.getXkly())) {
			sql += " and XKLY like '%" + page.getXkly() + "%' ";
		}
		if (null != page.getYjfx() && !"".equals(page.getYjfx())) {
			sql += " and YJFX like '%" + page.getYjfx() + "%' ";
		}
		System.out.println("countsql:" + sql);
		return (int) qr.query(sql, new ScalarHandler());
	}

	/**
	 * 根据条件分页获取专家信息
	 */
	@Override
	public List<zjxx> getList(zjxxPagingBean page) throws Exception {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select top " + page.getPageSize() + " * from zjrck where 1=1 ";
		String sql1 = "";

		if (null != page.getXm() && !"".equals(page.getXm())) {
			sql += " and xm like '%" + page.getXm() + "%' ";
			sql1 += " and xm like '%" + page.getXm() + "%' ";
		}
		if (null != page.getZc_zy() && !"".equals(page.getZc_zy())) {
			sql += " and zc_zy like '%" + page.getZc_zy() + "%' ";
			sql1 += " and zc_zy like '%" + page.getZc_zy() + "%' ";
		}
		if (null != page.getMc_szs() && !"".equals(page.getMc_szs())) {
			sql += " and MC_SZS like '%" + page.getMc_szs() + "%' ";
			sql1 += " and MC_SZS like '%" + page.getMc_szs() + "%' ";
		}
		if (null != page.getXkly() && !"".equals(page.getXkly())) {
			sql += " and XKLY like '%" + page.getXkly() + "%' ";
			sql1 += " and XKLY like '%" + page.getXkly() + "%' ";
		}
		if (null != page.getYjfx() && !"".equals(page.getYjfx())) {
			sql += " and YJFX like '%" + page.getYjfx() + "%' ";
			sql1 += " and YJFX like '%" + page.getYjfx() + "%' ";
		}
		sql1 += "order by id desc";
		sql += "and id not in (select top " + (page.getCurrentPage() - 1) * page.getPageSize()
				+ " id from zjrck where 1=1" + sql1 + ")";

		sql += "order by id desc";
		System.out.println("getsql:" + sql);
		return qr.query(sql, new BeanListHandler<>(zjxx.class));
	}

	/**
	 * 根据id获取专家信息
	 */
	@Override
	public zjxx getById(int id) throws Exception {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from zjrck where id =?";
		return qr.query(sql, new BeanHandler<>(zjxx.class), id);
	}

	/**
	 * 修改专家信息
	 */
	@Override
	public void update(zjxx z) throws Exception {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "update zjrck set XM='" + z.getXm() + "',mc_szs='" + z.getMc_szs() + "',xb='" + z.getXb()
				+ "',gj='" + z.getGj() + "',zc_zy='" + z.getZc_zy() + "'," + "xl='" + z.getXl() + "',xw='" + z.getXw()
				+ "',dw_gz='" + z.getDw_gz() + "',ch='" + z.getCh() + "',ch_qt='" + z.getCh_qt() + "'," + "xkly='"
				+ z.getXkly() + "',rq_cs='" + z.getRq_cs() + "',dh_bg='" + z.getDh_bg() + "',sj='" + z.getSj()
				+ "',xcshy='" + z.getXcshy() + "'," + "bz='" + z.getBz() + "',gjc='" + z.getGjc() + "',byyx='"
				+ z.getByyx() + "',yjfx='" + z.getYjfx() + "',yslb='" + z.getYslb() + "',username='" + z.getUsername()
				+ "' where id=" + z.getId();
		System.out.println("updateSql:" + sql);
		qr.update(sql);
	}

	@Override
	public void delete(int id) throws Exception {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "delete from zjrck where id = ?";
		qr.update(sql, id);
	}

	@Override
	public int frontCount(frontZjxxPagingBean page) throws Exception {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select count(*) from zjrck where 1=1 ";

		if (null != page.getXm() && !"".equals(page.getXm())) {
			sql += " and xm like '%" + page.getXm() + "%' ";
		}
		if (null != page.getTime1() && !"".equals(page.getTime1())) {
			sql += " and convert(varchar(10),s,120)>='" + page.getTime1() + "'";
		}
		if (null != page.getTime2() && !"".equals(page.getTime2())) {
			sql += " and convert(varchar(10),rq_cs,120)<='" + page.getTime2() + "'";
		}

		System.out.println("getsql:" + sql);
		return (int) qr.query(sql, new ScalarHandler());

	}

	@Override
	public List<zjxx> getFrontList(frontZjxxPagingBean page) throws Exception {

		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select top " + page.getPageSize() + " * from zjrck where 1=1 ";
		String sql1 = "";

		if (null != page.getXm() && !"".equals(page.getXm())) {
			sql += " and xm like '%" + page.getXm() + "%' ";
			sql1 += " and xm like '%" + page.getXm() + "%' ";
		}
		if (null != page.getTime1() && !"".equals(page.getTime1())) {
			sql += " and convert(varchar(10),s,120)>='" + page.getTime1() + "'";
		}
		if (null != page.getTime2() && !"".equals(page.getTime2())) {
			sql += " and convert(varchar(10),rq_cs,120)<='" + page.getTime2() + "'";
		}
		sql1 += "order by id desc";
		sql += "and id not in (select top " + (page.getCurrentPage() - 1) * page.getPageSize()
				+ " id from zjrck where 1=1" + sql1 + ")";

		sql += "order by id desc";
		System.out.println("getsql:" + sql);
		return qr.query(sql, new BeanListHandler<>(zjxx.class));

	}

	@Override
	public void addHits(int id) throws Exception {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "update zjrck set hits =hits+1 where id=?";
		qr.update(sql, id);
	}

	@Override
	public int CountByUser(frontZjxxPagingBean page, String username) throws Exception {

		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select count(*) from zjrck where 1=1 ";

		if (null != page.getXm() && !"".equals(page.getXm())) {
			sql += " and xm like '%" + page.getXm() + "%' ";
		}
		if (null != page.getTime1() && !"".equals(page.getTime1())) {
			sql += " and convert(varchar(10),s,120)>='" + page.getTime1() + "'";
		}
		if (null != page.getTime2() && !"".equals(page.getTime2())) {
			sql += " and convert(varchar(10),rq_cs,120)<='" + page.getTime2() + "'";
		}
		sql += " and username='" + username + "'";
		System.out.println("getsql:" + sql);
		return (int) qr.query(sql, new ScalarHandler());

	}

	@Override
	public List<zjxx> getListByUser(frontZjxxPagingBean page, String username) throws Exception {

		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select top " + page.getPageSize() + " * from zjrck where 1=1 ";
		String sql1 = "";

		if (null != page.getXm() && !"".equals(page.getXm())) {
			sql += " and xm like '%" + page.getXm() + "%' ";
			sql1 += " and xm like '%" + page.getXm() + "%' ";
		}
		if (null != page.getTime1() && !"".equals(page.getTime1())) {
			sql += " and convert(varchar(10),s,120)>='" + page.getTime1() + "'";
		}
		if (null != page.getTime2() && !"".equals(page.getTime2())) {
			sql += " and convert(varchar(10),rq_cs,120)<='" + page.getTime2() + "'";
		}
		sql += " and username='" + username + "'";
		sql1 += " and username='" + username + "'";

		sql1 += "order by id desc";
		sql += "and id not in (select top " + (page.getCurrentPage() - 1) * page.getPageSize()
				+ " id from zjrck where 1=1" + sql1 + ")";

		sql += "order by id desc";
		System.out.println("getsql:" + sql);
		return qr.query(sql, new BeanListHandler<>(zjxx.class));

	}

	@Override
	public List<zjxx> getTop(int topsize) throws Exception {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select top " + topsize + " * from zjrck order by rq_cs desc";
		return qr.query(sql, new BeanListHandler<>(zjxx.class));
	}

	@Override
	public int countByKey(zjxxPagingBean page) throws Exception {

		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select count(*) from zjrck where";

		String s[] = new String[page.getXm().length()];
		s = page.getXm().split("");
		if (s.length <= 1) {
			sql += " (xm like '%" + s[0] + "%'";
		} else {
			sql += " (xm like '%" + s[0] + "%'";
			for (int i = 1; i < s.length; i++) {
				sql += " or xm like '%" + s[i] + "%'";
			}
		}
		for (int i = 0; i < s.length; i++) {
			sql += " or mc_szs like '%" + s[i] + "%'";
		}
		for (int i = 0; i < s.length; i++) {
			sql += " or xb like '%" + s[i] + "%'";
		}
		for (int i = 0; i < s.length; i++) {
			sql += " or gj like '%" + s[i] + "%'";
		}
		for (int i = 0; i < s.length; i++) {
			sql += " or zc_zy like '%" + s[i] + "%'";
		}
		for (int i = 0; i < s.length; i++) {
			sql += " or xl like '%" + s[i] + "%'";
		}
		for (int i = 0; i < s.length; i++) {
			sql += " or xw like '%" + s[i] + "%'";
		}
		for (int i = 0; i < s.length; i++) {
			sql += " or dw_gz like '%" + s[i] + "%'";
		}
		for (int i = 0; i < s.length; i++) {
			sql += " or ch like '%" + s[i] + "%'";
		}
		for (int i = 0; i < s.length; i++) {
			sql += " or ch_qt like '%" + s[i] + "%'";
		}
		for (int i = 0; i < s.length; i++) {
			sql += " or xkly like '%" + s[i] + "%'";
		}
		for (int i = 0; i < s.length; i++) {
			sql += " or rq_cs like '%" + s[i] + "%'";
		}
		for (int i = 0; i < s.length; i++) {
			sql += " or dh_bg like '%" + s[i] + "%'";
		}
		for (int i = 0; i < s.length; i++) {
			sql += " or sj like '%" + s[i] + "%'";
		}
		for (int i = 0; i < s.length; i++) {
			sql += " or xcshy like '%" + s[i] + "%'";
		}
		for (int i = 0; i < s.length; i++) {
			sql += " or bz like '%" + s[i] + "%'";
		}
		for (int i = 0; i < s.length; i++) {
			sql += " or gjc like '%" + s[i] + "%'";
		}
		for (int i = 0; i < s.length; i++) {
			sql += " or byyx like '%" + s[i] + "%'";
		}
		for (int i = 0; i < s.length; i++) {
			sql += " or yjfx like '%" + s[i] + "%'";
		}
		for (int i = 0; i < s.length; i++) {
			sql += " or yslb like '%" + s[i] + "%'";
		}
		for (int i = 0; i < s.length; i++) {
			sql += " or username like '%" + s[i] + "%'";
		}
		sql+=")";
		System.out.println("CountSql:"+sql);
		return (int) qr.query(sql, new ScalarHandler());
	}

	@Override
	public List<zjxx> getByKey(zjxxPagingBean page) throws Exception {

		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select top " + page.getPageSize() + " * from zjrck where";
		String sql1 = "";

		String s[] = new String[page.getXm().length()];
		s = page.getXm().split("");

		if (s.length <= 1) {
			sql += " (xm like '%" + s[0] + "%'";
			sql1 += " (xm like '%" + s[0] + "%'";
		} else {
			sql += " (xm like '%" + s[0] + "%'";
			sql1 += " (xm like '%" + s[0] + "%'";
			for (int i = 1; i < s.length; i++) {
				sql += " or xm like '%" + s[i] + "%'";
				sql1 += " or xm like '%" + s[i] + "%'";
			}
		}

		for (int i = 0; i < s.length; i++) {
			sql += " or mc_szs like '%" + s[i] + "%'";
			sql1 += " or mc_szs like '%" + s[i] + "%'";
		}
		for (int i = 0; i < s.length; i++) {
			sql += " or xb like '%" + s[i] + "%'";
			sql1 += " or xb like '%" + s[i] + "%'";
		}
		for (int i = 0; i < s.length; i++) {
			sql += " or gj like '%" + s[i] + "%'";
			sql1 += " or gj like '%" + s[i] + "%'";
		}
		for (int i = 0; i < s.length; i++) {
			sql += " or zc_zy like '%" + s[i] + "%'";
			sql1 += " or zc_zy like '%" + s[i] + "%'";
		}
		for (int i = 0; i < s.length; i++) {
			sql += " or xl like '%" + s[i] + "%'";
			sql1 += " or xl like '%" + s[i] + "%'";
		}
		for (int i = 0; i < s.length; i++) {
			sql += " or xw like '%" + s[i] + "%'";
			sql1 += " or xw like '%" + s[i] + "%'";
		}
		for (int i = 0; i < s.length; i++) {
			sql += " or dw_gz like '%" + s[i] + "%'";
			sql1 += " or dw_gz like '%" + s[i] + "%'";
		}
		for (int i = 0; i < s.length; i++) {
			sql += " or ch like '%" + s[i] + "%'";
			sql1 += " or ch like '%" + s[i] + "%'";
		}
		for (int i = 0; i < s.length; i++) {
			sql += " or ch_qt like '%" + s[i] + "%'";
			sql1 += " or ch_qt like '%" + s[i] + "%'";
		}
		for (int i = 0; i < s.length; i++) {
			sql += " or xkly like '%" + s[i] + "%'";
			sql1 += " or xkly like '%" + s[i] + "%'";
		}
		for (int i = 0; i < s.length; i++) {
			sql += " or rq_cs like '%" + s[i] + "%'";
			sql1 += " or rq_cs like '%" + s[i] + "%'";
		}
		for (int i = 0; i < s.length; i++) {
			sql += " or dh_bg like '%" + s[i] + "%'";
			sql1 += " or dh_bg like '%" + s[i] + "%'";
		}
		for (int i = 0; i < s.length; i++) {
			sql += " or sj like '%" + s[i] + "%'";
			sql1 += " or sj like '%" + s[i] + "%'";
		}
		for (int i = 0; i < s.length; i++) {
			sql += " or xcshy like '%" + s[i] + "%'";
			sql1 += " or xcshy like '%" + s[i] + "%'";
		}
		for (int i = 0; i < s.length; i++) {
			sql += " or bz like '%" + s[i] + "%'";
			sql1 += " or bz like '%" + s[i] + "%'";
		}
		for (int i = 0; i < s.length; i++) {
			sql += " or gjc like '%" + s[i] + "%'";
			sql1 += " or gjc like '%" + s[i] + "%'";
		}
		for (int i = 0; i < s.length; i++) {
			sql += " or byyx like '%" + s[i] + "%'";
			sql1 += " or byyx like '%" + s[i] + "%'";
		}
		for (int i = 0; i < s.length; i++) {
			sql += " or yjfx like '%" + s[i] + "%'";
			sql1 += " or yjfx like '%" + s[i] + "%'";
		}
		for (int i = 0; i < s.length; i++) {
			sql += " or yslb like '%" + s[i] + "%'";
			sql1 += " or yslb like '%" + s[i] + "%'";
		}
		for (int i = 0; i < s.length; i++) {
			sql += " or username like '%" + s[i] + "%'";
			sql1 += " or username like '%" + s[i] + "%'";
		}

		sql1 += ") order by id desc";

		sql += " )and id not in (select top " + (page.getCurrentPage() - 1) * page.getPageSize()
				+ " id from zjrck where " + sql1 + ")";
		sql += " order by id desc";
		System.out.println("sql:" + sql);

		return qr.query(sql, new BeanListHandler<>(zjxx.class));

	}

}
