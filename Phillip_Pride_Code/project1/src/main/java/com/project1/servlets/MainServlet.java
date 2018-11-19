package com.project1.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project1.controllers.RequestHelper;
import com.project1.objs.User;

public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("in POST before request");
		req.getRequestDispatcher(RequestHelper.process(req)).forward(req, resp);
		System.out.println("in POST after request");
		User user = (User) req.getSession().getAttribute("currentuser");
		resp.getWriter().write("Welcome " + user.getFirstName() + user.getLastName() + "!");
		System.out.println("in POST After getWriter");
		//doGet(request, response);
	}

}
