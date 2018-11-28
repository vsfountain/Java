package com.ErsReimbursement;
import org.apache.log4j.Logger;

import com.ErsReimbursement.dao.ReimbursementDaoImpl;
import com.ErsReimbursement.model.Reimbursement;
import com.ErsReimbursement.service.ReimbursementService;
import com.ErsReimbursement.service.ReimbursementServiceImpl;


public class Main {

	
	
	
	
	final static Logger logger = Logger.getLogger(Main.class);
	private static ReimbursementService imbur = new ReimbursementServiceImpl();

	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		Reimbursement customer = ReimbursementServiceImpl.webRegister();
//		UserServiceImpl.selectUserByLoginInfo(String userName, String passWord);
//
//
//		logger.setLevel(Level.ERROR);
		
		
		/*if(logger.isInfoEnabled()) {*/
			logger.info("This is info: loggers are cool, right? Sugoi!");
		/*}*/
		
		logger.warn("This is a warning: it comes for me at dawn....");
		logger.error("This is an error: pineapples don't go on pizza...",
				new IndexOutOfBoundsException());
		logger.fatal("This is fatal");
		logger.info("-----------");
		System.out.println("I have learned alot from this project");
		System.out.println("o");
		Reimbursement reimbursement = null;
		
		int remb_Id = 2;
		double remb_Amount = 28.90;
		String remb_Submitted = "hello";
		String remb_Resolved = "approved";
		String remb_Description ="lodging";
		int remb_Author = 1;
		String remb_Resolver ="Jonathan" ;
		 int remb_Status_Id = 3;
		 int remb_Type_Id = 2;
		
		Reimbursement reimburse = new Reimbursement(remb_Id, remb_Amount, remb_Submitted, remb_Resolved, remb_Description,
				remb_Author, remb_Resolver, remb_Status_Id,remb_Type_Id);
		ReimbursementDaoImpl ReimbursementDao = new ReimbursementDaoImpl();
		imbur.InsertReimbursement(reimburse);

	}




}

	