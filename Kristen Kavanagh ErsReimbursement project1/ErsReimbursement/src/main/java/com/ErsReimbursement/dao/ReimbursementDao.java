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
}