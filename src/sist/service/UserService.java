package sist.service;

import java.util.List;

import sist.bean.UserPage;
import sist.domain.UserBean;

public interface UserService extends Service {

	/**
	 * 修改或者添加用户
	 * @param userBean
	 * @return
	 */
	boolean saveOrUpdate(UserBean userBean);

	int checkUser(UserBean userBean);

	/**
	 * 分页获取用户信息
	 * @param pagingBean
	 * @return
	 */
	List<UserBean> getPage(UserPage pagingBean);

	/**
	 * 获取指定id的用户信息
	 * @param id
	 * @return
	 */
	UserBean getUser(Integer id);

	boolean delById(Integer id);

}
