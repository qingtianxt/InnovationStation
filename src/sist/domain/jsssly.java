package sist.domain;
/**
 * 技术所属领域
 * @author wzw
 *
 */
public class jsssly {
	private Integer lyid;
	private String lymc;//领域名称
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
