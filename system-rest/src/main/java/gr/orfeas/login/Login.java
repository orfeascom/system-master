package gr.orfeas.login;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


import gr.orfeas.user.model.User;

/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {
	
	private static User a1 = new User();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uname = request.getParameter("uname");
		String pass = request.getParameter("pass");
		LoginDao dao = new LoginDao();
		a1 = dao.checkLogin(uname);
		
		
		if(uname.equals(a1.getUname()) && pass.equals(a1.getPassword()))
		{

			
			response.sendRedirect("system/services");
		}
		else
		{
			System.out.println("Wrong credentials");
			response.sendRedirect("/system-rest");
		}
		
		
	}
	
	
	public static User getAuth() {	
		System.out.println("getAuth called!");
		return a1;
	}
	

}
