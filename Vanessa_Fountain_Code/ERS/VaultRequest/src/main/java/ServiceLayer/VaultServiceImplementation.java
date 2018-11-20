package ServiceLayer;

import java.util.ArrayList;

import VaultAccess.VaultAccessImplementaion;
import VaultAccess.VaultInterface;
import VaultLogin.LoginImplementation;
import VaultLogin.LoginInterface;

public class VaultServiceImplementation implements VaultService{
	private LoginInterface dweller = new LoginImplementation();
	private VaultInterface request = new VaultAccessImplementaion();

	@Override
	public int getUserInfo(String username, String password) {
		return dweller.checkInfo(username, password);
	}


	@Override
	public ArrayList<Object> displayAllRequests() {
		return request.retrieveAll();
	}

}
