package sist.bean;

public class GlobalSearchPage extends PagingBean {

	protected String key;
	
	
	

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getKeys() {
		return key;
	}

	public void setKeys(String keys) {
		this.key = keys;
	}

	public GlobalSearchPage(String keys) {
		super();
		this.key = keys;
	}

	public GlobalSearchPage() {
		super();
		// TODO Auto-generated constructor stub
	}

	public GlobalSearchPage(int currentPage, int pageSize) {
		super(currentPage, pageSize);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "GlobalSearchPage [keys=" + key + "]";
	}
	
}
