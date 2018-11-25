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
		
		int userID = dweller.getUserInfo(username, password);
		
		System.out.println(dweller.getUserInfo(username, password));
		if( userID != 1) {
			return "Index.html";

		}else {
			req.getSession().setAttribute("loggedusername", username);
			req.getSession().setAttribute("loggedpassword", password);
			
			return "/home.vault867";
			//return "resources/html/ReqForm.html";
		}
	}
		
}
