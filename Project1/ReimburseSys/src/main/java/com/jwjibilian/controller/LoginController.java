package com.jwjibilian.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.jwjibilian.json.MasterJson;
import com.jwjibilian.model.user.Admin;
import com.jwjibilian.model.user.User;
import com.jwjibilian.services.UserService;
import com.jwjibilian.services.UserServiceImpl;

public class LoginController {
	private static final Logger LOGGER = LogManager.getLogger(LoginController.class.getName());

	public static String login(HttpServletRequest req, HttpServletResponse resp)
			throws JsonProcessingException, IOException {
		System.out.println("LC CONT");
		if (!req.getMethod().equals("POST")) {
			return "index.html";
		}
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		UserService userService = new UserServiceImpl();
		User user = userService.userLogin(username, password);
		System.out.println(user);
		req.getSession().setAttribute("password", "");
		System.out.println();
		if (user == null) {
			resp.sendRedirect(req.getContextPath() + "/index.html");
			return "/index.html";

		} else {
			LOGGER.info(user.getFirstName() + " " + user.getLastname() + " logged in as " + user.getClass().getName());
			System.out.println("SETTTING USER NOW!!");
			req.getSession().setAttribute("user", user);

			// resp.getWriter().write(new ObjectMapper().writeValueAsString(user));
			if (user instanceof Admin) {
				req.getSession().setAttribute("adminId", user.getId());
				resp.sendRedirect(req.getContextPath() + "/resources/html/admin.html");
				return "/resources/html/admin.html";
			}
			resp.sendRedirect(req.getContextPath() + "/resources/html/client.html");
			return "/resources/html/client.html";
		}

	}

	public static String getUser(HttpServletRequest req, HttpServletResponse resp)
			throws JsonProcessingException, IOException {

		User user = (User) req.getSession().getAttribute("user");
		System.out.println("THE USER IS: " + user);
		MasterJson json = new MasterJson();
		json.writeJsonToResp(resp, user);

		return "";
	}

	public static String logOut(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		LOGGER.info(req.getSession().getAttribute("user") + " has logged out");
		req.getSession().invalidate();
		resp.sendRedirect(req.getContextPath() + "/index.html");


		// resp.sendRedirect("/ReimburseSys/index.html");
		// resp.setStatus(HttpServletResponse.SC_FOUND);//302
		// resp.setHeader("Location", req.getContextPath() +
		// "/ReimburseSys/index.html");

		return "/index.html";
	}
}
