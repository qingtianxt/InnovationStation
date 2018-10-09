package sist.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import sist.bean.NewsPhotoPage;
import sist.dao.NewsPhotoDao;
import sist.domain.NewsPhoto;
import sist.utils.DataSourceUtils;
import sist.utils.SQLUtil;
import sist.utils.SQLUtil.SQLFactory;

public class NewsPhotoDaoImp implements NewsPhotoDao {

	/* (non-Javadoc)
	 * @see sist.dao.NewsPhotoDao#findNewsPhoto(java.lang.Integer)
	 */
	@Override
	public NewsPhoto findNewsPhoto(Integer id) {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		try {
			return runner.query("select * from news_photo where id=?", new BeanHandler<NewsPhoto>(NewsPhoto.class),id);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	/* (non-Javadoc)
	 * @see sist.dao.NewsPhotoDao#addNewsPhoto(sist.domain.NewsPhoto)
	 */
	@Override
	public boolean addNewsPhoto(NewsPhoto newsPhoto) {
		SQLFactory factory = SQLUtil.getSQLFactory("news_photo",newsPhoto, "id");
		String sql = factory.insertSql();
		Object[] params = factory.getParams();
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		try {
			int i = runner.update(sql, params);
			return i > 0;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	/* (non-Javadoc)
	 * @see sist.dao.NewsPhotoDao#updateNewsPhoto(sist.domain.NewsPhoto)
	 */
	@Override
	public boolean updateNewsPhoto(NewsPhoto newsPhoto) {
		SQLFactory factory = SQLUtil.getSQLFactory("news_photo",newsPhoto, "id");
		String sql = factory.updateSql();
		Object[] params = factory.getParams();
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		try {
			int i = runner.update(sql, params);
			return i>0;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	/* (non-Javadoc)
	 * @see sist.dao.NewsPhotoDao#getList(sist.bean.NewsPhotoPage)
	 */
	@Override
	public List<NewsPhoto> getList(NewsPhotoPage photoPage) {
		
		String sql = null;
        StringBuffer sb = new StringBuffer();
        if(photoPage != null)
        {
            String content = photoPage.getContent();
            if(content != null && !content.trim().isEmpty())
                sb.append(" and content like ").append("'%").append(content).append("%'");
            String publisher = photoPage.getPublisher();
            if(publisher != null && !publisher.trim().isEmpty())
                sb.append(" and publisher like ").append("'%").append(publisher).append("%'");
            String title = photoPage.getTitle();
            if(title != null && !title.trim().isEmpty())
                sb.append(" and title like ").append("'%").append(title).append("%'");
            String startTime = photoPage.getStartTime();
            if(startTime != null && !startTime.trim().isEmpty())
                sb.append(" and time > ").append("'").append(startTime).append("'");
            String endTime = photoPage.getEndTime();
            if(endTime != null && !endTime.trim().isEmpty())
                sb.append(" and time < ").append("'").append(endTime).append("'");
            sql = (new StringBuilder("select top ")).append(photoPage.getPageSize()).append(" * from news_photo where 1=1 ").append(sb).append(" and id not in (select top ").append(photoPage.getPageSize() * (photoPage.getCurrentPage() - 1)).append(" id from news_photo where 1=1").append(sb).append(" order by time desc,id asc) order by time desc,id asc").toString();
        } else
        {
            sql = "select * from news_photo";
        }
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		try {
			return runner.query(sql, new BeanListHandler<>(NewsPhoto.class));
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public static void main(String[] args) {
		NewsPhotoDao dao = new NewsPhotoDaoImp();
		NewsPhotoPage page = new NewsPhotoPage();
		page.setTitle("¹·ÐÜ");
		page.setCurrentPage(1);
		page.setPageSize(10);
		dao.getList(page);
	}
	@Override
	public int getCount(NewsPhotoPage photoPage) {
		StringBuffer sb = new StringBuffer();
		if(photoPage!=null){
			
			String content = photoPage.getContent();
			if(content!=null && !content.trim().isEmpty()){
				sb.append(" and content like ").append("'%").append(content).append("%'");
			}
			String publisher = photoPage.getPublisher();
			if(publisher!=null && !publisher.trim().isEmpty()){
				sb.append(" and publisher like ").append("'%").append(publisher).append("%'");
			}
			String title = photoPage.getTitle();
			if(title!=null && !title.trim().isEmpty()){
				sb.append(" and title like ").append("'%").append(title).append("%'");
			}
			String startTime = photoPage.getStartTime();
			if(startTime!=null && !startTime.trim().isEmpty()){
				sb.append(" and time > ").append("'").append(startTime).append("'");
			}
			String endTime = photoPage.getEndTime();
			if(endTime!=null && !endTime.trim().isEmpty()){
				sb.append(" and time < ").append("'").append(endTime).append("'");
			}
		}
		
		String sql = "select count(*) as count from news_photo where 1=1"+sb;
//		System.out.println(sql);
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		try {
			Integer integer = runner.query(sql, new ResultSetHandler<Integer>(){

				@Override
				public Integer handle(ResultSet arg0) throws SQLException {
					if(arg0.next()){
						return arg0.getInt("count");
					}
					return null;
				}});
			return integer;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	/* (non-Javadoc)
	 * @see sist.dao.NewsPhotoDao#getNewsPhoto(int)
	 */
	@Override
	public NewsPhoto getNewsPhoto(int id) {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		try {
			return runner.query("select * from news_photo where id=?", new BeanHandler<>(NewsPhoto.class),id);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	/* (non-Javadoc)
	 * @see sist.dao.NewsPhotoDao#delById(int)
	 */
	@Override
	public boolean delById(int id) {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		try {
			int i = runner.update("delete from news_photo where id=?",id);
			return i>0;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	public NewsPhoto getByTitle(String title) {
		String sql = "select * from news_photo where title=?";
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		try {
			NewsPhoto newsPhoto = runner.query(sql, new BeanHandler<>(NewsPhoto.class),title);
			return newsPhoto;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

}
