package sist.domain;
/**
 * ������������
 * @author wzw
 *
 */
public class jsssly {
	private Integer lyid;
	private String lymc;//��������
	public Integer getLyid() {
		return lyid;
	}
	public void setLyid(Integer lyid) {
		this.lyid = lyid;
	}
	public String getLymc() {
		return lymc;
	}
	public void setLymc(String lymc) {
		this.lymc = lymc;
	}
	@Override
	public String toString() {
		return "jsssly [lyid=" + lyid + ", lymc=" + lymc + "]";
	}
	public jsssly() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
