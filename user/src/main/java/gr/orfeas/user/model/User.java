package gr.orfeas.user.model;

import javax.xml.bind.annotation.XmlRootElement;
import gr.orfeas.user.info.Info;

@XmlRootElement
public class User extends Info {
	private String uname;
	private String password;
	private String fname;
	private String lname;
	private String type;

	public User() {}

	public User(String uname, String password, String fname, String lname, String type, String role) {
		super(role);
		this.uname = uname;
		this.password = password;
		this.fname = fname;
		this.lname = lname;
		this.type = type;
	};
	
	public User(String uname, String password, String fname, String lname, String type, String address, String cardtype, int cardnum, String carddate, int cardpass) {
		super(address, cardtype, cardnum, carddate, cardpass);
		this.uname = uname;
		this.password = password;
		this.fname = fname;
		this.lname = lname;
		this.type = type;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "User [uname=" + uname + ", password=" + password + ", fname=" + fname + ", lname=" + lname + ", type="
				+ type + "]";
	};
	
	
	
	
}
