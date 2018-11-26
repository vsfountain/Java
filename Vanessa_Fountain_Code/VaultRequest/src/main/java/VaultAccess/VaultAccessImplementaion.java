package VaultAccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import ModelLayer.VaultReimbursement;
import ModelLayer.VaultUser;

public class VaultAccessImplementaion implements VaultInterface{
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
	private static String pass= "MyPassword";

	public void insertVaultDB(VaultReimbursement reqEntrance) {
		//String str = "INSERT INTO ERS_REIMBURSEMENT (reimb_amount, reimb_submitted, reimb_author, reimb_status_id, reimb_type_id) VALUES (?, ?, ?, ?)";
		//INSERT INTO ERS_REIMBURSEMENT (reimb_amount, reimb_submitted, reimb_author, reimb_status_id, reimb_type_id) VALUES (98, systimestamp, 9, 0, 2);

		try(Connection connect = DriverManager.getConnection(url, user, pass);){

			PreparedStatement ps = connect.prepareStatement("INSERT INTO ERS_REIMBURSEMENT "
					+ "(reimb_amount, reimb_submitted, reimb_author, reimb_status_id, reimb_type_id, reimb_description) "
					+ "VALUES (?, ?, ?, ?, ?, ?)"
					);
			ps.setDouble(1, reqEntrance.getReimbAmount());
			Timestamp tmp = new Timestamp(System.currentTimeMillis());
			ps.setTimestamp(2, tmp);
			ps.setInt(3, reqEntrance.getReimbAuthor());
			ps.setInt(4, reqEntrance.getReimbStatusID());
			ps.setInt(5, reqEntrance.getReimbTypeID());
			ps.setString(6, reqEntrance.getReimbDescription());

			ps.executeQuery();
					
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}

	public int retreiveReq(VaultReimbursement reimbAuthor) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int retreiveDweller(VaultUser ERSUsersID) {
		// TODO Auto-generated method stub
		return 0;
	}

	public void updateStatus(int reimbID, boolean approve) {
		try(
				Connection connect = DriverManager.getConnection(url, user, pass);
				){
			
			PreparedStatement ps = connect.prepareStatement("UPDATE ERS_REIMBURSEMENT " + 
					"SET REIMB_STATUS_ID = ? " + 
					"WHERE REIMB_ID = ? "
					);
			ps.setInt(2, reimbID);
			if (approve) {
				//IN DATABASE APPROVE == 1
				ps.setInt(1,  1);
			} else {
				//IN DATABASE DENY == 2
				ps.setInt(1, 2);
			}
				ps.executeQuery();
					
		}catch(SQLException e) {
			e.printStackTrace();
		}		
		
	}

	public void deleteReq() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<VaultReimbursement> retrieveAll() {
		//HashMap<Object, Object> map = new HashMap<>();
		ArrayList<VaultReimbursement> all = new ArrayList<VaultReimbursement>();
		try(
				Connection connect = DriverManager.getConnection(url, user, pass);
				){
			
			PreparedStatement ps = connect.prepareStatement("SELECT REIMB_ID, REIMB_AMOUNT, REIMB_SUBMITTED, REIMB_RESOLVED, REIMB_DESCRIPTION, REIMB_RECEIPT, REIMB_AUTHOR, REIMB_RESOLVER, REIMB_STATUS_ID, REIMB_TYPE_ID FROM ERS_REIMBURSEMENT");
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				 all.add(new VaultReimbursement(rs.getInt("REIMB_ID"), rs.getInt("REIMB_AMOUNT"), rs.getDate("REIMB_SUBMITTED"), rs.getDate("REIMB_RESOLVED"), rs.getString("REIMB_DESCRIPTION"), 
						 rs.getBlob("REIMB_RECEIPT"), rs.getInt("REIMB_AUTHOR"), rs.getInt("REIMB_RESOLVER"), rs.getInt("REIMB_STATUS_ID"), rs.getInt("REIMB_TYPE_ID")) );
			}
					
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return all;
	}

	@Override
	public Map<Integer, Integer> masterKey() {
		//SELECT REIMB_ID, REIMB_AUTHOR FROM ERS_REIMBURSEMENT;
		Map<Integer, Integer> all = new HashMap<Integer, Integer>();
		try(
				Connection connect = DriverManager.getConnection(url, user, pass);
				){
			
			PreparedStatement ps = connect.prepareStatement("SELECT REIMB_ID, REIMB_AUTHOR FROM ERS_REIMBURSEMENT");
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				all.put(rs.getInt("REIMB_ID"), rs.getInt("REIMB_AUTHOR"));
			}
					
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return all;
		
	}
	

}
