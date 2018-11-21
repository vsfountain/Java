package com.jwjibilian.services;

import java.util.ArrayList;

import com.jwjibilian.model.reimbursement.Reimbursement;
import com.jwjibilian.model.user.User;

public interface ReimbursementService {
	public ArrayList<Reimbursement> getUserReimbursments(User u);
	public boolean addReimbursement(int userId, double ammount, String type, String desc);
	public boolean approve(int requestId, int adminId);
	public boolean deny(int requestId, int adminId);
}
