package sist.bean;

import java.util.List;

import sist.domain.NewsPhoto;

/**
 * @author 悦尔
 *
 *图片新闻分页查询显示时用到的Javabean
 */
public class NewsPhotoPage extends PagingBean {

	private String q_publisher;
	private String q_title;
	private String q_content;
	private String startTime;
	private String endTime;
	private List<NewsPhoto> list;
	public String getPublisher() {
		return q_publisher;
	}
	public void setPublisher(String publisher) {
		this.q_publisher = publisher;
	}
	public String getTitle() {
		return q_title;
	}
	public void setTitle(String title) {
		this.q_title = title;
	}
	public String getContent() {
		return q_content;
	}
	public void setContent(String content) {
		this.q_content = content;
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
	public List<NewsPhoto> getList() {
		return list;
	}
	public void setList(List<NewsPhoto> list) {
		this.list = list;
	}
	@Override
	public String toString() {
		return "NewsPhotoPage [publisher=" + q_publisher + ", title=" + q_title + ", content=" + q_content + ", startTime="
				+ startTime + ", endTime=" + endTime + ", list=" + list + "]";
	}
	public String getQ_publisher() {
		return q_publisher;
	}
	public void setQ_publisher(String q_publisher) {
		this.q_publisher = q_publisher;
	}
	public String getQ_title() {
		return q_title;
	}
	public void setQ_title(String q_title) {
		this.q_title = q_title;
	}
	public String getQ_content() {
		return q_content;
	}
	public void setQ_content(String q_content) {
		this.q_content = q_content;
	}
	
	
}
