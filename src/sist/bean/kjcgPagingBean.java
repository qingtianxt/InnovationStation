package sist.bean;

import java.util.List;

import sist.domain.kjcg;

/**
 * �Ƽ��ɹ�pagebean
 * @author wzw
 *
 */
public class kjcgPagingBean extends PagingBean{
	private String mc;//�Ƽ��ɹ�����
	private String km;//�Ƽ��ɹ�����
	private String dw;//�Ƽ�������λ
	
	private String time1;//����ʱ��
	private String time2;
	private List<kjcg> list;
	public String getMc() {
		return mc;
	}
	public void setMc(String mc) {
		this.mc = mc;
	}
	public String getKm() {
		return km;
	}
	public void setKm(String km) {
		this.km = km;
	}
	public String getDw() {
		return dw;
	}
	public void setDw(String dw) {
		this.dw = dw;
	}
	public String getTime1() {
		return time1;
	}
	public void setTime1(String time1) {
		this.time1 = time1;
	}
	public String getTime2() {
		return time2;
	}
	public void setTime2(String time2) {
		this.time2 = time2;
	}
	public List<kjcg> getList() {
		return list;
	}
	public void setList(List<kjcg> list) {
		this.list = list;
	}
	@Override
	public String toString() {
		return "kjcgPagingBean [mc=" + mc + ", km=" + km + ", dw=" + dw + ", time1=" + time1 + ", time2=" + time2
				+ ", list=" + list + "]";
	}
}
