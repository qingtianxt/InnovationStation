package sist.dao.impl;

import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import sist.bean.kjcgPagingBean;
import sist.dao.kjcgDao;
import sist.domain.jsxq;
import sist.domain.kjcg;
import sist.utils.DataSourceUtils;

public class kjcgDaoImpl implements kjcgDao {

	@Override
	public void add(kjcg k) throws Exception {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "insert into KJCG (KM,MC,Time,DW,username,hits) values(?,?,?,?,?,?)";
		qr.update(sql, k.getKm(), k.getMc(), k.getTime(), k.getDw(), k.getUsername(),0);
	}

	/**
	 * 根据条件查询总数量
	 */
	@Override
	public int count(kjcgPagingBean page) throws Exception {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select count(*) from kjcg where 1=1";
		if (null != page.getMc() && !"".equals(page.getMc())) {
			sql += "and mc like '%" + page.getMc() + "%'";
		}
		if (null != page.getKm() && !"".equals(page.getKm())) {
			sql += " and km like '%" + page.getKm() + "%'";
		}
		if (null != page.getDw() && !"".equals(page.getDw())) {
			sql += " and dw like '%" + page.getDw() + "%'";
		}
		if (null != page.getTime1() && !"".equals(page.getTime1())) {
			sql += "and convert(varchar(10),time,120)>='" + page.getTime1() + "'";
		}
		if (null != page.getTime2() && !"".equals(page.getTime2())) {
			sql += "and convert(varchar(10),time,120)<='" + page.getTime2() + "'";
		}
		System.out.println("countsql:" + sql);
		return (int) qr.query(sql, new ScalarHandler());
	}

	/**
	 * 根据条件分页获取科技成果信息。
	 */
	@Override
	public List<kjcg> getByPage(kjcgPagingBean page) throws Exception {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select top " + page.getPageSize() + " * from kjcg where 1=1 ";
		String sql1 = "";

		if (null != page.getMc() && !"".equals(page.getMc())) {
			sql += "and mc like '%" + page.getMc() + "%'";
			sql1 += "and mc like '%" + page.getMc() + "%'";
		}
		if (null != page.getKm() && !"".equals(page.getKm())) {
			sql += " and km like '%" + page.getKm() + "%'";
			sql1 += " and km like '%" + page.getKm() + "%'";
		}
		if (null != page.getDw() && !"".equals(page.getDw())) {
			sql += " and dw like '%" + page.getDw() + "%'";
			sql1 += " and dw like '%" + page.getDw() + "%'";
		}
		if (null != page.getTime1() && !"".equals(page.getTime1())) {
			sql += "and convert(varchar(10),time,120)>='" + page.getTime1() + "'";
			sql1 += "and convert(varchar(10),time,120)>='" + page.getTime1() + "'";
		}
		if (null != page.getTime2() && !"".equals(page.getTime2())) {
			sql += "and convert(varchar(10),time,120)<='" + page.getTime2() + "'";
			sql1 += "and convert(varchar(10),time,120)<='" + page.getTime2() + "'";
		}
		sql1 += " order by time desc";

		sql += " and mc not in (select top " + (page.getCurrentPage() - 1) * page.getPageSize()
				+ " mc from kjcg where 1=1" + sql1 + ")";
		sql += " order by time desc";
		System.out.println("getsql:" + sql);
		return qr.query(sql, new BeanListHandler<>(kjcg.class));
	}

	/**
	 * 根据名称获取科技成果信息
	 */
	@Override
	public kjcg getByMc(String mc) throws Exception {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select *  from kjcg where mc =?";
		return qr.query(sql, new BeanHandler<>(kjcg.class), mc);
	}

	/**
	 * 根据名称删除科技成果信息
	 */
	@Override
	public void delete(String id) throws Exception {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "delete from kjcg where id = ?";
		qr.update(sql, id);
	}

	@Override
	public kjcg getById(int id) throws Exception {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from kjcg where id = ?";
		return qr.query(sql, new BeanHandler<>(kjcg.class), id);
	}

	/**
	 * 修改科技成果
	 */
	@Override
	public void update(kjcg k) throws Exception {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "update kjcg set km='" + k.getKm() + "',mc='" + k.getMc() + "',time='" + k.getTime() + "',dw='"
				+ k.getDw() + "',username='" + k.getUsername() + "' where id=" + k.getId();
		System.out.println(sql);
		qr.update(sql);
	}

	@Override
	public int countByUser(kjcgPagingBean page, String username) throws Exception {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select count(*) from kjcg where 1=1";
		if (null != page.getMc() && !"".equals(page.getMc())) {
			sql += "and mc like '%" + page.getMc() + "%'";
		}
		if (null != page.getTime1() && !"".equals(page.getTime1())) {
			sql += "and convert(varchar(10),time,120)>='" + page.getTime1() + "'";
		}
		if (null != page.getTime2() && !"".equals(page.getTime2())) {
			sql += "and convert(varchar(10),time,120)<='" + page.getTime2() + "'";
		}
		sql+=" and username='"+username+"'";
		System.out.println("countsql:" + sql);
		return (int) qr.query(sql, new ScalarHandler());
	}

	@Override
	public List<kjcg> getByPageAndUser(kjcgPagingBean page, String username) throws Exception {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select top " + page.getPageSize() + " * from kjcg where 1=1 ";
		String sql1 = "";

		if (null != page.getMc() && !"".equals(page.getMc())) {
			sql += "and mc like '%" + page.getMc() + "%'";
			sql1 += "and mc like '%" + page.getMc() + "%'";
		}
		if (null != page.getTime1() && !"".equals(page.getTime1())) {
			sql += "and convert(varchar(10),time,120)>='" + page.getTime1() + "'";
			sql1 += "and convert(varchar(10),time,120)>='" + page.getTime1() + "'";
		}
		if (null != page.getTime2() && !"".equals(page.getTime2())) {
			sql += "and convert(varchar(10),time,120)<='" + page.getTime2() + "'";
			sql1 += "and convert(varchar(10),time,120)<='" + page.getTime2() + "'";
		}
		sql += " and username='" + username + "'";
		sql1 += " and username='" + username + "'";
		sql1 += " order by time desc";

		sql += " and mc not in (select top " + (page.getCurrentPage() - 1) * page.getPageSize()
				+ " mc from kjcg where 1=1" + sql1 + ")";
		sql += " order by time desc";
		System.out.println("getsql:" + sql);
		return qr.query(sql, new BeanListHandler<>(kjcg.class));
	}

	@Override
	public void addHits(int id) throws Exception {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "update kjcg set hits = hits + 1 where id = " + id;
		qr.update(sql);
	}

	@Override
	public List<kjcg> getTop(int topsize) throws Exception {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select top "+topsize+" * from kjcg order by time desc";
		return qr.query(sql,new BeanListHandler<>(kjcg.class));
	}

	@Override
	public int countByKey(kjcgPagingBean page) throws Exception {

		
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select count(*) from cgzhxmk where";

		String s[] = new String[page.getMc().length()];
		s = page.getMc().split("");

		if (s.length <= 1) {
			sql += " (mc like '%" + s[0] + "%'";
		} else {
			sql += " (mc like '%" + s[0] + "%'";
			for (int i = 1; i < s.length; i++) {
				sql += " or mc like '%" + s[i] + "%'";
			}
		}
		for (int i = 0; i < s.length; i++) {
			sql += " or djh like '%" + s[i] + "%'";
		}
		for (int i = 0; i < s.length; i++) {
			sql += " or djrq like '%" + s[i] + "%'";
		}
		for (int i = 0; i < s.length; i++) {
			sql += " or cglb like '%" + s[i] + "%'";
		}
		for (int i = 0; i < s.length; i++) {
			sql += " or dw like '%" + s[i] + "%'";
		}
		for (int i = 0; i < s.length; i++) {
			sql += " or xs like '%" + s[i] + "%'";
		}
		for (int i = 0; i < s.length; i++) {
			sql += " or jslb like '%" + s[i] + "%'";
		}
		for (int i = 0; i < s.length; i++) {
			sql += " or jd like '%" + s[i] + "%'";
		}
		for (int i = 0; i < s.length; i++) {
			sql += " or sp like '%" + s[i] + "%'";
		}
		
		for (int i = 0; i < s.length; i++) {
			sql += " or yyhy like '%" + s[i] + "%'";
		}
		for (int i = 0; i < s.length; i++) {
			sql += " or yyzt like '%" + s[i] + "%'";
		}
		for (int i = 0; i < s.length; i++) {
			sql += " or lxr like '%" + s[i] + "%'";
		}
		for (int i = 0; i < s.length; i++) {
			sql += " or dh like '%" + s[i] + "%'";
		}
		for (int i = 0; i < s.length; i++) {
			sql += " or cgsx like '%" + s[i] + "%'";
		}
		for (int i = 0; i < s.length; i++) {
			sql += " or dz like '%" + s[i] + "%'";
		}
		for (int i = 0; i < s.length; i++) {
			sql += " or gbnr like '%" + s[i] + "%'";
		}
		for (int i = 0; i < s.length; i++) {
			sql += " or nf like '%" + s[i] + "%'";
		}
		for (int i = 0; i < s.length; i++) {
			sql += " or hxzl like '%" + s[i] + "%'";
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
		sql+=")";
		System.out.println("Countsql:"+sql);
	
		return (int) qr.query(sql, new ScalarHandler());
	}

	@Override
	public List<kjcg> getByKey(kjcgPagingBean page) throws Exception {
		
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select top " + page.getPageSize() + " * from cgzhxmk where";
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
			sql += " or djh like '%" + s[i] + "%'";
			sql1 += " or djh like '%" + s[i] + "%'";
		}
		for (int i = 0; i < s.length; i++) {
			sql += " or djrq like '%" + s[i] + "%'";
			sql1 += " or djrq like '%" + s[i] + "%'";
		}
		for (int i = 0; i < s.length; i++) {
			sql += " or cglb like '%" + s[i] + "%'";
			sql1 += " or cglb like '%" + s[i] + "%'";
		}
		for (int i = 0; i < s.length; i++) {
			sql += " or dw like '%" + s[i] + "%'";
			sql1 += " or dw like '%" + s[i] + "%'";
		}
		for (int i = 0; i < s.length; i++) {
			sql += " or xs like '%" + s[i] + "%'";
			sql1 += " or xs like '%" + s[i] + "%'";
		}
		for (int i = 0; i < s.length; i++) {
			sql += " or jslb like '%" + s[i] + "%'";
			sql1 += " or jslb like '%" + s[i] + "%'";
		}
		for (int i = 0; i < s.length; i++) {
			sql += " or jd like '%" + s[i] + "%'";
			sql1 += " or jd like '%" + s[i] + "%'";
		}
		for (int i = 0; i < s.length; i++) {
			sql += " or sp like '%" + s[i] + "%'";
			sql1 += " or sp like '%" + s[i] + "%'";
		}
		
		for (int i = 0; i < s.length; i++) {
			sql += " or yyhy like '%" + s[i] + "%'";
			sql1 += " or yyhy like '%" + s[i] + "%'";
		}
		for (int i = 0; i < s.length; i++) {
			sql += " or yyzt like '%" + s[i] + "%'";
			sql1 += " or yyzt like '%" + s[i] + "%'";
		}
		for (int i = 0; i < s.length; i++) {
			sql += " or lxr like '%" + s[i] + "%'";
			sql1 += " or lxr like '%" + s[i] + "%'";
		}
		for (int i = 0; i < s.length; i++) {
			sql += " or dh like '%" + s[i] + "%'";
			sql1 += " or dh like '%" + s[i] + "%'";
		}
		for (int i = 0; i < s.length; i++) {
			sql += " or cgsx like '%" + s[i] + "%'";
			sql1 += " or cgsx like '%" + s[i] + "%'";
		}
		for (int i = 0; i < s.length; i++) {
			sql += " or dz like '%" + s[i] + "%'";
			sql1 += " or dz like '%" + s[i] + "%'";
		}
		for (int i = 0; i < s.length; i++) {
			sql += " or gbnr like '%" + s[i] + "%'";
			sql1 += " or gbnr like '%" + s[i] + "%'";
		}
		for (int i = 0; i < s.length; i++) {
			sql += " or nf like '%" + s[i] + "%'";
			sql1 += " or nf like '%" + s[i] + "%'";
		}
		for (int i = 0; i < s.length; i++) {
			sql += " or hxzl like '%" + s[i] + "%'";
			sql1 += " or hxzl like '%" + s[i] + "%'";
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
				+ " id from cgzhxmk where " + sql1 + ")";
		sql += " order by time desc";
		System.out.println("sql:"+sql);
		return qr.query(sql, new BeanListHandler<>(kjcg.class));
	}
	/**
	 * 获取id
	 */
		@Override
		public int getId(String mc) throws Exception {
			QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
			String sql = "select max(id) from CGZHXMK";
			return (int) qr.query(sql, new ScalarHandler());
		}

}
