package com.ers.model;

import java.sql.Timestamp;
import java.util.ArrayList;

public class ReimbursementServiceImpl implements ReimbursementService {
	
	private ReimbursementDAO rDAO = new ReimbursementDAOImpl();

	public ReimbursementServiceImpl() {
		// TODO Auto-generated constructor stub
	}
	public void approveOrDeny(int reimbId, int resolver, int statusId) {
		System.out.println("approveOrDeny in service");
		rDAO.approveOrDeny(reimbId, resolver, statusId);
	}
	public void createReimbursement(double amount, String description, Timestamp reqTime, int author, int statusId, int typeId) {
		rDAO.preparedInsertReimbursement(amount, description, reqTime, author, statusId, typeId);
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
