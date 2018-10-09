package sist.bean;

import java.util.List;

import sist.domain.JSGJBean;

public class TeachSearchPage extends PagingBean {

	public TeachSearchPage() {
		super();
		currentPage = 1;
		pageSize = 5;
	}
	public TeachSearchPage(int currentPage, int pageSize) {
		super(currentPage, pageSize);
		// TODO Auto-generated constructor stub
	}
	public TeachSearchPage(String string) {
		this();
		key= string;
	}
	private List<JSGJBean> list;
	private String key;
	public List<JSGJBean> getList() {
		return list;
	}
	public void setList(List<JSGJBean> list) {
		this.list = list;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	@Override
	public String toString() {
		return "TeachSearchPage [list=" + list + ", key=" + key + "]";
	}
	
}
