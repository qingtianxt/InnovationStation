package sist.bean;

import java.util.List;

import sist.domain.Fwpt;

public class FwptPagingBean extends PagingBean {
	private String mc;//名称
	private String km;//类型
	private String lxr;//联系人
	private String gjc;//关键词
	public String getKm() {
		return km;
	}
	public void setKm(String km) {
		this.km = km;
	}
	public String getLxr() {
		return lxr;
	}
	public void setLxr(String lxr) {
		this.lxr = lxr;
	}
	public String getGjc() {
		return gjc;
	}
	public void setGjc(String gjc) {
		this.gjc = gjc;
	}
	private List<Fwpt> list ;
	public String getMc() {
		return mc;
	}
	public void setMc(String mc) {
		this.mc = mc;
	}
	public List<Fwpt> getList() {
		return list;
	}
	public void setList(List<Fwpt> list) {
		this.list = list;
	}
	@Override
	public String toString() {
		return "FwptPagingBean [mc=" + mc + ", km=" + km + ", lxr=" + lxr + ", gjc=" + gjc + ", list=" + list + "]";
	}
	
}
