package VaultAccess;
//CRUD
import ERSModelLayer.ERSUser;
import ERSModelLayer.ERSReimbursement;

public interface VaultAccess {
	//CREATE REQ TO OPEN VAULT DOOR
	public void insertVaultDB(ERSReimbursement reqEntrance);
	
	//RETREIVE VAULT DOOR REQ BEFORE OPENING VAULT DOOR
	public int retreiveReq(ERSReimbursement reimbAuthor);
	//RETREIVE CHECK REQUESTORS INFORMATION
	public int retreiveDweller(ERSUser ERSUsersID);
	
	//UPDATE GRANT ACCESS TO OPEN VAULT DOOR OR DENY UPDATE REOLVED, UPDATE RESOLVER
	public void updateStatus(ERSReimbursement reimbStatusID, 
			ERSReimbursement reimbResolver, ERSReimbursement reimbResolved);
	
	//DELETE MAKE SURE RESOLVED THEN DELETE
	public void deleteReq();
	
}
