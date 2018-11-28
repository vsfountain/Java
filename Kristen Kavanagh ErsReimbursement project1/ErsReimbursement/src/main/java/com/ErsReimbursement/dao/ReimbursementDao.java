package com.ErsReimbursement.dao;

import java.util.ArrayList;

import com.ErsReimbursement.model.Reimbursement;

/**
 Model  for reimbursement type.
 *
 * @author Kristen Kavanagh
 * @version 11/15/2018
 *
 */
public interface ReimbursementDao {
	/**
	 * Crud Methods only
	 */
		

	public int InsertReimbursement(Reimbursement reimburse);
	public ArrayList<Reimbursement> viewReimburse();
	public int updateReimbursementByStatusId();
	public int updateReimbursementByStatusId(Reimbursement reimburse);
	//test method
	public static Object fetchReimbursements() {
		// TODO Auto-generated method stub
		return null;
	}
//	// to be reivewd
//	public Reimbursement updateReimbursement(Reimbursement r);

	public int updateapprovedReimbursementByStatusId(String reimb_Resolved, String reimb_Resolver, int reimb_status_id);
	}


