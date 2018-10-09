package sist.domain;

public class NewsPhoto {
	
	private Integer id;
	private String image;//图片路径
	private String title;// 新闻标题
	private String content;// 新闻内容
	private String publisher;// 发布人
	private String time;// 发布时间
	private String username;// 上传用户名
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
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
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	@Override
	public String toString() {
		return "News_Photo [id=" + id + ", image=" + image + ", title=" + title + ", content=" + content
				+ ", publisher=" + publisher + ", time=" + time + ", username=" + username + "]";
	}
	
	
}
