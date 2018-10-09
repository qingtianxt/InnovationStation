package sist.domain;
/**
 * 政策法规bean
 * @author wzw
 *
 */
public class zcfg {
	private Integer id;
	private String zcmc;//政策名称
	private String bgbrq;//公布日期
	
	private String bsxrq;//施行日期
	private String zcflmc;//政策分类(类型)名称
	private String ttzlymc;//主要针对对象
	
	private String bbbxsmc;//颁布形式名称
	private String zcwh;//政策文号
	private String zcnr;//政策内容;
	
	private String bzdjgmc;//制定机关名称
	private String bsxfwmc;//实行范围名称
	private String ztcmc;//主题词名称
	
	private String gjzmc;//关键字名称
	private String username;//用户名
	
	private Integer hits;
	public Integer getHits() {
		return hits;
	}
	public void setHits(Integer hits) {
		this.hits = hits;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getZcmc() {
		return zcmc;
	}
	public void setZcmc(String zcmc) {
		this.zcmc = zcmc;
	}
	public String getBgbrq() {
		return bgbrq;
	}
	public void setBgbrq(String bgbrq) {
		this.bgbrq = bgbrq;
	}
	public String getBsxrq() {
		return bsxrq;
	}
	public void setBsxrq(String bsxrq) {
		this.bsxrq = bsxrq;
	}
	public String getZcflmc() {
		return zcflmc;
	}
	public void setZcflmc(String zcflmc) {
		this.zcflmc = zcflmc;
	}
	public String getTtzlymc() {
		return ttzlymc;
	}
	public void setTtzlymc(String ttzlymc) {
		this.ttzlymc = ttzlymc;
	}
	public String getBbbxsmc() {
		return bbbxsmc;
	}
	public void setBbbxsmc(String bbbxsmc) {
		this.bbbxsmc = bbbxsmc;
	}
	public String getZcwh() {
		return zcwh;
	}
	public void setZcwh(String zcwh) {
		this.zcwh = zcwh;
	}
	public String getZcnr() {
		return zcnr;
	}
	public void setZcnr(String zcnr) {
		this.zcnr = zcnr;
	}
	public String getBzdjgmc() {
		return bzdjgmc;
	}
	public void setBzdjgmc(String bzdjgmc) {
		this.bzdjgmc = bzdjgmc;
	}
	public String getBsxfwmc() {
		return bsxfwmc;
	}
	public void setBsxfwmc(String bsxfwmc) {
		this.bsxfwmc = bsxfwmc;
	}
	public String getZtcmc() {
		return ztcmc;
	}
	public void setZtcmc(String ztcmc) {
		this.ztcmc = ztcmc;
	}
	public String getGjzmc() {
		return gjzmc;
	}
	public void setGjzmc(String gjzmc) {
		this.gjzmc = gjzmc;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	@Override
	public String toString() {
		return "zcfg [id=" + id + ", zcmc=" + zcmc + ", bgbrq=" + bgbrq + ", bsxrq=" + bsxrq + ", zcflmc=" + zcflmc
				+ ", ttzlymc=" + ttzlymc + ", bbbxsmc=" + bbbxsmc + ", zcwh=" + zcwh + ", zcnr=" + zcnr + ", bzdjgmc="
				+ bzdjgmc + ", bsxfwmc=" + bsxfwmc + ", ztcmc=" + ztcmc + ", gjzmc=" + gjzmc + ", username=" + username
				+ "]";
	}
	public zcfg() {
		
	}
	
	
	
}
