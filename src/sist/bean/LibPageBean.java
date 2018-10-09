package sist.bean;

/**
 * @author 悦尔
 *	封装专题库查询条件的Javabean
 */
public class LibPageBean extends PagingBean {
	
	private String name;	// 专题库名称
	private String publisher;// 发布人
	private String startTime;// 其实日期
	private String endTime;	// 截止日期
	private String intro;// 专题库简介
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
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
	public String getIntro() {
		return intro;
	}
	public void setIntro(String intro) {
		this.intro = intro;
	}
	@Override
	public String toString() {
		return "LibPageBean [name=" + name + ", publisher=" + publisher + ", startTime=" + startTime + ", endTime="
				+ endTime + ", intro=" + intro + "]";
	}
	
	
}
