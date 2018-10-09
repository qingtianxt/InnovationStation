package sist.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import sist.bean.GlobalSearchPage;
import sist.bean.PagingBean;
import sist.dao.ZtzlxxkDao;
import sist.domain.Ztzlxxk;
import sist.utils.DataSourceUtils;

public class ZtzlxxkDaoImpl implements ZtzlxxkDao {

	@Override
	public List<Ztzlxxk> search(PagingBean page) {
		List<Object> list = new ArrayList<>();
		String sql = null;
		if(page!=null){
			StringBuffer sb = new StringBuffer();
			GlobalSearchPage searchPage = (GlobalSearchPage) page;
			String key = searchPage.getKey();
			if(key!=null && !key.trim().isEmpty()){
				sb.append("(zlmc like ? or flzt like ? or zllb like ? or zlqr like ? or qsrssdy like ? or zlzy like ? or gjz like ? or username like ?)");
				String like = like(key);
				for(int i = 0; i < 16; i++)
					list.add(like);
			}
			String str = sb.toString();
			sql = "select top "+page.getPageSize()+" * from ztzlxxk where "
					+(str.trim().isEmpty()?"1=1":str)+" and id not in (select top "
							+ (page.getCurrentPage()*page.getPageSize()-page.getPageSize())+" id from ztzlxxk where "
									+(str.trim().isEmpty()?"1=1":str)+ " order by sqr desc , id asc ) order by sqr desc , id asc";
		}else{
			sql = "select * from ztzlxxk" ;
		}
		try {
			Connection conn = DataSourceUtils.getDataSource().getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			int size = list.size();
			for(int i = 0; i < size; i++)
			{
				ps.setObject(i+1, list.get(i));
			}
			ResultSet rs = ps.executeQuery();
			List<Ztzlxxk> list2 = new BeanListHandler<>(Ztzlxxk.class).handle(rs);
			DbUtils.closeQuietly(conn, ps, rs);
			return list2;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	public Integer searchCount(PagingBean page) {
		List<Object> list = new ArrayList<>();
		String sql = null;
		if(page!=null){
			StringBuffer sb = new StringBuffer();
			GlobalSearchPage searchPage = (GlobalSearchPage) page;
			String key = searchPage.getKey();
			if(key!=null && !key.trim().isEmpty()){
				sb.append("(zlmc like ? or flzt like ? or zllb like ? or zlqr like ? or qsrssdy like ? or zlzy like ? or gjz like ? or username like ?)");
				String like = like(key);
				for(int i = 0; i < 8; i++)
					list.add(like);System.out.println(sb);
			}
			String str = sb.toString();
			sql = "select count(*) as count from ztzlxxk where "+(str.trim().isEmpty()?"1=1":str);
		}else{
			sql = "select count(*) as count from ztzlxxk" ;
		}
		try {
			System.err.println(sql);
			Connection conn = DataSourceUtils.getDataSource().getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			int size = list.size();
			for(int i = 0; i < size; i++){
				ps.setObject(i+1, list.get(i));
			}
			ResultSet rs = ps.executeQuery();
			int count = 0;
			if(rs.next())
				count = rs.getInt("count");
			DbUtils.closeQuietly(conn, ps, rs);
			return count;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	private String like(String key){
		if(key==null || key.trim().isEmpty())
			return "";
		char[] charArray = key.toCharArray();
		StringBuffer sb = new StringBuffer();
		for (char c : charArray) {
			sb.append("%").append(c);
		}
		sb.append("%");
		return sb.toString();
	}
}
