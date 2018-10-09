package sist.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import own.dome.sqlutils.SQLUtil;
import own.dome.sqlutils.SQLUtil.SQLFactory;
import sist.bean.CoopSitePage;
import sist.dao.CoopSiteDao;
import sist.domain.CoopSite;
import sist.utils.DataSourceUtils;

public class CoopSiteDaoImp implements CoopSiteDao {

	@Override
	public CoopSite findSiteById(Integer id) {
		String sql = "select * from hzzd where id=?";
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		try {
			CoopSite list = runner.query(sql, new BeanHandler<>(CoopSite.class),id);
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	public boolean addSite(CoopSite site) {
		SQLFactory factory = own.dome.sqlutils.SQLUtil.getSQLFactory(site);
		factory.setField("hits", 0);
		String sql = factory.insertPreSql();
		Object[] params = factory.getParams();
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
//		System.out.println(sql);
//		System.out.println(Arrays.toString(params));
		try {
			int i = runner.update(sql, params);
			return i > 0;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	public boolean updateSite(CoopSite site) {
		SQLFactory factory = SQLUtil.getSQLFactory(site);
		String sql = factory.updateSql();
		System.out.println(sql);
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		try {
			int i = runner.update(sql);
			return i > 0;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<CoopSite> getList(CoopSitePage sitePage) {
		StringBuffer sb = new StringBuffer();
		StringBuffer sub = new StringBuffer();
		List<Object> params1 = new ArrayList<>();
		List<Object> params2 = new ArrayList<>();
		
		if (sitePage!=null) {
			int currentPage = sitePage.getCurrentPage();
            int pageSize = sitePage.getPageSize();
            sb.append("select top ").append(pageSize).append(" id,name,link,type,hits as hites,date ").append("from hzzd ");
            sub.append("select top ").append((currentPage - 1) * pageSize).append(" id ").append("from hzzd ");
            boolean f = true;
            String siteName = sitePage.getSiteName();
            if(siteName != null && !siteName.trim().isEmpty())
            {
                if(f)
                {
                    sb.append("where ");
                    sub.append("where ");
                    f = false;
                } else
                {
                    sb.append("and ");
                    sub.append("and ");
                }
                sb.append("name like ? ");
                sub.append("name like ? ");
                params1.add((new StringBuilder("%")).append(siteName).append("%").toString());
                params2.add((new StringBuilder("%")).append(siteName).append("%").toString());
            }
            String siteLink = sitePage.getSiteLink();
            if(siteLink != null && !siteLink.trim().isEmpty())
            {
                if(f)
                {
                    sb.append("where ");
                    sub.append("where ");
                    f = false;
                } else
                {
                    sb.append("and ");
                    sub.append("and ");
                }
                sb.append("link like ? ");
                sub.append("link like ? ");
                params1.add((new StringBuilder("%")).append(siteLink).append("%").toString());
                params2.add((new StringBuilder("%")).append(siteLink).append("%").toString());
            }
            String type = sitePage.getType();
            if(type != null && !type.isEmpty())
            {
                if(f)
                {
                    sb.append("where ");
                    sub.append("where ");
                    f = false;
                } else
                {
                    sb.append("and ");
                    sub.append("and ");
                }
                sb.append("type = ? ");
                sub.append("type = ? ");
                params1.add(type);
                params2.add(type);
            }
            String startTime = sitePage.getStartTime();
            if(startTime != null && !startTime.isEmpty())
            {
                if(f)
                {
                    sb.append("where ");
                    sub.append("where ");
                    f = false;
                } else
                {
                    sb.append("and ");
                    sub.append("and ");
                }
                sb.append("date >= ? ");
                sub.append("date >= ? ");
                params1.add(startTime);
                params2.add(startTime);
            }
            String endTime = sitePage.getEndTime();
            if(endTime != null && !endTime.isEmpty())
            {
                if(f)
                {
                    sb.append("where ");
                    sub.append("where ");
                    f = false;
                } else
                {
                    sb.append("and ");
                    sub.append("and ");
                }
                sb.append("date <= ? ");
                sub.append("date <= ? ");
                params1.add(endTime);
                params2.add(endTime);
            }
            if(f)
            {
                sb.append("where ");
                f = false;
            } else
            {
                sb.append("and ");
            }
            sb.append("id not in (").append(sub.append("order by date desc,id asc")).append(") order by date desc,id asc");
            params1.addAll(params2);
		}else{
			sb.append("select * from hzzd");
		}
		Object[] param = params1.toArray();
//		System.out.println(sb);
//		System.out.println(Arrays.toString(param));
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		try {
			List<CoopSite> list = runner.query(sb.toString(), new BeanListHandler<>(CoopSite.class),param);
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	public int getCount(CoopSitePage sitePage) {
		
		StringBuffer sb = new StringBuffer();
		List<Object> param = new ArrayList<>();
		boolean isWhere = true;
		sb.append("select count(*) count from hzzd ");
		String siteName = sitePage.getSiteName();
		if(siteName!=null && !siteName.trim().isEmpty())
		{
			if(isWhere)
			{
				sb.append("where ");
				isWhere = false;
			}
			else
				sb.append("and ");
			sb.append("name like ? ");
			param.add("%"+siteName+"%");
		}
		String siteLink = sitePage.getSiteLink();
		if(siteLink!=null && !siteLink.trim().isEmpty())
		{
			if(isWhere)
			{
				sb.append("where ");
				isWhere = false;
			}
			else
				sb.append("and ");
			sb.append("link like ? ");
			param.add("%"+siteLink+"%");
		}
		String type = sitePage.getType();
		if(type!=null&&!type.trim().isEmpty()){
			if(isWhere)
			{
				sb.append("where ");
				isWhere = false;
			}
			else
				sb.append("and ");
			sb.append("type like ?");
			param.add("%"+type+"%");
			
		}
//		System.out.println(sb);
//		System.out.println(Arrays.toString(param.toArray()));
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		try {
			Object object = runner.query(sb.toString(), new ScalarHandler(), param.toArray());
			return Integer.parseInt(object.toString());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	public CoopSite getCoopSite(int id) {
		String sql = "select * from hzzd where id=?";
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		try {
			return runner.query(sql, new BeanHandler<>(CoopSite.class), id);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	public boolean delById(int id) {
		String sql = "delete from hzzd where id=?";
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		try {
			int i = runner.update(sql,id);
			return i > 0;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	public CoopSite getByName(String name) {
		String sql = "select * from hzzd where name=?";
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		try {
			CoopSite l = runner.query(sql, new BeanHandler<>(CoopSite.class),name);
			return l;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

}
