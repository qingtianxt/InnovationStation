package sist.bean;

public class UserPage extends PagingBean {
	
	private String username;
	private String roleName;
	private Integer roleId;
	private String eName;// ÆóÒµÃû³Æ
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String geteName() {
		return eName;
	}
	public void seteName(String eName) {
		this.eName = eName;
	}
	@Override
	public String toString() {
		return "UserPage [username=" + username + ", roleName=" + roleName + ", roleId=" + roleId + ", eName=" + eName
				+ "]";
	}
	public Integer getRoleId() {
		return roleId;
	}
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	
	
}
