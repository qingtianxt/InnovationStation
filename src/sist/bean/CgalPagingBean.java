package sist.bean;

import java.util.List;

import sist.domain.cgal;

public class CgalPagingBean extends PagingBean {
	private String mc;
	private String time;
	private List<cgal> list;
	public String getMc() {
		return mc;
	}
	public void setMc(String mc) {
		this.mc = mc;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public List<cgal> getList() {
		return list;
	}
	public void setList(List<cgal> list) {
		this.list = list;
	}
	@Override
	public String toString() {
		return "CgalPagingBean [mc=" + mc + ", time=" + time + ", list=" + list + "]";
	}
	
	
}
