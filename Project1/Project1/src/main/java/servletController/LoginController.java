package servletController;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import reimbursement.ReimbursementManager;
import reimbursement.ReimbursementManagerDAO;

public class LoginController {
	final static Logger logger = Logger.getLogger(LoginController.class);
	
	public static String login(HttpServletRequest req) {
		if(!req.getMethod().equals("POST")) {
			logger.warn("loginController called as a GET Method");
			req.getSession().invalidate();
			return "index.html";
		}
		
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		if(username!=null || password!=null) {
			ReimbursementManagerDAO check = new ReimbursementManager();
			String checkName = check.getUserName(username);
			if(!checkName.equals("")) {
				//Name is valid now lets perform pw validation on the hashed values
				String currPWHash = check.getUserPassword(checkName);
				String actualPWHash = check.validateUser(checkName, password);
				if(currPWHash.equals(actualPWHash)) {
					req.getSession().setAttribute("loggedusername", username);
					req.getSession().setAttribute("loggedpassword", password);
					
					//Added this
					/*String getCurrName = check.getCurrFullName(username);
					String[] splitName = getCurrName.split(" ");
					req.getSession().setAttribute("loggedFirstname", splitName[0]);
					req.getSession().setAttribute("loggedLastname", splitName[1]);
					req.getSession().setAttribute("loggedUsersID", check.getUsersId(username));
					req.getSession().setAttribute("loggedUserRoleID", check.getRoleID(username));
					System.out.println(req.getSession().getAttribute("loggedFirstname"));
					System.out.println(req.getSession().getAttribute("loggedLastname"));
					System.out.println(req.getSession().getAttribute("loggedUsersID"));
					System.out.println(req.getSession().getAttribute("loggedUserRoleID"));*/
					
					int currRole = Integer.parseInt(check.getRoleID(username));
					if(currRole == 1) {
						logger.info("Employee login: " + req.getSession().getAttribute("loggedusername"));
						return "MainMenu.html";
					}
					else if(currRole == 2) {
						logger.info("Admin login: " + req.getSession().getAttribute("loggedusername"));
						return "managerMainMenu.html";
					}
				}
			}
			else {
				logger.warn("Failed login.");
				req.getSession().invalidate();
				return "index.html";
			}
		}
		logger.warn("Failed login.");
		req.getSession().invalidate();
		return "index.html";
	}
}
