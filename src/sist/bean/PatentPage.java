package sist.bean;

/**
 * @author 悦尔
 *封装查理的查询信息
 */
public class PatentPage extends PagingBean {

	private String name;// 发明名称
	private String patentNumber;// 专利号
	private String startTime;//
	private String endTime;
	private String summary;//摘要信息
	private Integer libId;
	
	public Integer getLibId() {
		return libId;
	}
	public void setLibId(Integer libId) {
		this.libId = libId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPatentNumber() {
		return patentNumber;
	}
	public void setPatentNumber(String patentNumber) {
		this.patentNumber = patentNumber;
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
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	@Override
	public String toString() {
		return "PatentPage [name=" + name + ", patentNumber=" + patentNumber + ", startTime=" + startTime + ", endTime="
				+ endTime + ", summary=" + summary + ", libId=" + libId + "]";
	}
	
}
