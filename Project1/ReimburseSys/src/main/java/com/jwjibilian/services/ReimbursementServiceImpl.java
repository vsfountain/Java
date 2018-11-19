package com.jwjibilian.services;

import java.util.ArrayList;

import com.jwjibilian.daos.ReimbursementDAO;
import com.jwjibilian.daos.ReimbursementDAOImpl;
import com.jwjibilian.daos.UserDAO;
import com.jwjibilian.daos.UserDAOImpl;
import com.jwjibilian.model.reimbursement.Reimbursement;
import com.jwjibilian.model.user.User;

public class ReimbursementServiceImpl implements ReimbursementService{
	public ReimbursementDAO dao = new ReimbursementDAOImpl();
	@Override
	public ArrayList<Reimbursement> getUserReimbursments(User u) {
		return dao.getUserReimbursments(u);
	}
	@Override
	public boolean addReimbursement(int userId, double ammount, String type, String desc) {
		return dao.addReimbursement(userId, ammount, type, desc);
	}

}
