package sist.domain;

import java.io.Serializable;

import own.dome.annotation.DBTabCol;
import own.dome.annotation.DBTable;

@DBTable("UserInform")
public class UserBean implements Serializable {
	@DBTabCol(ignore=true)
	private static final long serialVersionUID = 1L;
	@DBTabCol(primaryKey=true,value="id")
	private Integer id;
	private String username;
	private String pwd;
	@DBTabCol(value="qymc")
	private String name;
	@DBTabCol(value="qydz")
	private String address;// µÿ÷∑
	@DBTabCol("lxfs")
	private String cellphone;
	@DBTabCol("yx")
	private String email;
	@DBTabCol(value="powerid",ignoreZore=false)
	private Integer roleId;
	private Role role;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCellphone() {
		return cellphone;
	}
	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getRoleId() {
		return roleId;
	}
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "UserBean [id=" + id + ", username=" + username + ", pwd=" + pwd + ", name=" + name + ", address="
				+ address + ", cellphone=" + cellphone + ", email=" + email + ", roleId=" + roleId + ", role=" + role
				+ "]";
	}
	
}
