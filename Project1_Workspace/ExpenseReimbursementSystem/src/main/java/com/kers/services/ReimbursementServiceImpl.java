package com.kers.services;

import java.util.List;

import com.kers.daos.ReimbursementDAO;
import com.kers.daos.ReimbursementDAOImpl;
import com.kers.models.Reimbursement;

public class ReimbursementServiceImpl implements ReimbursementService {

	ReimbursementDAO rdao = new ReimbursementDAOImpl();

	@Override
	public int addReimbursement(Reimbursement reimbursement) {
		return rdao.insertReimbursement(reimbursement);
	}

	@Override
	public List<Reimbursement> getAllReimbursements() {
		return rdao.selectAllReimbursements();
	}

	@Override
	public Reimbursement getReimbursementById(int id) {
		return rdao.selectReimbursementById(id);
	}

	@Override
	public int updateReimbursementById(int id, String decision, String resolver) {
		
		String _decision = "";
		if (decision.equals("approve")) {
			_decision = "Approved";
		} else {
			_decision = "Denied";
		}
		return rdao.updateReimbursementById(id, _decision, resolver);
	}
	
}
