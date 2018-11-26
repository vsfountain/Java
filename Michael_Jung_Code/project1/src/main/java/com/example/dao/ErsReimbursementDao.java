package com.example.dao;

import java.util.List;

import com.example.model.ErsReimbursement;

public interface ErsReimbursementDao {

	public List<ErsReimbursement> /*void*/ selectAllErsReimbursements();
	
	
	public int approveReimbursement(int reimbursementId, int adminUserId);
	
	public int disapproveReimbursement(int reimbursementId, int adminUserId);
	
	public int insertReimbursement(ErsReimbursement ersReimbursement);
	
}
