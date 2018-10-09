package sist.domain;

public class gmjj {
	private String code;
	private String Title;
	private String father;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public String getFather() {
		return father;
	}
	public void setFather(String father) {
		this.father = father;
	}
	@Override
	public String toString() {
		return "gmjj [code=" + code + ", Title=" + Title + ", father=" + father + "]";
	}
	
	
}
