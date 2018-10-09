package sist.bean;

public class CoopSitePage extends PagingBean {
	
	private String siteName;
	private String siteLink;
	private String startTime;
	private String endTime;
	private String type;
	
	public CoopSitePage() {
		super();
	}
	
	public CoopSitePage(String siteName, String siteLink) {
		super();
		this.siteName = siteName;
		this.siteLink = siteLink;
	}

	public String getSiteName() {
		return siteName;
	}
	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}
	public String getSiteLink() {
		return siteLink;
	}
	public void setSiteLink(String siteLink) {
		this.siteLink = siteLink;
	}
	@Override
	public String toString() {
		return "CoopSitePage [siteName=" + siteName + ", siteLink=" + siteLink + ", startTime=" + startTime
				+ ", endTime=" + endTime + ", type=" + type + "]";
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	
}
