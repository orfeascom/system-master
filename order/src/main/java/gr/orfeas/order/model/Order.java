package gr.orfeas.order.model;

import javax.xml.bind.annotation.XmlRootElement;
import gr.orfeas.user.model.User;

@XmlRootElement
public class Order {
	private int id;
	private String address;
	private int cardid;
	private User client;
	private String status = null;
	private String datecr = null;
	private String datecmpl = null;
	private String stalling = null;
	private String deleted = null;
	
	public Order() {}

	public Order(int id, String address, int cardid, User client, String status, String datecr) {
		super();
		this.id = id;
		this.address = address;
		this.cardid = cardid;
		this.client = client;
		this.status = status;
		this.datecr = datecr;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getCardid() {
		return cardid;
	}

	public void setCardid(int cardid) {
		this.cardid = cardid;
	}

	public User getClient() {
		return client;
	}

	public void setClient(User client) {
		this.client = client;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDatecr() {
		return datecr;
	}

	public void setDatecr(String datecr) {
		this.datecr = datecr;
	}

	public String getDatecmpl() {
		return datecmpl;
	}

	public void setDatecmpl(String datecmpl) {
		this.datecmpl = datecmpl;
	}

	public String getStalling() {
		return stalling;
	}

	public void setStalling(String stalling) {
		this.stalling = stalling;
	}

	public String getDeleted() {
		return deleted;
	}

	public void setDeleted(String deleted) {
		this.deleted = deleted;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", address=" + address + ", cardid=" + cardid + ", client=" + client + ", status="
				+ status + ", datecr=" + datecr + ", datecmpl=" + datecmpl + ", stalling=" + stalling + ", deleted="
				+ deleted + "]";
	}
	
	
}
