package VaultAccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
		// TODO Auto-generated method stub
		
	}

	public int retreiveReq(VaultReimbursement reimbAuthor) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int retreiveDweller(VaultUser ERSUsersID) {
		// TODO Auto-generated method stub
		return 0;
	}

	public void updateStatus(int reimbID) {
		try(
				Connection connect = DriverManager.getConnection(url, user, pass);
				){
			
			PreparedStatement ps = connect.prepareStatement("UPDATE ERS_REIMBURSEMENT " + 
					"SET REIMB_STATUS_ID = 1 " + 
					"WHERE REIMB_ID = ?; " + 
					" COMMIT;");
			ps.setInt(1, reimbID);
			
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

}
