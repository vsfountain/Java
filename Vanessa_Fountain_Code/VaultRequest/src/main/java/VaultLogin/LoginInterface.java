package VaultLogin;

import java.util.ArrayList;

import ModelLayer.VaultUser;

public interface LoginInterface {
	//CREATE LOGIN FOR NEW DWELLER
		public void addNewDweller(VaultUser newDweller);
		
		//RETREIVE LOGIN FOR DWELLER GET USERNAME AND EMAIL
		public int checkInfo(String username, String password);
			
		//UPDATE LOGIN FOR DWELLER
		public void changeInfo(VaultUser VaultUsersID);
			
		//DELETE LOGIN FOR DWELLER
		public void deleteDwellerAccess(VaultUser dwellerRelease);

		public ArrayList<Object> retriveAll();

}
