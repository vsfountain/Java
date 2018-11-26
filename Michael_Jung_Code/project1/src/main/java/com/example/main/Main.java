package com.example.main;

import com.example.dao.ErsReimbursementDao;
import com.example.dao.ErsReimbursementDaoImpl;
import com.example.model.ErsReimbursement;
import com.example.model.ErsUser;
import com.example.service.ErsUsersService;
import com.example.service.ErsUsersServiceImpl;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*ErsUser ersUser = null;
		ErsUsersService ersUsersService = new ErsUsersServiceImpl();
		ersUser = ersUsersService.getFinanceManager("admin1", "password");
		System.out.println(ersUser);*/
		System.out.println("fdlskjlsdkj");
		ErsReimbursement ersReimbursement = null;
		ErsReimbursementDaoImpl ersReimbursementDao = new ErsReimbursementDaoImpl();
		ersReimbursementDao.selectAllErsReimbursements();
		
	}

}
