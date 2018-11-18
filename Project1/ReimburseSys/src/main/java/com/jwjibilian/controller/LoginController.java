package com.jwjibilian.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.jwjibilian.json.MasterJson;
import com.jwjibilian.model.user.Admin;
import com.jwjibilian.model.user.User;
import com.jwjibilian.services.UserService;
import com.jwjibilian.services.UserServiceImpl;

public class LoginController {
	public static String login(HttpServletRequest req, HttpServletResponse resp) throws JsonProcessingException, IOException {
		System.out.println("LC CONT");
		if (!req.getMethod().equals("POST")) {
			return "index.html";
		}
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		UserService userService = new UserServiceImpl();
		User user = userService.userLogin(username, password);
		System.out.println(user);
		if (user == null) {
			req.getSession().setAttribute("password", "");
			return "index.html";

		} else {
			req.getSession().setAttribute("user", user);
			
			//resp.getWriter().write(new ObjectMapper().writeValueAsString(user));
			if (user instanceof Admin) {
				return "/resources/html/admin.html";
			}
			return "/resources/html/client.html";
		}

	}
	
	public static String getUser(HttpServletRequest req, HttpServletResponse resp) throws JsonProcessingException, IOException {
		User user = (User) req.getSession().getAttribute("user");
		MasterJson json = new MasterJson();
		json.writeJsonToResp(resp, user);
		return "";
	}
}
