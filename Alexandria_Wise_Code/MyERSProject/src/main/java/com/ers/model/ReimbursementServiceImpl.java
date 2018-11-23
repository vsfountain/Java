package com.ers.model;

import java.util.ArrayList;

public class ReimbursementServiceImpl implements ReimbursementService {
	
	private ReimbursementDAO rDAO = new ReimbursementDAOImpl();

	public ReimbursementServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	public ArrayList<Reimbursement> displayReimbursements() {
		return rDAO.selectAllReimbursements();
	}
	public ArrayList<Reimbursement> filterByEmployee(int userId) {
		return rDAO.selectReimbursementsByID(userId);
	}
	public ArrayList<Reimbursement> filterByStatus(int statusId) {
		return rDAO.selectReimbursementsByStatus(statusId);
	}
}
