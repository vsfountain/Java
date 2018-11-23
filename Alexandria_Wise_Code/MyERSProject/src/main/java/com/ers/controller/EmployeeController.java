package com.ers.controller;

import javax.servlet.http.HttpServletRequest;

public class EmployeeController {
	
		ReimbursementController reimb = new ReimbursementController();
	
		public static String employee(HttpServletRequest req) {
			return "resources/html/employee.html";
		}
}
