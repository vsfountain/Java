package com.example.controller;

import java.io.IOException;
import java.io.PrintWriter;
/*import java.util.logging.Logger;*/

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.dao.ErsReimbursementDao;
import com.example.dao.ErsReimbursementDaoImpl;
import com.example.main.Main;
import com.example.model.ErsUser;
import com.example.service.ErsReimbursementService;
import com.example.service.ErsReimbursementServiceImpl;

import org.apache.log4j.Logger;

public class ApplicationController {

	final static Logger logger = Logger.getLogger(ApplicationController.class);
	
	public static String land(HttpServletRequest req) {
		return "resources/html/reimbursementApplicationLandingPage.html";
	}
	
	public static String backToLand(HttpServletRequest req, HttpServletResponse resp) {
		
	
		
		ErsUser ersUser = (ErsUser) req.getSession().getAttribute("employeeUser");
		
		String str = "<input type=\"hidden\" name=\"ersUser\" value=\"" + ersUser.getUserId() + "\" />";
		
		try {
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
		out.write("<th id=\"4\">Resolved Date</th>\n");
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
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		return "";
	}
	
	
	
	public static String submitApplication(HttpServletRequest req) {
		
		double amount = Double.parseDouble(req.getParameter("amount"));
		String type = req.getParameter("type");
		String description = req.getParameter("description");
		
		ErsUser ersUser = (ErsUser) req.getSession().getAttribute("employeeUser");
		
		
		ErsReimbursementService ersReimbursementService = new ErsReimbursementServiceImpl();
		int a = ersReimbursementService.createReimbursement(ersUser, amount, type, description);
		logger.info("User: " + ersUser.getUsername() + " has applied for reimbursement");
		return "resources/html/applicationHasBeenSubmittedPage.html";
		
	}
	
	
}
