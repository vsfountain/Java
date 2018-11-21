package com.jwjibilian.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jwjibilian.controller.ReimburseHelper;

/**
 * Servlet implementation class ReimburseServlet
 */
public class ReimburseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReimburseServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("DO get ___________________________-");
		
		ReimburseHelper.process(request, response);

		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("DO POST ___________________________-");
		String forwardTo = ReimburseHelper.process(request, response);
		System.out.println("GOING HERE NOW!!!!" + forwardTo);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(forwardTo);
	    dispatcher.forward(request, response);
		
	}

}
