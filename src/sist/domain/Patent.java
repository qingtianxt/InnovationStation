package sist.domain;

/**
 * @author 悦尔
 * 专利
 */
public class Patent {
	
	private Integer id;
	private String zlh;
	private String sqrq;// 申请日期
	private String gkh;//公开号
	private String gkr;// 公开日期
	private String fmmc;//发明名称
	private String ipc_flh;// IPC分类号
	private String fmr;// 发明人
	private String sqr;// 申请人
	private String yxqr;
	private String yxqh;// 优先权号
	private String flzt;// 法律状态
	private String sqrdz;// 申请人地址
	private String zy;// 摘要
	private Integer ztzlk_id;// 本专利所属专题专利库的id号
	private String username;// 
	private Integer hits;
	private SpecialLibrary library;
	
	
	public SpecialLibrary getLibrary() {
		return library;
	}
	public void setLibrary(SpecialLibrary library) {
		this.library = library;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	public String getGkh() {
		return gkh;
	}
	public void setGkh(String gkh) {
		this.gkh = gkh;
	}
	public String getGkr() {
		return gkr;
	}
	public void setGkr(String gkr) {
		this.gkr = gkr;
	}
	public String getFmmc() {
		return fmmc;
	}
	public void setFmmc(String fmmc) {
		this.fmmc = fmmc;
	}
	public String getIpc_flh() {
		return ipc_flh;
	}
	public void setIpc_flh(String ipc_flh) {
		this.ipc_flh = ipc_flh;
	}
	public String getFmr() {
		return fmr;
	}
	public void setFmr(String fmr) {
		this.fmr = fmr;
	}
	public String getSqr() {
		return sqr;
	}
	public void setSqr(String sqr) {
		this.sqr = sqr;
	}
	public String getYxqh() {
		return yxqh;
	}
	public void setYxqh(String yxqh) {
		this.yxqh = yxqh;
	}
	public String getFlzt() {
		return flzt;
	}
	public void setFlzt(String flzt) {
		this.flzt = flzt;
	}
	public String getSqrdz() {
		return sqrdz;
	}
	public void setSqrdz(String sqrdz) {
		this.sqrdz = sqrdz;
	}
	public String getZy() {
		return zy;
	}
	public void setZy(String zy) {
		this.zy = zy;
	}
	public Integer getZtzlk_id() {
		return ztzlk_id;
	}
	public void setZtzlk_id(Integer ztzlk_id) {
		this.ztzlk_id = ztzlk_id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Integer getHits() {
		return hits;
	}
	public void setHits(Integer hits) {
		this.hits = hits;
	}
	public String getYxqr() {
		return yxqr;
	}
	public void setYxqr(String yxqr) {
		this.yxqr = yxqr;
	}
	@Override
	public String toString() {
		return "Patent [id=" + id + ", zlh=" + zlh + ", sqrq=" + sqrq + ", gkh=" + gkh + ", gkr=" + gkr + ", fmmc="
				+ fmmc + ", ipc_flh=" + ipc_flh + ", fmr=" + fmr + ", sqr=" + sqr + ", yxqr=" + yxqr + ", yxqh=" + yxqh
				+ ", flzt=" + flzt + ", sqrdz=" + sqrdz + ", zy=" + zy + ", ztzlk_id=" + ztzlk_id + ", username="
				+ username + ", hits=" + hits + "]";
	}
	
	
	
}
