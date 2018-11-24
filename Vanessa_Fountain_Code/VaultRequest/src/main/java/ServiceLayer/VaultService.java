package ServiceLayer;

import java.util.ArrayList;
import java.util.HashMap;

import ModelLayer.RequestDisplay;
import ModelLayer.VaultReimbursement;

public interface VaultService {
	
	public int getUserInfo(String username, String password);
	
	public HashMap<String, Integer> displayAllRequests();
	
	public ArrayList<RequestDisplay> displayAllUsers();
	
	public HashMap<String, Integer> displayAllPending();
	
	//APPROVE OR DENY PENDING
	public void denyReimb(int reimbID);

	void mapBuilder();

	public void approveReimb(int reimbID);
}
