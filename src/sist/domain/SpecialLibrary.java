package sist.domain;

import java.util.List;

/**
 * @author 悦尔
 * 专题库
 */
public class SpecialLibrary {

	private Integer id;// ID号
	private String title;// 标题
	private String publisher;// 发布人
	private String date;// 发布日期
	private String intro;// 专题库简介
	private List<Patent> patents;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getIntro() {
		return intro;
	}
	public void setIntro(String abstract1) {
		intro = abstract1;
	}
	public List<Patent> getPatents() {
		return patents;
	}
	public void setPatents(List<Patent> patents) {
		this.patents = patents;
	}
	@Override
	public String toString() {
		return "SpecialLibrary [id=" + id + ", title=" + title + ", publisher=" + publisher + ", date=" + date
				+ ", intro=" + intro + ", patents=" + patents + "]";
	}
	
	
}
