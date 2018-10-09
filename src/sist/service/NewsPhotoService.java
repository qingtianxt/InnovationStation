package sist.service;

import java.util.List;

import sist.bean.NewsPhotoPage;
import sist.domain.NewsPhoto;

public interface NewsPhotoService extends Service {

	/**
	 * 保存或者修改图片新闻
	 * @param newsPhoto
	 * @return
	 */
	boolean saveOrUpdate(NewsPhoto newsPhoto);

	/**
	 * 查询图片新闻
	 * @param photoPage 封装了图片新闻信息的Javabean
	 * @return			图片新闻的list集合
	 */
	List<NewsPhoto> getList(NewsPhotoPage photoPage);

	/**
	 * 通过图片新闻的id获取图片新闻
	 * @param id
	 * @return
	 */
	NewsPhoto getNewsPhoto(int id);

	/**
	 * 根据id删除图片新闻
	 * @param id
	 * @return
	 */
	boolean delById(int id);

	/**
	 * 检查图片新闻的标题是否已经存在
	 * @param title	待检测的新闻标题
	 * @return		如果新闻标题存在返回false，否则返回true
	 */
	boolean checkTitle(String title);

}
