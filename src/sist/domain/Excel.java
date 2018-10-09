package sist.domain;

import java.util.ArrayList;
import java.util.List;

public class Excel {
	private String path;		// Excel�ļ���ž���·��
	private List<Sheet> sheets;	// Excel�ļ������Ĺ���������
	private String username;	// ��ǰExcel�ļ������û��û���
	private Integer ztzlk_id;	// ָ����Excel�ļ��е�������Ҫ��ӵ���ר����id
	
	public Excel() {
		super();
		sheets = new ArrayList<>();
	}

	/**
	 * Ϊ��Excel�ļ����һ��������
	 * @return	����������
	 */
	public Sheet addSheet(){
		Sheet sheet = new Sheet();
		sheets.add(sheet);
		return sheet;
	}

	/**
	 * ����Excel�ļ������й�����
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
	 * @author �ö�
	 *	Excel�ļ��Ĺ�������
	 */
	public class Sheet {
		public Sheet() {
			super();
			handNames = new ArrayList<>();
		}

		private Integer num;
		private String name;
		/**
		 * �������ĵ�һ��
		 */
		private List<String> handNames;
		private Integer zlh;
		private Integer sqrq;// ��������
		private Integer gkh;// ������
		private Integer gkr;// ��������
		private Integer fmmc;// ��������
		private Integer ipc_flh;// IPC�����
		private Integer fmr;// ������
		private Integer sqr;// ������
		private Integer yxqr;
		private Integer yxqh;// ����Ȩ��
		private Integer flzt;// ����״̬
		private Integer sqrdz;// �����˵�ַ
		private Integer zy;// ժҪ
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
