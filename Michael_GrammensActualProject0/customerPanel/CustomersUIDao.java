package customerPanel;

import java.util.Scanner;

public interface CustomersUIDao {
	public void customerMain(Scanner consoleInput) throws Exception;
	public void loggedInAccount(Scanner loggedInAccount) throws Exception;
	public void createAccount(Scanner createAccount) throws Exception;
}
