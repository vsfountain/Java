package com.project1.service;

import java.sql.Blob;
import java.util.List;

import com.project1.daos.ReimbursementDao;
import com.project1.daos.ReimbursementDaoImpl;
import com.project1.objs.Reimbursement;
import com.project1.objs.User;

public class ReimbursementServiceImpl implements ReimbursementService {
	ReimbursementDao reimb = new ReimbursementDaoImpl();

	@Override
	public void logReimbursement(int reimbAmount, String reimbDescription, Blob receipt, User reimbAuthor,
			String reimbType) {
		switch (reimbType.toLowerCase()) {
		case "lodging":
			reimb.creatReimb(reimbAmount, reimbDescription, receipt, reimbAuthor.getUserId(), 1);
			break;
		case "travel":
			reimb.creatReimb(reimbAmount, reimbDescription, receipt, reimbAuthor.getUserId(), 1);
			break;
		case "food":
			reimb.creatReimb(reimbAmount, reimbDescription, receipt, reimbAuthor.getUserId(), 1);
			break;
		case "other":
			reimb.creatReimb(reimbAmount, reimbDescription, receipt, reimbAuthor.getUserId(), 1);
			break;
		default:
			System.out.println("Please enter a valid type of reimbursement");
		}

	}

	@Override
	public List<Reimbursement> getUserReimbs(User user) {
		return reimb.getUserReimbs(user);
	}

	@Override
	public List<Reimbursement> getAllReimbs(User user) {
		if (user.getUserRoleId() == 2) {
			return reimb.getAllReimbs();
		} else {
			return getUserReimbs(user);
		}
	}

	@Override
	public void processReimb(Reimbursement reimb, User resolver, int process) {
		if (resolver.getUserRoleId() == 2)
			this.reimb.updateReimb(reimb, resolver, process);
		else
			System.out.println("This user is not authorized to process reimbursements.");

	}

}
