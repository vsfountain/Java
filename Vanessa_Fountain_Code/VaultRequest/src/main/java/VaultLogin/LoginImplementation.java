package VaultLogin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import ModelLayer.PastDisplay;
import ModelLayer.RequestDisplay;
import ModelLayer.VaultUser;

public class LoginImplementation implements LoginInterface{
	static {
		// This is how we can make sure our tomcat knows what to do when calling DB
		// make sure you add ojdbc to WEB-INF and add to build-path
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	private static String url="jdbc:oracle:thin:@revature.cakynjhhcvux.us-east-2.rds.amazonaws.com:1521:orcl";
	private static String user= "reimburse_admin";
	private static String pass = "MyPassword";

	public void addNewDweller(VaultUser newDweller) {
		
	}
	
	public int getInfo(String username, String password) {
		//HashMap<Object, Object> map = new HashMap<>();
		int userID = 0;
		//FOR HASHMAP IMPLEMENTATION USE GET ALL SQL STATEMENT
		//SELECT * FROM ERS_USERS WHERE ERS_USERNAME = 'vsfount' and ERS_PASSWORD = 'password';
		try(
				Connection connect = DriverManager.getConnection(url, user, pass);
				){
			
			PreparedStatement ps = connect.prepareStatement("SELECT ERS_USERS_ID FROM ERS_USERS WHERE ERS_USERNAME = ? and ERS_PASSWORD = ?");
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				userID = rs.getInt("ERS_USERS_ID");
			}
					
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return userID;
	}

	public int checkInfo(String username, String password) {
		//HashMap<Object, Object> map = new HashMap<>();
		int userRole = 0;
		//FOR HASHMAP IMPLEMENTATION USE GET ALL SQL STATEMENT
		//SELECT * FROM ERS_USERS WHERE ERS_USERNAME = 'vsfount' and ERS_PASSWORD = 'password';
		try(
				Connection connect = DriverManager.getConnection(url, user, pass);
				){
			
			PreparedStatement ps = connect.prepareStatement("SELECT USER_ROLE_ID FROM ERS_USERS WHERE ERS_USERNAME = ? and ERS_PASSWORD = ?");
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				userRole = rs.getInt("USER_ROLE_ID");
			}
					
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return userRole;
	}

	public void changeInfo(VaultUser VaultUsersID) {
		
	}

	public void deleteDwellerAccess(VaultUser dwellerRelease) {
		
	}
	
	public ArrayList<VaultUser> retrieveAll(){
		ArrayList<VaultUser> all = new ArrayList<VaultUser>();
		try(
				Connection connect = DriverManager.getConnection(url, user, pass);
				){
			
			PreparedStatement ps = connect.prepareStatement("SELECT ERS_USERS_ID, ERS_USERNAME, ERS_PASSWORD, USER_FIRST_NAME, USER_LAST_NAME, USER_EMAIL, USER_ROLE_ID FROM ERS_USERS");
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {	
				 all.add(new VaultUser(rs.getInt("ERS_USERS_ID"), rs.getString("ERS_USERNAME"), rs.getString("ERS_PASSWORD"), rs.getString("USER_FIRST_NAME"), rs.getString("USER_LAST_NAME"), rs.getString("USER_EMAIL"), rs.getInt("USER_ROLE_ID")) );
			}
					
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return all;
	}

	@Override
	public ArrayList<RequestDisplay> retrieveUser() {
		ArrayList<RequestDisplay> all = new ArrayList<RequestDisplay>();
		try(
				Connection connect = DriverManager.getConnection(url, user, pass);
				){
			
			PreparedStatement ps = connect.prepareStatement("SELECT R.REIMB_ID, R.REIMB_AMOUNT, P.USER_FIRST_NAME, P.USER_LAST_NAME, S.REIMB_STATUS, T.REIMB_TYPE, V.USER_ROLE " + 
					"FROM ERS_REIMBURSEMENT R " + 
					"JOIN ERS_USERS P ON P.ERS_USERS_ID = R.REIMB_AUTHOR " + 
					"JOIN ERS_REIMBURSEMENT_TYPE T ON T.REIMB_TYPE_ID = R.REIMB_TYPE_ID " + 
					"JOIN ERS_REIMBURSEMENT_STATUS S ON S.REIMB_STATUS_ID = R.REIMB_STATUS_ID " + 
					"JOIN ERS_USER_ROLES V ON P.USER_ROLE_ID = V.ERS_USER_ROLE_ID");
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				all.add(new RequestDisplay(rs.getInt("REIMB_ID"),rs.getInt("REIMB_AMOUNT"), rs.getString("USER_FIRST_NAME"), rs.getString("USER_LAST_NAME"), rs.getString("REIMB_STATUS"), rs.getString("REIMB_TYPE"), rs.getString("USER_ROLE")));
			}
					
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return all;
	}

	@Override
	public ArrayList<RequestDisplay> retrievePending() {
		ArrayList<RequestDisplay> all = new ArrayList<RequestDisplay>();
		try(
				Connection connect = DriverManager.getConnection(url, user, pass);
				){
			
			PreparedStatement ps = connect.prepareStatement("SELECT R.REIMB_ID, R.REIMB_AMOUNT, P.USER_FIRST_NAME, P.USER_LAST_NAME, S.REIMB_STATUS, T.REIMB_TYPE, V.USER_ROLE " + 
					"FROM ERS_REIMBURSEMENT R " + 
					"JOIN ERS_USERS P ON P.ERS_USERS_ID = R.REIMB_AUTHOR " + 
					"JOIN ERS_REIMBURSEMENT_TYPE T ON T.REIMB_TYPE_ID = R.REIMB_TYPE_ID " + 
					"JOIN ERS_REIMBURSEMENT_STATUS S ON S.REIMB_STATUS_ID = R.REIMB_STATUS_ID " + 
					"JOIN ERS_USER_ROLES V ON P.USER_ROLE_ID = V.ERS_USER_ROLE_ID " + 
					"WHERE R.REIMB_STATUS_ID = 0");
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				 all.add(new RequestDisplay(rs.getInt("REIMB_ID"), rs.getInt("REIMB_AMOUNT"), rs.getString("USER_FIRST_NAME"), rs.getString("USER_LAST_NAME"), rs.getString("REIMB_STATUS"), rs.getString("REIMB_TYPE"), rs.getString("USER_ROLE")));
			}
					
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return all;
	}

	@Override
	public ArrayList<PastDisplay> retrievePast() {
		ArrayList<PastDisplay> all = new ArrayList<PastDisplay>();
		try(
				Connection connect = DriverManager.getConnection(url, user, pass);
				){
			
			PreparedStatement ps = connect.prepareStatement("SELECT R.REIMB_ID, R.REIMB_AMOUNT, R.REIMB_AUTHOR, P.USER_FIRST_NAME, P.USER_LAST_NAME, S.REIMB_STATUS, T.REIMB_TYPE, V.USER_ROLE " + 
					"FROM ERS_REIMBURSEMENT R " + 
					"JOIN ERS_USERS P ON P.ERS_USERS_ID = R.REIMB_AUTHOR " + 
					"JOIN ERS_REIMBURSEMENT_TYPE T ON T.REIMB_TYPE_ID = R.REIMB_TYPE_ID " + 
					"JOIN ERS_REIMBURSEMENT_STATUS S ON S.REIMB_STATUS_ID = R.REIMB_STATUS_ID " + 
					"JOIN ERS_USER_ROLES V ON P.USER_ROLE_ID = V.ERS_USER_ROLE_ID"
					);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				 all.add(new PastDisplay(rs.getInt("REIMB_ID"), rs.getInt("REIMB_AMOUNT"), rs.getInt("REIMB_AUTHOR"), rs.getString("USER_FIRST_NAME"), rs.getString("USER_LAST_NAME"), rs.getString("REIMB_STATUS"), rs.getString("REIMB_TYPE"), rs.getString("USER_ROLE")));
			}
					
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return all;
	}



}
