package VaultMain;

import VaultLogin.LoginImplementation;

public class Main {

	public static void main(String[] args) {
		LoginImplementation login = new LoginImplementation();
		
		String username = "vsfount";
		String password = "password";
		
		System.out.println(login.checkInfo(username, password));

	}

}
