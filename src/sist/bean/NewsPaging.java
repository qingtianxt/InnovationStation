package sist.bean;

/**
 * @author 悦尔
 *	新闻信息查询条件封装的Javabean
 */
public class NewsPaging extends PagingBean {
	
	private String qpublisher;
	private String qtitle;
	private String qcontent;
	private String qstart;
	private String qend;
	private String qtype;
	private String orderBy = "time";
	private String sortBy = "DESC";
	public String getQpublisher() {
		return qpublisher;
	}
	public void setQpublisher(String qpublisher) {
		this.qpublisher = qpublisher;
	}
	public String getQtitle() {
		return qtitle;
	}
	public void setQtitle(String qtitle) {
		this.qtitle = qtitle;
	}
	public String getQcontent() {
		return qcontent;
	}
	public void setQcontent(String qcontent) {
		this.qcontent = qcontent;
	}
	public String getQstart() {
		return qstart;
	}
	public void setQstart(String qstart) {
		this.qstart = qstart;
	}
	public String getQend() {
		return qend;
	}
	public void setQend(String qend) {
		this.qend = qend;
	}
	public String getQtype() {
		return qtype;
	}
	public void setQtype(String qtype) {
		this.qtype = qtype;
	}
	public String getOrderBy() {
		return orderBy;
	}
	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}
	public String getSortBy() {
		return sortBy;
	}
	public void setSortBy(String sortBy) {
		this.sortBy = sortBy;
	}
	@Override
	public String toString() {
		return "NewsPaging [qpublisher=" + qpublisher + ", qtitle=" + qtitle + ", qcontent=" + qcontent + ", qstart="
				+ qstart + ", qend=" + qend + ", qtype=" + qtype + ", orderBy=" + orderBy + ", sortBy=" + sortBy + "]";
	}
	
	
	
}
