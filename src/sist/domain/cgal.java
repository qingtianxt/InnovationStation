package sist.domain;

public class cgal {
	private Integer id;
	private String mc;//��������
	private String szd;//���ڵ�
	
	private String dw;//��λ
	private String nr;//��������
	private String gjc;//�ؼ���
	
	private String time;//�ύʱ��
	private String username;//�û���
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
