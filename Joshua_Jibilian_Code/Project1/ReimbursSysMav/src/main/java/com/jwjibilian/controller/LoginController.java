package com.jwjibilian.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jwjibilian.model.user.Admin;
import com.jwjibilian.model.user.User;
import com.jwjibilian.services.UserService;
import com.jwjibilian.services.UserServiceImpl;

public class LoginController {
	public static String login(HttpServletRequest req, HttpServletResponse resp) throws JsonProcessingException, IOException {
		if (!req.getMethod().equals("POST")) {
			return "index.html";
		}

		String username = req.getParameter("username");
		String password = req.getParameter("password");
		UserService userService = new UserServiceImpl();
		User user = userService.userLogin(username, password);
		System.out.println(user);
		if (user == null) {
			req.getSession().setAttribute("loggedpassword", "");
			return "index.html";

		} else {
			req.getSession().setAttribute("loggedusername", username);
			req.getSession().setAttribute("loggedpassword", "");
			resp.getWriter().write(new ObjectMapper().writeValueAsString(user));
			if (user instanceof Admin) {
				return "/home.admin";
			}
			return "/home.client";
		}

	}
}
