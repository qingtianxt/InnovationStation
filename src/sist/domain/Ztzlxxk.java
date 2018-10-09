package sist.domain;

import own.dome.annotation.DBTabCol;
import own.dome.annotation.DBTable;

@DBTable("ZTZLXXK")
public class Ztzlxxk {
	
	private Integer id;
	private String zlmc;
	private String zlh;
	private String sqrq;
	private String flzt;
	private String zllb;
	private String zlqr;// 专利申请人
	private String sqr;
	private String qsrssdy;
	private String zlzy;
	private String xxyxq;
	private String zlxxlxfs;
	private String gjz;// 关键字
	private String username;
	@DBTabCol(value="hits",ignoreZore=true)
	private int hits;
	private Integer ztzlk_id;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getZlmc() {
		return zlmc;
	}
	public void setZlmc(String zlmc) {
		this.zlmc = zlmc;
	}
	public String getZlh() {
		return zlh;
	}
	public void setZlh(String zlh) {
		this.zlh = zlh;
	}
	public String getSqrq() {
		return sqrq;
	}
	public void setSqrq(String sqrq) {
		this.sqrq = sqrq;
	}
	public String getFlzt() {
		return flzt;
	}
	public void setFlzt(String flzt) {
		this.flzt = flzt;
	}
	public String getZllb() {
		return zllb;
	}
	public void setZllb(String zllb) {
		this.zllb = zllb;
	}
	public String getZlqr() {
		return zlqr;
	}
	public void setZlqr(String zlqr) {
		this.zlqr = zlqr;
	}
	public String getSqr() {
		return sqr;
	}
	public void setSqr(String sqr) {
		this.sqr = sqr;
	}
	public String getQsrssdy() {
		return qsrssdy;
	}
	public void setQsrssdy(String qsrssdy) {
		this.qsrssdy = qsrssdy;
	}
	public String getZlzy() {
		return zlzy;
	}
	public void setZlzy(String zlzy) {
		this.zlzy = zlzy;
	}
	public String getXxyxq() {
		return xxyxq;
	}
	public void setXxyxq(String xxyxq) {
		this.xxyxq = xxyxq;
	}
	public String getZlxxlxfs() {
		return zlxxlxfs;
	}
	public void setZlxxlxfs(String zlxxlxfs) {
		this.zlxxlxfs = zlxxlxfs;
	}
	public String getGjz() {
		return gjz;
	}
	public void setGjz(String gjz) {
		this.gjz = gjz;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getHits() {
		return hits;
	}
	public void setHits(int hits) {
		this.hits = hits;
	}
	public Integer getZtzlk_id() {
		return ztzlk_id;
	}
	public void setZtzlk_id(Integer ztzlk_id) {
		this.ztzlk_id = ztzlk_id;
	}
	@Override
	public String toString() {
		return "Ztzlxxk [id=" + id + ", zlmc=" + zlmc + ", zlh=" + zlh + ", sqrq=" + sqrq + ", flzt=" + flzt + ", zllb="
				+ zllb + ", zlqr=" + zlqr + ", sqr=" + sqr + ", qsrssdy=" + qsrssdy + ", zlzy=" + zlzy + ", xxyxq="
				+ xxyxq + ", zlxxlxfs=" + zlxxlxfs + ", gjz=" + gjz + ", username=" + username + ", hits=" + hits
				+ ", ztzlk_id=" + ztzlk_id + "]";
	}
	
}
