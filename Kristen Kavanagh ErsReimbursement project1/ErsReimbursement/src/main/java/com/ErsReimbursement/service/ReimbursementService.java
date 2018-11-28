package com.ErsReimbursement.service;

import java.util.ArrayList;

import com.ErsReimbursement.model.Reimbursement;

public interface ReimbursementService {

	boolean InsertReimbursement(Reimbursement reimburse);

	int updateReimbursementByStatusId(Reimbursement reimburse);	
	public ArrayList<Reimbursement> selectAllReimburse();
	public int updateapprovedReimbursementByStatusId(String reimb_Resolved, String reimb_Resolver, int reimb_status_id);
	public int updatedeclinedReimbursementByStatusId(String reimb_Resolved, String reimb_Resolver, int reimb_status_id);
	}
