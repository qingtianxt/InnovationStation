package sist.dao;

import java.util.List;

import sist.bean.UserPage;
import sist.domain.UserBean;

public interface UserDao extends Dao {

	/**
	 * 通过id查找用户
	 * @param id
	 * @return
	 */
	UserBean getUserById(Integer id);

	/**
	 * 修改用户信息
	 * @param userBean
	 * @return
	 */
	boolean update(UserBean userBean);

	/**
	 * 添加用户信息
	 * @param userBean
	 * @return
	 */
	boolean addUser(UserBean userBean);

	UserBean getUser(String userBean);

	/**
	 * 分页获取用户
	 * @param pagingBean
	 * @return
	 */
	List<UserBean> getList(UserPage pagingBean);

	int getCount(UserPage pagingBean);

	boolean delById(Integer id);

	/**
	 * 指定角色下的所有用户
	 * @param id
	 * @return
	 */
	List<UserBean> getByRoleId(int id);


}
