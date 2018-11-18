package ServiceLayer;

import VaultLogin.LoginImplementation;
import VaultLogin.LoginInterface;

public class VaultServiceImplementation implements VaultService{
	private LoginInterface dweller = new LoginImplementation();

	@Override
	public int getUserInfo() {
		
		return dweller.checkInfo(null, null);
	}

}
