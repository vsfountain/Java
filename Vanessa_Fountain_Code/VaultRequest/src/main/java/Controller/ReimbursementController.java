 package Controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import ServiceLayer.VaultService;
import ServiceLayer.VaultServiceImplementation;

public class ReimbursementController {

	public static void viewRequests(HttpServletRequest req, HttpServletResponse resp) throws JsonProcessingException, IOException {
		VaultService dweller = new VaultServiceImplementation();
		//CONTROLLER TO DISPLAY ALL REQUESTS
		HashMap<String, Integer> requests = dweller.displayAllRequests();
		System.out.println(requests);
		resp.getWriter().write(new ObjectMapper().writeValueAsString(requests));
	}
	public static String insertRequest(HttpServletRequest req) throws JsonProcessingException, IOException{
		System.out.println(req.getParameter("amount"));
		System.out.println(req.getParameter("type"));
		System.out.println(req.getParameter("your-message"));
		System.out.println(req.getSession().getAttribute("loggedID"));
		VaultService newReq = new VaultServiceImplementation();
		
		double amount = Double.parseDouble(req.getParameter("amount"));
		int type = Integer.parseInt(req.getParameter("type"));
		String message = req.getParameter("your-message");
		Integer loggedId= (Integer) req.getSession().getAttribute("loggedID");
		if(amount < 0 || type > 4 || type < 0) {
			return "/dweller.vault867";
		}else {
		
			newReq.insertReq(amount, type, message, loggedId);
		}
		
		return "/dweller.vault867";
	}
	public static void viewPastReq(HttpServletRequest req, HttpServletResponse resp) throws JsonProcessingException, IOException {
		VaultService dweller = new VaultServiceImplementation();
		Integer loggedId= (Integer) req.getSession().getAttribute("loggedID");
		HashMap<Integer, String> requests = dweller.viewMyReq(loggedId);
		System.out.println(requests);
		
		resp.getWriter().write(new ObjectMapper().writeValueAsString(requests));
	}

}
