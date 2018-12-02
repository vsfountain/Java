package com.ErsReimbursement.service.test;

import java.util.ArrayList;

import com.ErsReimbursement.dao.ReimbursementDaoImpl;
import com.ErsReimbursement.model.Reimbursement;
import com.ErsReimbursement.service.ReimbursementService;
import com.ErsReimbursement.service.ReimbursementServiceImpl;

public class MyTestclass implements ReimbursementService {
	// private ReimbursementDao reimbursementDao;
	ReimbursementService emburse = new ReimbursementServiceImpl();

	// public List<Reimbursement> filterReimbursements(String filter){
	// if(allReimbursements == null ) {
	// allReimbursements = getReimbursementDao().fetchReimbursements();
	// }
	// List <Reimbursement> returnReimbursements = new ArrayList<Reimbursement>();
	// for (Reimbursement reimbursement: allReimbursements)
	// if (reimbursement.toString().contains(filter)) {
	// returnReimbursements.add(reimbursement);
	// }
	// }
	// Return returnReimbursements;
	//
	// }
	public ArrayList<Reimbursement> constructReimbursementList() {
		ArrayList<Reimbursement> allReimbursements = new ArrayList<Reimbursement>();

		Reimbursement mostExpensive = new Reimbursement("remb_Amount", "remb_Description", "remb_Type_Id");
		mostExpensive.setRemb_Amount(350.00);
		mostExpensive.setRemb_Description("Most Expensive");
		mostExpensive.setRemb_Type_Id(2);
		allReimbursements.add(mostExpensive);

		Reimbursement moderateExpense = new Reimbursement("remb_Amount", "remb_Description", "remb_Type_Id");
		moderateExpense.setRemb_Amount(87.00);
		moderateExpense.setRemb_Description("Moderate Expense");
		moderateExpense.setRemb_Type_Id(2);
		allReimbursements.add(moderateExpense);

		Reimbursement leastExpensive = new Reimbursement("remb_Amount", "remb_Description", "remb_Type_Id");
		leastExpensive.setRemb_Amount(65.00);
		leastExpensive.setRemb_Description("Least Expensive");
		leastExpensive.setRemb_Type_Id(2);
		allReimbursements.add(leastExpensive);
		return allReimbursements;
	}

	public ReimbursementDaoImpl getReimbursementDao() {
		return getReimbursementDao();
	}

	@Override
	public boolean InsertReimbursement(Reimbursement reimburse) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int updateReimbursementByStatusId(Reimbursement reimburse) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<Reimbursement> selectAllReimburse() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateapprovedReimbursementByStatusId(String reimb_Resolved, String reimb_Resolver,
			int reimb_status_id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updatedeclinedReimbursementByStatusId(String reimb_Resolved, String reimb_Resolver,
			int reimb_status_id) {
		// TODO Auto-generated method stub
		return 0;
	}

}