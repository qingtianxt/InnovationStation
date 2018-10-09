package sist.dao;

import java.util.List;

import sist.bean.RolePage;
import sist.bean.RolePagingBean;
import sist.domain.Role;
import sist.domain.UserBean;

public interface RoleDao extends Dao {

	/**
	 * 通过角色id查找角色信息
	 * @param roleId
	 * @return
	 */
	Role getById(Integer roleId);


	List<UserBean> getList(RolePage pagingBean);

	int getCount(RolePage rolePage);

	boolean add(Role role);

	boolean update(Role role);

	Role getByName(String roleName);

	Integer getMaxId();

	List<Role> getList(RolePagingBean pagingBean);
	
	Integer getCount(RolePagingBean pagingBean);


	boolean delById(Integer id);
}
