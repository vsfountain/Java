package com.ErsReimbursement.service;

import java.util.ArrayList;

import com.ErsReimbursement.model.Reimbursement;
import com.ErsReimbursement.model.User;

public interface ReimbursementService {

	boolean InsertReimbursement(Reimbursement reimburse);

	void CreateReimbursement(User staff);
	
	public ArrayList<Reimbursement> selectAllReimburse();

 	
					
}
