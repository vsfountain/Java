package controller.main;

import java.util.Scanner;

import controller.services.UserService;
import controller.services.UserServicesImpl;
import controller.task.AddingUser;
import controller.task.AdminMenu;
import controller.task.ClientMenu;
import model.users.CurrentUser;
import model.users.Employee;
import model.users.User;
import view.LoginView;
import view.TopMenu;

// TODO: Auto-generated Javadoc
/**
 * Contains main. Loads serialized files and saves them when program ends
 */
public class RunApp {

	/** The Constant scannner used through program. */
	public static final Scanner scan = new Scanner(System.in);

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {

		//AllUsers allUsers = AllUsers.getInstance(); // loads the users information
		// creates the current user singleton. used to track the person loged in
		CurrentUser currentUser = CurrentUser.getInstance();
		// allUsers.setUsers(new ArrayList<User>());
		// allUsers.addUser(new Employee("joshua", "email@email.com", "123"));
		// Loads singleton that contains requsts to create and account.
		//PotentialAccounts pAccounts = PotentialAccounts.getInstance();

		// System.out.println(pAccounts);

		// Closes static scanner object and saves serialized objects
/*		Runtime.getRuntime().addShutdownHook(new Thread() {
			public void run() {

				System.out.println("Main: Saving items");
				Serializer<AllUsers> serial = new Serializer<AllUsers>();
				serial.save(allUsers, AllUsers.getF());
				Serializer<PotentialAccounts> serial2 = new Serializer<PotentialAccounts>();
				serial2.save(pAccounts, PotentialAccounts.getF());
				scan.close();

			}
		});*/

		int choice = -1;
		while (choice != 3) {
			choice = TopMenu.topMenuChoice(); // Login,create account option page
			if (choice == 1) {
				User info = LoginView.login();
				UserService service = new UserServicesImpl();
				if (info != null) {
					info = service.loginUser(info.getEmail(), info.getPassword());
				}
				// System.out.println("user : " + info);
				if (info != null) {
					
					System.out.println("INFO: " + info);
					currentUser.updateUser(info);
					// load admin menu
					if (info instanceof Employee) {
						//System.out.println("Admin324");
						AdminMenu.goToAdminMenu();
					} else {
						// load client menu
						//System.out.println("Client");
						ClientMenu.goToClientMenu();
					}
				} else {
					System.out.println("Wrong email or password.");
				}

			} else if (choice == 2) {
				AddingUser.AddUser();
			}
			if (choice != 3) {
				choice = -1;
			}
		}
	}

}
