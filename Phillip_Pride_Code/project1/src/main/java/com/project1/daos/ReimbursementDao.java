package com.project1.daos;

import java.sql.Blob;
import java.util.List;

import com.project1.objs.Reimbursement;
import com.project1.objs.User;

public interface ReimbursementDao {

	// CREATE a new reimbursement
	public void creatReimb(int reimbAmount, String reimbDescription, Blob receipt, int reimbAuthor, int reimbTypeId);

	public List<Reimbursement> getUserReimbs(User user);
	
	public List<Reimbursement> getAllReimbs();

	// UPDATE an new Reimbursement
	public void updateReimb(Reimbursement reimb, User resolver, int process);

}
