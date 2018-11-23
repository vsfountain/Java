package com.ers.helper;

import java.io.IOException;

//import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ers.controller.EmployeeController;
import com.ers.controller.LoginController;
import com.ers.controller.ManagerController;
import com.ers.controller.ReimbursementController;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class RequestHelper {
	
	public static String process(HttpServletRequest request, HttpServletResponse response) throws JsonProcessingException, IOException {
		System.out.println("in request helper");	
		System.out.println(request.getRequestURI());
			
			switch(request.getRequestURI()) {
			case "/MyERSProject/login.ERSServlet":
				System.out.println("case login");
				return LoginController.login(request, response);
			
			/*case "/MyERSProject/employee.":
				System.out.println("case employee");
				return EmployeeController.employee(request);
				
			case "/MyERSProject/manager.":
				System.out.println("case manager");
				return ManagerController.manager(request);*/
			
			default:
				return "resources/html/index.html";
			}
		}
		
}
