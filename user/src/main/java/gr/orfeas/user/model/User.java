package gr.orfeas.user.model;

import jakarta.xml.bind.annotation.XmlRootElement;
import gr.orfeas.user.info.Info;

@XmlRootElement
public class User extends Info {
	private String uname;
	private String password;
	private String fname;
	private String lname;
	private String role;
	private int userid;

	public User() {}

	public User(String uname, String password, String fname, String lname, String role, int userid, String type) {
		super(type);
		this.uname = uname;
		this.password = password;
		this.fname = fname;
		this.lname = lname;
		this.role = role;
		this.userid = userid;
	};
	
	public User(String uname, String password, String fname, String lname, String role, String type, String address, String cardtype, int cardnum, String carddate, int cardpass, int userid) {
		super(type,address, cardtype, cardnum, carddate, cardpass);
		this.uname = uname;
		this.password = password;
		this.fname = fname;
		this.lname = lname;
		this.role = role;
		this.userid = userid;
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

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	@Override
	public String toString() {
		return "User [uname=" + uname + ", password=" + password + ", fname=" + fname + ", lname=" + lname + ", role="
				+ role + "]";
	};
	
	
	
	
}
