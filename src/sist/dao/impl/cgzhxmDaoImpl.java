package sist.dao.impl;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import sist.dao.cgzhxmDao;
import sist.domain.cgzhxm;
import sist.utils.DataSourceUtils;

public class cgzhxmDaoImpl implements cgzhxmDao {

	@Override
	public cgzhxm getByMc(String mc) throws Exception {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql ="select * from CGZHXMK where mc=?";
		return qr.query(sql, new BeanHandler<>(cgzhxm.class),mc);
	}

	@Override
	public void add(cgzhxm c) throws Exception {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql ="insert into CGZHXMK (mc,djh,djrq,cglb,dw,"
				+ "xs,jslb,jd,sp,yyhy,"
				+ "yyzt,lxr,dh,cgsx,dz,"
				+ "gbnr,nf,hxzl,jsssly,gjc,"
				+ "time,username) values(?,?,?,?,?,"
				+ "?,?,?,?,?,"
				+ "?,?,?,?,?,"
				+ "?,?,?,?,?,"
				+ "?,?)";
		qr.update(sql,c.getMc(),c.getDjh(),c.getDjrq(),c.getCglb(),c.getDw(),
				c.getXs(),c.getJslb(),c.getJd(),c.getSp(),c.getYyhy(),
				c.getYyzt(),c.getLxr(),c.getDh(),c.getCgsx(),c.getDz(),
				c.getGbnr(),c.getNf(),c.getHxzl(),c.getJsssly(),c.getGjc(),
				c.getTime(),c.getUsername());
	}
/**
 * 根据名称删除成果转化项目信息
 */
	@Override
	public void delete(String mc) throws Exception {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql ="delete from CGZHXMK where mc =?";
		qr.update(sql,mc);
	}
/**
 * 根据id获取成果转化项目信息
 */
	@Override
	public cgzhxm getById(int id) throws Exception {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql ="select * from CGZHXMK where id=?";
		return qr.query(sql, new BeanHandler<>(cgzhxm.class),id);
	}
/**
 * 修改成果转化项目
 */
	@Override
	public void update(cgzhxm c) throws Exception {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "update CGZHXMK set mc='"+c.getMc()+"',djh='"+c.getDjh()+"',djrq='"+c.getDjrq()+"',"
				+ "cglb='"+c.getCglb()+"',dw='"+c.getDw()+"',xs='"+c.getXs()+"',jslb='"+c.getJslb()+"',"
						+ "jd='"+c.getJd()+"',sp='"+c.getSp()+"',yyhy='"+c.getYyhy()+"',lxr='"+c.getLxr()+"',"
								+ "dh='"+c.getDh()+"',cgsx='"+c.getCgsx()+"',dz='"+c.getDz()+"',gbnr='"+c.getGbnr()+"',"
										+ "nf='"+c.getNf()+"',hxzl='"+c.getHxzl()+"',jsssly='"+c.getJsssly()+"',gjc='"+c.getGjc()+"',"
												+ "time='"+c.getTime()+"',username='"+c.getUsername()+"' where id="+c.getId();
		qr.update(sql);
	}

}
