package com.ers.model;

import java.sql.Timestamp;

public class FinanceManager extends User {
	
	public FinanceManager() {
		super();
	}

	public FinanceManager(int userId, String userName, String password, String firstName, String lastName, String email,
			int roleId) {
		//super(userId, userName, password, firstName, lastName, email, roleId);
		// TODO Auto-generated constructor stub
	}
	
	void viewPendingTickets(int statusId) {
		/*ReimbursementDAOImpl myReimbursement = new ReimbursementDAOImpl();
		myReimbursement.selectReimbursementsByStatus(statusId);*/
	}

	void approveOrDeny(int reimbId, int statusId) {
		/*Timestamp currentTime = getCurrentTime();
		ReimbursementDAOImpl myReimbursement = new ReimbursementDAOImpl();*/
		//myReimbursement.approveOrDeny(reimbId, currentTime, "approved...for now", "receipt", this.userId, statusId);
	}
	
}
