package com.reimbsys.service;

import java.util.Map;

import com.reimbsys.model.Reimbursement;

public interface ReimbService {

	//GETTERS
	public Map<String, Reimbursement> getAllReimbs();
	public Reimbursement getReimbById(int reimbid);
	public Map<String, Reimbursement> getReimbsByIds(String[] reimbids);
	public Map<String, Reimbursement> getReimbByUserName(String username);
	public Map<String, Reimbursement> getReimbByUserId(int userid);
	public Map<String, Integer> getTypes();
	public Map<String, Integer> getStatuses();
	
	//SETTERS
	public int putReimb(Reimbursement reimb, String type);
	
	//UPDATERS
	public Reimbursement approveReimb(Reimbursement reimb, int resolver);
	public Reimbursement denyReimb(Reimbursement reimb, int resolver);
		
	//REMOVE
	public int removeReimb(Reimbursement reimb);

}
