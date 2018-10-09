package sist.bean;

public class PagingBean {
	protected int totalPage;
	protected int totalCount;
	protected int currentPage;
	protected int pageSize;
	protected String preUrl;
	protected boolean isAnd;
	
	
	public PagingBean() {
		super();
	}
	public PagingBean(int currentPage, int pageSize) {
		super();
		this.currentPage = currentPage;
		this.pageSize = pageSize;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public String getPreUrl() {
		return preUrl;
	}
	public void setPreUrl(String preUrl) {
		this.preUrl = preUrl;
	}
	public boolean isAnd() {
		return isAnd;
	}
	public void setAnd(boolean isAnd) {
		this.isAnd = isAnd;
	}
	
	
	
}
