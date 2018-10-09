// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   NewsDaoImp.java

package sist.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.*;
import sist.bean.*;
import sist.dao.NewsDao;
import sist.domain.NewsBean;
import sist.utils.DataSourceUtils;
import sist.utils.SQLUtil;

public class NewsDaoImp
    implements NewsDao
{

    public NewsDaoImp()
    {
    }

    public NewsBean findById(Integer id)
    {
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        try
        {
            return runner.query("select * from XWGG where id=?", new BeanHandler<>(NewsBean.class), new Object[] {
                id
            });
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public boolean addNews(NewsBean newsBean)
    {
        sist.utils.SQLUtil.SQLFactory factory = SQLUtil.getSQLFactory("XWGG", newsBean, new String[] {
            "id"
        });
        String insertSql = factory.insertSql();
        Object params[] = factory.getParams();
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        try
        {
            int i = runner.update(insertSql, params);
            return i > 0;
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public boolean updateNews(NewsBean newsBean)
    {
        sist.utils.SQLUtil.SQLFactory factory = SQLUtil.getSQLFactory("XWGG", newsBean, new String[] {
            "id"
        });
        String updateSql = factory.updateSql();
        Object params[] = factory.getParams();
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        try
        {
            int i = runner.update(updateSql, params);
            return i > 0;
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public List<NewsBean> getList(PagingBean bena)
    {
        NewsPaging newsPaging = (NewsPaging)bena;
        String sql = (new StringBuilder("select top ")).append(newsPaging.getPageSize()).append(" * from XWGG").toString();
        StringBuffer sb = new StringBuffer();
        Boolean isWhere = Boolean.valueOf(true);
        String title = newsPaging.getQtitle();
        if(title != null && !title.trim().isEmpty())
        {
            whereOrAnd(isWhere, sb);
            isWhere = Boolean.valueOf(false);
            sb.append("title like '%").append(title).append("%'");
        }
        String publisher = newsPaging.getQpublisher();
        if(publisher != null && !publisher.trim().isEmpty())
        {
            whereOrAnd(isWhere, sb);
            isWhere = Boolean.valueOf(false);
            sb.append("publisher like '%").append(publisher).append("%'");
        }
        String type = newsPaging.getQtype();
        if(type != null && !type.trim().isEmpty())
        {
            whereOrAnd(isWhere, sb);
            isWhere = Boolean.valueOf(false);
            sb.append("type = '").append(type).append("'");
        }
        String content = newsPaging.getQcontent();
        if(content != null && !content.trim().isEmpty())
        {
            whereOrAnd(isWhere, sb);
            isWhere = Boolean.valueOf(false);
            sb.append("content like '%").append(content).append("%'");
        }
        String start = newsPaging.getQstart();
        if(start != null && !start.trim().isEmpty())
        {
            whereOrAnd(isWhere, sb);
            isWhere = Boolean.valueOf(false);
            sb.append("time >= '").append(start).append("'");
        }
        String end = newsPaging.getQend();
        if(end != null && !end.trim().isEmpty())
        {
            whereOrAnd(isWhere, sb);
            isWhere = Boolean.valueOf(false);
            sb.append("time <= '").append(end).append("'");
        }
        String str = sb.toString();
        StringBuffer order = new StringBuffer();
        String orderBy2 = newsPaging.getOrderBy();
        String sortBy = newsPaging.getSortBy();
        if(orderBy2!=null&&sortBy!=null&&!orderBy2.trim().isEmpty()&&!sortBy.trim().isEmpty())
        {
        	order.append(orderBy2).append(" ").append(sortBy).append(" , id asc");
        }
        else order.append("id ASC");
        whereOrAnd(isWhere, sb);
        isWhere = Boolean.valueOf(false);
        sb.append("id not in ( select top ").append(newsPaging.getPageSize() * newsPaging.getCurrentPage() - newsPaging.getPageSize()).append(" id from XWGG").append(str).append(" order by ").append(order).append(") order by ").append(order);
        sql = (new StringBuilder(String.valueOf(sql))).append(sb).toString();
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        try
        {
            List<NewsBean> query = runner.query(sql, new BeanListHandler<>(NewsBean.class));
            return query;
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public List<NewsBean> getList(PagingBean s, Integer x)
    {
        NewsPaging newsPaging = (NewsPaging)s;
        String sql = "";
        String qcontent = newsPaging.getQcontent();
        if(qcontent != null && !qcontent.trim().isEmpty())
            sql = (new StringBuilder(String.valueOf(sql))).append(" and content like '%").append(qcontent).append("%'").toString();
        String publisher = newsPaging.getQpublisher();
        if(publisher != null && !publisher.trim().isEmpty())
            sql = (new StringBuilder(String.valueOf(sql))).append(" and publisher like '%").append(publisher).append("%'").toString();
        String tile = newsPaging.getQtitle();
        if(tile != null && !tile.trim().isEmpty())
            sql = (new StringBuilder(String.valueOf(sql))).append(" and title like '%").append(tile).append("%'").toString();
        String type = newsPaging.getQtype();
        if(type != null && !type.trim().isEmpty())
            sql = (new StringBuilder(String.valueOf(sql))).append(" and type='").append(type).append("'").toString();
        String start = newsPaging.getQstart();
        if(start != null && !start.trim().isEmpty())
            sql = (new StringBuilder(String.valueOf(sql))).append(" and time > '").append(start).append("'").toString();
        String end = newsPaging.getQend();
        if(end != null && !end.trim().isEmpty())
            sql = (new StringBuilder(String.valueOf(sql))).append(" and time < '").append(end).append("'").toString();
        sql = (new StringBuilder("select top ")).append(newsPaging.getPageSize()).append(" * from XWGG where 1=1 ").append(sql).append(" and id not in ( select top ").append(newsPaging.getPageSize() * (newsPaging.getCurrentPage() - 1)).append(" id from XWGG where 1=1 ").append(sql).append(" order by time desc,id asc) order by time desc,id asc").toString();
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        try
        {
            return runner.query(sql, new BeanListHandler<>(NewsBean.class));
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public int getCount(PagingBean s)
    {
        NewsPaging newsPaging = (NewsPaging)s;
        String sql = "";
        if(newsPaging != null)
        {
            String qcontent = newsPaging.getQcontent();
            if(qcontent != null && !qcontent.trim().isEmpty())
                sql = (new StringBuilder(String.valueOf(sql))).append(" and content like '%").append(qcontent).append("%'").toString();
            String publisher = newsPaging.getQpublisher();
            if(publisher != null && !publisher.trim().isEmpty())
                sql = (new StringBuilder(String.valueOf(sql))).append(" and publisher like '%").append(publisher).append("%'").toString();
            String tile = newsPaging.getQtitle();
            if(tile != null && !tile.trim().isEmpty())
                sql = (new StringBuilder(String.valueOf(sql))).append(" and title like '%").append(tile).append("%'").toString();
            String type = newsPaging.getQtype();
            if(type != null && !type.trim().isEmpty())
                sql = (new StringBuilder(String.valueOf(sql))).append(" and type='").append(type).append("'").toString();
            String start = newsPaging.getQstart();
            if(start != null && !start.trim().isEmpty())
                sql = (new StringBuilder(String.valueOf(sql))).append(" and time > '").append(start).append("'").toString();
            String end = newsPaging.getQend();
            if(end != null && !end.trim().isEmpty())
                sql = (new StringBuilder(String.valueOf(sql))).append(" and time < '").append(end).append("'").toString();
        }
        sql = (new StringBuilder("select count(*) as count from XWGG where 1=1 ")).append(sql).toString();
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        try
        {
            return runner.query(sql, new ResultSetHandler<Integer>() {

				@Override
				public Integer handle(ResultSet arg0) throws SQLException {
					if(arg0.next())
						return arg0.getInt("count");
					return null;}
				});
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public boolean delById(int id)
    {
        String sql = "delete from XWGG where id=?";
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        try
        {
            int i = runner.update(sql, Integer.valueOf(id));
            return i > 0;
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    private void whereOrAnd(Boolean isWhere, StringBuffer sb)
    {
        if(isWhere.booleanValue())
            sb.append(" where ");
        else
            sb.append(" and ");
        isWhere = Boolean.valueOf(false);
    }

    public List<NewsBean> search(PagingBean keys)
    {
        GlobalSearchPage page = (GlobalSearchPage)keys;
        String sql = (new StringBuilder("select top ")).append(keys.getPageSize()).append(" * from XWGG where (").append(appendWhere(page.getKeys())).append(") and id not in (select top ").append(keys.getCurrentPage() * keys.getPageSize() - keys.getPageSize()).append(" id from xwgg where ").append(appendWhere(page.getKeys())).append(" order by time desc,id asc) order by time desc,id asc").toString();
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        try
        {
            List<NewsBean> list = runner.query(sql, new BeanListHandler<>(NewsBean.class));
            return list;
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    private String getLike(String keys)
    {
        char array[] = keys.toCharArray();
        StringBuffer sb = new StringBuffer("%");
        char ac[];
        int j = (ac = array).length;
        for(int i = 0; i < j; i++)
        {
            char c = ac[i];
            sb.append(c).append("%");
        }

        return sb.toString();
    }

    private String appendWhere(String keys)
    {
        String like = getLike(keys);
        StringBuffer sb = new StringBuffer();
        sb.append("title like '").append(like).append("' ");
        sb.append("or publisher like '").append(like).append("' ");
        sb.append("or type like '").append(like).append("' ");
        sb.append("or content like '").append(like).append("' ");
        return sb.toString();
    }

    public Integer serchCount(PagingBean pagingBean)
    {
        String sql = (new StringBuilder("select count(*) as count from xwgg where ")).append(appendWhere(((GlobalSearchPage)pagingBean).getKeys())).toString();
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        try
        {
            Object query = runner.query(sql, new ScalarHandler());
            return Integer.valueOf(query.toString());
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

	@Override
	public NewsBean getByTitle(String title) {
		String sql = "select * from xwgg where title = ?";
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		try {
			NewsBean newsBean = runner.query(sql, new BeanHandler<>(NewsBean.class),title);
			return newsBean;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
}
