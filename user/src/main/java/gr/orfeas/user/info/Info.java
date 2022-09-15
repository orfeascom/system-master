package gr.orfeas.user.info;



public class Info {
	private String type = null;
	private String address = null;
	private String cardtype = null;
	private int cardnum = 10;
	private String carddate = null;
	private int cardpass = 10;
	
	public Info() {}

	public Info(String type, String address, String cardtype, int cardnum, String carddate, int cardpass) {
		this.type = type;
		this.address = address;
		this.cardtype = cardtype;
		this.cardnum = cardnum;
		this.carddate = carddate;
		this.cardpass = cardpass;
	}
	
	
	public Info(String type) {
		this.type = type;
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	
	

}
