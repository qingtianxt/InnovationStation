package sist.bean;
/**
 * ǰ̨ר����Ϣ��ҳ
 * @author wzw
 *
 */

import java.util.List;

import sist.domain.zjxx;

public class frontZjxxPagingBean extends PagingBean {
	private String xm;//ר������
	private String time1;//��ʼʱ��
	private String time2;//��ֹʱ��
	
	private List<zjxx> list;

	public String getXm() {
		return xm;
	}

	public void setXm(String xm) {
		this.xm = xm;
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

	public List<zjxx> getList() {
		return list;
	}

	public void setList(List<zjxx> list) {
		this.list = list;
	}

	@Override
	public String toString() {
		return "frontZjxxPagingBean [xm=" + xm + ", time1=" + time1 + ", time2=" + time2 + ", list=" + list + "]";
	}
	
}
