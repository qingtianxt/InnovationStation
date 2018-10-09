package sist.bean;

public class RolePage extends PagingBean {

	public RolePage() {
		super();
	}
	public RolePage(String username, Integer roleId) {
		super();
		this.username = username;
		this.roleId = roleId;
	}
	
	public RolePage(int currentPage, int pageSize) {
		super(currentPage, pageSize);
	}
	

	public RolePage(String username, Integer roleId, int currentPage, int pageSize) {
		super(currentPage, pageSize);
		this.username = username;
		this.roleId = roleId;
	}


	private String username;
	private Integer roleId;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Integer getRoleId() {
		return roleId;
	}
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	@Override
	public String toString() {
		return "RolePage [username=" + username + ", roleId=" + roleId + "]";
	}
	
	
}
