package VaultMain;

import ServiceLayer.VaultService;
import ServiceLayer.VaultServiceImplementation;

public class Main {

	public static void main(String[] args) {
		VaultService dweller = new VaultServiceImplementation();
		
		String username = "vsfount";
		String password = "password";
		
		System.out.println(dweller.getUserInfo(username,password));

	}

}
