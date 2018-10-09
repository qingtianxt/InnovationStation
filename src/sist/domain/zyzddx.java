package sist.domain;

/**
 * 主要针对对象模块
 * @author wzw
 *
 */
public class zyzddx {
	private int zyzddxid;//主要针对对象id
	private String zyzddxmc;//主要针对对象名称
	public int getZyzddxid() {
		return zyzddxid;
	}
	public void setZyzddxid(int zyzddxid) {
		this.zyzddxid = zyzddxid;
	}
	public String getZyzddxmc() {
		return zyzddxmc;
	}
	public void setZyzddxmc(String zyzddxmc) {
		this.zyzddxmc = zyzddxmc;
	}
	@Override
	public String toString() {
		return "zyzddx [zyzddxid=" + zyzddxid + ", zyzddxmc=" + zyzddxmc + "]";
	}
	public zyzddx() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
