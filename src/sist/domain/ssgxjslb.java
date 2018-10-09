package sist.domain;
/**
 * 所属高新技术类别
 * @author wzw
 *
 */
public class ssgxjslb {
	private Integer jslbid;//类别id
	private String jslbmc;//类别名称
	public Integer getJslbid() {
		return jslbid;
	}
	public void setJslbid(Integer jslbid) {
		this.jslbid = jslbid;
	}
	public String getJslbmc() {
		return jslbmc;
	}
	public void setJslbmc(String jslbmc) {
		this.jslbmc = jslbmc;
	}
	@Override
	public String toString() {
		return "ssgxjslb [jslbid=" + jslbid + ", jslbmc=" + jslbmc + "]";
	}
	public ssgxjslb() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
