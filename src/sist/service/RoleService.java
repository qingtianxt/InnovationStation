package sist.service;

import java.util.List;

import sist.bean.RolePage;
import sist.bean.RolePagingBean;
import sist.domain.Role;
import sist.domain.UserBean;

public interface RoleService extends Service {


	/**
	 * 获取用户
	 * @param pagingBean
	 * @return
	 */
	@Deprecated
	List<UserBean> getList(RolePage pagingBean);

	/**
	 * 通过角色的id获取一个角色的信息
	 * @param id	角色id
	 * @return
	 */
	Role getRole(Integer id);

	/**
	 * 如果role的id在数据库中存在,测修改,否则删除
	 * @param role	待操作的角色对象
	 * @return		成功返回true,失败返回false
	 */
	boolean addOrUpdate(Role role);

	/**
	 * 检测角色名称是否已经存在,添加角色的时候调用
	 * @param roleName	待检测的名称
	 * @return			如果指定名称存在返回true,否则返回false
	 */
	boolean checkName(String roleName);

	List<Role> getList2(RolePagingBean pagingBean);

	/**
	 * 删除指定id的角色,待删除的角色下必须不含任何用户
	 * @param id	待删除的角色的id
	 * @return		3表示删除成功,4表示删除失败,5表示改角色下面存在用户不能删除
	 */
	int delById(int id);

}
