package com.project1.service;

import java.sql.Blob;
import java.util.List;

import com.project1.daos.ReimbursementDao;
import com.project1.daos.ReimbursementDaoImpl;
import com.project1.objs.Reimbursement;
import com.project1.objs.User;

public interface ReimbursementService {
	
	public void logReimbursement(int reimbAmount, String reimbDescription, Blob receipt, User reimbAuthor, String reimbType); 
	
	public List<Reimbursement> getUserReimbs(User user);
	
	public List<Reimbursement> getAllReimbs(User user);
	
	public void processReimb(Reimbursement reimb, User resolver, int process);

}
