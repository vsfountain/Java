package ServiceLayer;

import java.util.ArrayList;
import java.util.HashMap;

import ModelLayer.RequestDisplay;

public interface VaultService {
	
	public int getUserId(String username, String password);
	
	public int getUserInfo(String username, String password);
	
	public HashMap<String, Integer> displayAllRequests();
	
	public ArrayList<RequestDisplay> displayAllUsers();
	
	public HashMap<String, Integer> displayAllPending();
	
	//APPROVE OR DENY PENDING
	public void denyReimb(int reimbID);

	void mapBuilder();

	public void approveReimb(int reimbID);

	public void insertReq(double amount, int type, String message, Integer loggedId);

	public HashMap<Integer, String> viewMyReq(Integer loggedId);

}
