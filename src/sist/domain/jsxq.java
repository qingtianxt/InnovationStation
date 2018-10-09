package sist.domain;

public class jsxq {
	private Integer id;
	private String mc;//技术需求名称
	private String ly_js;//技术所属领域（存取技术名词的id，中间用，隔开）
	
	private String hzfs;//合作方式包括成果引进，联合研发和其他
	private String gjc;//关键词
	private String nr_xq;//技术需求说明
	
	private String mc_dw;//技术需求单位
	private String dz_dw;//单位地址
	private String lxr;//联系人
	
	private String dh_lx;//联系电话
	private String email;
	private String jj_dw;//单位情况简介
	
	private String yt_tr;//投入总资金及用途
	private String xmzk;//项目状况
	private String rcxx;//人才信息
	
	private String zjxx;//资金信息
	private String time;//添加时间
	private String username;//添加的用户名
	
	private Integer sh;//信息审核的状态，0未审核，-1退回 1审核通过
	private String shyj;//审核意见
	private Integer hits=0;//
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
	public String getMc() {
		return mc;
	}
	public void setMc(String mc) {
		this.mc = mc;
	}
	public String getLy_js() {
		return ly_js;
	}
	public void setLy_js(String ly_js) {
		this.ly_js = ly_js;
	}
	public String getHzfs() {
		return hzfs;
	}
	public void setHzfs(String hzfs) {
		this.hzfs = hzfs;
	}
	public String getGjc() {
		return gjc;
	}
	public void setGjc(String gjc) {
		this.gjc = gjc;
	}
	public String getNr_xq() {
		return nr_xq;
	}
	public void setNr_xq(String nr_xq) {
		this.nr_xq = nr_xq;
	}
	public String getMc_dw() {
		return mc_dw;
	}
	public void setMc_dw(String mc_dw) {
		this.mc_dw = mc_dw;
	}
	public String getDz_dw() {
		return dz_dw;
	}
	public void setDz_dw(String dz_dw) {
		this.dz_dw = dz_dw;
	}
	public String getLxr() {
		return lxr;
	}
	public void setLxr(String lxr) {
		this.lxr = lxr;
	}
	public String getDh_lx() {
		return dh_lx;
	}
	public void setDh_lx(String dh_lx) {
		this.dh_lx = dh_lx;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getJj_dw() {
		return jj_dw;
	}
	public void setJj_dw(String jj_dw) {
		this.jj_dw = jj_dw;
	}
	public String getYt_tr() {
		return yt_tr;
	}
	public void setYt_tr(String yt_tr) {
		this.yt_tr = yt_tr;
	}
	public String getXmzk() {
		return xmzk;
	}
	public void setXmzk(String xmzk) {
		this.xmzk = xmzk;
	}
	public String getRcxx() {
		return rcxx;
	}
	public void setRcxx(String rcxx) {
		this.rcxx = rcxx;
	}
	public String getZjxx() {
		return zjxx;
	}
	public void setZjxx(String zjxx) {
		this.zjxx = zjxx;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getShyj() {
		return shyj;
	}
	public void setShyj(String shyj) {
		this.shyj = shyj;
	}
	public Integer getSh() {
		return sh;
	}
	public void setSh(Integer sh) {
		this.sh = sh;
	}
	@Override
	public String toString() {
		return "jsxq [id=" + id + ", mc=" + mc + ", ly_js=" + ly_js + ", hzfs=" + hzfs + ", gjc=" + gjc + ", nr_xq="
				+ nr_xq + ", mc_dw=" + mc_dw + ", dz_dw=" + dz_dw + ", lxr=" + lxr + ", dh_lx=" + dh_lx + ", email="
				+ email + ", jj_dw=" + jj_dw + ", yt_tr=" + yt_tr + ", xmzk=" + xmzk + ", rcxx=" + rcxx + ", zjxx="
				+ zjxx + ", time=" + time + ", username=" + username + ", sh=" + sh + ", shyj=" + shyj + "]";
	}
	public jsxq() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
