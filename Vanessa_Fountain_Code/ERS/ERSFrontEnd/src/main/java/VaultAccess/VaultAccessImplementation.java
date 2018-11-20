package VaultAccess;

import ERSModelLayer.ERSReimbursement;
import ERSModelLayer.ERSUser;

public class VaultAccessImplementation implements VaultAccess{
	private static String url="jdbc:oracle:thin:@revature.cakynjhhcvux.us-east-2.rds.amazonaws.com:1521:orcl";
	private static String username= "reimburse_admin";
	private static String password= "MyPassword";
	
	
	public void insertVaultDB(ERSReimbursement reqEntrance) {
		
	}
	public int retreiveReq(ERSReimbursement reimbAuthor) {
		return 0;
	}
	public int retreiveDweller(ERSUser ERSUsersID) {
		return 0;
	}
	public void updateStatus(ERSReimbursement reimbStatusID, ERSReimbursement reimbResolver,
			ERSReimbursement reimbResolved) {
		
	}
	public void deleteReq() {
		
	}
	public void deleteDweller() {
		//DONT FORGET TO COMMIT
	}
	
	

}
