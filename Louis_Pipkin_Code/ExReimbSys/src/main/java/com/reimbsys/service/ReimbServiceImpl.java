package com.reimbsys.service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import com.reimbsys.dao.ReimbDao;
import com.reimbsys.dao.ReimbDaoImpl;
import com.reimbsys.model.Reimbursement;

public class ReimbServiceImpl implements ReimbService {

	final static Logger logger = Logger.getLogger(ReimbServiceImpl.class);
	
	private ReimbDao rdao = new ReimbDaoImpl();
	
	@Override
	public Map<String, Reimbursement> getAllReimbs() {
		logger.info("ReimbServiceImpl, calling getAllReimbs");
		
		return rdao.selectAllReimbs();
	}

	@Override
	public Reimbursement getReimbById(int reimbid) {
		logger.info("ReimbServiceImpl, calling getReimbById: "+reimbid);
		
		return rdao.selectReimbById(reimbid);
	}

	@Override
	public Map<String, Reimbursement> getReimbsByIds(String[] reimbids) {
		logger.info("ReimbServiceImpl, calling getReimbById: "+ Arrays.toString(reimbids));
		Map<String, Reimbursement> allReimbs = this.getAllReimbs();
		// return key will be the id string passed in
		Map<String, Reimbursement> reimbs = new HashMap<>(); 
		
		// the keys for the allReimbs map are author|id
		// remove all entries for keys that do not end with out ids
		for (Map.Entry<String, Reimbursement> entry : allReimbs.entrySet()) {
			for (String id: reimbids) {
				if (entry.getKey().endsWith("|"+id)) {
					reimbs.put(id, entry.getValue());
			    }
			}
	    }
		System.out.println(reimbs);
		return reimbs;
	}
	
	@Override
	public Map<String, Reimbursement> getReimbByUserName(String username) {
		logger.info("ReimbServiceImpl, calling getReimbByUserName: "+username);
		
		return rdao.selectReimbByUserName(username);
	}

	@Override
	public Map<String, Reimbursement> getReimbByUserId(int userid) {
		logger.info("ReimbServiceImpl, calling getReimbByUserId: "+userid);
		
		return rdao.selectReimbByUserId(userid);
	}

	@Override
	public Map<String, Integer> getTypes() {
		logger.info("ReimbServiceImpl, calling getTypes");
		
		return rdao.selectTypes();
	}

	@Override
	public Map<String, Integer> getStatuses() {
		logger.info("ReimbServiceImpl, calling getStatuses");
		
		return rdao.selectStatuses();
	}
	
	@Override
	public int putReimb(Reimbursement reimb, String type) {
		logger.info("ReimbServiceImpl, calling putReimb: "+reimb);
		
		// update the type id in the reimbursement from null
		reimb.setTypeId(this.getTypes().get(type));
		
		return rdao.insertReimb(reimb.getAmount(), reimb.getAuthorId(), reimb.getTypeId(), 
				reimb.getDescription(), reimb.getReceipt());
	}

	@Override
	public Reimbursement approveReimb(Reimbursement reimb, int resolver) {
		logger.info("ReimbServiceImpl, calling approveReimb: "+reimb);
		
		int approved = this.getStatuses().get("Approved");
		rdao.updateReimb(reimb.getReimbId(), approved, resolver, reimb.getResolved());
		
		return rdao.selectReimbById(reimb.getReimbId());
	}

	@Override
	public Reimbursement denyReimb(Reimbursement reimb, int resolver) {
		logger.info("ReimbServiceImpl, calling denyReimb: "+reimb);
		
		int denied = this.getStatuses().get("Denied");
		rdao.updateReimb(reimb.getReimbId(), denied, resolver, reimb.getResolved());
		
		return rdao.selectReimbById(reimb.getReimbId());
	}

	@Override
	public int removeReimb(Reimbursement reimb) {
		logger.info("ReimbServiceImpl, calling removeReimb: "+reimb);
		
		return rdao.deleteReimb(reimb.getReimbId());
	}

}
