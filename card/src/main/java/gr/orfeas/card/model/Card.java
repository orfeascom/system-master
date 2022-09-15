package gr.orfeas.card.model;


import java.util.List;

import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Card {
	private int id = 0;
	private int userid = 0;
	private List<String> dvd;
	private int dvdnum = 0;
	private String date;
	private int cost = 0;
	private String status;
	
	public Card() {}

	public Card(int id, int userid, List<String> dvd, int dvdnum, String date, int cost, String status) {
		super();
		this.id = id;
		this.userid = userid;
		this.dvd = dvd;
		this.dvdnum = dvdnum;
		this.date = date;
		this.cost = cost;
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public List<String> getDvds() {
		return dvd;
	}

	public void setDvds(List<String> dvd) {
		this.dvd = dvd;
	}

	public int getDvdnum() {
		return dvdnum;
	}

	public void setDvdnum(int dvdnum) {
		this.dvdnum = dvdnum;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}
	

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", userid=" + userid + ", dvd=" + dvd + ", dvdnum=" + dvdnum + ", date=" + date
				+ ", cost=" + cost + ", status=" + status + "]";
	}
	
	
	
	
	
}
