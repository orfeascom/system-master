package gr.orfeas.client;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import gr.orfeas.card.model.Card;
import gr.orfeas.user.model.User;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.client.Invocation;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

public class Clients {
	private static int id = 1;
	private static Client client = ClientBuilder.newClient();
	private static WebTarget t = client.target("http://localhost:8080/system-rest/system/services");
	
	/*private WebTarget getTarget(String str) {
		Client client = ClientBuilder.newClient();
		WebTarget t = client.target("http://localhost:8080/system-rest/system/services" + str);
		
		return t;
	}*/
	
	/*public void getIt() {
		System.out.println("GET /services for login sequence");
		Invocation.Builder ib = t.request();
		Response res = ib.get();
		int status = res.getStatus();
		if (status >= 300){
 	    	System.out.println("Something wrong happened when calling getIt");
 	    	System.out.println(res.readEntity(String.class));
 	    }
 	    else{
 	    	System.out.println("Got successful result from invocation");
 	    	System.out.println(res.readEntity(String.class));
 	    }
	}*/
	
	
	
	public void getUser() {
		System.out.println("GET /user for login sequence");
		Invocation.Builder ib = t.request();
		Response res = ib.get();
		int status = res.getStatus();
		if (status >= 300){
 	    	System.out.println("Something wrong happened when calling getIt");
 	    	System.out.println(res.readEntity(String.class));
 	    }
 	    else{
 	    	System.out.println("Got successful result from invocation");
 	    	System.out.println(res.readEntity(String.class));
 	    }
	}
	
	public void getCardByUserid(int userid) {
		
		System.out.println("GET /CardByUserid");
		WebTarget tar = t.path("/cards" + userid);
		System.out.println(tar);
		Invocation.Builder ib = tar.request(MediaType.APPLICATION_XML);
		Response res = ib.get();
		int status = res.getStatus();
		if (status >= 300){
 	    	System.out.println("Something wrong happened when calling getCardByUserid");
 	    	System.out.println(res.readEntity(String.class));
 	    }
 	    else{
 	    	System.out.println("Got successful result from invocation");
 	    	System.out.println(res.readEntity(String.class));
 	    }
	}
	
	public void getCardById(int id) {
			
			System.out.println("GET /CardById");
			WebTarget tar = t.path("/card" + id);
			System.out.println(tar);
			Invocation.Builder ib = tar.request(MediaType.APPLICATION_XML);
			Response res = ib.get();
			int status = res.getStatus();
			if (status >= 300){
	 	    	System.out.println("Something wrong happened when calling getCardByUserid");
	 	    	System.out.println(res.readEntity(String.class));
	 	    }
	 	    else{
	 	    	System.out.println("Got successful result from invocation");
	 	    	System.out.println(res.readEntity(String.class));
	 	    }
	}
	
	public void getCards() {
		
		System.out.println("GET /Cards");
		WebTarget tar = t.path("/cards");
		System.out.println(tar);
		Invocation.Builder ib = tar.request(MediaType.APPLICATION_XML);
		Response res = ib.get();
		int status = res.getStatus();
		if (status >= 300){
 	    	System.out.println("Something wrong happened when calling getCardByUserid");
 	    	System.out.println(res.readEntity(String.class));
 	    }
 	    else{
 	    	System.out.println("Got successful result from invocation");
 	    	System.out.println(res.readEntity(String.class));
 	    }
}
	
	
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public void getOrders() {
			
			System.out.println("GET /Orders");
			WebTarget tar = t.path("/orders");
			System.out.println(tar);
			Invocation.Builder ib = tar.request(MediaType.APPLICATION_XML);
			Response res = ib.get();
			int status = res.getStatus();
			if (status >= 300){
	 	    	System.out.println("Something wrong happened when calling getCardByUserid");
	 	    	System.out.println(res.readEntity(String.class));
	 	    }
	 	    else{
	 	    	System.out.println("Got successful result from invocation");
	 	    	System.out.println(res.readEntity(String.class));
	 	    }
	}	
	
	public void getOrdersByUserid(int userid) {
		
		System.out.println("GET /OrdersByUserid");
		WebTarget tar = t.path("/orders" + userid);
		System.out.println(tar);
		Invocation.Builder ib = tar.request(MediaType.APPLICATION_XML);
		Response res = ib.get();
		int status = res.getStatus();
		if (status >= 300){
 	    	System.out.println("Something wrong happened when calling getCardByUserid");
 	    	System.out.println(res.readEntity(String.class));
 	    }
 	    else{
 	    	System.out.println("Got successful result from invocation");
 	    	System.out.println(res.readEntity(String.class));
 	    }
	}	
	
	public void getOrdersById(int id) {
			
		System.out.println("GET /OrdersById");
		WebTarget tar = t.path("/order" + id);
		System.out.println(tar);
		Invocation.Builder ib = tar.request(MediaType.APPLICATION_XML);
		Response res = ib.get();
		int status = res.getStatus();
		if (status >= 300){
	 	    System.out.println("Something wrong happened when calling getCardByUserid");
	 	    System.out.println(res.readEntity(String.class));
	 	}
	 	else{
	 	    System.out.println("Got successful result from invocation");
	 	    System.out.println(res.readEntity(String.class));
	 	}
	}
	
	
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	public Card crtCard() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter first dvd");
		String str1 = sc.nextLine();
		System.out.println("Enter second dvd");
		String str2 = sc.nextLine();
		List<String> l = new ArrayList<String>();
		l.add(str1);
		l.add(str2);
		LocalDate date = LocalDate.now();
		String str = date.toString();
		Card card = new Card(3, 201, l, 2, str, 67, "created");
		
		return card;
	}
	
	public void createCard() {
		System.out.println("POST /createCard");
		WebTarget tar = t.path("/create/card");
		System.out.println(tar);
		Invocation.Builder ib = tar.request();
		Card card = crtCard();
		Response res = ib.post(Entity.entity(card,MediaType.APPLICATION_XML));
		int status = res.getStatus();
		if (status >= 300){
	 	    System.out.println("Something wrong happened when calling getCardByUserid");
	 	    System.out.println(res.readEntity(String.class));
	 	}
	 	else{
	 	    System.out.println("Got successful result from invocation");
	 	    System.out.println(res.readEntity(String.class));
	 	}
	}
	
	
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
	
	
	public void updateCard(Card card, int id) {
		System.out.println("PUT /updateCard");
		WebTarget tar = t.path("/update/card" +id);
		System.out.println(tar);
		Invocation.Builder ib = tar.request();
		Response res = ib.put(Entity.entity(card,MediaType.APPLICATION_XML));
		int status = res.getStatus();
		if (status >= 300){
	 	    System.out.println("Something wrong happened when calling updateCard");
	 	    System.out.println(res.readEntity(String.class));
	 	}
	 	else{
	 	    System.out.println("Got successful result from invocation");
	 	    System.out.println(res.readEntity(String.class));
	 	}
	}
	
	public static void main(String[] args) {
		Clients client = new Clients();
		
		
		/*User user = new User("orfeascom", "3664", "Orfeas", "Polychronidis", "employee", "admin", "zafeiraki", null, 0, null, 0, 101);
		Services.setUserByClient(user);*/
		
		
		/*client.getCardByUserid(202);
		client.getUser();
		client.getCardById(54645);
		client.getCards();
		client.getOrders();*/
		//client.getOrdersByUserid(202);
		//client.getOrdersById(1);
		//client.createCard();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter first dvd");
		String str1 = sc.nextLine();
		System.out.println("Enter second dvd");
		String str2 = sc.nextLine();
		List<String> l = new ArrayList<String>();
		l.add(str1);
		l.add(str2);
		Card card = new Card();
		card.setId(2);
		card.setUserid(205);
		card.setDvdnum(2);
		card.setDvds(l);
		card.setDate("2022-09-14");
		card.setCost(45);
		card.setStatus("created");
		client.updateCard(card, 2);

		
		
	}
	
	
	
}
