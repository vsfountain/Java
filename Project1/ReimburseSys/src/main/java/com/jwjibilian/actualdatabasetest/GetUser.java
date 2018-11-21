package com.jwjibilian.actualdatabasetest;
import java.io.File;

import org.apache.logging.log4j.LogManager;

import org.apache.logging.log4j.Logger;

public class GetUser {
    private static final Logger LOGGER = LogManager.getLogger(GetUser.class.getName());
    
    public static void main(String[] args)
    {
    	
        LOGGER.debug("Debug Message Logged !!!");
        LOGGER.info("Info Message Logged !!!");
        LOGGER.error("Error Message Logged !!!", new NullPointerException("NullError"));
    }
}
