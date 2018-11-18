package com.kers.json;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kers.models.User;

public class UserController {
	public static void userFinder(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException{
		User u = new User("Username","firstname","lastname","email","employee");
		resp.getWriter().write(new ObjectMapper().writeValueAsString(u));
	}
}
