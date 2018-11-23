package com.ers.model;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		UserDAOImpl myUser = new UserDAOImpl();
		
		User user = myUser.login("sawise", "prince");
		//user.submitReimbursement(80, 0);
		
		//user.viewTickets();
		//user.viewMyTickets();
		//user.viewPendingTickets(0);
		//user.approveOrDeny(1004, 1);
		//user.viewTickets();
		
		//Entry to the reimbursement system
		//login as employee or finance manager
		//IF EMPLOYEE
		//rolling menu toggling..
		//view past tickets
		//make new reimbursement request
		//IF FINANCE MANAGER
		//rolling menu toggling...
		//view all
		//view pending
		//view per customer
	}
}
