package sist.domain;
/**
 * 科技成果模块，包括成功案例和成果转化项目，只是对两个模块的简单统计
 * @author wzw
 *
 */
public class kjcg {
	private Integer id;
	private String km;//成果类型（成功案例或者成果转化项目）
	private String mc;//成果名称
	
	private String time;//提交日期
	private String dw;//单位
	private String username;//用户名
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
