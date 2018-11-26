package com.ErsReimbursement.service;

import java.util.ArrayList;

import com.ErsReimbursement.dao.ReimbursementDao;
import com.ErsReimbursement.dao.ReimbursementDaoImpl;
import com.ErsReimbursement.model.Reimbursement;
import com.ErsReimbursement.model.User;

/**
 * @author Kristen Kavanagh
 * @version 11/15/2018
 *
 */

public class ReimbursementServiceImpl implements ReimbursementService {

	private ReimbursementDao emburse = new ReimbursementDaoImpl();

	@Override
	public boolean InsertReimbursement(Reimbursement reimburse) {
		System.out.println("in RSI at IR" + reimburse.getRemb_Description());
		if (reimburse.getRemb_Description().length() > 250) {
			reimburse.setRemb_Description(reimburse.getRemb_Description().substring(0, 250));
		}

		int imbur = emburse.InsertReimbursement(reimburse);
		if (imbur == 1) {
			return true;

		} else

			return false;
	}


	@Override
	public void CreateReimbursement(User staff) {

	}
	@Override
	public ArrayList<Reimbursement>selectAllReimburse() {
		return emburse.viewReimburse();
}
}