package sist.bean;

/**
 * @author �ö�
 * ���¼���������ѯ��ϢJavabean
 *
 */
public class SupplyPagingBean extends PagingBean {

	private String techName;
	private String keyWord;// �ؼ���
	private String startTime;
	private String endTime;
	private String status;// ���״̬
	private String category;// �������¼������
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
	 * ��ȡ�����ֶ�
	 * @return
	 */
	public String getOrderBy() {
		return orderBy;
	}
	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}
	/**
	 * ��ȡ����ʽ,����ASC,����DESC
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
