package reimbursement;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.sql.Blob;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import org.apache.log4j.Logger;

import objects.ReimbursementObj;
import oracle.sql.TIMESTAMP;

public class ReimbursementManager implements ReimbursementManagerDAO{
	final static Logger logger = Logger.getLogger(ReimbursementManager.class);
	private final static String url="jdbc:oracle:thin:@revy-chan.cvi5jgypuakx.us-east-2.rds.amazonaws.com:1521:orcl";
	private final static String managerUserName = "manager";
	private final static String managerPassword = "p4ssw0rd";
	
	static {

		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");

		} catch (ClassNotFoundException e) {

			e.printStackTrace();

		}

	}
	
	public ReimbursementManager() {
		super();
		
	}
	@Override
	public String getCurrFullName(String currUserName) {
		try(Connection conn=DriverManager.getConnection(url, managerUserName, managerPassword)){
			String sql = "SELECT user_first_name, user_last_name FROM ers_users WHERE ers_username=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, currUserName);
			ResultSet currName = ps.executeQuery();
			
			String currUsersName = "";
			while(currName.next()) {
				currUsersName = currName.getString(1) + " " + currName.getString(2);
			}
			return currUsersName;
		}catch(SQLException e) {
			logger.error("Problem occured with selecting the users full name.",
					new SQLException());
		}
		return "";
	}
	
	@Override
	public String getUserName(String currUserName) {
		try(Connection conn=DriverManager.getConnection(url, managerUserName, managerPassword)){
			String sql = "SELECT ers_username FROM ers_users WHERE ers_username=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, currUserName);
			ResultSet currName = ps.executeQuery();
			currName.next();
			String currUsersName = currName.getString(1);
			return currUsersName;
		}catch(SQLException e) {
			logger.error("Problem occured with selecting the current username.",
					new SQLException());
		}
		return "";
	}
	
	@Override
	public String getUserPassword(String currUserName) {
		try(Connection conn=DriverManager.getConnection(url, managerUserName, managerPassword)){
			String sql = "SELECT ers_password FROM ers_users WHERE ers_username=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, currUserName);
			ResultSet currPW = ps.executeQuery();
			currPW.next();
			String currPw = currPW.getString(1);
			return currPw;
		}catch(SQLException e) {
			logger.warn("User not found, invalid username credidentials");
		}
		return "";
	}
	
	@Override
	public String validateUser(String currUserName, String currUserPassword) {
		try(Connection conn=DriverManager.getConnection(url, managerUserName, managerPassword)){
			String sql = "{? = call GET_CUSTOMER_HASH(?,?)}";
			CallableStatement cs = conn.prepareCall(sql);

			cs.setString(2, currUserName);
			cs.setString(3, currUserPassword);
			cs.registerOutParameter(1, java.sql.Types.VARCHAR);
			cs.execute();

			String getName = cs.getString(1);

			return getName;
		}catch(SQLException e) {
			logger.error("Problem occured with hash, password invalid.",
					new SQLException());
		}
		return "";
	}
	
	@Override
	public String getUsersId(String currUserName) {
		try(Connection conn=DriverManager.getConnection(url, managerUserName, managerPassword)){
			String sql = "SELECT ers_users_id FROM ers_users WHERE ers_username=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, currUserName);
			ResultSet getUserId = ps.executeQuery();
			getUserId.next();
			int getUserID = getUserId.getInt(1);
			return ""+getUserID;
		}catch(SQLException e) {
			logger.error("Problem occured with selecting current usersID",
					new SQLException());
		}
		return "";
	}
	
	@Override
	public ArrayList<ReimbursementObj> getReimbursement(){
		ArrayList<ReimbursementObj> allReqs = new ArrayList<>();
		try(Connection conn=DriverManager.getConnection(url, managerUserName, managerPassword)){
			String sql = "SELECT * FROM ERS_REIMBURSEMENT";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				allReqs.add(new ReimbursementObj(rs.getInt(1), rs.getDouble(2), rs.getTimestamp(3),
						rs.getTimestamp(4), rs.getString(5), rs.getBlob(6), getCurrFullName(getCurrUsernamee(rs.getInt(7))),
						getCurrFullName(getCurrUsernamee(rs.getInt(8))), getStatus(rs.getInt(9)), getType(rs.getInt(10))));
		
			}
			return allReqs;
		}catch(SQLException e) {
			logger.error("Problem occured with returning all reimbursement requests.",
					new SQLException());
		}
		return allReqs;
	}
	
	@Override
	public ArrayList<ReimbursementObj> getReimbursement(String ersUsersId) {
		ArrayList<ReimbursementObj> sqlReqs = new ArrayList<>();
		try(Connection conn=DriverManager.getConnection(url, managerUserName, managerPassword)){
			String sql = "SELECT * FROM ERS_REIMBURSEMENT WHERE REIMB_AUTHOR=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			int test = Integer.parseInt(ersUsersId);
			//Get all reimbursements requests associated with a particular users id
			ps.setInt(1, test);
			ResultSet currReimbursements = ps.executeQuery();
			while(currReimbursements.next()) {
				sqlReqs.add(new ReimbursementObj(currReimbursements.getInt(1), currReimbursements.getDouble(2), currReimbursements.getTimestamp(3),
							currReimbursements.getTimestamp(4), currReimbursements.getString(5), currReimbursements.getBlob(6), getCurrFullName(getCurrUsernamee(currReimbursements.getInt(7))),
							getCurrFullName(getCurrUsernamee(currReimbursements.getInt(8))), getStatus(currReimbursements.getInt(9)), getType(currReimbursements.getInt(10))));
			}
			return sqlReqs;
		}catch(SQLException e) {
			logger.error("Problem occured with selecting reimbursements to a particular user.",
					new SQLException());
		}
		return sqlReqs;
	}
	
	@Override
	public String getCurrUsernamee(int userId) {
		try(Connection conn=DriverManager.getConnection(url, managerUserName, managerPassword)){
			String sql = "SELECT ERS_USERNAME FROM ERS_USERS WHERE ERS_USERS_ID=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, userId);
			ResultSet currUsersName = ps.executeQuery();
			String currUser = "";
			while(currUsersName.next()) {
				currUser = currUsersName.getString(1);
			}
			return currUser;
		}catch(SQLException e) {
			logger.error("Problem occured with selecting current username given an id.",
					new SQLException());
		}
		return "";
	}
	@Override
	public String getStatus(int status_id) {
		try(Connection conn=DriverManager.getConnection(url, managerUserName, managerPassword)){
			String sql = "SELECT REIMB_STATUS FROM ERS_REIMBURSEMENT_STATUS WHERE REIMB_STATUS_ID=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			//Get all reimbursements requests associated with a particular users id
			ps.setInt(1, status_id);
			ResultSet currStatus = ps.executeQuery();
			currStatus.next();
			return currStatus.getString(1);
		}catch(SQLException e) {
			logger.error("Problem occured with selecting the current status.",
					new SQLException());
		}
		return "";
	}
	
	@Override
	public String getType(int type_id) {
		try(Connection conn=DriverManager.getConnection(url, managerUserName, managerPassword)){
			String sql = "SELECT REIMB_TYPE FROM ERS_REIMBURSEMENT_TYPE WHERE REIMB_TYPE_ID=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			//Get all reimbursements requests associated with a particular users id
			ps.setInt(1, type_id);
			ResultSet currType = ps.executeQuery();
			currType.next();
			return currType.getString(1);
		}catch(SQLException e) {
			logger.error("Problem occured with selecting the current type.",
					new SQLException());
		}
		return "";
	}
	
	@Override
	//public void addReimbursementRequest(double currAmount, String currDescription, Blob currImage, String currType, int currAuthor) {
	public void addReimbursementRequest(double currAmount, String currDescription, String currType, int currAuthor) {
		try(Connection conn=DriverManager.getConnection(url, managerUserName, managerPassword)){
			String sql = "INSERT INTO ERS_REIMBURSEMENT (REIMB_AMOUNT, REIMB_SUBMITTED, REIMB_RESOLVED, REIMB_DESCRIPTION, REIMB_RECEIPT, REIMB_AUTHOR, REIMB_RESOLVER, REIMB_STATUS_ID, REIMB_TYPE_ID) VALUES(?,?,null,?,null,?,null,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			//Get all reimbursements requests associated with a particular users id
			int getCurrType = Integer.parseInt(currType);
			Date today = new Date();
			Timestamp timestamp = new Timestamp(today.getTime());
			ps.setDouble(1, currAmount);
			ps.setTimestamp(2, timestamp);
			ps.setString(3, currDescription);
			ps.setInt(4, currAuthor);
			ps.setInt(5, 1); //Pending by default aka 1
			ps.setInt(6, getCurrType);
			ps.executeUpdate();
		}catch(SQLException e) {
			logger.error("Problem occured with inserting into reimbursementrequests",
					new SQLException());
		}
	}
	
	@Override
	public String getRoleID(String currUsername) {
		try(Connection conn=DriverManager.getConnection(url, managerUserName, managerPassword)){
			String sql = "SELECT USER_ROLE_ID FROM ERS_USERS WHERE ERS_USERNAME=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, currUsername);
			ResultSet rs = ps.executeQuery();
			String getCurrRoleID = "";
			while(rs.next()) {
				getCurrRoleID = rs.getString(1);
			}
			return getCurrRoleID;
		}catch(SQLException e) {
			logger.error("Problem occured with selecting current roleID.",
					new SQLException());
		}
		return "";
	}
	
	@Override
	public void approveDenyReimbursement(String approveOrDeny, String adminID, String reimbID) {
		try(Connection conn=DriverManager.getConnection(url, managerUserName, managerPassword)){
			String sql = "UPDATE ERS_REIMBURSEMENT SET REIMB_RESOLVED=?, REIMB_RESOLVER=?, REIMB_STATUS_ID=? WHERE REIMB_ID=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			Date today = new Date();
			Timestamp timestamp = new Timestamp(today.getTime());
			ps.setTimestamp(1, timestamp);
			ps.setInt(2, Integer.parseInt(adminID));
			ps.setInt(3, Integer.parseInt(approveOrDeny));
			ps.setInt(4, Integer.parseInt(reimbID));
			ps.executeUpdate();
		}catch(SQLException e) {
			logger.error("Problem occured with updating reimbursement_table.",
					new SQLException());
		}
	}
}
