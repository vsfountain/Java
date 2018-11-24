package VaultAccess;

import java.util.ArrayList;
import ModelLayer.VaultReimbursement;
import ModelLayer.VaultUser;

public interface VaultInterface {
		//CREATE REQ TO OPEN VAULT DOOR
		public void insertVaultDB(VaultReimbursement reqEntrance);
		
		//RETREIVE VAULT DOOR REQ BEFORE OPENING VAULT DOOR
		public int retreiveReq(VaultReimbursement reimbAuthor);
		//RETRIEVE ALL REQUESTS
		public ArrayList<VaultReimbursement> retrieveAll();
		//RETREIVE CHECK REQUESTORS INFORMATION
		public int retreiveDweller(VaultUser ERSUsersID);
		
		//UPDATE GRANT ACCESS TO OPEN VAULT DOOR OR DENY UPDATE REOLVED, UPDATE RESOLVER
		public void updateStatus(int reimbID, boolean approve);
		
		//DELETE MAKE SURE RESOLVED THEN DELETE
		public void deleteReq();

}
