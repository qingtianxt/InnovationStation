package sist.bean;

/**
 * @author �ö�
 *	��װר����ѯ������Javabean
 */
public class LibPageBean extends PagingBean {
	
	private String name;	// ר�������
	private String publisher;// ������
	private String startTime;// ��ʵ����
	private String endTime;	// ��ֹ����
	private String intro;// ר�����
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
