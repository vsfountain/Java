package VaultAccess;

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
	private static String username= "reimburse_admin";
	private static String password= "MyPassword";

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

	public void updateStatus(VaultReimbursement reimbStatusID, VaultReimbursement reimbResolver,
			VaultReimbursement reimbResolved) {
		// TODO Auto-generated method stub
		
	}

	public void deleteReq() {
		// TODO Auto-generated method stub
		
	}

}
