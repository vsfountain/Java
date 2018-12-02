package com.ErsReimbursement.test;
import org.apache.log4j.Logger;

import com.ErsReimbursement.service.UserService;
import com.ErsReimbursement.service.UserServiceImpl;

public class Main {
	final static Logger logger = Logger.getLogger(Main.class);



	public static void main(String[] args) {


		if (logger.isInfoEnabled()) {
			logger.info("This is info: loggers are cool");
			logger.warn("This is a warning....");
			logger.error("This is an error:", new IndexOutOfBoundsException());
			logger.fatal("This is fatal:");
			logger.info("");
		}
		
		UserService userv = new UserServiceImpl();
		System.out.println("Hey this is the userid: " + userv.getCurrUserName("currUserName"));
		}
}



