package sist.domain;
/**
 * �Ƽ��ɹ�ģ�飬�����ɹ������ͳɹ�ת����Ŀ��ֻ�Ƕ�����ģ��ļ�ͳ��
 * @author wzw
 *
 */
public class kjcg {
	private Integer id;
	private String km;//�ɹ����ͣ��ɹ��������߳ɹ�ת����Ŀ��
	private String mc;//�ɹ�����
	
	private String time;//�ύ����
	private String dw;//��λ
	private String username;//�û���
	private Integer hits=0;
	
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
	public String getKm() {
		return km;
	}
	public void setKm(String km) {
		this.km = km;
	}
	public String getMc() {
		return mc;
	}
	public void setMc(String mc) {
		this.mc = mc;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getDw() {
		return dw;
	}
	public void setDw(String dw) {
		this.dw = dw;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	@Override
	public String toString() {
		return "kjcg [id=" + id + ", km=" + km + ", mc=" + mc + ", time=" + time + ", dw=" + dw + ", username="
				+ username + "]";
	}
	public kjcg() {
	}
	
	
}
