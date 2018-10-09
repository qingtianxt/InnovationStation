package sist.dao;

import java.util.List;

import sist.bean.NewsPhotoPage;
import sist.domain.NewsPhoto;

public interface NewsPhotoDao extends Dao{

	/**
	 * 通过图片新闻的id号查找图片新闻
	 * @param id	图片新闻的id
	 * @return		如果查找到相应id的图片新闻，返回封装了图片信息的Javabean对象
	 * 				否则返回null
	 */
	NewsPhoto findNewsPhoto(Integer id);

	/**
	 * 像数据库中添加图片新闻
	 * @param newsPhoto	封装了新闻信息的Javabean对象
	 * @return			添加成功返回true，添加失败返回false
	 */
	boolean addNewsPhoto(NewsPhoto newsPhoto);

	/**
	 * 更新数据库总的新闻信息
	 * @param newsPhoto	封装了待更新的新闻信息
	 * @return			更新成功返回true，更新失败返回false
	 */
	boolean updateNewsPhoto(NewsPhoto newsPhoto);

	/**
	 * 查询数据表中的新闻信息
	 * @param photoPage 封装了查询条件的Javabean对象
	 * @return			list集合对象
	 */
	List<NewsPhoto> getList(NewsPhotoPage photoPage);

	/**
	 * 查询数据表中符合条件的新闻的记录条数
	 * @param photoPage	封装了查询条件的Javabean对象
	 * @return			Integer类型变量
	 */
	int getCount(NewsPhotoPage photoPage);

	/**
	 * 通过图片新闻的id获取图片新闻的信息
	 * @param id
	 * @return
	 */
	NewsPhoto getNewsPhoto(int id);

	/**
	 * 通过id删除
	 * @param id
	 * @return
	 */
	boolean delById(int id);

	/**
	 * 通过新闻标题名称精确查找新闻信息
	 * @param title	新闻标题的名称
	 * @return		
	 */
	NewsPhoto getByTitle(String title);

}
