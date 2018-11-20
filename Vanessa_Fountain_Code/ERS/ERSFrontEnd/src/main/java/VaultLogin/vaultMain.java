package VaultLogin;

public class vaultMain extends LoginImplementation{

	public static void main(String[] args) {
		
		Login login = new LoginImplementation();
		
		String username = "vsfount";
		String password = "password";
		
		login.checkInfo(username, password);

	}

}
