package com.dikokosolutions.requesthelpers;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import com.dikokosolutions.controller.HomeController;
import com.dikokosolutions.controller.LogOutController;
import com.dikokosolutions.controller.LoginController;
import com.dikokosolutions.controller.ReimbursementController;
import com.dikokosolutions.dao.ReimbursementDao;
import com.fasterxml.jackson.core.JsonProcessingException;

public class RequestHelper {
	public static String process(HttpServletRequest req) throws JsonProcessingException, IOException, SQLException {
		System.out.println(req.getRequestURI());

		switch (req.getRequestURI()) {
		case "/Project1/login.serv":
			return LoginController.login(req);
		case "/Project1/home.serv":
			return HomeController.home(req);
		case "/Project1/managerhome.serv":
			return HomeController.ManagerHome(req);
		case "/Project1/logout.serv":
			return LogOutController.logOut(req);
		case "/Project1/submitReimbursement.serv":
			return ReimbursementController.submitReimbursement(req);
//			return "/Project1/home.serv";
		case "/Project1/approve.serv":
			return ReimbursementController.approveReimbursement(req);
		case "/Project1/deny.serv":
			return ReimbursementController.denyReimbursement(req);

		default:
			return "resources/html/unsuccessfullogin.html";
		}
	}
}
