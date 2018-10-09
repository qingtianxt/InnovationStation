package sist.dao;

import java.util.List;

import sist.bean.UserPage;
import sist.domain.UserBean;

public interface UserDao extends Dao {

	/**
	 * ͨ��id�����û�
	 * @param id
	 * @return
	 */
	UserBean getUserById(Integer id);

	/**
	 * �޸��û���Ϣ
	 * @param userBean
	 * @return
	 */
	boolean update(UserBean userBean);

	/**
	 * ����û���Ϣ
	 * @param userBean
	 * @return
	 */
	boolean addUser(UserBean userBean);

	UserBean getUser(String userBean);

	/**
	 * ��ҳ��ȡ�û�
	 * @param pagingBean
	 * @return
	 */
	List<UserBean> getList(UserPage pagingBean);

	int getCount(UserPage pagingBean);

	boolean delById(Integer id);

	/**
	 * ָ����ɫ�µ������û�
	 * @param id
	 * @return
	 */
	List<UserBean> getByRoleId(int id);


}
