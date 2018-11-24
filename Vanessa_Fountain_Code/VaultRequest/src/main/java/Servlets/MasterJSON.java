package Servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import RequestHelper.JSONRequestHelper;

/**
 * Servlet implementation class MasterJSON
 */
public class MasterJSON extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("in masterjson");
		JSONRequestHelper.process(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		JSONRequestHelper.process(request, response);
		
		//doGet(request, response);
//		System.out.println("in post uri is: "+request.getRequestURI());
//		String reimbKey = request.getParameter("reimbKey");
//		System.out.println("Our reimbKey is: "+reimbKey);
//		int value = Integer.parseInt(reimbKey);
//		System.out.println("Our integer reimbKey is: "+ value);
	}

}
