package sist.domain;

public class Fwpt {
	private String km;//类型
	private String mc;//名称
	private String lxr;//联系人
	private String dz;//地址
	private String gjc;//关键词
	private String dh;//电话
	public String getKm() {
		return km;
	}
	public void setKm(String km) {
		this.km = km;
	}
	public String getMc() {
		return mc;
	}
	public void setMc(String mc) {
		this.mc = mc;
	}
	public String getLxr() {
		return lxr;
	}
	public void setLxr(String lxr) {
		this.lxr = lxr;
	}
	public String getDz() {
		return dz;
	}
	public void setDz(String dz) {
		this.dz = dz;
	}
	public String getGjc() {
		return gjc;
	}
	public void setGjc(String gjc) {
		this.gjc = gjc;
	}
	public String getDh() {
		return dh;
	}
	public void setDh(String dh) {
		this.dh = dh;
	}
	@Override
	public String toString() {
		return "Fwpt [km=" + km + ", mc=" + mc + ", lxr=" + lxr + ", dz=" + dz + ", gjc=" + gjc + ", dh=" + dh + "]";
	}
	
	
	
}
