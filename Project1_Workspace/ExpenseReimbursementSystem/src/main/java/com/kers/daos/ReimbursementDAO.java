package com.kers.daos;

import java.util.List;

import com.kers.models.Reimbursement;

public interface ReimbursementDAO {
	public int insertReimbursement(Reimbursement r);
	public int insertReimbursementSansBlob(Reimbursement r);
	
	public List<Reimbursement> selectAllReimbursements();
	
	public Reimbursement selectReimbursementById(int id);
	
	public Reimbursement selectReimbursementByStatusId(int status_id);
	
	public Reimbursement updateReimbursement(Reimbursement r);
	public Reimbursement deleteReimbursement(Reimbursement r);
	
	public int updateReimbursementById(int id, String approved, String resolver);
	
	public void h2InitDao();
	public void h2DestroyDao();
	public String h2InitTables();
	public String h2InitSeqs();
	public String h2InitTriggers();
	public String h2InitProcedures();
	public String h2InitFunctions();
	
}
