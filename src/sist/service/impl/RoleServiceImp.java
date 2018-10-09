package sist.service.impl;

import java.util.List;

import sist.bean.RolePage;
import sist.bean.RolePagingBean;
import sist.dao.RoleDao;
import sist.dao.UserDao;
import sist.domain.Role;
import sist.domain.UserBean;
import sist.factory.BasicFactory;
import sist.service.RoleService;
import sist.utils.URLUtil;

public class RoleServiceImp implements RoleService {

	@Override
	public List<Role> getList2(RolePagingBean pagingBean) {
		if(pagingBean==null){
			RoleDao dao = BasicFactory.getFactory().getDao(RoleDao.class);
			List<Role> list = dao.getList(pagingBean);
			return list;
		}else{
			int currentPage = pagingBean.getCurrentPage();
			int pageSize = pagingBean.getPageSize();
			if(currentPage==0){
				currentPage = 1;
				pagingBean.setCurrentPage(1);
			}
			if(pageSize==0){
				pageSize = 10;
				pagingBean.setPageSize(pageSize);
			}
			
			RoleDao dao = BasicFactory.getFactory().getDao(RoleDao.class);
			Integer count = dao.getCount(pagingBean);
			pagingBean.setTotalCount(count);
			pagingBean.setTotalPage(count % pageSize == 0 ? count / pageSize : count / pageSize + 1);
			pagingBean.setAnd(true);
			List<Role> list = dao.getList(pagingBean);
			return list;
		}
	}
	
	@Override
	public List<UserBean> getList(RolePage pagingBean) {
		int currentPage = pagingBean.getCurrentPage();
		int pageSize = pagingBean.getPageSize();
		if(currentPage==0){
			currentPage = 1;
			pagingBean.setCurrentPage(1);
		}
		if(pageSize==0){
			pageSize = 10;
			pagingBean.setPageSize(pageSize);
		}
		RoleDao dao = BasicFactory.getFactory().getDao(RoleDao.class);
		List<UserBean> list = dao.getList(pagingBean);
		for (UserBean userBean : list) {
			Integer roleId = userBean.getRoleId();
			Role role = dao.getById(roleId);
			userBean.setRole(role);
		}
		
		int count = dao.getCount(pagingBean);
		pagingBean.setTotalCount(count);
		pagingBean.setTotalPage(count%pageSize==0?count/pageSize:count/pageSize+1);
		String preUrl = "roleServlet?method=pageList&result=list&"+URLUtil.preUrl(pagingBean);
		pagingBean.setPreUrl(preUrl);
		pagingBean.setAnd(true);
		return list;
	}

	@Override
	public Role getRole(Integer id) {
		RoleDao dao = BasicFactory.getFactory().getDao(RoleDao.class);
		Role role = dao.getById(id);
		return role;
	}

	@Override
	public boolean addOrUpdate(Role role) {
		RoleDao dao = BasicFactory.getFactory().getDao(RoleDao.class);
		Role role2 = dao.getById(role.getId());
		if(role2==null){
			Integer id = dao.getMaxId();
			role.setId(id+1);
			return dao.add(role);
		}else{
			return dao.update(role);
		}
	}

	@Override
	public boolean checkName(String roleName) {
		RoleDao dao = BasicFactory.getFactory().getDao(RoleDao.class);
		Role role = dao.getByName(roleName);
		
		return role==null;
	}

	@Override
	public int delById(int id) {
		if(id==-1)
			return 6;
		RoleDao dao = BasicFactory.getFactory().getDao(RoleDao.class);
		List<UserBean> users = BasicFactory.getFactory().getDao(UserDao.class).getByRoleId(id);
		if(users!=null&&!users.isEmpty()){
			return 5;
		}
		boolean byId = dao.delById(id);
		return byId?3:4;
	}

}
