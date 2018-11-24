package com.example.sessionservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.example.model.SuperVillain;

public class SessionServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req,
				HttpServletResponse resp) throws IOException,
										ServletException
	{
		SuperVillain billy = new SuperVillain("Billy", "Inertial Dampen",
				100_000);
		HttpSession session = req.getSession();
		session.setAttribute("villain", billy);
		
		PrintWriter out =  resp.getWriter();
		out.println("Billy is on the loose...");
	}
	
	@Override
	protected void doPost(HttpServletRequest req,
			HttpServletResponse resp) throws IOException,
									ServletException
	{
		String name= req.getParameter("name");
		String superpower= (String) req.getParameter("superpower");
		int bounty= Integer.parseInt(req.getParameter("bounty"));
		
		SuperVillain tempVill = new SuperVillain(name, superpower, bounty);
		
		HttpSession session = req.getSession();
		session.setAttribute("villain", tempVill);
		
		PrintWriter out = resp.getWriter();
		out.println("A new villain is on the loose....");
	}
}
