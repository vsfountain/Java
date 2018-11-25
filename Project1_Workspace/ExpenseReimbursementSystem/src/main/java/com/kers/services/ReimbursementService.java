package com.kers.services;

import java.util.List;

import com.kers.models.Reimbursement;

public interface ReimbursementService {
	public int addReimbursement(Reimbursement reimbursement);
	public List<Reimbursement> getAllReimbursements();
	public Reimbursement getReimbursementById(int id);
	public int updateReimbursementById(int id, String decsion, String resolver);
}
