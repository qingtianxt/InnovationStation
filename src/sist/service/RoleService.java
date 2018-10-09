package sist.service;

import java.util.List;

import sist.bean.RolePage;
import sist.bean.RolePagingBean;
import sist.domain.Role;
import sist.domain.UserBean;

public interface RoleService extends Service {


	/**
	 * ��ȡ�û�
	 * @param pagingBean
	 * @return
	 */
	@Deprecated
	List<UserBean> getList(RolePage pagingBean);

	/**
	 * ͨ����ɫ��id��ȡһ����ɫ����Ϣ
	 * @param id	��ɫid
	 * @return
	 */
	Role getRole(Integer id);

	/**
	 * ���role��id�����ݿ��д���,���޸�,����ɾ��
	 * @param role	�������Ľ�ɫ����
	 * @return		�ɹ�����true,ʧ�ܷ���false
	 */
	boolean addOrUpdate(Role role);

	/**
	 * ����ɫ�����Ƿ��Ѿ�����,��ӽ�ɫ��ʱ�����
	 * @param roleName	����������
	 * @return			���ָ�����ƴ��ڷ���true,���򷵻�false
	 */
	boolean checkName(String roleName);

	List<Role> getList2(RolePagingBean pagingBean);

	/**
	 * ɾ��ָ��id�Ľ�ɫ,��ɾ���Ľ�ɫ�±��벻���κ��û�
	 * @param id	��ɾ���Ľ�ɫ��id
	 * @return		3��ʾɾ���ɹ�,4��ʾɾ��ʧ��,5��ʾ�Ľ�ɫ��������û�����ɾ��
	 */
	int delById(int id);

}
