package view;

import java.util.Scanner;

import controller.main.RunApp;
import model.users.AllUsers;
import model.users.User;


// TODO: Auto-generated Javadoc
/**
 * The Class LoginView. 
 */
public class LoginView {

 /**
  * Login. This handles log in logic.
  *
  * @return User the information of the User that has loged in
  */
 public static User login() {
	 AllUsers users = AllUsers.getInstance();
	 Scanner scan = RunApp.scan;
	 String email = "";
	 String password = "";
	 
	 System.out.println("\n\nplease enter your email.");
	 email = scan.next();
	 System.out.println("Please enter your password.");
	 password = scan.next();
	 User u = new User("", email, password);
	 User logInAs = users.loginCorrect(u);
	 return logInAs;
	 
 }
}
