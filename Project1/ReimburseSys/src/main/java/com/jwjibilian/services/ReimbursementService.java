package com.jwjibilian.services;

import java.util.ArrayList;

import com.jwjibilian.model.reimbursement.Reimbursement;
import com.jwjibilian.model.user.User;

public interface ReimbursementService {
	public ArrayList<Reimbursement> getUserReimbursments(User u);
}
