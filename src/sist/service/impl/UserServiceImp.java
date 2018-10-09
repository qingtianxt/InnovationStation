package sist.service.impl;

import java.util.List;

import sist.bean.UserPage;
import sist.dao.RoleDao;
import sist.dao.UserDao;
import sist.domain.Role;
import sist.domain.UserBean;
import sist.factory.BasicFactory;
import sist.service.UserService;
import sist.utils.URLUtil;

public class UserServiceImp implements UserService {

	private BasicFactory factory = BasicFactory.getFactory();
	
	@Override
	public boolean saveOrUpdate(UserBean userBean) {
		UserDao dao = factory.getDao(UserDao.class);
		Integer id = userBean.getId();
		UserBean bean = dao.getUserById(id);
		if(bean!=null){
			// 修改
			return dao.update(userBean);
		}else{
			// 添加
			boolean b = dao.addUser(userBean);
			// 查询角色信息
			Role role = factory.getDao(RoleDao.class).getById(userBean.getRoleId());
			// 设置当前角色
			userBean.setRole(role);
			return b;
		}
	}

	@Override
	public int checkUser(UserBean userBean) {
		UserDao dao = factory.getDao(UserDao.class);
		UserBean user = dao.getUser(userBean.getUsername());
		if(user==null){
			// 用户名不存在
			return 2;
		}
		if(user.getPwd().equals(userBean.getPwd())){
			userBean.setAddress(user.getAddress());
			userBean.setCellphone(user.getCellphone());
			userBean.setEmail(user.getEmail());
			userBean.setId(user.getId());
			userBean.setName(user.getName());
			userBean.setRoleId(user.getRoleId());
			RoleDao dao2 = factory.getDao(RoleDao.class);
			userBean.setRole(dao2.getById(user.getRoleId()));
			return 0;
		}
		else{
			// 密码错误
			return 3;
		}
	}

	@Override
	public List<UserBean> getPage(UserPage pagingBean) {
		int currentPage = pagingBean.getCurrentPage();
		if(currentPage==0){
			currentPage = 1;
			pagingBean.setCurrentPage(1);
		}
		int pageSize = pagingBean.getPageSize();
		if(pageSize==0){
			pageSize = 10;
			pagingBean.setPageSize(10);
		}
		
		UserDao dao = factory.getDao(UserDao.class);
		RoleDao roleDao = factory.getDao(RoleDao.class);
		List<UserBean> list = dao.getList(pagingBean);
		for (UserBean userBean : list) {
			Role role = roleDao.getById(userBean.getRoleId());
			userBean.setRole(role);
		}
		int count = dao.getCount(pagingBean);
		pagingBean.setTotalCount(count);
		pagingBean.setTotalPage(count%pageSize==0?count/pageSize:count/pageSize+1);
		
		String preUrl = "userServlet?method=list&result=list&"+URLUtil.preUrl(pagingBean);
		pagingBean.setPreUrl(preUrl);
		pagingBean.setAnd(true);
		return list;
	}

	@Override
	public UserBean getUser(Integer id) {
		UserDao dao = factory.getDao(UserDao.class);
		UserBean userBean = dao.getUserById(id);
		return userBean;
	}

	@Override
	public boolean delById(Integer id) {
		UserDao dao = factory.getDao(UserDao.class);
		boolean b = dao.delById(id);
		return b;
	}

}
