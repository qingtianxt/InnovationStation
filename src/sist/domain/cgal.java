package sist.domain;

public class cgal {
	private Integer id;
	private String mc;//案例名称
	private String szd;//所在地
	
	private String dw;//单位
	private String nr;//案例内容
	private String gjc;//关键词
	
	private String time;//提交时间
	private String username;//用户名
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getMc() {
		return mc;
	}
	public void setMc(String mc) {
		this.mc = mc;
	}
	public String getSzd() {
		return szd;
	}
	public void setSzd(String szd) {
		this.szd = szd;
	}
	public String getDw() {
		return dw;
	}
	public void setDw(String dw) {
		this.dw = dw;
	}
	public String getNr() {
		return nr;
	}
	public void setNr(String nr) {
		this.nr = nr;
	}
	public String getGjc() {
		return gjc;
	}
	public void setGjc(String gjc) {
		this.gjc = gjc;
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
		return "cgal [id=" + id + ", mc=" + mc + ", szd=" + szd + ", dw=" + dw + ", nr=" + nr + ", gjc=" + gjc
				+ ", time=" + time + ", username=" + username + "]";
	}
	public cgal() {
	}
	
	
	
	
}
