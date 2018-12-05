package com.example.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SecondServ extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
		throws IOException, ServletException
	{
		System.out.println("Inside second serv");
		
		String contextEx=
				getServletContext().getInitParameter("contextExample");
		String configEx=
				getServletConfig().getInitParameter("configExample");
		
		System.out.println(contextEx+ " & "+ configEx);
	}
}
