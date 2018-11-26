package ServiceLayer;

import java.util.ArrayList;
import java.util.HashMap;
import ModelLayer.PastDisplay;
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
	
	private HashMap<Integer,String> reqUser = new HashMap<Integer,String>();
	
	private int loggedIn;
	private int inSess;

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
	public void denyReimb(int reimbID) {
		//ReimbImple(reqID, false);
		request.updateStatus(reimbID, false);
		
	}


	@Override
	public void approveReimb(int reimbID) {
		//ReimbImple(reqID, true);
		request.updateStatus(reimbID, true);

	}


	@Override
	public int getUserId(String username, String password) {
		inSess = dweller.getInfo(username, password);
		return inSess;
	}


	@Override
	public void insertReq(double amount, int type, String message, Integer loggedId) {
		
		VaultReimbursement reqEntrance = new VaultReimbursement(amount, message, loggedId, 0,
				type);
		System.out.println(reqEntrance);
		request.insertVaultDB(reqEntrance);
		
	}


	@Override
	public HashMap<Integer,String> viewMyReq(Integer loggedId) {
		
		ArrayList<PastDisplay> pastReq = dweller.retrievePast();
		
		for(PastDisplay req : pastReq) {
			System.out.println(req.getAuthor()+" "+req.getId() + " "+ pastReq);
			if (req.getAuthor() == loggedId) {
				reqUser.put(req.getId(), req.getStatus()+": "+req.getRole()+" "+req.getFirst()+" "+req.getLast()+" Amount: "+req.getAmount());
			}
		}
		
		return reqUser;
		
	}

}
