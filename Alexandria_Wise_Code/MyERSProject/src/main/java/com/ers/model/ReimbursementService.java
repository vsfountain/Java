package com.ers.model;

import java.sql.Timestamp;
import java.util.ArrayList;

public interface ReimbursementService {
	
	public void createReimbursement(double amount, String description, Timestamp reqTime, int author, int statusId, int typeId);
	public ArrayList<Reimbursement>displayReimbursements();
	public ArrayList<Reimbursement> filterByEmployee(int UserId);
	public ArrayList<Reimbursement> filterByStatus(int StatusId);
	public void approveOrDeny(int reimbId, int resolver, int statusId);

}
