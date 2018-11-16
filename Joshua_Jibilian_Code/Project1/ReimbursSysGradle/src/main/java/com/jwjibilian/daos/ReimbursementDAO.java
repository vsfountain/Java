package com.jwjibilian.daos;

import java.util.ArrayList;

import com.jwjibilian.model.reimbursement.Reimbursement;
import com.jwjibilian.model.user.User;

public interface ReimbursementDAO {
	public ArrayList<Reimbursement> getUserReimbursments(User u);

}