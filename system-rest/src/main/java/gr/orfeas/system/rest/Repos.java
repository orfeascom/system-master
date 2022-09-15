package gr.orfeas.system.rest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import gr.orfeas.card.model.Card;
import gr.orfeas.order.model.Order;
import gr.orfeas.user.model.User;


public class Repos {
	private static Connection getConnection() throws SQLException{
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/system","root","root");
		}catch (ClassNotFoundException e) {
			System.out.println(e);
		}
		
		return con;
	}
	
	
	
	
	
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	
	
	private static String getQuery(String str) {
		if (str == null || str.trim().equals("")) return new String("NULL");
		else return "'" + str + "'";
	}
	
	
	private static List<String> getDvds(String str) {
		List<String> dvds = new ArrayList<String>();
		String[] array = str.split(", ");
		for (String s: array) dvds.add(s);
		return dvds;
	}
	
	public static String getDvdsString(List<String> dvds) {
		String str = dvds.get(0);
		for (int i = 1; i < dvds.size(); i++) str += ", " + dvds.get(i);
		return str;
	}
	
	
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	public static boolean existsCard(int id) throws SQLException{
		boolean exists = false;
		Connection con = getConnection();
		ResultSet rs = con.createStatement().executeQuery("select * from card where id='" + id + "'");
		if(rs.next()) {
			exists = true;
		}
		con.close();
		return exists;
	}
	
	public static boolean existsOrder(int id) throws SQLException{
		boolean exists = false;
		Connection con = getConnection();
		ResultSet rs = con.createStatement().executeQuery("select * from ord where id='" + id + "'");
		if(rs.next()) {
			exists = true;
		}
		con.close();
		return exists;
	}
	
	
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	public static User getUserID(int id) throws SQLException{
		User u1 = new User();
		Connection con = getConnection();
		ResultSet rs = con.createStatement().executeQuery("select * from user where userid='" + id + "'");
		if(rs.next()) {
			u1.setUname(rs.getString("uname"));
			u1.setPassword(rs.getString("password"));
			u1.setFname(rs.getString("fname"));
			u1.setLname(rs.getString("lname"));
			u1.setType(rs.getString("type"));
			u1.setRole(rs.getString("role"));
			u1.setAddress(rs.getString("address"));
			u1.setCardtype(rs.getString("cardtype"));
			u1.setCardnum(rs.getInt("cardnum"));
			u1.setCarddate(rs.getString("carddate"));
			u1.setCardpass(rs.getInt("cardpass"));
			u1.setUserid(rs.getInt("userid"));	
		}
		
		con.close();

		return u1;
	}
	
	public static List<User> getUser() throws SQLException{
		List<User> a1 = new ArrayList<User>();
		Connection con = getConnection();
		ResultSet rs = con.createStatement().executeQuery("select * from user");
		while(rs.next()) {
			User u1 = new User();
			u1.setUname(rs.getString("uname"));
			u1.setPassword(rs.getString("password"));
			a1.add(u1);
		}
		
		con.close();

		return a1;
	}
	
	
	
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	public static Card getCard(int id) throws SQLException{
		Card c1 = new Card();
		Connection con = getConnection();
		
		try {
			ResultSet rs = con.createStatement().executeQuery("select * from card where id='" + id + "'");
			if(rs.next()) {
					c1.setId(rs.getInt("id"));
					String dvd = rs.getString("dvds");
					List<String> dvds = getDvds(dvd);
					c1.setDvds(dvds);
					c1.setDvdnum(rs.getInt("dvdnum"));
					c1.setDate(rs.getString("date"));
					c1.setCost(rs.getInt("cost"));
					c1.setStatus(rs.getString("status"));
				
			}
			con.close();
		}
		catch (Exception e) {
			System.out.println(e);
		}

		return c1;
	}
	
	public static List<Card> getCards() throws SQLException{
		List<Card> a1 = new ArrayList<Card>();
		Connection con = getConnection();
		ResultSet rs = con.createStatement().executeQuery("select * from card");
		while(rs.next()) {
			if(rs.getString("status") != "deleted") {
				Card c1 = new Card();
				c1.setId(rs.getInt("id"));
				String dvd = rs.getString("dvds");
				List<String> dvds = getDvds(dvd);
				c1.setDvds(dvds);
				c1.setDvdnum(rs.getInt("dvdnum"));
				c1.setDate(rs.getString("date"));
				c1.setCost(rs.getInt("cost"));
				c1.setStatus(rs.getString("status"));
				a1.add(c1);
			}
		}
		
		con.close();

		return a1;
	}
	
	public static List<Card> getCards(int userid) throws SQLException{
		List<Card> a1 = new ArrayList<Card>();
		Connection con = getConnection();
		ResultSet rs = con.createStatement().executeQuery("select * from card where userid='" + userid + "'");
		while(rs.next()) {
			if(rs.getString("status") != "deleted") {
				Card c1 = new Card();
				c1.setId(rs.getInt("id"));
				String dvd = rs.getString("dvds");
				List<String> dvds = getDvds(dvd);
				c1.setDvds(dvds);
				c1.setDvdnum(rs.getInt("dvdnum"));
				c1.setDate(rs.getString("date"));
				c1.setCost(rs.getInt("cost"));
				c1.setStatus(rs.getString("status"));
				c1.setUserid(rs.getInt("userid"));
				a1.add(c1);
			}
		}
		
		con.close();
		
		
		return a1;
	}
	
	
	
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	
	public static List<Order> getOrders() throws SQLException{
		List<Order> a1 = new ArrayList<Order>();
		Connection con = getConnection();
		ResultSet rs = con.createStatement().executeQuery("select * from ord");
		while(rs.next()) {
			if(rs.getString("deleted") != "deleted") {
				Order c1 = new Order();
				c1.setId(rs.getInt("id"));
				c1.setAddress(rs.getString("address"));
				c1.setCardid(rs.getInt("cardid"));
				c1.setUserid(rs.getInt("userid"));
				c1.setStatus(rs.getString("status"));
				c1.setDatecr(rs.getString("datecr"));
				c1.setDatecmpl(rs.getString("datecmpl"));
				c1.setStalling(rs.getString("stalling"));
				c1.setDeleted(rs.getString("deleted"));
				a1.add(c1);
			}
		}
		
		con.close();

		return a1;
	}
	
	public static List<Order> getOrders(int userid) throws SQLException{
		List<Order> a1 = new ArrayList<Order>();
		Connection con = getConnection();
		ResultSet rs = con.createStatement().executeQuery("select * from ord where userid='" + userid + "'");
		while(rs.next()) {
			if(rs.getString("deleted") != "deleted") {
				Order c1 = new Order();
				c1.setId(rs.getInt("id"));
				c1.setAddress(rs.getString("address"));
				c1.setCardid(rs.getInt("cardid"));
				c1.setUserid(rs.getInt("userid"));
				c1.setStatus(rs.getString("status"));
				c1.setDatecr(rs.getString("datecr"));
				c1.setDatecmpl(rs.getString("datecmpl"));
				c1.setStalling(rs.getString("stalling"));
				c1.setDeleted(rs.getString("deleted"));
				a1.add(c1);
			}
		}
		
		con.close();

		return a1;
	}
		
	public static Order getOrder(int id) throws SQLException{
		Order c1 = new Order();
		Connection con = getConnection();
		try {
		ResultSet rs = con.createStatement().executeQuery("select * from ord where id='" + id + "'");
		
		if(rs.next()) {
			c1.setId(rs.getInt("id"));
			c1.setAddress(rs.getString("address"));
			c1.setCardid(rs.getInt("cardid"));
			c1.setUserid(rs.getInt("userid"));
			c1.setStatus(rs.getString("status"));
			c1.setDatecr(rs.getString("datecr"));
			c1.setDatecmpl(rs.getString("datecmpl"));
			c1.setStalling(rs.getString("stalling"));
			c1.setDeleted(rs.getString("deleted"));
		}
		
		con.close();
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return c1;
	}

	
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	public static void createCard ( Card card ) throws SQLException {
		Connection con = getConnection();
		String sql = "insert into card values (?,?,?,?,?,?,?)";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, card.getId());
			ps.setInt(2, card.getUserid());
			ps.setString(3, getDvdsString(card.getDvds()));
			ps.setInt(4, card.getDvdnum());
			ps.setString(5, card.getDate());
			ps.setInt(6, card.getCost());
			ps.setString(7, card.getStatus());
			
			ps.executeUpdate();
			
			con.close();
			
			Timer timer = new Timer();
			TimerTask task = new TimerTask() {

				@Override
				public void run() {
					System.out.println("Creating order for userid: " + card.getUserid());
					try {
						createOrder(card);
					} catch (SQLException e) {
						System.out.println(e);
					}
				}
			};
			timer.schedule(task, 10000);
			
		}
		catch(Exception e) {
		System.out.println(e);
		}
	}


	private static void createOrder(Card card) throws SQLException{
		Connection con = getConnection();
		String address = null;
		Random rand = new Random();
		String sql = "insert into ord values (?,?,?,?,?,?,?,?,?)";
		try {
			System.out.println("Creating order...");
			ResultSet rs = con.createStatement().executeQuery("select * from user where userid='" + card.getUserid() + "'");
			if(rs.next()) {
				System.out.println("Got the address!");
				address = rs.getString("address");
			}
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, rand.nextInt(20));
			ps.setString(2, address);
			ps.setInt(3, card.getId());
			ps.setInt(4, card.getUserid());
			ps.setString(5, "created");
			ps.setString(6, card.getDate());
			ps.setString(7, null);
			ps.setString(8, null);
			ps.setString(9, null);
			
			ps.executeUpdate();
			
			con.close();
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
	}
	
	
	
	
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
	
	public static void updateCard(Card card) throws SQLException{
		Connection con = getConnection();
		String sql = "update card set id=?, userid=?, dvds=?, dvdnum=?, date=?, cost=?, status=? where id=?";
		try {
			System.out.println("Updating card...");
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, card.getId());
			ps.setInt(2, card.getUserid());
			ps.setString(3, getDvdsString(card.getDvds()));
			ps.setInt(4, card.getDvdnum());
			ps.setString(5,card.getDate());
			ps.setInt(6, card.getCost());
			ps.setString(7, card.getStatus());
			ps.setInt(8, card.getId());
			
			ps.executeUpdate();
			
			con.close();
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	
	
	public static void updateOrder(Order order) throws SQLException{
		Connection con = getConnection();
		String sql = "update ord set id=?, address=?, cardid=?, userid=?, status=?, datecr=?, datecmpl=?, stalling=?, deleted=? where id=?";
		try {
			System.out.println("Updating order...");
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, order.getId());
			ps.setString(2, order.getAddress());
			ps.setInt(3, order.getCardid());
			ps.setInt(4, order.getUserid());
			ps.setString(5, order.getStatus());
			ps.setString(6, order.getDatecr());
			ps.setString(7, order.getDatecmpl());
			ps.setString(8, order.getStalling());
			ps.setString(9, order.getDeleted());
			ps.setInt(10, order.getId());
			
			ps.executeUpdate();
			
			con.close();
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	
	
	
	
	/*public static boolean existsCard(int id) throws SQLException{
		boolean exists = false;
		Connection con = getConnection();
		try {
			ResultSet rs = con.createStatement().executeQuery("select * from card where id='" + id + "'");
		}
	}
	*/
	
}
