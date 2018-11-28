package com.reimbsys.dao;

import java.sql.Blob;
import java.sql.Timestamp;
import java.util.Map;

import com.reimbsys.model.Reimbursement;

public interface ReimbDao {
	
		//CREATE
		public int insertReimb(Double amount, int userid, int typeid, String description, Blob receipt);
		
		//READ
		public Map<String, Reimbursement> selectAllReimbs();
		public Reimbursement selectReimbById(int reimbid);
		public Map<String, Reimbursement> selectReimbByUserName(String username);
		public Map<String, Reimbursement> selectReimbByUserId(int userid);
		public Map<String, Integer> selectTypes();
		public Map<String, Integer> selectStatuses();
		
		//UPDATE
		public int updateReimb(int reimbid, int statusid, int resolverid, Timestamp resolved);
		
		//DELETE
		public int deleteReimb(int	reimbid);

}
