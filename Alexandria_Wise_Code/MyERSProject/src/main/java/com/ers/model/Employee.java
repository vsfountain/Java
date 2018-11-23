package com.ers.model;

import java.sql.Timestamp;

public class Employee extends User{
	
	public Employee() {
		super();
	}

	public Employee(int userId, String userName, String password, String firstName, String lastName, String email,
		int roleId) {
		/*super(userId, userName, password, firstName, lastName, email, roleId);
		// TODO Auto-generated constructor stub
*/	}
	
	void submitReimbursement(int amount, int typeId) {
		/*Timestamp currentTime = getCurrentTime();
		ReimbursementDAOImpl myReimbursement = new ReimbursementDAOImpl();
		myReimbursement.preparedInsertReimbursement(amount, currentTime, this.userId, 0, typeId);*/
	}
	
	

}
