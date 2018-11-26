package com.ers.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ers.helper.JSONRequestHelper;
import com.ers.model.Reimbursement;
import com.ers.model.ReimbursementDAO;
import com.ers.model.ReimbursementDAOImpl;
import com.fasterxml.jackson.databind.ObjectMapper;

public class MasterJSON extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MasterJSON() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*System.out.println(request.getRequestURI());
		HttpSession session = request.getSession();
		ArrayList<Reimbursement> list = (ArrayList<Reimbursement>) session.getAttribute("reimbs");
		System.out.println("reimbs: "+list);
		PrintWriter out = response.getWriter();
		out.println(new ObjectMapper().writeValueAsString(list));
	
*/	
		JSONRequestHelper.process(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*System.out.println(request.getRequestURI());
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		out.println(JSONRequestHelper.process(request, response));*/
		System.out.println("In POST");
		/*String type = request.getParameter("type");
		String amount = request.getParameter("amount");
		String desc = request.getParameter("desc");*/
		
		//System.out.println("POST Paramters gotten: "+type+" "+amount+" "+desc);
		JSONRequestHelper.process(request, response);
	}

}
