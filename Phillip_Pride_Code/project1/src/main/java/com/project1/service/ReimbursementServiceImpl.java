package com.project1.service;

import java.util.List;

import com.project1.daos.ReimbursementDao;
import com.project1.daos.ReimbursementDaoImpl;
import com.project1.objs.Reimbursement;
import com.project1.objs.User;

public class ReimbursementServiceImpl implements ReimbursementService {
	ReimbursementDao reimb = new ReimbursementDaoImpl();

	@Override
	public void logReimbursement(double reimbAmount, String reimbDescription, User reimbAuthor,
			String reimbType) {
		switch (reimbType.toLowerCase()) {
		case "lodging":
			reimb.creatReimb(reimbAmount, reimbDescription, reimbAuthor.getUserId(), 1);
			break;
		case "travel":
			reimb.creatReimb(reimbAmount, reimbDescription, reimbAuthor.getUserId(), 2);
			break;
		case "food":
			reimb.creatReimb(reimbAmount, reimbDescription, reimbAuthor.getUserId(), 3);
			break;
		case "other":
			reimb.creatReimb(reimbAmount, reimbDescription, reimbAuthor.getUserId(), 4);
			break;
		default:
			System.out.println("Please enter a valid type of reimbursement");
		}

	}
	
	@Override
	public Reimbursement getReimb(int id) {
		return reimb.getReimb(id);
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
	public void processReimb(Reimbursement reimb, User resolver, String process) {
		if (resolver.getUserRoleId() == 2) {
			switch(process.toLowerCase()) {
			case "approve":
				this.reimb.updateReimb(reimb, resolver, 2);
				break;
			case "deny":
				this.reimb.updateReimb(reimb, resolver, 3);
			}
			
		}
		else
			System.out.println("This user is not authorized to process reimbursements.");

	}

}
