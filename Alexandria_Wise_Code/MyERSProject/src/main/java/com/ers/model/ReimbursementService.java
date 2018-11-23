package com.ers.model;

import java.util.ArrayList;

public interface ReimbursementService {
	
	public ArrayList<Reimbursement>displayReimbursements();
	public ArrayList<Reimbursement> filterByEmployee(int UserId);
	public ArrayList<Reimbursement> filterByStatus(int StatusId);

}
