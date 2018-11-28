package VaultLogin;

import java.util.ArrayList;
import ModelLayer.PastDisplay;
import ModelLayer.RequestDisplay;
import ModelLayer.VaultUser;

public interface LoginInterface {
	//CREATE LOGIN FOR NEW DWELLER
		public void addNewDweller(VaultUser newDweller);
		
		//RETRIEVE LOGIN FOR DWELLER GET USERNAME AND EMAIL
		public int checkInfo(String username, String password);
		
		//RETRIEVE USERID
		public int getInfo(String username, String password);
			
		//UPDATE LOGIN FOR DWELLER
		public void changeInfo(VaultUser VaultUsersID);
			
		//DELETE LOGIN FOR DWELLER
		public void deleteDwellerAccess(VaultUser dwellerRelease);
		
		//RETRIEVE PENDING AND DISPLAY
		public ArrayList<RequestDisplay> retrievePending();
		
		//RETRIEVE PAST REQUEST DISPLAY
		public ArrayList<PastDisplay> retrievePast();
		
		//RETRIEVE ALL USERS
		public ArrayList<VaultUser> retrieveAll();
		
		//RETRIEVE ALL PENDING REQUESTS
		public ArrayList<RequestDisplay> retrieveUser();
		
		

		

}
