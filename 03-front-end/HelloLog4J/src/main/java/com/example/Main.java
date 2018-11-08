package com.example;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

/*
 * Logging levels include:
 * 
 * All, debug, info, warn, error, fatal, off, trace
 * 
 * All < debug< info< warn< error< fatal< off
 */

public class Main {

	final static Logger logger = Logger.getLogger(Main.class);
	
	public static void main(String[] args) {

		logger.setLevel(Level.ERROR);
		
		if(logger.isInfoEnabled()) {
			logger.info("This is info: loggers are cool, right? Sugoi!");
		}
		
		logger.warn("This is a warning: it comes for me at dawn....");
		logger.error("This is an error: pineapples don't go on pizza...",
				new IndexOutOfBoundsException());
		logger.fatal("This is fatal");
		logger.info("-----------");
	}

}
