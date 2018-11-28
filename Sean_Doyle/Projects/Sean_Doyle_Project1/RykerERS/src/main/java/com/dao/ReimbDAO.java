package com.dao;

import java.util.ArrayList;

import com.classes.Reimbursement;

public interface ReimbDAO {

	public ArrayList<Reimbursement> getReimbursements();
	public ArrayList<Reimbursement> getReimbursementForUser(int ers_user_id);
	public ArrayList<Reimbursement> getReimbursementForUser(String ers_username);
	public int addReimbursement(double amount, String description, String username, String type);
	public int updateReimbursement(int reimb_id, String admin_name, String newStatus);
	public int addReimbursementReceipt(double amount, String description, String username, String type, String filePath);
	ArrayList<Reimbursement> getReimbursementForUser(int ers_user_id, boolean getBlob);
}
