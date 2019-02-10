package com.bankofdikoko.service;

import java.util.Scanner;

import javax.persistence.NoResultException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bankofdikoko.dao.AccountDao;
import com.bankofdikoko.dao.UserDao;
import com.bankofdikoko.model.Account;
import com.bankofdikoko.model.User;

/*To run my project, please register first and then log in to attempt the functionality that users have to view, edit accounts
 * As of right now my project only remembers the information of the obj that is created when registering a user and forgets
 * that object once another user is registered or once the program is closed.
 * */

public class Main {

	public static ApplicationContext appContext = new ClassPathXmlApplicationContext("applicationContext.xml");
	
	
	public static AccountDao accountDao = appContext.getBean("accountDao", AccountDao.class); 
	
	public static Account account= appContext.getBean("account", Account.class);
	
	
	public static UserService userService = appContext.getBean("", UserService.class);
	public static User user = appContext.getBean("users", User.class);
	
	public static UserDao userDao;

	// public static UserDao userDao = appContext
	// .getBean("AccountDao", AccountDao.class);
	public static void main(String[] args) {
		System.out.println("Select an Option: ");
		System.out.println("[1] Register \n [2]Log in");
		Scanner s = new Scanner(System.in);
		int choice = s.nextInt();
		if (choice == 1) {
			register();
			s.close();
		}
		if (choice == 2) {
			login();
			s.close();
		}

	}

	public static void login() {
		Scanner login = new Scanner(System.in);
		System.out.println("Enter your credentials:");
		System.out.println("Username: ");
		String username = login.next();
		System.out.println("Password: ");
		String password = login.next();
		try {

			User loggedUser = userService.getUser(username);
			System.out.println(loggedUser.getUserName());
			if(loggedUser.getUserName().equals(username) && loggedUser.getPassword().equals(password)) {
				System.out.println(loggedUser);
			}
			login.close();

		} catch (NullPointerException e) {
			System.out.println("Username and Password Combination is incorrect.");

		}
	}

	public static void register() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Loading...");
		user = gatherUserInfo();
		System.out.print("How much would you like to deposit : ");
		int amount = scan.nextInt();
		if (amount > 500) {
			try {
				User thisuser = userDao.findByName(user);
				System.out.println("Sorry this username already exists");
			} catch (NoResultException e) {}finally {
				System.out.println("Will this be a private [p] or a joint account [j] ? : " );
				String type = scan.next();
				if(type.toLowerCase().equals("j")) {
					User secondUser = gatherUserInfo();
					
					account = new Account(amount, user, secondUser);
					userDao.insertUser(user);
					userDao.insertUser(secondUser);
					accountDao.insertAccount(account);
				}
				if(type.toLowerCase().equals("p")) {
					Account one = new Account(amount, user,null);
					userDao.insertUser(user);
					accountDao.insertAccount(one);
					System.out.print("Welcome to your account " + user.getFirstName() + "\n your current balance is: " + amount);
					
				}
/*				System.out.println("Creating account....");
				userDao.insertUser(user);
				System.out.println("Account has been successfully created!");
				System.out.println();
*/
			}
		}

	}

	public static User gatherUserInfo() {
		Scanner scan = new Scanner(System.in);

		System.out.println("Enter Username : ");
		String username = scan.next();
		System.out.println("Enter Password : ");
		String password = scan.next();
		System.out.println("Enter email : ");
		String email = scan.next();
		System.out.println("Enter first name : ");
		String firstName = scan.next();
		System.out.println("Enter last name : ");
		String lastName = scan.next();
		user = new User(username, password, email, firstName, lastName);
		return user;
	}
}
