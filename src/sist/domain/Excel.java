package sist.domain;

import java.util.ArrayList;
import java.util.List;

public class Excel {
	private String path;		// Excel文件存放绝对路径
	private List<Sheet> sheets;	// Excel文件包含的工作簿数组
	private String username;	// 当前Excel文件所属用户用户名
	private Integer ztzlk_id;	// 指定此Excel文件中的内容需要添加到的专利库id
	
	public Excel() {
		super();
		sheets = new ArrayList<>();
	}

	/**
	 * 为此Excel文件添加一个工作簿
	 * @return	工作簿对象
	 */
	public Sheet addSheet(){
		Sheet sheet = new Sheet();
		sheets.add(sheet);
		return sheet;
	}

	/**
	 * 返回Excel文件的所有工作簿
	 * @return
	 */
	public List<Sheet> getSheets() {
		return sheets;
	}

	public void setSheets(List<Sheet> sheets) {
		this.sheets = sheets;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Integer getZtzlk_id() {
		return ztzlk_id;
	}

	public void setZtzlk_id(Integer ztzlk_id) {
		this.ztzlk_id = ztzlk_id;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	@Override
	public String toString() {
		return "Excel [sheets=" + sheets + ", username=" + username + ", ztzlk_id=" + ztzlk_id + "]";
	}

	/**
	 * @author 悦尔
	 *	Excel文件的工作簿类
	 */
	public class Sheet {
		public Sheet() {
			super();
			handNames = new ArrayList<>();
		}

		private Integer num;
		private String name;
		/**
		 * 工作簿的第一行
		 */
		private List<String> handNames;
		private Integer zlh;
		private Integer sqrq;// 申请日期
		private Integer gkh;// 公开号
		private Integer gkr;// 公开日期
		private Integer fmmc;// 发明名称
		private Integer ipc_flh;// IPC分类号
		private Integer fmr;// 发明人
		private Integer sqr;// 申请人
		private Integer yxqr;
		private Integer yxqh;// 优先权号
		private Integer flzt;// 法律状态
		private Integer sqrdz;// 申请人地址
		private Integer zy;// 摘要
		private Integer maxRow;
		private Integer maxColumn;

		public Integer getNum() {
			return num;
		}

		public void setNum(Integer num) {
			this.num = num;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public List<String> getHandNames() {
			return handNames;
		}

		public void setHandNames(List<String> handNames) {
			this.handNames = handNames;
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

		@Override
		public String toString() {
			return "Sheet [name=" + name + ", handNames=" + handNames + ", zlh=" + zlh + ", sqrq=" + sqrq + ", gkh="
					+ gkh + ", gkr=" + gkr + ", fmmc=" + fmmc + ", ipc_flh=" + ipc_flh + ", fmr=" + fmr + ", sqr=" + sqr
					+ ", yxqr=" + yxqr + ", yxqh=" + yxqh + ", flzt=" + flzt + ", sqrdz=" + sqrdz + ", zy=" + zy
					+ ", maxRow=" + maxRow + ", maxColumn=" + maxColumn + "]";
		}

	}
}
