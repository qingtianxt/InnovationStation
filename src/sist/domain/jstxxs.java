package sist.domain;
/**
 * �ɹ�������ʽ
 * @author wzw
 *
 */
public class jstxxs {
	private Integer jstxxsid;
	private String jstxxsmc;//����������ʽ����
	public Integer getJstxxsid() {
		return jstxxsid;
	}
	public void setJstxxsid(Integer jstxxsid) {
		this.jstxxsid = jstxxsid;
	}
	public String getJstxxsmc() {
		return jstxxsmc;
	}
	public void setJstxxsmc(String jstxxsmc) {
		this.jstxxsmc = jstxxsmc;
	}
	@Override
	public String toString() {
		return "jstxxs [jstxxsid=" + jstxxsid + ", jstxxsmc=" + jstxxsmc + "]";
	}
	public jstxxs() {
	}
	
}
