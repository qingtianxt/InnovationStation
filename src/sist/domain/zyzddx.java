package sist.domain;

/**
 * ��Ҫ��Զ���ģ��
 * @author wzw
 *
 */
public class zyzddx {
	private int zyzddxid;//��Ҫ��Զ���id
	private String zyzddxmc;//��Ҫ��Զ�������
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
