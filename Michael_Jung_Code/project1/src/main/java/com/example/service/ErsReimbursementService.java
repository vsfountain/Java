package com.example.service;

import java.util.List;

import com.example.model.ErsReimbFeModel;
import com.example.model.ErsReimbursement;
import com.example.model.ErsUser;

public interface ErsReimbursementService {

	public List<ErsReimbFeModel> getAllErsReimbursements();
	
	public int approveReimbursement(int reimbursementId, int adminUserId);
	
	
	public int disapproveReimbursement(int reimbursementId, int adminUserId);

	public int createReimbursement(ErsUser ersUser, double amount, String type, String description);
	
}
