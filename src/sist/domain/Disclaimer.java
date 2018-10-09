package sist.domain;

import own.dome.annotation.DBTabCol;
import own.dome.annotation.DBTable;

@DBTable("MZSM")
public class Disclaimer {

	@DBTabCol(value="MZSMID",primaryKey=true)
	private Integer id;
	private String publisher;
	private String time;
	@DBTabCol("MZSMCONTENT")
	private String content;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	@Override
	public String toString() {
		return "Disclaimer [id=" + id + ", publisher=" + publisher + ", time=" + time + ", content=" + content + "]";
	}
	
}
