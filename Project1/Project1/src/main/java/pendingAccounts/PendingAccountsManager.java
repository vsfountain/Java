package pendingAccounts;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import objects.ReimbursementObj;
import objects.UserObj;
import reimbursement.ReimbursementManager;

public class PendingAccountsManager implements PendingAccountsManagerDAO{
	final static Logger logger = Logger.getLogger(PendingAccountsManager.class);
	private final static String url="jdbc:oracle:thin:@revy-chan.cvi5jgypuakx.us-east-2.rds.amazonaws.com:1521:orcl";
	private final static String managerUserName = "manager";
	private final static String managerPassword = "p4ssw0rd";
	static {

		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");

		} catch (ClassNotFoundException e) {

			logger.error("Cannot find Driver for oracle.jdbc",
					new SQLException());
		}

	}
	
	public PendingAccountsManager() {
		super();
	}
	
	@Override
	public void addPendingAccount(String currUsername, String currPassword, String currFirstname, String currLastname, String currEmail, int role) {
		try(Connection conn=DriverManager.getConnection(url, managerUserName, managerPassword)){
			String sql = "INSERT INTO PENDING_ACCOUNTS (PENDING_ERS_USERNAME, PENDING_ERS_PASSWORD, PENDING_USER_FIRST_NAME, PENDING_USER_LAST_NAME, PENDING_USER_EMAIL, PENDING_USER_ROLE_ID) VALUES(?,?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, currUsername);
			ps.setString(2, currPassword);
			ps.setString(3, currFirstname);
			ps.setString(4, currLastname);
			ps.setString(5, currEmail);
			ps.setInt(6, role);
			ps.executeUpdate();
		}catch(SQLException e) {
			logger.error("Problem occured with inserting into Pending_Accounts Table",
					new SQLException());
		}
	}
	
	@Override
	public ArrayList<UserObj> getPendingAccounts() {
		ArrayList<UserObj> pendingAccounts = new ArrayList<>(); 
		try(Connection conn=DriverManager.getConnection(url, managerUserName, managerPassword)){
			String sql = "SELECT * FROM PENDING_ACCOUNTS";
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				pendingAccounts.add(new UserObj(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getInt(7)));
			}
			return pendingAccounts;
		}catch(SQLException e) {
			logger.error("Problem occured with selecting all records from pending_accounts Table",
					new SQLException());
		}
		return pendingAccounts;
	}
	
	@Override
	public void removePendingAccount(String currUsername) {
		try(Connection conn=DriverManager.getConnection(url, managerUserName, managerPassword)){
			String sql = "DELETE FROM PENDING_ACCOUNTS WHERE PENDING_ERS_USERNAME=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, currUsername);
			ps.executeUpdate();
		}catch(SQLException e) {
			logger.error("Problem occured with deleting a record from pending_accounts Table",
					new SQLException());
		}catch(Exception s) {
			logger.error("Problem occured with parsing an integer in removePendingAccount",
					new Exception());
		}
	}
	
	@Override
	public void insertNewActualAccount(String currUsername, String currPassword, String currFirstname, String currLastname, String currEmail, String currRole) {
		try(Connection conn=DriverManager.getConnection(url, managerUserName, managerPassword)){
			String sql = "INSERT INTO ERS_USERS (ERS_USERNAME, ERS_PASSWORD, USER_FIRST_NAME, USER_LAST_NAME, USER_EMAIL, USER_ROLE_ID) VALUES(?,?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, currUsername);
			ps.setString(2, currPassword);
			ps.setString(3, currFirstname);
			ps.setString(4, currLastname);
			ps.setString(5, currEmail);
			ps.setInt(6, Integer.parseInt(currRole));
			ps.executeQuery();
		}catch(SQLException e) {
			logger.error("Problem occured with inserting into ers_users from pending_accounts",
					new SQLException());
		}
	}
}
