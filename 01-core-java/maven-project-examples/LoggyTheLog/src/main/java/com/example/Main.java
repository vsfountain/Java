package com.example;

import org.apache.log4j.Logger;

public class Main {

	final static Logger logger = Logger.getLogger(Main.class);
	
	public static void main(String[] args) {

		if(logger.isInfoEnabled()) {
			logger.info("This is info: loggers are cool, right? Sugoi!");
		}
		
		logger.warn("This is a warning: it comes for me at dawn....");
		logger.error("This is an error: I can't fight it...I must accept it",
				new IndexOutOfBoundsException());
		logger.fatal("This is fatal: It is easier to let it take me...farewell");
		logger.info("");
	}

}
