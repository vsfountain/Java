package com.example.dao;

import java.util.List;

import com.example.model.ErsReimbursement;

public interface H2ErsReimbursementDao {
	
	public List<ErsReimbursement> selectAllErsReimbursements();
	
	public int insertReimbursement(ErsReimbursement ersReimbursement);
	
	
	
	
	public void h2InitDao();
	public void h2DestroyDao();
	
	
}
