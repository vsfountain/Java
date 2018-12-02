package com.ErsReimbursement.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.ErsReimbursement.Main;
import com.ErsReimbursement.dao.ReimbursementDao;
import com.ErsReimbursement.dao.ReimbursementDaoImpl;
import com.ErsReimbursement.model.Reimbursement;

/**
 * @author Kristen Kavanagh
 * @version 11/15/2018
 *
 */

public class ReimbursementServiceImpl implements ReimbursementService {

	final static Logger logger = Logger.getLogger(Main.class);
	private ReimbursementDao emburse = new ReimbursementDaoImpl();

	@Override
	public boolean InsertReimbursement(Reimbursement reimburse) {
		//System.out.println("in RSI at IR" + reimburse.getRemb_Description());
		if (reimburse.getRemb_Description().length() > 250) {
			reimburse.setRemb_Description(reimburse.getRemb_Description().substring(0, 250));
		}

		int imbur = emburse.InsertReimbursement(reimburse);
		logger.info("New Reimbursement: " + reimburse.getRemb_Description() + " inserted");
		if (imbur == 1) {
			return true;

		} else
		{
			return false;
	}
	}

	@Override
	public ArrayList<Reimbursement>selectAllReimburse() {
		return emburse.viewReimburse();
}


	@Override
	public int updateReimbursementByStatusId(Reimbursement reimburse) {
		return 0;
	}
	
	public int updateapprovedReimbursementByStatusId(String reimb_Resolved, String reimb_Resolver, int reimb_status_id) {
		
		Reimbursement reimburse = null;
		List<Reimbursement> reimburse2;
		reimburse2 = emburse.viewReimburse();
		for(Reimbursement reimburse3: reimburse2) {
			if(reimburse3.getRemb_Id() == reimb_status_id) {
				reimburse = reimburse3;
			}
		}
		
		int reimb_Status_Id = 0;
		/*reimburse.setRemb_Status_Id(reimb_Status_Id);*/
		reimburse.setRemb_Status_Id(1);
		if (reimb_Status_Id == 1) {
		
		return reimb_status_id;}
		else {
			/*return emburse.updateReimbursementByStatusId();*/
			return emburse.updateReimbursementByStatusId(reimburse);
		}
		
		
	}
	
public int updatedeclinedReimbursementByStatusId(String reimb_Resolved, String reimb_Resolver, int reimb_status_id) {
		
		Reimbursement reimburse = null;
		List<Reimbursement> reimburse2;
		reimburse2 = emburse.viewReimburse();
		for(Reimbursement reimburse3: reimburse2) {
			if(reimburse3.getRemb_Id() == reimb_status_id) {
				reimburse = reimburse3;
			}
		}
		
		int reimb_Status_Id = 2;
		reimburse.setRemb_Status_Id(reimb_Status_Id);
		if (reimb_Status_Id == 1) {
		
		return reimb_status_id;}
		else {
			return emburse.updateReimbursementByStatusId(reimburse);
		}
		
		
	}


		
}