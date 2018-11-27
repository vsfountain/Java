package com.jwjibilian.services;

import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.jwjibilian.daos.ReimbursementDAO;
import com.jwjibilian.daos.ReimbursementDAOImpl;
import com.jwjibilian.model.reimbursement.Reimbursement;
import com.jwjibilian.model.user.User;

public class ReimbursementServiceImpl implements ReimbursementService{
	public ReimbursementDAO dao = new ReimbursementDAOImpl();
	private static final Logger LOGGER = LogManager.getLogger(ReimbursementServiceImpl.class.getName());
	@Override
	public ArrayList<Reimbursement> getUserReimbursments(User u) {
		return dao.getUserReimbursments(u);
	}
	@Override
	public boolean addReimbursement(int userId, double ammount, String type, String desc) {
		return dao.addReimbursement(userId, ammount, type, desc);
	}
	@Override
	public boolean approve(int requestId, int adminId) {
		
		return dao.updateRequest(requestId, adminId, "approve");
	}
	@Override
	public boolean deny(int requestId, int adminId) {
		
		return dao.updateRequest(requestId, adminId,"deny");
	}

}
