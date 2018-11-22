package ServiceLayer;

import java.util.ArrayList;
import ModelLayer.RequestDisplay;
import ModelLayer.VaultReimbursement;

public interface VaultService {
	
	public int getUserInfo(String username, String password);
	
	public ArrayList<RequestDisplay> displayAllRequests();
	
	public ArrayList<RequestDisplay> displayAllUsers();
	
	public ArrayList<RequestDisplay> displayAllPending();
	
	//APPROVE OR DENY PENDING
	public VaultReimbursement approveDeny(VaultReimbursement reqID);

	void mapBuilder();
}
