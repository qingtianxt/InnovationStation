package sist.bean;

import java.util.List;

import sist.domain.zjxx;

public class zjxxPagingBean extends PagingBean {
	private String xm;//ר������
	private String zc_zy;//ְ��
	private String xkly;//ѧ������
	
	private String mc_szs;//������
	private String yjfx;//�о�����
	
	private List<zjxx> list;

	public String Zc_zy() {
		return xm;
	}

	public void setXm(String xm) {
		this.xm = xm;
	}

	public String getZc_zy() {
		return zc_zy;
	}

	public void setZc_zy(String zc_zy) {
		this.zc_zy = zc_zy;
	}

	public String getXkly() {
		return xkly;
	}

	public void setXkly(String xkly) {
		this.xkly = xkly;
	}

	public String getMc_szs() {
		return mc_szs;
	}

	public void setMc_szs(String mc_szs) {
		this.mc_szs = mc_szs;
	}

	public String getYjfx() {
		return yjfx;
	}

	public void setYjfx(String yjfx) {
		this.yjfx = yjfx;
	}

	public List<zjxx> getList() {
		return list;
	}

	public void setList(List<zjxx> list) {
		this.list = list;
	}

	@Override
	public String toString() {
		return "zjxxPagingBean [xm=" + xm + ", zc_zy=" + zc_zy + ", xkly=" + xkly + ", mc_szs=" + mc_szs + ", yjfx="
				+ yjfx + ", list=" + list + "]";
	}

	public String getXm() {
		return xm;
	}
	
	
}
