package gr.orfeas.user.info;



public class Info {
	private String role = null;
	private String address = null;
	private String cardtype = null;
	private int cardnum;
	private String carddate = null;
	private int cardpass;
	
	public Info() {}

	public Info(String address, String cardtype, int cardnum, String carddate, int cardpass) {
		this.address = address;
		this.cardtype = cardtype;
		this.cardnum = cardnum;
		this.carddate = carddate;
		this.cardpass = cardpass;
	}
	
	
	public Info(String role) {
		this.role = role;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCardtype() {
		return cardtype;
	}

	public void setCardtype(String cardtype) {
		this.cardtype = cardtype;
	}

	public int getCardnum() {
		return cardnum;
	}

	public void setCardnum(int cardnum) {
		this.cardnum = cardnum;
	}

	public String getCarddate() {
		return carddate;
	}

	public void setCarddate(String carddate) {
		this.carddate = carddate;
	}

	public int getCardpass() {
		return cardpass;
	}

	public void setCardpass(int cardpass) {
		this.cardpass = cardpass;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	
	

}
