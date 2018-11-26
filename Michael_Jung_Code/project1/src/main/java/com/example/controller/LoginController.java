package com.example.controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
/*import java.util.logging.Logger;*/

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.main.Main;
import com.example.model.ErsUser;
import com.example.service.ErsUsersService;
import com.example.service.ErsUsersServiceImpl;

import org.apache.log4j.Logger;

public class LoginController {
	
	final static Logger logger = Logger.getLogger(LoginController.class);
	
	public static String login(HttpServletRequest req, HttpServletResponse resp) {
		
		if(!req.getMethod().equals("POST")) {
			return "index.html";
		}
		
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		ErsUser ersUser = null;
		ErsUsersService ersUsersService = new ErsUsersServiceImpl();
		ersUser = ersUsersService.getErsUser(username);
		
		if(ersUser == null) {
			return "index.html";
		} else {
			if(ersUser.getPassword().equals(password)) {
				
				if(ersUser.getUserRoleId() == 1) {
					req.getSession().setAttribute("loggedusername", username);
					req.getSession().setAttribute("loggedpassword", password);
					req.getSession().setAttribute("employeeUser", ersUser);
					
					System.out.println("a");
					try {
						System.out.println("a");
						/*BufferedReader in = new BufferedReader(new FileReader("C:\\Users\\Michael's Laptop\\Documents\\workspace-sts-3.9.6.RELEASE\\Project1\\src\\main\\webapp\\resources\\html\\employeeHomeLandingPage.html"));
						String str;
						while((str = in.readLine()) != null) {
							
							if(str.equals("<input type=\"hidden\" name=\"ersUser\" "))
							
						}*/
						/*ErsUser ersSessionUser = (ErsUser) req.getSession().getAttribute("employeeUser");*/
						FileWriter fw = new FileWriter("C:\\Users\\Michael's Laptop\\Documents\\workspace-sts-3.9.6.RELEASE\\Project1\\src\\main\\webapp\\resources\\html\\employeeHomeLandingPage.html", false);
						/*PrintWriter pw = new PrintWriter(fw);*/
						BufferedWriter out1 = new BufferedWriter(fw);
						String str = "<input type=\"hidden\" name=\"ersUser\" value=\"" + ersUser.getUserId() + "\" />";
	
						PrintWriter out = resp.getWriter();
						
						out.write("<!DOCTYPE html>\n");
						out.write("<html>\n");
						out.write("<head>\n");
						out.write("<meta charset=\"ISO-8859-1\">\n");
						out.write("<title>Insert title here</title>\n");
						out.write("<link rel=\"stylesheet\" href=\"resources/css/mystyles2.css\">\n");
						out.write("<link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css\">\n");
						out.write("<link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css\">\n");
						out.write("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css\">\n");
						out.write("<script src=\"https://code.jquery.com/jquery-3.2.1.slim.min.js\"></script>\n");
						out.write("<script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js\"></script>\n");
						out.write("<script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js\"></script>\n");
						out.write("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css\">\n");
						out.write("<!-- Bootstrap core CSS -->\n");
						out.write("<link href=\"resources/css/bootstrap.min.css\" rel=\"stylesheet\">\n");
						out.write("<!-- Material Design Bootstrap -->\n");
						out.write("<link href=\"resources/css/mdb.min.css\" rel=\"stylesheet\">\n");
						out.write("<!-- Your custom styles (optional) -->\n");
						out.write("<link href=\"resources/css/style.css\" rel=\"stylesheet\">\n");
						
						
						
						
						out.write("</head>\n");
						out.write("<body style=\"background-color:rgba(210,180,140,1);\">\n");
						out.write("<h2 style=\"color:white;margin-left:26px;margin-top:25px;\"><b>Welcome " + ersUser.getUsername() + "</b></h2>");
						out.write("<form style=\"float:right;display:inline-block;margin-top:-54px;margin-right:20px;\"method=\"POST\" action=\"employeeLogout.servletTwo\"><button type=\"submit\" class=\"btn btn-primary\">Logout</button></form>");
						
						out.write("<section class=\"section2\">\n");
						
						out.write("<form method=\"POST\" action=\"reimbursementApplication.servletTwo\"><button type=\"submit\" class=\"btn btn-primary\">Apply</button></form>");
						
						out.write("<div class=\"taable\"style=\"width:80%;margin-left:10%;\">\n");
						
						out.write("<table class=\"table table-hover table-sm\">\n");
						out.write("<thead class=\"thead-light\">");
						out.write("<tr>\n");
						out.write("<th>Reimbursement Number</th>\n");
						out.write("<th>Reimbursement Type</th>\n");
						out.write("<th>Reimbursement Amount</th>\n");
						out.write("<th id=\"1\">Submitted Date</th>\n");
						out.write("<th id=\"2\">Description</th>\n");
						out.write("<th id=\"3\">Status</th>\n");
						out.write("<th>Reimbursing Manager</th>\n");
						out.write("<th>Resolved Date</th>\n");
						out.write("</tr>\n");
						out.write("<tr></tr>\n");
						out.write("<tbody><tr><td colspan=\"7\" style=\"text-align:center;\"><i class=\"fa fa-spinner fa-spin fa-3x fa-fw margin-bottom\"style=\"opacity:.5;\"></i><i style=\"font-size:12px;opacity:.5;\">Your Reimbursements are Loading...</i><td></tr></tbody>");
						out.write("</table>\n");
						out.write(str);
						
						out.write("</section>\n");
						out.write("<script type=\"text/javascript\" src=\"resources/js/ourEmployeeJavascriptFile.js\"></script>\n");
						out.write("<script src=\"https://code.jquery.com/jquery-3.3.1.slim.min.js\"></script>\n");
						out.write("<script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js\"></script>\n");
						out.write("<script src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js\"></script>\n");
						out.write("</body>\n");
						out.write("</html>\n");
						/*out.write("a");*/
						out.close();
						/*System.out.println("aaa");*/
						
						
						/*for(int i = 0; i < 33; i++) {
							if (i == 24) {
								System.out.println("a");*/
								/*pw.println(str);*/
								/*out.write(str);*/
								/*pw.println("aaaaaa");*/
								/*pw.close();*/
								/*out.close();*/
							/*} else {*/
								/*System.out.println();*/
								/*out.nex;
							}
						}*/
						
						logger.info("User: " + username + " has logged In");
						
						
					} catch(IOException e) {
						e.printStackTrace();
					}
					
					/*return "resources/html/employeeHomeLandingPage.html2";*/
					return "";
				} else {
					req.getSession().setAttribute("loggedusername", username);
					req.getSession().setAttribute("loggedpassword", password);
					req.getSession().setAttribute("adminUser", ersUser);
					
					logger.info("User: " + username + " has logged In");
					
					return "resources/html/adminHomeLandingPage.html";
				}
				
				
			} else {
				return "index.html";
			}
		}
		
		
		/*if(!(username.equals("mac") && password.equals("cheese"))) {
			return "index.html";
		}else {
			req.getSession().setAttribute("loggedusername", username);
			req.getSession().setAttribute("loggedpasssword", password);
			
			return "/home.secondServlet";
		}*/
		
	}
	
	public static String logout(HttpServletRequest req) {
		req.getSession().setAttribute("adminUser", null);
		return "index.html";
	}
	
	public static String employeeLogout(HttpServletRequest req) {
		req.getSession().setAttribute("employeeUser", null);
		return "index.html";
	}
	
	
}
