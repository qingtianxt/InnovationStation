package sist.bean;

public class RolePagingBean extends PagingBean {

	private String roleName;

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	@Override
	public String toString() {
		return "RolePagingBean [roleName=" + roleName + ", totalPage=" + totalPage + ", totalCount=" + totalCount
				+ ", currentPage=" + currentPage + ", pageSize=" + pageSize + ", preUrl=" + preUrl + ", isAnd=" + isAnd
				+ "]";
	}

	
	
}
