package sist.bean;

import java.util.List;

import sist.domain.zcfg;

public class zcfgPagingBean extends PagingBean {
	private String zcmc;//政策名称
	private String zcflmc;//政策分类名称
	private String ztcmc;//主题词名称
	
	private String time1;//公布日期
	private String time2;
	private String zcwh;//政策文号
	
	private List<zcfg> list;

	public String getZcmc() {
		return zcmc;
	}

	public void setZcmc(String zcmc) {
		this.zcmc = zcmc;
	}

	public String getZcflmc() {
		return zcflmc;
	}

	public void setZcflmc(String zcflmc) {
		this.zcflmc = zcflmc;
	}

	public String getZtcmc() {
		return ztcmc;
	}

	public void setZtcmc(String ztcmc) {
		this.ztcmc = ztcmc;
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

	public String getZcwh() {
		return zcwh;
	}

	public void setZcwh(String zcwh) {
		this.zcwh = zcwh;
	}

	public List<zcfg> getList() {
		return list;
	}

	public void setList(List<zcfg> list) {
		this.list = list;
	}

	public zcfgPagingBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "zcfgPagingBean [zcmc=" + zcmc + ", zcflmc=" + zcflmc + ", ztcmc=" + ztcmc + ", time1=" + time1
				+ ", time2=" + time2 + ", zcwh=" + zcwh + ", list=" + list + "]";
	}
	
	
}
