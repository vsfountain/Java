package Controller;

import javax.servlet.http.HttpServletRequest;

import ServiceLayer.VaultService;
import ServiceLayer.VaultServiceImplementation;

public class LoginController {
	public static String login(HttpServletRequest req) {
		if(!req.getMethod().equals("POST")) {
			return "Index.html";
		}
		String username = req.getParameter("username");
		String password= req.getParameter("password");
		
		VaultService dweller = new VaultServiceImplementation();
		
		int userRole = dweller.getUserInfo(username, password);
		int userID = dweller.getUserId(username, password);
		
		System.out.println(dweller.getUserInfo(username, password));
		
		if( userRole == 1) {
			req.getSession().setAttribute("loggedID", userID);
			
			System.out.println(req.getSession().getAttribute("loggedID"));
			
			return "/dweller.vault867";

		}
		if( userRole == 2) {
			req.getSession().setAttribute("loggedID", userID);
			
			System.out.println(req.getSession().getAttribute("loggedID"));
			
			return "/home.vault867";

		}else {
			req.getSession().setAttribute("loggedusername", username);
			req.getSession().setAttribute("loggedpassword", password);
			
			return "Index.html";
		}
	}
	
	public static String logout(HttpServletRequest req) {
		
		req.getSession().invalidate();
		
		return "Index.html";
		
	}
		
}
