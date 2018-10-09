package sist.domain;

import own.dome.annotation.DBTabCol;
import own.dome.annotation.DBTable;

/**
 * @author ÔÃ¶û
 *ºÏ×÷Õ¾µã
 */
@DBTable("HZZD")
public class CoopSite {
	@DBTabCol(value="id",primaryKey=true)
	private Integer id;
	
	private String name;
	private String link;
	private String type;
	@DBTabCol(value="hits",ignoreZore=true)
	private Integer hites;
	private String date;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Integer getHites() {
		return hites;
	}
	public void setHites(Integer hites) {
		this.hites = hites;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "CoopSite [id=" + id + ", name=" + name + ", link=" + link + ", type=" + type + ", hites=" + hites
				+ ", date=" + date + "]";
	}
	
	
}
