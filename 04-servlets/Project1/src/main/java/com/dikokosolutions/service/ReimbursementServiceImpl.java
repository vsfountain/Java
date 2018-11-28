package com.dikokosolutions.service;

import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.dikokosolutions.controller.HomeController;
import com.dikokosolutions.dao.ReimbursementDao;
import com.dikokosolutions.model.Reimbursement;

public class ReimbursementServiceImpl implements ReimbursementService {
	final static Logger logger = Logger.getLogger(HomeController.class);
	public Reimbursement r = new Reimbursement();
	public ReimbursementDao reimDao = new ReimbursementDao();

	@Override
	public ArrayList<Reimbursement> getAllReimbursements() {
		logger.warn("This should only be called by Finance Manager");
		return reimDao.getAllReimbursementsFromDB();
	}

	public ArrayList<Reimbursement> getUserReimbursement(String username) {

		logger.warn("This should only be called by an Employee");
		return reimDao.getUserReimbursement(username);

	}

}
