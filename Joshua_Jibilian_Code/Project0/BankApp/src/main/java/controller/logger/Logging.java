package controller.logger;



import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import controller.dao.UserDaoImpl;

public class Logging {
	final static Logger logger = LogManager.getLogger(UserDaoImpl.class.getName());
}
