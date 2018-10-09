package sist.bean;

/**
 * @author 悦尔
 * 高新技术供给查询信息Javabean
 *
 */
public class SupplyPagingBean extends PagingBean {

	private String techName;
	private String keyWord;// 关键词
	private String startTime;
	private String endTime;
	private String status;// 审核状态
	private String category;// 所属高新技术类别
	private String orderBy = "time";
	private String sortBy = "DESC";
	
	public String getTechName() {
		return techName;
	}
	public void setTechName(String techName) {
		this.techName = techName;
	}
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getKeyWord() {
		return keyWord;
	}
	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	/**
	 * 获取排序字段
	 * @return
	 */
	public String getOrderBy() {
		return orderBy;
	}
	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}
	/**
	 * 获取排序方式,升序ASC,降序DESC
	 * @return
	 */
	public String getSortBy() {
		return sortBy;
	}
	public void setSortBy(String sortBy) {
		this.sortBy = sortBy;
	}
	@Override
	public String toString() {
		return "SupplyPagingBean [techName=" + techName + ", keyWord=" + keyWord + ", startTime=" + startTime
				+ ", endTime=" + endTime + ", status=" + status + ", category=" + category + ", orderBy=" + orderBy
				+ ", sortBy=" + sortBy + "]";
	}
	
	
}
