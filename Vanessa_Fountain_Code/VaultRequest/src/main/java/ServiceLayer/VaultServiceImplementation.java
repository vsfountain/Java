package ServiceLayer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import ModelLayer.RequestDisplay;
import ModelLayer.VaultReimbursement;
import ModelLayer.VaultUser;
import VaultAccess.VaultAccessImplementaion;
import VaultAccess.VaultInterface;
import VaultLogin.LoginImplementation;
import VaultLogin.LoginInterface;

public class VaultServiceImplementation implements VaultService{
	private LoginInterface dweller = new LoginImplementation();
	private VaultInterface request = new VaultAccessImplementaion();
	
	private HashMap<VaultUser,Integer> idUser = new HashMap<VaultUser, Integer>();
	private HashMap<VaultReimbursement,Integer> idReqPending = new HashMap<VaultReimbursement, Integer>();
	
	private HashMap<String, Integer> display = new HashMap<String, Integer>();
	private HashMap<String, Integer> displayAll = new HashMap<String, Integer>();
	
	private int loggedIn;

	@Override
	public int getUserInfo(String username, String password) {
		loggedIn = dweller.checkInfo(username, password);
		return loggedIn;
	}


	@Override
	public HashMap<String, Integer> displayAllRequests() {
		ArrayList<RequestDisplay> all = dweller.retrieveUser();
		for(RequestDisplay req : all) {
			displayAll.put(req.getStatus()+": "+req.getRole()+" "+req.getFirst()+" "+req.getLast()+" Amount: "+req.getAmount(), req.getId());
		}
		return displayAll;
	}


	@Override
	public ArrayList<RequestDisplay> displayAllUsers() {
		return dweller.retrieveUser();
	}


	@Override
	public HashMap<String, Integer> displayAllPending() {
		ArrayList<RequestDisplay> pending = dweller.retrievePending();
		for(RequestDisplay req : pending) {
			display.put(req.getStatus()+": "+req.getRole()+" "+req.getFirst()+" "+req.getLast()+" Amount: "+req.getAmount(), req.getId());
		}
			
		return display;
		
	}


	@Override
	public void mapBuilder() {
		//ON CLICK DWELLER ON CLICK APPROVE(Y) DWELLER REQ CHANGED TO APPROVE
		ArrayList<VaultUser> users = dweller.retrieveAll();
		ArrayList<VaultReimbursement> pending = request.retrieveAll();

		//BUILD ID USER HASHMAP WHERE KEY = USER, VAL = USER ID
		for(VaultUser user : users) {
			idUser.put(user, user.getUserID());
		}
		//BUILD PENDING REQUEST HASHMAP WHERE KEY = REQUEST, VAL = REQ ID
		for(VaultReimbursement req : pending) {
			idReqPending.put(req, req.getReimbId());
		}
	}


	@Override
	public VaultReimbursement approveDeny(VaultReimbursement reqID) {
		return reqID;
		
	}

}
