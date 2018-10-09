package sist.bean;

import java.util.List;

import sist.domain.jsxq;

public class qyxqPagingBean extends PagingBean{
	private String mc;
	private Integer sh;
	private String nr_xq;//技术需求说明
	private String jsssly;//技术所属领域
	private String time1;//发布时间
	private String time2;//发布时间2
	@Override
	public String toString() {
		return "qyxqPagingBean [mc=" + mc + ", sh=" + sh + ", nr_xq=" + nr_xq + ", jsssly=" + jsssly + ", time1="
				+ time1 + ", time2=" + time2 + ", list=" + list + "]";
	}
	private List<jsxq> list;
	public String getMc() {
		return mc;
	}
	public List<jsxq> getList() {
		return list;
	}
	public void setList(List<jsxq> list) {
		this.list = list;
	}
	public void setMc(String mc) {
		this.mc = mc;
	}
	public Integer getSh() {
		return sh;
	}
	public void setSh(Integer sh) {
		this.sh = sh;
	}
	public String getNr_xq() {
		return nr_xq;
	}
	public void setNr_xq(String nr_xq) {
		this.nr_xq = nr_xq;
	}
	public String getJsssly() {
		return jsssly;
	}
	public void setJsssly(String jsssly) {
		this.jsssly = jsssly;
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
	
}
