package com.kers.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kers.controller.RequestHelper;
import com.kers.json.JSONRequestHelper;

/**
 * Servlet implementation class MasterServlet
 */
public class MasterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MasterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		//String contextEx = getServletContext().getInitParameter("contextExample");
		//String configEx = getServletConfig().getInitParameter("configExample");
		//System.out.println(contextEx + " " + configEx);
		//JSONRequestHelper.process(request, response);
		//request.getRequestDispatcher(RequestHelper.retrieve(req, resp);)
		RequestHelper.retrieve(request, response);
		PrintWriter out = response.getWriter();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		request.getRequestDispatcher(RequestHelper.process(request)).forward(request, response);
		//System.out.println("Context path: " + request.getRequestURI());
	}

}
