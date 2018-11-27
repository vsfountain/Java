package revERS.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import revERS.model.User;

//u.ers_username = ? AND 
public class UserDAO {
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	private static String url = "jdbc:oracle:thin:@colt-rev-db.cjm6y7b2xpmz.us-east-2.rds.amazonaws.com:1521:orcl";
	private static String username = "revERS";
	private static String password = "p4ssw0rd";

	public static Logger logger = Logger.getLogger(UserDAO.class);

	// How to call a stored function from JDBC
	/*CallableStatement cs = conn.prepareCall("{ ? = call GET_CUSTOMER_HASH('coltossoff','12345') }");
	cs.registerOutParameter(1, Types.VARCHAR);;
	cs.execute();
	String hash = cs.getString(1);
	System.out.println("hash" + hash);
	cs.close();*/

	
	public static User selectLogin(String uname, String pwd) {
		try(Connection conn= DriverManager.getConnection(url, username, password))
		{
			logger.info("In UserDAO.selectLogin()");
			String sql = "SELECT u.ers_users_id, u.ers_username, u.USER_FIRST_NAME, u.USER_LAST_NAME, u.user_email, r.user_role " + 
					"FROM ers_users u LEFT OUTER JOIN ers_user_roles r ON u.USER_ROLE_ID = r.ers_user_role_id " + 
					"WHERE u.ers_username = ? AND u.ers_password = GET_CUSTOMER_HASH(?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, uname);
			ps.setString(2, uname);
			ps.setString(3, pwd);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				return new User (
						rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getString(4),
						rs.getString(5),
						rs.getString(6)
						);
			}
		} catch(SQLException e) {
			logger.error("SQL Exception in selectLogin()", e);
		}
		return null;
	}
	public static User selectId(int id) {
		
		try(Connection conn= DriverManager.getConnection(url, username, password))
		{
			logger.info("In UserDAO.selectId()");
			String sql = "SELECT u.ers_users_id, u.ers_username, u.USER_FIRST_NAME, u.USER_LAST_NAME, u.user_email, r.user_role " + 
					"FROM ers_users u LEFT OUTER JOIN ers_user_roles r ON u.USER_ROLE_ID = r.ers_user_role_id " + 
					"WHERE u.ers_users_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				return new User (
						rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getString(4),
						rs.getString(5),
						rs.getString(6)
						);
			}
		} catch(SQLException e) {
			logger.error("SQL Exception in selectId()", e);
		}
		return null;
	}
}
