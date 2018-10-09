package sist.dao.impl;

import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import sist.bean.qyxqPagingBean;
import sist.dao.qyxqDao;
import sist.domain.jsxq;
import sist.utils.DataSourceUtils;

public class qyxqDaoImpl implements qyxqDao {
	@Override
	public void add(jsxq j) throws Exception {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "insert into JSXQK (MC,LY_JS,HZFS,Email,MC_DW,DZ_DW,LXR,DH_LX,YT_TR,GJC,NR_XQ,JJ_DW,RCXX,ZJXX,XMZK,TIME,username,shyj,sh,hits) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		qr.update(sql, j.getMc(), j.getLy_js(), j.getHzfs(), j.getEmail(), j.getMc_dw(), j.getDz_dw(), j.getLxr(),
				j.getDh_lx(), j.getYt_tr(), j.getGjc(), j.getNr_xq(), j.getJj_dw(), j.getRcxx(), j.getZjxx(),
				j.getXmzk(), j.getTime(), j.getUsername(), j.getShyj(), j.getSh(), 0);
	}

	@Override
	public jsxq checkMc(String jsxqmc) throws Exception {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from JSXQK where mc=?";
		return qr.query(sql, new BeanHandler<>(jsxq.class), jsxqmc);
	}

	/**
	 * 获取审核和退回的信息
	 */
	@Override
	public List<jsxq> getShList(qyxqPagingBean page) throws Exception {
		String sql1 = "";

		System.out.println(page.toString());
		System.out.println(page.getCurrentPage());

		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select top " + page.getPageSize() + " * from JSXQK where 1=1";
		if (null != page.getMc() && !"".equals(page.getMc())) {
			sql += " and MC like '%" + page.getMc() + "%'";
			sql1 += " and MC like '%" + page.getMc() + "%'";
		}
		if (null != page.getSh() && !"".equals(page.getSh())) {
			sql += " and sh =" + page.getSh();
			sql1 += " and sh =" + page.getSh();
		} else {
			sql += " and sh !=1 ";
			sql1 += " and sh !=1 ";
		}
		if (null != page.getNr_xq() && !"".equals(page.getNr_xq())) {
			sql += " and NR_XQ like '%" + page.getNr_xq() + "%'";
			sql1 += " and NR_XQ like '%" + page.getNr_xq() + "%'";
		}
		if (null != page.getTime1() && !"".equals(page.getTime1())) {
			sql += "and convert(varchar(10),time,120)>='" + page.getTime1() + "'";
			sql1 += "and convert(varchar(10),time,120)>='" + page.getTime1() + "'";
		}
		if (null != page.getTime2() && !"".equals(page.getTime2())) {
			sql += "and convert(varchar(10),time,120)<='" + page.getTime2() + "'";
			sql1 += "and convert(varchar(10),time,120)<='" + page.getTime2() + "'";
		}
		if (null != page.getJsssly() && !"".equals(page.getJsssly())) {
			sql += " and '" + page.getJsssly() + "' in ( SELECT items from dbo.Split(ly_js,','))";
			sql1 += " and '" + page.getJsssly() + "' in ( SELECT items from dbo.Split(ly_js,','))";
		}
		sql1 += " order by time desc";

		sql += " and id not in (select top " + (page.getCurrentPage() - 1) * page.getPageSize()
				+ " id from JSXQK where 1=1" + sql1 + ")";
		sql += " order by time desc";
		System.out.println("getsql:" + sql);
		return qr.query(sql, new BeanListHandler<>(jsxq.class));
	}

	/**
	 * 统计审核的信息
	 */
	@Override
	public int countSh(qyxqPagingBean page) throws Exception {

		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select count(*) from JSXQK where 1=1";
		if (null != page.getMc() && !"".equals(page.getMc())) {
			sql += " and MC like '%" + page.getMc() + "%'";
		}
		if (null != page.getSh() && !"".equals(page.getSh())) {
			sql += " and sh =" + page.getSh();
		} else if (null == page.getSh() && !"".equals(page.getSh())) {
			sql += " and sh !=1 ";
		}
		if (null != page.getNr_xq() && !"".equals(page.getNr_xq())) {
			sql += " and NR_XQ like '%" + page.getNr_xq() + "%'";
		}
		if (null != page.getTime1() && !"".equals(page.getTime1())) {
			sql += "and convert(varchar(10),time,120)>='" + page.getTime1() + "'";
		}
		if (null != page.getTime2() && !"".equals(page.getTime2())) {
			sql += "and convert(varchar(10),time,120)<='" + page.getTime2() + "'";
		}
		if (null != page.getJsssly() && !"".equals(page.getJsssly())) {
			sql += " and '" + page.getJsssly() + "' in ( SELECT items from dbo.Split(ly_js,','))";
		}
		System.out.println("countsql:" + sql);
		return (int) qr.query(sql, new ScalarHandler());
	}

	/**
	 * 统计已审核的信息
	 * 
	 * @param page
	 * @return
	 * @throws Exception
	 */
	@Override
	public int countGl(qyxqPagingBean page) throws Exception {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select count(*) from JSXQK where 1=1";
		if (null != page.getMc() && !"".equals(page.getMc())) {
			sql += " and MC like '%" + page.getMc() + "%'";
		}
		sql += " and sh =1 ";
		if (null != page.getNr_xq() && !"".equals(page.getNr_xq())) {
			sql += " and NR_XQ like '%" + page.getNr_xq() + "%'";
		}
		if (null != page.getTime1() && !"".equals(page.getTime1())) {
			sql += "and convert(varchar(10),time,120)>='" + page.getTime1() + "'";
		}
		if (null != page.getTime2() && !"".equals(page.getTime2())) {
			sql += "and convert(varchar(10),time,120)<='" + page.getTime2() + "'";
		}
		if (null != page.getJsssly() && !"".equals(page.getJsssly())) {
			sql += " and '" + page.getJsssly() + "' in ( SELECT items from dbo.Split(ly_js,','))";
		}
		System.out.println("countsql:" + sql);
		return (int) qr.query(sql, new ScalarHandler());

	}

	/**
	 * 获取已审核的信息
	 * 
	 * @param page
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<jsxq> getGlList(qyxqPagingBean page) throws Exception {
		String sql1 = "";

		System.out.println(page.toString());
		System.out.println(page.getCurrentPage());

		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select top " + page.getPageSize() + " * from JSXQK where 1=1";
		if (null != page.getMc() && !"".equals(page.getMc())) {
			sql += " and MC like '%" + page.getMc() + "%'";
			sql1 += " and MC like '%" + page.getMc() + "%'";
		}

		sql += " and sh =1 ";
		sql1 += " and sh =1 ";
		if (null != page.getNr_xq() && !"".equals(page.getNr_xq())) {
			sql += " and NR_XQ like '%" + page.getNr_xq() + "%'";
			sql1 += " and NR_XQ like '%" + page.getNr_xq() + "%'";
		}
		if (null != page.getTime1() && !"".equals(page.getTime1())) {
			sql += "and convert(varchar(10),time,120)>='" + page.getTime1() + "'";
			sql1 += "and convert(varchar(10),time,120)>='" + page.getTime1() + "'";
		}
		if (null != page.getTime2() && !"".equals(page.getTime2())) {
			sql += "and convert(varchar(10),time,120)<='" + page.getTime2() + "'";
			sql1 += "and convert(varchar(10),time,120)<='" + page.getTime2() + "'";
		}
		if (null != page.getJsssly() && !"".equals(page.getJsssly())) {
			sql += " and '" + page.getJsssly() + "' in ( SELECT items from dbo.Split(ly_js,','))";
			sql1 += " and '" + page.getJsssly() + "' in ( SELECT items from dbo.Split(ly_js,','))";
		}
		sql1 += " order by time desc";

		sql += " and id not in (select top " + (page.getCurrentPage() - 1) * page.getPageSize()
				+ " id from JSXQK where 1=1" + sql1 + ")";
		sql += " order by time desc";
		System.out.println("getsql:" + sql);
		return qr.query(sql, new BeanListHandler<>(jsxq.class));

	}

	/**
	 * 根据id获取需求信息
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@Override
	public jsxq getById(int id) throws Exception {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from JSXQK where id =?";
		return qr.query(sql, new BeanHandler<>(jsxq.class), id);
	}

	/**
	 * 修改信息
	 */
	@Override
	public void update(jsxq j) throws Exception {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "update JSXQK set mc='" + j.getMc() + "',ly_js='" + j.getLy_js() + "',hzfs='" + j.getHzfs()
				+ "',gjc='" + j.getGjc() + "'" + ",nr_xq='" + j.getNr_xq() + "',mc_dw='" + j.getMc_dw() + "',dz_dw='"
				+ j.getDz_dw() + "',lxr='" + j.getLxr() + "',dh_lx='" + j.getDh_lx() + "'," + "email='" + j.getEmail()
				+ "',jj_dw='" + j.getJj_dw() + "',yt_tr='" + j.getYt_tr() + "',xmzk='" + j.getXmzk() + "',rcxx='"
				+ j.getRcxx() + "'," + "zjxx='" + j.getZjxx() + "',time='" + j.getTime() + "',username='"
				+ j.getUsername() + "',sh='" + j.getSh() + "',shyj='" + j.getShyj() + "' where id=" + j.getId();
		qr.update(sql);
	}

	@Override
	public void deleteById(int id) throws Exception {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "delete  from JSXQK where id=?";
		qr.update(sql, id);
	}

	/**
	 * 增加点击量
	 */
	@Override
	public void addHits(int id) throws Exception {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "update JSXQK set hits = hits + 1 where id = " + id;
		qr.update(sql);
	}

	@Override
	public List<jsxq> getListByUser(qyxqPagingBean page, String username) throws Exception {
		String sql1 = "";

		System.out.println(page.toString());
		System.out.println(page.getCurrentPage());

		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select top " + page.getPageSize() + " * from JSXQK where 1=1";
		if (null != page.getMc() && !"".equals(page.getMc())) {
			sql += " and MC like '%" + page.getMc() + "%'";
			sql1 += " and MC like '%" + page.getMc() + "%'";
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

		sql += " and id not in (select top " + (page.getCurrentPage() - 1) * page.getPageSize()
				+ " id from JSXQK where 1=1" + sql1 + ")";
		sql += " order by time desc";
		System.out.println("getsql:" + sql);
		return qr.query(sql, new BeanListHandler<>(jsxq.class));

	}

	@Override
	public int countByUser(qyxqPagingBean page, String username) throws Exception {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select count(*) from JSXQK where 1=1";
		if (null != page.getMc() && !"".equals(page.getMc())) {
			sql += " and MC like '%" + page.getMc() + "%'";
		}
		if (null != page.getTime1() && !"".equals(page.getTime1())) {
			sql += "and convert(varchar(10),time,120)>='" + page.getTime1() + "'";
		}
		if (null != page.getTime2() && !"".equals(page.getTime2())) {
			sql += "and convert(varchar(10),time,120)<='" + page.getTime2() + "'";
		}
		sql += " and username='" + username + "'";
		System.out.println("countsql:" + sql);
		return (int) qr.query(sql, new ScalarHandler());
	}

	@Override
	public List<jsxq> getTop(int topSize) throws Exception {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select top " + topSize + " * from JSXQK order by time desc";
		return qr.query(sql, new BeanListHandler<>(jsxq.class));
	}

	@Override
	public int countByKey(qyxqPagingBean page) throws Exception {

		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select count(*) from JSXQK where";

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
			sql += " or mc like '%" + s[i] + "%'";
		}
		for (int i = 0; i < s.length; i++) {
			sql += " or hzfs like '%" + s[i] + "%'";
		}
		for (int i = 0; i < s.length; i++) {
			sql += " or gjc like '%" + s[i] + "%'";
		}
		for (int i = 0; i < s.length; i++) {
			sql += " or nr_xq like '%" + s[i] + "%'";
		}
		for (int i = 0; i < s.length; i++) {
			sql += " or mc_dw like '%" + s[i] + "%'";
		}
		for (int i = 0; i < s.length; i++) {
			sql += " or dz_dw like '%" + s[i] + "%'";
		}
		for (int i = 0; i < s.length; i++) {
			sql += " or lxr like '%" + s[i] + "%'";
		}
		for (int i = 0; i < s.length; i++) {
			sql += " or dh_lx like '%" + s[i] + "%'";
		}
		for (int i = 0; i < s.length; i++) {
			sql += " or email like '%" + s[i] + "%'";
		}
		for (int i = 0; i < s.length; i++) {
			sql += " or jj_dw like '%" + s[i] + "%'";
		}
		for (int i = 0; i < s.length; i++) {
			sql += " or yt_tr like '%" + s[i] + "%'";
		}
		for (int i = 0; i < s.length; i++) {
			sql += " or xmzk like '%" + s[i] + "%'";
		}
		for (int i = 0; i < s.length; i++) {
			sql += " or rcxx like '%" + s[i] + "%'";
		}
		for (int i = 0; i < s.length; i++) {
			sql += " or zjxx like '%" + s[i] + "%'";
		}
		for (int i = 0; i < s.length; i++) {
			sql += " or time like '%" + s[i] + "%'";
		}
		for (int i = 0; i < s.length; i++) {
			sql += " or username like '%" + s[i] + "%'";
		}
		sql+=")";
		System.out.println("countSql:" + sql);

		return (int) qr.query(sql, new ScalarHandler());
	}

	@Override
	public List<jsxq> getByKey(qyxqPagingBean page) throws Exception {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select top " + page.getPageSize() + " * from JSXQK where ";
		String sql1 = "";

		String s[] = new String[page.getMc().length()];
		s = page.getMc().split("");

		if (s.length <= 1) {
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
			sql += " or hzfs like '%" + s[i] + "%'";
			sql1 += " or hzfs like '%" + s[i] + "%'";
		}
		for (int i = 0; i < s.length; i++) {
			sql += " or gjc like '%" + s[i] + "%'";
			sql1 += " or gjc like '%" + s[i] + "%'";
		}
		for (int i = 0; i < s.length; i++) {
			sql += " or nr_xq like '%" + s[i] + "%'";
			sql1 += " or nr_xq like '%" + s[i] + "%'";
		}
		for (int i = 0; i < s.length; i++) {
			sql += " or mc_dw like '%" + s[i] + "%'";
			sql1 += " or mc_dw like '%" + s[i] + "%'";
		}
		for (int i = 0; i < s.length; i++) {
			sql += " or dz_dw like '%" + s[i] + "%'";
			sql1 += " or dz_dw like '%" + s[i] + "%'";
		}
		for (int i = 0; i < s.length; i++) {
			sql += " or lxr like '%" + s[i] + "%'";
			sql1 += " or lxr like '%" + s[i] + "%'";
		}
		for (int i = 0; i < s.length; i++) {
			sql += " or dh_lx like '%" + s[i] + "%'";
			sql1 += " or dh_lx like '%" + s[i] + "%'";
		}
		for (int i = 0; i < s.length; i++) {
			sql += " or email like '%" + s[i] + "%'";
			sql1 += " or email like '%" + s[i] + "%'";
		}
		for (int i = 0; i < s.length; i++) {
			sql += " or jj_dw like '%" + s[i] + "%'";
			sql1 += " or jj_dw like '%" + s[i] + "%'";
		}
		for (int i = 0; i < s.length; i++) {
			sql += " or yt_tr like '%" + s[i] + "%'";
			sql1 += " or yt_tr like '%" + s[i] + "%'";
		}
		for (int i = 0; i < s.length; i++) {
			sql += " or xmzk like '%" + s[i] + "%'";
			sql1 += " or xmzk like '%" + s[i] + "%'";
		}
		for (int i = 0; i < s.length; i++) {
			sql += " or rcxx like '%" + s[i] + "%'";
			sql1 += " or rcxx like '%" + s[i] + "%'";
		}
		for (int i = 0; i < s.length; i++) {
			sql += " or zjxx like '%" + s[i] + "%'";
			sql1 += " or zjxx like '%" + s[i] + "%'";
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
				+ " id from JSXQK where " + sql1 + ")";
		sql += " order by time desc";
		System.out.println("sql:" + sql);
		return qr.query(sql, new BeanListHandler<>(jsxq.class));
	}

}
