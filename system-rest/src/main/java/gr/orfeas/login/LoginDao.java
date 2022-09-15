package gr.orfeas.login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import gr.orfeas.user.model.User;

public class LoginDao {

	public User checkLogin(String uname) {
		
		User a = new User();
		
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/system","root","root");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from user where uname='" + uname +"'" );
			if(rs.next())
			{
				a.setUname(rs.getString("uname"));
				a.setPassword(rs.getString("password"));
				a.setFname(rs.getString("fname"));
				a.setLname(rs.getString("lname"));
				a.setType(rs.getString("type"));
				a.setRole(rs.getString("role"));
				a.setAddress(rs.getString("address"));
				a.setCardtype(rs.getString("cardtype"));
				a.setCardnum(rs.getInt("cardnum"));
				a.setCarddate(rs.getString("carddate"));
				a.setCardpass(rs.getInt("cardpass"));
				a.setUserid(rs.getInt("userid"));
				
				
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
		return a;
	}
}
