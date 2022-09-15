package gr.orfeas.system.rest;

import java.net.URI;
import java.sql.SQLException;
import java.util.List;

import jakarta.ws.rs.BadRequestException;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.NotFoundException;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriInfo;
import gr.orfeas.card.model.Card;
import gr.orfeas.order.model.Order;
import gr.orfeas.user.model.User;
import gr.orfeas.login.Login;

/**
 * Root resource (exposed at "services" path)
 */
@Path("services")
public class Services {


	
			Repos rep = new Repos();
			//Login log = new Login();
			// private static int admin = -1;
			private static User user = new User();
			
	/*public static void setUserByClient(User u1) {
		user = u1;
		System.out.println("In setUserByClient " + user);
	}*/
	
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {
    	
    	user = Login.getAuth();
    	if(user.getRole() != null) {
    		System.out.println("Authorized!");	
    		return "Authorized!";

    	}
    	
        return "You need to log in first!";

    }
    
    @Path("/user")
    @GET
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML,MediaType.TEXT_XML})
    public User getUser() throws SQLException {
    	System.out.println("In get user " + user);
    	if(user.getRole() != null) {
        	if(user.getRole().equals("client"))
        	{
        		System.out.println("Authorized!");
        		System.out.println("Initialiting connection");
        		return user;
        	}
        	else System.out.println("User info available to clients only!");	       	
        }
    	else System.out.println("Need to log in first...");
    	
        return null;
    }
    
    @Path("/user{id}")
    @GET
    @Produces({MediaType.APPLICATION_XML})
    public User getUserID(@PathParam("id") int id) throws SQLException, NotFoundException {
    	
    	if(user.getRole() != null) {
    		if(user.getRole().equals("employee"))
    		{
    			System.out.println("Initialiting connection as admin...");
    			User u1 = Repos.getUserID(id);
    			if(u1.getUname() != null) {
    				return u1;
    			}
        	else throw new NotFoundException();
    		}
    		else {
    			System.out.println("Service available to admins only...");
    			return null;
    		}
    	}
    	System.out.println("You need to log in first...");       	
        return null;
    }
    
    
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    
    @Path("/card{id}")
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public Card getCard(@PathParam("id") int id) throws SQLException, NotFoundException {
    	
    	if(user.getRole() != null) {
    		if(user.getRole().equals("employee")) {
    			System.out.println("Initializing connection as admin...");
    			Card c1 = Repos.getCard(id);
    			if(c1.getId() > 0) return c1;
    			else throw new NotFoundException();
    		}
    		else {
    			System.out.println("Service available to admins only...");
    			return null;
    			
    		}
    	}
    	
    	System.out.println("You need to log in first...");
    	return null;
    }
    
    @Path("/cards")
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public List<Card> getCards() throws SQLException, NotFoundException {
    	
    	if(user.getRole() != null) {
    		if(user.getRole().equals("employee")) {
    			System.out.println("Initializing connection as admin...");
    			return Repos.getCards();
    		}
    		else {
    			System.out.println("Initializing connection");
    			List<Card> c1 = Repos.getCards(user.getUserid());
    			if(c1.size() != 0) return c1;
    			else throw new NotFoundException();
    			
    		}
    	}
    	
    	System.out.println("You need to log in first...");
    	return null;
    }
    
    
    @Path("/cards{userid}")
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public List<Card> getCards(@PathParam("userid") int userid) throws SQLException, NotFoundException {
    	
    	/*if(user.getRole() != null) {
    		if(user.getRole().equals("employee")) {
    			System.out.println("Initializing connection as admin...");*/
    			System.out.println("Initializing connection...");
    			List<Card> c1 = Repos.getCards(userid);
    			if(c1.size() != 0) return c1;
    			else throw new NotFoundException();
    		/*}
    		else {
    			System.out.println("Service available to admins only...");
    			return null;
    			
    		}
    	}
    	
    	System.out.println("You need to log in first...");
    	return null;*/
    }
    
    
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
       
    
      
    @Path("/orders")
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public List<Order> getOrders() throws SQLException {
    	
    	if(user.getRole() != null) {
    		if(user.getRole().equals("employee")) {
    			System.out.println("Initializing connection as admin...");
    			return Repos.getOrders();
    		}
    		else {
    			System.out.println("Initializing connection");
    			List<Order> o1 = Repos.getOrders(user.getUserid());
    			if(o1.size() != 0) return o1;
    			else throw new NotFoundException();
    			
    		}
    	}
    	
    	System.out.println("You need to log in first...");
    	return null;
    	
    }
    
    
    @Path("/orders{userid}")
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public List<Order> getOrders(@PathParam("userid") int userid) throws NotFoundException, SQLException {
    	
    	if(user.getRole() != null) {
    		if(user.getRole().equals("employee")) {
    			System.out.println("Initializing connection as admin...");
    			List<Order> o1 = Repos.getOrders(userid);
    			if(o1.size() != 0) return o1;
    			else throw new NotFoundException();
    		}
    		else {
    			System.out.println("Service available to admins only...");
    			return null;
    			
    		}
    	}
    	
    	System.out.println("You need to log in first...");
    	return null;

    }
    
    @Path("/order{id}")
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public Order getOrder(@PathParam("id") int id) throws NotFoundException, SQLException {
    	
    	if(user.getRole() != null) {
    		if(user.getRole().equals("employee")) {
    			System.out.println("Initializing connection as admin...");
    			Order o1 = Repos.getOrder(id);
    			if(o1.getId() > 0) return o1;
    			else throw new NotFoundException();
    		}
    		else {
    			System.out.println("Initializing connection...");
    			Order o1 = Repos.getOrder(id);
    			if(o1.getId() > 0) {
    				if(o1.getUserid() == user.getUserid()) {
    					return o1;
    				}
    				else System.out.println("Cannot provide order info for another user");
    			}
    			else throw new NotFoundException();
    		}
    	}
    	
    	System.out.println("You need to log in first...");
    	return null;

    }
    
    
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    @Path("/create/card")
    @POST
    @Consumes(MediaType.APPLICATION_XML)
    public Response createCard (Card card, @Context UriInfo UriInfo) throws BadRequestException, SQLException {
    	
    	if(user.getRole() != null) {
    		
    		String cardid = String.valueOf(card.getId());
    		int id = card.getId();
	    	if(id <= 0) throw new BadRequestException();
	
	    	if(card.getUserid() <= 0) throw new BadRequestException();
	    		
	    	List<String> dvds = card.getDvds();
	    	if(dvds == null || dvds.isEmpty()) throw new BadRequestException();
	    	
	    	if(card.getDvdnum() <= 0) throw new BadRequestException();
	    	
	    	String date = card.getDate();
	    	if(date == null || date.trim().equals("")) throw new BadRequestException();
	    	
	    	if(card.getCost() <= 0) throw new BadRequestException();
	    	
	    	String status = card.getStatus();
	    	if(status == null || status.trim().equals("")) throw new BadRequestException();
    	
    	
    		if(user.getRole().equals("employee")) {
    			System.out.println("Initializing connection as admin...");
    			if(!Repos.existsCard(id)) {
    				Repos.createCard(card);
    				URI uri = UriInfo.getAbsolutePathBuilder().path(cardid).build();
    				return Response.created(uri).entity(card).build();
    			}
    			else throw new BadRequestException();
    		}
    		else if(user.getUserid() == card.getUserid()) { 
    			System.out.println("Initializing connection");
    			if(!Repos.existsCard(id)) {
    				Repos.createCard(card);
    				URI uri = UriInfo.getAbsolutePathBuilder().path(cardid).build();
    				return Response.created(uri).entity(card).build();
    			}
    			else System.out.println("Card already exists!...");
    		}
    		else System.out.println("Cannot create a card for another user (content available to admins only)");    			

    	}
    	System.out.println("You need to log in first...");
    	return null;
    }
    
    
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    
    @PUT
    @Path("/update/card{id}")
    @Consumes(MediaType.APPLICATION_XML)
    public Response putCard(@PathParam("id") int id, Card card) throws BadRequestException, NotFoundException, SQLException{
		if(user.getRole() != null) {
	    	
		    if(id <= 0) throw new BadRequestException();
		
		    if(card.getUserid() <= 0) throw new BadRequestException();
		    		
		   	List<String> dvds = card.getDvds();
		   	if(dvds == null || dvds.isEmpty()) throw new BadRequestException();
		    	
		   	if(card.getDvdnum() <= 0) throw new BadRequestException();
		   	
		   	String date = card.getDate();
	    	if(date == null || date.trim().equals("")) throw new BadRequestException();
	    	
	    	if(card.getCost() <= 0) throw new BadRequestException();
		    	
		   	String status = card.getStatus();
		    if(status == null || status.trim().equals("")) throw new BadRequestException();
	    	
	    	
	    	if(user.getRole().equals("employee")) {
	    		System.out.println("Initializing connection as admin...");
	    		if(Repos.existsCard(id)) {
	    			Repos.updateCard(card);
	    			return Response.ok().build();
	    		}
	    		else throw new NotFoundException();	    		
	    	}
	    	else if(user.getUserid() == card.getUserid()) { 
	    		System.out.println("Initializing connection");
	    		if(Repos.existsCard(id)) {
	    			Repos.updateCard(card);
	    			return Response.ok().build();
	    		}
	    		else throw new NotFoundException();
	    	}
	    	else System.out.println("Cannot update a card for another user (content available to admins only)");    			
	
	    }
	    System.out.println("You need to log in first...");
	    return null;
    }
    
    
    @PUT
    @Path("/update/order{id}")
    @Consumes(MediaType.APPLICATION_XML)
    public Response putOrder(@PathParam("id") int id, Order order) throws BadRequestException, NotFoundException, SQLException{
		if(user.getRole() != null) {
	    	
		    if(id <= 0) throw new BadRequestException();
		    
		    String address = order.getAddress();
		    if(address == null || address.trim().equals("")) throw new BadRequestException();
		    		
		   	if(order.getCardid() <= 0) throw new BadRequestException();
		    	
		   	if(order.getUserid() <= 0) throw new BadRequestException();
		   	
		   	String status = order.getStatus();
	    	if(status == null || status.trim().equals("")) throw new BadRequestException();
	    	
	    	String datecr = order.getDatecr();
	    	if(datecr == null || datecr.trim().equals("")) throw new BadRequestException();
    	
	    	if(user.getRole().equals("employee")) {
	    		System.out.println("Initializing connection as admin...");
	    		if(Repos.existsOrder(id)) {
	    			Repos.updateOrder(order);
	    			return Response.ok().build();
	    		}
	    		else throw new NotFoundException();	    		
	    	}
	    	else if(user.getUserid() == order.getUserid()) { 
	    		System.out.println("Initializing connection");
	    		if(Repos.existsOrder(id)) {
	    			Repos.updateOrder(order);
	    			return Response.ok().build();
	    		}
	    		else throw new NotFoundException();
	    	}
	    	else System.out.println("Cannot update an order for another user (content available to admins only)");    			
	
	    }
	    System.out.println("You need to log in first...");
	    return null;
    }
}
