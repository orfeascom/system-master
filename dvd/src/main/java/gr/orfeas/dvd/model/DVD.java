package gr.orfeas.dvd.model;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;


@XmlRootElement
public class DVD {
	private int dvdid;
	private String title;
	private  String director;
	private String date;
	private List<String> actors;
	private List<String> languages;
	private List<String> subs;
	private int duration;
	private List<String> genre;
	private int price;
	private int pieces;
	
	public DVD() {}

	public DVD(int dvdid, String title, String director, String date, List<String> actors, List<String> languages,
			List<String> subs, int duration, List<String> genre, int price, int pieces) {
		super();
		this.dvdid = dvdid;
		this.title = title;
		this.director = director;
		this.date = date;
		this.actors = actors;
		this.languages = languages;
		this.subs = subs;
		this.duration = duration;
		this.genre = genre;
		this.price = price;
		this.pieces = pieces;
	}

	public int getDvdid() {
		return dvdid;
	}

	public void setDvdid(int dvdid) {
		this.dvdid = dvdid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public List<String> getActors() {
		return actors;
	}

	public void setActors(List<String> actors) {
		this.actors = actors;
	}

	public List<String> getLanguages() {
		return languages;
	}

	public void setLanguages(List<String> languages) {
		this.languages = languages;
	}

	public List<String> getSubs() {
		return subs;
	}

	public void setSubs(List<String> subs) {
		this.subs = subs;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public List<String> getGenre() {
		return genre;
	}

	public void setGenre(List<String> genre) {
		this.genre = genre;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getPieces() {
		return pieces;
	}

	public void setPieces(int pieces) {
		this.pieces = pieces;
	}

	@Override
	public String toString() {
		return "DVD [dvdid=" + dvdid + ", title=" + title + ", director=" + director + ", price=" + price + ", pieces="
				+ pieces + "]";
	};
	
	
}
