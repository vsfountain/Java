package debug;

import controller.dao.UserDao;
import controller.dao.UserDaoImpl;

// TODO: Auto-generated Javadoc
/**
 * The Class Main.
 */
public class Main {
	
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		UserDao userDao = new UserDaoImpl();
		userDao.userLogin("email@", "123");
	}
	
}
