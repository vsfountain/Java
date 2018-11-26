package com.ErsReimbursement.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ErsReimbursement.json.JSONRequestHelper;
import com.ErsReimbursement.model.Reimbursement;
import com.fasterxml.jackson.databind.ObjectMapper;

public class MasterJSON extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	@Override
	protected void doPost(HttpServletRequest req,
				HttpServletResponse resp)
						throws IOException, ServletException
								
	{
		//ArrayList<Reimbursement> arryreimb = emburse.selectAllReimburse();
		//System.out.println(req.getRequestURI());
		//resp.setContentType("application/json");
		//Reimbursement reimburse = new Reimbursement ("reimb_amount", "reimb_description", "reimb_author", 
		//		"reimb_status_id","reimb_type_id");
		//resp.getWriter().write(
		//		new ObjectMapper().writeValueAsString(reimburse));

		System.out.println("Helloooooooooooo");
		req.getRequestDispatcher(JSONRequestHelper.process(req, resp));
	}

		
		
		
		
		
		
		
		
//		
//		try {
//			resp.setContentType("text/html");
//			Class.forName("oracle.jdbc.driver.OracleDriver");
//			Connection conn= DriverManager.getConnection("jdbc:oracle:thin:@kristen.cu5uh73jvis1.us-east-2.rds.amazonaws.com:1521:kristen", 
//					"kristenzers","krisers1234");
//			PreparedStatement ps=conn.prepareStatement("select *from Ers_reimbursement");
//			ResultSet rs= ps.executeQuery();
//			PrintWriter out = resp.getWriter();
//		
//				out.println("<html><body><table border ='1'><tr><td>REIMB_ID</td><td>REIMB_AMOUNT</td><td>REIMB_SUBMITTED</td><td>REIMB_RESOLVED</td><td>REIMB_DESCRIPTION</td><td>REIMB_AUTHOR</td><td>REIMB_RESOLVER</td><td>REIMB_STATUS</td><td>REIMB_TYPE</td><tr>");
//			
//			while (rs.next()) {
//	out.println("<tr><td>"+rs.getString(1)+"</td><td>" + rs.getString(2) + "</td><td>"+ rs.getString(3)+ "</td><td>" + rs.getString(4)+ "</td><td>"+ rs.getString(5)+"</td><td>"+rs.getString(6)+"</td><td>"+rs.getString(7)+"</td></td>"+rs.getString(8)+"</td><td>"+ rs.getString(9)+"</td><td>");		

	//start writing a stream of data.
		//JSONRequestHelper.process(req,resp);
//		System.out.println(req.getRequestURI());
//		resp.setContentType("application/json");
//		PrintWriter out = resp.getWriter();
//		resp.getWriter().write(
//				new ObjectMapper().writeValueAsString(emburse));
//		List<Reimbursement> arryreimb = new ArrayList<Reimbursement>();
//
//		for (Reimbursement remburses: arryreimb ) {
//				
//						resp.getWriter().write(new ObjectMapper().writeValueAsString(arryreimb));
//		}
//		//HttpSession session = req.getSession();
////PrintWriter out = resp.getWriter();
//		req.getRequestDispatcher(JSONRequestHelper.process(req, resp));
		
//		Reimbursement reimburse = new Reimbursement ("reimb_amount", "reimb_description", "reimb_author", "reimb_status_id",
//				"reimb_type_id"); 
				//resp.getWriter().write(
				//new ObjectMapper().writeValueAsString(reimburse));
//		System.out.println("we're inside of our  json servlet! POST!");
//	}
//			out.println("</table></body></html>");
//		}
//		catch (Exception e) {
//			e.printStackTrace();
		}
	
	

