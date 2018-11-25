package com.ErsReimbursement.service;

import com.ErsReimbursement.model.Reimbursement;
import com.ErsReimbursement.model.User;

public interface ReimbursementService {

	//public String InsertReimbursement(Reimbursement newReimb);
	boolean InsertReimbursement(Reimbursement reimburse);

	void CreateReimbursement(User staff);

 	
					
}
