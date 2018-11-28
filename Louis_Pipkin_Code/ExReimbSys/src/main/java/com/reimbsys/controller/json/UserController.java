package com.reimbsys.controller.json;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.reimbsys.model.User;
import com.reimbsys.service.UserService;
import com.reimbsys.service.UserServiceImpl;

public class UserController {

	protected static UserService service = new UserServiceImpl();
	
	public static void userFinder(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		
		System.out.println("in User Controler: "+req.getSession().getAttribute("loggerusername"));
		
		String username = (String) req.getSession().getAttribute("loggerusername");
		User user = service.getUser(username);
		
		System.out.println("in user constroller, setting role: "+user.getRole());
		req.getSession().setAttribute("loggerrole", user.getRole());
		
		resp.getWriter().write(new ObjectMapper().writeValueAsString(user));
	}
	
public static void retrieveUsers(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		
		System.out.println("in User Controler, retirve: "+req.getSession().getAttribute("loggerusername"));
		
		Map<String, User> users = service.getAllUsers();

		resp.getWriter().write(new ObjectMapper().writeValueAsString(users));
	}
	
}
