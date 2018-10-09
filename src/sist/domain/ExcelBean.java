package sist.domain;

import java.util.ArrayList;
import java.util.List;

public class ExcelBean {

	public ExcelBean() {
		super();
		sheets = new ArrayList<>();
		firstLine = new ArrayList<>();
	}
	private List<String> sheets;
	private List<String> firstLine;
	private Integer zlh;
	private Integer sqrq;// 申请日期
	private Integer gkh;//公开号
	private Integer gkr;// 公开日期
	private Integer fmmc;//发明名称
	private Integer ipc_flh;// IPC分类号
	private Integer fmr;// 发明人
	private Integer sqr;// 申请人
	private Integer yxqr;
	private Integer yxqh;// 优先权号
	private Integer flzt;// 法律状态
	private Integer sqrdz;// 申请人地址
	private Integer zy;// 摘要
	private Integer ztzlk_id;// 本专利所属专题专利库的id号
	private String username;// 
	private Integer maxRow;
	private Integer maxColumn;
	
	
	
	public Integer getMaxRow() {
		return maxRow;
	}
	public void setMaxRow(Integer maxRow) {
		this.maxRow = maxRow;
	}
	public Integer getMaxColumn() {
		return maxColumn;
	}
	public void setMaxColumn(Integer maxColumn) {
		this.maxColumn = maxColumn;
	}
	public List<String> getSheets() {
		return sheets;
	}
	public void setSheets(List<String> sheets) {
		this.sheets = sheets;
	}
	public Integer getZlh() {
		return zlh;
	}
	public void setZlh(Integer zlh) {
		this.zlh = zlh;
	}
	public Integer getSqrq() {
		return sqrq;
	}
	public void setSqrq(Integer sqrq) {
		this.sqrq = sqrq;
	}
	public Integer getGkh() {
		return gkh;
	}
	public void setGkh(Integer gkh) {
		this.gkh = gkh;
	}
	public Integer getGkr() {
		return gkr;
	}
	public void setGkr(Integer gkr) {
		this.gkr = gkr;
	}
	public Integer getFmmc() {
		return fmmc;
	}
	public void setFmmc(Integer fmmc) {
		this.fmmc = fmmc;
	}
	public Integer getIpc_flh() {
		return ipc_flh;
	}
	public void setIpc_flh(Integer ipc_flh) {
		this.ipc_flh = ipc_flh;
	}
	public Integer getFmr() {
		return fmr;
	}
	public void setFmr(Integer fmr) {
		this.fmr = fmr;
	}
	public Integer getSqr() {
		return sqr;
	}
	public void setSqr(Integer sqr) {
		this.sqr = sqr;
	}
	public Integer getYxqr() {
		return yxqr;
	}
	public void setYxqr(Integer yxqr) {
		this.yxqr = yxqr;
	}
	public Integer getYxqh() {
		return yxqh;
	}
	public void setYxqh(Integer yxqh) {
		this.yxqh = yxqh;
	}
	public Integer getFlzt() {
		return flzt;
	}
	public void setFlzt(Integer flzt) {
		this.flzt = flzt;
	}
	public Integer getSqrdz() {
		return sqrdz;
	}
	public void setSqrdz(Integer sqrdz) {
		this.sqrdz = sqrdz;
	}
	public Integer getZy() {
		return zy;
	}
	public void setZy(Integer zy) {
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
	public List<String> getFirstLine() {
		return firstLine;
	}
	public void setFirstLine(List<String> firstLine) {
		this.firstLine = firstLine;
	}
	@Override
	public String toString() {
		return "ExcelBean [sheets=" + sheets + ", firstLine=" + firstLine + ", zlh=" + zlh + ", sqrq=" + sqrq + ", gkh="
				+ gkh + ", gkr=" + gkr + ", fmmc=" + fmmc + ", ipc_flh=" + ipc_flh + ", fmr=" + fmr + ", sqr=" + sqr
				+ ", yxqr=" + yxqr + ", yxqh=" + yxqh + ", flzt=" + flzt + ", sqrdz=" + sqrdz + ", zy=" + zy
				+ ", ztzlk_id=" + ztzlk_id + ", username=" + username + ", maxRow=" + maxRow + ", maxColumn="
				+ maxColumn + "]";
	}
	
}
