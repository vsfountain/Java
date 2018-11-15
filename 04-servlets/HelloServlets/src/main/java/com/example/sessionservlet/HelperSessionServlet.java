package com.example.sessionservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.example.model.SuperVillain;

public class HelperSessionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException
	{
		HttpSession session = req.getSession();
		SuperVillain villain=
				(SuperVillain) session.getAttribute("villain");
		
		PrintWriter out = resp.getWriter();
		out.print("<html><body>");
		
		if(villain != null) {
			out.println("We've captured the villain!");
			out.println("<h1> Villain Name: "+villain.getName()+"</h1><br/>");
			out.println("<h2> 	Superpower: "+villain.getSuperpower()+"</h2><br/>");
			out.println("<h2> 	Bounty: $"+villain.getBounty()+"</h2><br/>");
		}else {
			out.println("Can't find any villains...");
		}
		
		out.println("</body></html>");
	}
}
