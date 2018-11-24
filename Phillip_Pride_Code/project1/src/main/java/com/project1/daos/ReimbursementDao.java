package com.project1.daos;

import java.sql.Blob;
import java.util.List;

import com.project1.objs.Reimbursement;
import com.project1.objs.User;

public interface ReimbursementDao {

	// CREATE a new reimbursement
	public void creatReimb(double reimbAmount, String reimbDescription, int reimbAuthor, int reimbTypeId);

	// Access existing reimbursements
	public Reimbursement getReimb(int reimbId);
	
	public List<Reimbursement> getUserReimbs(User user);
	
	public List<Reimbursement> getAllReimbs();

	// UPDATE an new Reimbursement
	public void updateReimb(Reimbursement reimb, User resolver, int process);

}
