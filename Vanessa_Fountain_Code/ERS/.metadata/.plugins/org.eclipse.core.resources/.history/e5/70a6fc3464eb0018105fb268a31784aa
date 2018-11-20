package ServiceLayer;

import VaultLogin.LoginImplementation;
import VaultLogin.LoginInterface;

public class VaultServiceImplementation implements VaultService{
	private LoginInterface dweller = new LoginImplementation();


	@Override
	public int getUserInfo(String username, String password) {
		// TODO Auto-generated method stub
		return dweller.checkInfo(username, password);
	}

}
