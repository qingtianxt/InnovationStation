package sist.domain;

/**
 * @author �ö�
 * ר��
 */
public class Patent {
	
	private Integer id;
	private String zlh;
	private String sqrq;// ��������
	private String gkh;//������
	private String gkr;// ��������
	private String fmmc;//��������
	private String ipc_flh;// IPC�����
	private String fmr;// ������
	private String sqr;// ������
	private String yxqr;
	private String yxqh;// ����Ȩ��
	private String flzt;// ����״̬
	private String sqrdz;// �����˵�ַ
	private String zy;// ժҪ
	private Integer ztzlk_id;// ��ר������ר��ר�����id��
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
