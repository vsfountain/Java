package com.kers.json;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kers.models.User;

public class JSONRequestHelper {
	public static void process(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException{
		System.out.println(req.getRequestURI());
		
		switch(req.getRequestURI()) {
		case "/ExpenseReimbursementSystem/user.json":
			UserController.userFinder(req, resp);
			break;
		default:
			User u = new User("?", "?", "?", "?", "?");
			resp.getWriter().write(new ObjectMapper().writeValueAsString(u));
		}
	}
}
