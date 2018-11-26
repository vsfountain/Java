package com.ers.model;

import java.sql.Blob;
import java.sql.Timestamp;
import java.util.ArrayList;

public interface ReimbursementDAO {
	
	
	//insert new reimbursement <- used by employee
	public void preparedInsertReimbursement(double amount, String description, Timestamp reqTime, int author, int statusId, int typeId);
	//select all existing reimbursements <- used my finance manager
	public ArrayList<Reimbursement> selectAllReimbursements();
	//select all pending reimbursements <- used by finance manager
	public ArrayList<Reimbursement> selectReimbursementsByStatus(int statusId);
	//select all reimbursements associated with a certain employee <- used by employee and finance manager
	public ArrayList<Reimbursement> selectReimbursementsByID(int userId);
	//update a reimbursement's status from pending to approved/denied <- used by finance manager 
	public void approveOrDeny(int reimbId, int resolver, int statusId);
	
	
}
