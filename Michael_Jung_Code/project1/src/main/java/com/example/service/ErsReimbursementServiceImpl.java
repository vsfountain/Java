package com.example.service;

import java.util.ArrayList;
import java.util.List;

import com.example.dao.ErsReimbursementDao;
import com.example.dao.ErsReimbursementDaoImpl;
import com.example.dao.ErsUsersDao;
import com.example.dao.ErsUsersDaoImpl;
import com.example.model.ErsReimbFeModel;
import com.example.model.ErsReimbursement;
import com.example.model.ErsUser;

public class ErsReimbursementServiceImpl implements ErsReimbursementService{

	private ErsReimbursementDao ersReimbursementDao = new ErsReimbursementDaoImpl();
	private ErsUsersDao ersUsersDao = new ErsUsersDaoImpl();
	
	@Override
	public List<ErsReimbFeModel> getAllErsReimbursements() {
		
		List<ErsReimbursement> ersReimbursements = ersReimbursementDao.selectAllErsReimbursements();
		List<ErsReimbFeModel> ersReimbFeModels = new ArrayList<>();
		/*ErsUser ersUser;*/
		String reimbStatus;
		String reimbType;
		
		for(ErsReimbursement ersReimbursement: ersReimbursements) {
			/*ersUser = ersUsersDao.selectErsUserById(ersReimbursement.getReimbursementErsUserId());*/
			if(ersReimbursement.getReimbursementStatusId() == 1) {
				reimbStatus = "Approved";
			} else if(ersReimbursement.getReimbursementStatusId() == 2) {
				reimbStatus = "Declined";
			} else {
				reimbStatus = "Pending";
			}
			
			if(ersReimbursement.getReimbursementTypeId() == 1) {
				reimbType = "Lodging";
			} else if(ersReimbursement.getReimbursementTypeId() == 2) {
				reimbType = "Travel";
			} else if(ersReimbursement.getReimbursementTypeId() == 3) {
				reimbType = "Food";
			} else {
				reimbType = "Other";
			}
			
			
			ersReimbFeModels.add(new ErsReimbFeModel(ersReimbursement.getReimbursementId(),
													ersReimbursement.getReimbursementAmount(),
													ersReimbursement.getReimbursementSubmittedDate(),
													ersReimbursement.getReimbursementResolvedDate(),
													ersReimbursement.getReimbursementDescription(),
													ersReimbursement.getReimbursementReceipt(),
													ersUsersDao.selectErsUserById(ersReimbursement.getReimbursementErsUserId()),
													reimbStatus,
													reimbType,
													ersUsersDao.selectErsUserById(ersReimbursement.getReimbursementResolverId())
													));
			
		}
		
		return ersReimbFeModels;
		/*return ersReimbursementDao.selectAllErsReimbursements();*/
	}
	
	
	
	
	public int approveReimbursement(int reimbursementId, int adminUserId) {
		
		return ersReimbursementDao.approveReimbursement(reimbursementId, adminUserId);
		
		
	}
	
	public int disapproveReimbursement(int reimbursementId, int adminUserId) {
		
		return ersReimbursementDao.disapproveReimbursement(reimbursementId, adminUserId);
	}
	
	
	public int createReimbursement(ErsUser ersUser, double amount, String type, String description) {
		
		int typeId;
		if(type.equals("Lodging")) {
			typeId = 1;
		} else if (type.equals("Travel")) {
			typeId = 2;
		} else if (type.equals("Food")) {
			typeId = 3;
		} else {
			typeId = 4;
		}
		
		
		
		ErsReimbursement ersReimbursement = new ErsReimbursement(0,
																 amount,
																 null,
																 null,
																 description,
																 null,
																 ersUser.getUserId(),
																 0,
																 typeId,
																 0
																 );
		int a = ersReimbursementDao.insertReimbursement(ersReimbursement);
		
		return a;
		
	}
	
	
	
}
