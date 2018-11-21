package com.jwjibilian.daos;

import java.util.ArrayList;

import com.jwjibilian.model.reimbursement.Reimbursement;
import com.jwjibilian.model.user.User;

public interface ReimbursementDAO {
	public ArrayList<Reimbursement> getUserReimbursments(User u);
	public boolean addReimbursement(int userId, double ammount, String type, String desc);
	public boolean updateRequest(int requestId, int admingId, String status);
	
}