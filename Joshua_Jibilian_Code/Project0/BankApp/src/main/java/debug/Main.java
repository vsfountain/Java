package debug;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import controller.dao.UserDao;
import controller.dao.UserDaoImpl;

// TODO: Auto-generated Javadoc
/**
 * The Class Main.
 */
public class Main {
	final static Logger logger = LogManager.getLogger(UserDaoImpl.class.getName());
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		logger.info("info");
	}
	
}
