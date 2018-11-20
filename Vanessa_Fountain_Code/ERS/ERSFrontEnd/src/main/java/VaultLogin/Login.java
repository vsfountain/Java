package VaultLogin;

import ERSModelLayer.ERSUser;

public interface Login {
	//CREATE LOGIN FOR NEW DWELLER
	public void addNewDweller(ERSUser newDweller);
	
	//RETREIVE LOGIN FOR DWELLER GET USERNAME AND EMAIL
	public int checkInfo(String username, String password);
		
	//UPDATE LOGIN FOR DWELLER
	public void changeInfo(ERSUser ersUsersID);
		
	//DELETE LOGIN FOR DWELLER
	public void deleteDwellerAccess(ERSUser dwellerRelease);

}
