package sist.domain;

import java.io.Serializable;

import own.dome.annotation.DBTabCol;
import own.dome.annotation.DBTable;

@DBTable("power")
public class Role implements Serializable{

	@DBTabCol(ignore=true)
	private static final long serialVersionUID = 9024177395798597983L;
	@DBTabCol("powerid")
	private Integer id;
	@DBTabCol("powerName")
	private String roleName;
	private String power;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getPower() {
		return power;
	}
	public void setPower(String power) {
		this.power = power;
	}
	@Override
	public String toString() {
		return "Role [id=" + id + ", roleName=" + roleName + ", power=" + power + "]";
	}
	
	
}
