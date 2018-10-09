package sist.service;

import java.util.List;

import sist.bean.UserPage;
import sist.domain.UserBean;

public interface UserService extends Service {

	/**
	 * �޸Ļ�������û�
	 * @param userBean
	 * @return
	 */
	boolean saveOrUpdate(UserBean userBean);

	int checkUser(UserBean userBean);

	/**
	 * ��ҳ��ȡ�û���Ϣ
	 * @param pagingBean
	 * @return
	 */
	List<UserBean> getPage(UserPage pagingBean);

	/**
	 * ��ȡָ��id���û���Ϣ
	 * @param id
	 * @return
	 */
	UserBean getUser(Integer id);

	boolean delById(Integer id);

}
