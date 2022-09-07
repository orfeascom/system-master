package gr.orfeas.card.model;

import gr.orfeas.user.model.User;
import java.util.List;

public class Card {
	private int id;
	private User user;
	private List<String> dvd;
	private int dvdnum;
	private String date;
	private int cost;
	
	public Card() {}

	public Card(int id, User user, List<String> dvd, int dvdnum, String date, int cost) {
		super();
		this.id = id;
		this.user = user;
		this.dvd = dvd;
		this.dvdnum = dvdnum;
		this.date = date;
		this.cost = cost;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<String> getDvd() {
		return dvd;
	}

	public void setDvd(List<String> dvd) {
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

	@Override
	public String toString() {
		return "Order [id=" + id + ", user=" + user + ", dvd=" + dvd + ", dvdnum=" + dvdnum + ", date=" + date
				+ ", cost=" + cost + "]";
	}
	
	
	
	
	
}
