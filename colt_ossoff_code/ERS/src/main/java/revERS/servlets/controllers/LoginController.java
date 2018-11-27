package revERS.servlets.controllers;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import revERS.model.User;
import revERS.services.UserService;

public class LoginController {
	public static Logger logger = Logger.getLogger(LoginController.class);
	public static String login(HttpServletRequest req) throws JsonProcessingException {
		logger.info("in LoginContrtoller.login()");
		if(!req.getMethod().equals("POST")) {
			logger.warn("How did you get here without using POST");
			return null;
		}

		logger.info(req.getParameter("username"));
		logger.info(req.getParameter("password"));
		User u = UserService.login(req.getParameter("username"), req.getParameter("password"));
		if (u == null) {
			logger.warn("Login failed");
			return null;
		} else {
			String value = new ObjectMapper().writeValueAsString(u);
			req.getSession().setAttribute("user", value);
			req.getSession().setAttribute("username", req.getParameter("username"));
			req.getSession().setAttribute("role", u.getRole());
			req.getSession().setAttribute("userid", u.getId());
			logger.info(value);
			return value;
		}
	}
}
