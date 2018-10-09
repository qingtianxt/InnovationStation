package sist.dao;

import java.util.List;

import sist.bean.PagingBean;
import sist.domain.JSGJBean;

public interface JSGJDao extends Dao {
	public abstract JSGJBean findById(Integer integer);

	public abstract boolean add(JSGJBean jsgjbean);

	public abstract boolean update(JSGJBean jsgjbean);

	/**
	 * 查询符合指定条件的数据新，pagingBean中封装了查询条件和查询记录条数
	 * 如果pagingBean为null，则返回所有记录。pagingBean中的条件连接方式 为and
	 * 
	 * @param pagingbean
	 *            封装了查询信息与分页信息的pagingBean对象
	 * @return JSGJBean的list集合
	 */
	public abstract List<JSGJBean> getList(PagingBean pagingbean);

	/**
	 * 获取符合指定条件的记录的条数，配合getList实现分页查询
	 * 
	 * @param pagingbean
	 *            封装了分页信息和查询条件的pagingBean对象
	 * @return 如果pagingBean对象不为空，返回符 pagingBean中封装的条件的记录数，否则返回记录总数
	 */
	public abstract int getCount(PagingBean pagingbean);

	/**
	 * 通过id删除供给信息
	 * 
	 * @param i
	 *            待删除的信息的主键
	 * @return 删除成功返回true，否则返回false
	 */
	public abstract boolean delById(int i);

	/**
	 * 模糊查询，根据关键字模糊匹配多个字段 如果pagingBean为null，将返回所有记录信息
	 * 
	 * @param pagingbean
	 *            封装了查询信息和分页信息的PagingBean对象
	 * @return 查询结果的list集合
	 */
	public abstract List<JSGJBean> search(PagingBean pagingbean);

	/**
	 * 模糊查询记录条数，根据关键字模糊匹配技术供给表中的所有字段。 配合search实现分页
	 * 
	 * @param pagingbean
	 *            封装了分页信息和关键字
	 * @return 信息条数
	 */
	public abstract Integer searchCount(PagingBean pagingbean);

	/**
	 * 通过技术名称精确查找技术信息
	 * 
	 * @param name
	 *            技术名称
	 * @return 如果存在返回技术信息，否则返回null
	 */
	public abstract JSGJBean getByName(String name);

}
