package com.project1.service;

import java.util.List;

import org.apache.log4j.Logger;

import com.project1.daos.ReimbursementDao;
import com.project1.daos.ReimbursementDaoImpl;
import com.project1.objs.Reimbursement;
import com.project1.objs.User;

public class ReimbursementServiceImpl implements ReimbursementService {
	ReimbursementDao reimb = new ReimbursementDaoImpl();
	final static Logger logger = Logger.getLogger(ReimbursementServiceImpl.class);

	@Override
	public void logReimbursement(double reimbAmount, String reimbDescription, User reimbAuthor,
			String reimbType) {
		switch (reimbType.toLowerCase()) {
		case "lodging":
			reimb.creatReimb(reimbAmount, reimbDescription, reimbAuthor.getUserId(), 1);
			logger.info(reimbType + " reimbursement for $" + reimbAmount 
						+ " submitted by " + reimbAuthor.getFirstName() + " " + reimbAuthor.getLastName() + ".");
			break;
		case "travel":
			reimb.creatReimb(reimbAmount, reimbDescription, reimbAuthor.getUserId(), 2);
			logger.info(reimbType + " reimbursement for $" + reimbAmount 
					+ " submitted by " + reimbAuthor.getFirstName() + " " + reimbAuthor.getLastName() + ".");
			break;
		case "food":
			reimb.creatReimb(reimbAmount, reimbDescription, reimbAuthor.getUserId(), 3);
			logger.info(reimbType + " reimbursement for $" + reimbAmount 
					+ " submitted by " + reimbAuthor.getFirstName() + " " + reimbAuthor.getLastName() + ".");
			break;
		case "other":
			reimb.creatReimb(reimbAmount, reimbDescription, reimbAuthor.getUserId(), 4);
			logger.info(reimbType + " reimbursement for $" + reimbAmount 
					+ " submitted by " + reimbAuthor.getFirstName() + " " + reimbAuthor.getLastName() + ".");
			break;
		default:
			logger.error("invalid type of reimbursement", new Exception());
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
				logger.info(reimb.getReimbAuthor() + "'s reimbursement for $" + reimb.getReimbAmount() 
						+ " was approved by " + resolver.getFirstName() + " " + resolver.getLastName() + ".");
				break;
			case "deny":
				this.reimb.updateReimb(reimb, resolver, 3);
				logger.info(reimb.getReimbAuthor() + "'s reimbursement for $" + reimb.getReimbAmount() 
				+ " was denied by " + resolver.getFirstName() + " " + resolver.getLastName() + ".");
			}
			
		}
		else
			logger.warn("Unauthorized user (" + resolver.getFirstName() + " " + resolver.getLastName() 
			+ ") attempted to perform admin function.");

	}

}
