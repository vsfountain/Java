package com.reimbsys.controller.json;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.reimbsys.model.User;

public class JSONRequestHelper {

	public static void process(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		
		System.out.println("in JSONRequestHelper, reg: "+req.getRequestURI());
		
		switch(req.getRequestURI()) {
		case "/ExReimbSys/userHome.json":
		case "/ExReimbSys/resources/html/userHome.json":
			System.out.println("in user case");
			UserController.userFinder(req, resp);
			break;
		case "/ExReimbSys/getUsers.json":
		case "/ExReimbSys/resources/html/getUsers.json":
			System.out.println("in user case");
			UserController.retrieveUsers(req, resp);
			break;
		case "/ExReimbSys/reimbHome.json":
		case "/ExReimbSys/resources/html/reimbHome.json":
			System.out.println("in reimb case");
			ReimbursementController.reimbFinder(req, resp);
			break;
		default:
			User user = new User("johndoe", "John", "Doe");
			resp.getWriter().write(new ObjectMapper().writeValueAsString(user));
		}
		
	}
	
	public static String processForward(HttpServletRequest req) throws IOException, ServletException {
		
		System.out.println("in JSONRequestHelper, forward: "+req.getRequestURI());
		
		switch(req.getRequestURI()) {
		case "/ExReimbSys/subReimb.json":
		case "/ExReimbSys/resources/html/subReimb.json":
			System.out.println("in reimb case");
			return ReimbursementController.addReimb(req);
		case "/ExReimbSys/updateReimb.json":
		case "/ExReimbSys/resources/html/updateReimb.json":
			System.out.println("in reimb case");
			return ReimbursementController.updateReimb(req);
		default:
			System.out.println("in the default");
			return "/home.serf";
		}
	}

}
