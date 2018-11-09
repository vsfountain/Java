package com.simulate.Kavanagh.bank.service;

import java.util.List;
import java.util.Scanner;
import com.simulate.Kavanagh.bank.dao.CustomerDao;
import com.simulate.Kavanagh.bank.dao.CustomerDaoImpl;
import com.simulate.Kavanagh.bank.model.Customer;

/**
 * @author Kristen Kavanagh
 * @version 11/6/2018
 *
 */
public class CustomerServiceImpl implements CustomerService {
		private CustomerDao client = new CustomerDaoImpl();

@Override
public List<Customer> getAllCustomer() {
	return client.selectAllCustomer();
}

 public static Customer webRegister() {
Scanner scanner = new Scanner(System.in);
	System.out.println("Welcome to Kavanagh's Bank. How may I help you?");
	
	boolean doesNotWantToLogOut = true;
	
	while(doesNotWantToLogOut) {
String response = scanner.next();

if (response.equals("Register")) {
	System.out.println("Create your username");
	String username= scanner.next();	
CustomerService CustomerService = new CustomerServiceImpl();

	List<Customer>customerList = CustomerService.selectAllCustomer();
System.out.println("dlkfjsdlkf");
System.out.println(customerList);

boolean loop = false;
while (loop) {	
boolean usernamehasbeenfound = true;

for (Customer client : customerList){
	if(username.equals(client.getuserName())){
		usernamehasbeenfound = true;
		//String input= scanner.next();
	System.out.println("username is already taken, try creating another one");
	}	


System.out.println("What password would you like to use?");
String password = scanner.next();
System.out.println("Enter you lastname");
String lastname = scanner.next();
System.out.println("Enter you Firstname");
String fiRstname = scanner.next();
System.out.println("Enter your monthly Income");
String income = scanner.next();
System.out.println("Enter your creditScore");
String creditscore = scanner.next();
System.out.println("Enter your address");
String address = scanner.next();
System.out.println("Enter your city");
String City = scanner.next();
System.out.println("Enter your state");
String State = scanner.next();
System.out.println("Enter your zipcode");
String postalcode = scanner.next();
System.out.println("Enter you phoneNumber");
String telephonenumber = scanner.next();
System.out.println("Enter your Email");
String customeremail = scanner.next();
System.out.println("welcome we are processing your login information");
}}}
else if (response.equals("Login")) {
System.out.println("Please enter your username");
String userName = scanner.next();

CustomerService CustomerService = new CustomerServiceImpl();
Customer newCustomer = CustomerService.getcustomerByusername(userName);
//System.out.println(newCustomer.getuserName());// enter welcome message
System.out.println("Enter your Password");
String password = scanner.next();
System.out.println(password);
if (password.equals(newCustomer.getpassWord())) {
	System.out.println("Welcome you have sucessfully login");
	return newCustomer;
} else {
	System.out.println("Invalid password");
}


}}	return null;}
	//Scanner scanner = new Scanner(System.in);
//for (Customer newCustomer : customerList) {
//if (newCustomer.getuserName().equals(username)) {
//System.out.println("That username is already taken. Please choose another");
//boolean loop = true;
//while (loop) {
//System.out.println("Please enter a new username");
//String response = username.next();
//for (Customer newCustomer : CustomerService) {
//if (newCustomer.getuserName().equals(username)) {
//System.out.println("That username is already taken. Please choose another");
//break;
//	}
//	}
//	}
//}
//return newCustomer.selectAllCustomer();
//}

//Customer newCustomer = new Customer(firstname, lastname, Double.parseDouble(income),
//Integer.parseInt(creditScore), address, city, state, Integer.parseInt(postalCode),Integer.parseInt(telePhoneNumber), customerEmail));
//createCustomer(newCustomer);
//return customerList;
//}

//public void loginInformation() {
//	//boolean loop = false;
//	//while (loop) {
//	String input= scanner.next();				
////CustomerService CustomerService = new CustomerServiceImpl();
////List<Customer> customerList = CustomerService.getAllCustomer(username);
////boolean usernamehasbeenfound = false;
//for (Customer client : userName){
//		if(input.equals(client.getuserName())){
//		usernamehasbeenfound = true;
//System.out.println("username is already taken, try creating another one");
//}
//	}
//if (usernamehasbeenfound){
//	
//}else {
//loop = false;
//
//}
//}
//}
//
////System.out.println("What would you like to do?");
////String response = scanner.next();
////if (response.equals("Register")) {
////
////System.out.println("Create your username");
////boolean loop = true;
////while (loop) {
////	String username = scanner.next();				
////	CustomerService CustomerService = new CustomerServiceImpl();
////	List<Customer> customerList = CustomerService.getAllCustomer(username);
////	boolean usernamehasbeenfound = false;
////	for (Customer newCustomer : customerList) {
////		if(username.equals(newCustomer.getuserName())){
////				usernamehasbeenfound = true;
////			System.out.println("username is already taken, try creating another one");
////	}
////	}
////if (usernamehasbeenfound){
////	
////	}else {
////	loop = false;
////	
////	}
////}
////System.out.println("Create your password");
////String username = scanner.next();
////
////
////} else if (response.equals("Login")) {
////System.out.println("Please enter your username");
////String userName = scanner.next();
//////System.out.println(userName);
////CustomerService CustomerService = new CustomerServiceImpl();
////Customer newCustomer = CustomerService.getcustomerByusername(userName);
////System.out.println(newCustomer.getuserName());
////System.out.println("Enter your Password");
////String password = scanner.next();
//////System.out.println(password);
////if (password.equals(newCustomer.getpassWord())) {
////}
//////
//for (Customer newCustomer : customerList) {
//if (newcustomer.getuserName().equals(username)) {
//System.out.println("That username is already taken. Please choose another");
//boolean loop = true;
//while (loop) {
//System.out.println("Please enter a new username");
//String response = username.next();
//for (Customer newCustomer : CustomerService) {
//if (newcustomer.getuserName().equals(username)) {
//System.out.println("That username is already taken. Please choose another");
//break;
//	}
//	}
//	}
//}
//return newCustomer.selectAllCustomer();
//}
//System.out.println("What password would you like to use?");
//String password = scanner.nextLine();

//System.out.println("Enter you firstname");
//String firstname = scanner.nextLine();
//////System.out.println("Enter you lastname");
//////String lastname = scanner.nextLine();
//////System.out.println("Enter your monthly Income");
//////String income = scanner.nextLine();
//////System.out.println("Enter your creditScore");
//////String creditScore = scanner.nextLine();
//////System.out.println("Enter your address");
//////String address = scanner.nextLine();
//////System.out.println("Enter your city");
//////String city = scanner.nextLine();
//////System.out.println("Enter your state");
//////String state = scanner.nextLine();
//////System.out.println("Enter your postalCode");
//////String postalCode = scanner.nextLine();
//////System.out.println("Enter you telePhoneNumber");
//////String telePhoneNumber = scanner.nextLine();
//////System.out.println("Enter your customerEmail");
//////String customerEmail = scanner.nextLine();
////
//
//////String response = scanner.next();
//////if (response.equals("Register")) {
//////
//////System.out.println("Create your username");
//////boolean loop = true;
//////while (loop) {
//////	String username = scanner.next();				
//////	CustomerService CustomerService = new CustomerServiceImpl();
//////	List<Customer> customerList = CustomerService.getAllCustomer(username);
//////	boolean usernamehasbeenfound = false;
//////	for (Customer client : customerList) {
//////			if(username.equals(client.getuserName())){
//////				usernamehasbeenfound = true;
//////			System.out.println("username is already taken, try creating another one");
//////		}
//////	}
//////	if (usernamehasbeenfound){
//////	
//////	}else {
//////		loop = false;
//////	
//////	}
//////}
////System.out.println("Create your password");
////String username = scanner.next();
////
////
////} else if (response.equals("Login")) {
////System.out.println("Please enter your username");
////String userName = scanner.next();
////System.out.println(userName);
////CustomerService CustomerService = new CustomerServiceImpl();
////Customer newCustomer = CustomerService.getcustomerByusername(userName);
////System.out.println(newCustomer.getuserName());
////System.out.println("Enter your Password");
////String password = scanner.next();
////System.out.println(password);
////if (password.equals(newCustomer.getpassWord())) {
////}
////System.out.println("Enter your Password");
////
////String passWord = scanner.next();
////if (password.equals(newCustomer.getpassWord())) {
////	System.out.println("Welcome you have sucessfully login");
////
////	System.out.println("What would you like to do?");
////	String input = scanner.next();
////	//System.out.println(input + "kthy");
////	if (input.equals("Applyforanaccount")) {
////		// create an account
////		AccountService accountService = new AccountServiceImpl();
////		accountService.CreateAccount(newCustomer);
////////			
////
////////		
////////		Scanner scanner = new Scanner(System.in);
////////		
////////		List<Customer> customerList = client.selectAllCustomer();
////////		System.out.println("Welcome to Kavanagh's Bank. How may I help you?");
////////
////////		String response = scanner.next();
////////		if (response.equals("Register")) {
////////
////////			System.out.println("Create your username");
////////			boolean loop = true;
////////			while (loop) {
////////				String username = scanner.next();				
////////				CustomerService CustomerService = new CustomerServiceImpl();
////////				List<Customer> customerList = CustomerService.getAllCustomer(username);
////////				boolean usernamehasbeenfound = false;
////////				for (Customer client : customerList) {
////////						if(username.equals(client.getuserName())){
////////							usernamehasbeenfound = true;
////////						System.out.println("username is already taken, try creating another one");
////////					}
////////				}
////////				if (usernamehasbeenfound){
////////				
////////				}else {
////////					loop = false;
////////				
////////				}
////////			}
////////			System.out.println("Create your password");
////////			String userName = scanner.next();
//////
////////			
////////		} else if (response.equals("Login")) {
////////			System.out.println("Please enter your username");
////////			String userName = scanner.next();
////////			System.out.println(userName);
////////			CustomerService CustomerService = new CustomerServiceImpl();
////////			Customer newCustomer = CustomerService.getcustomerByusername(userName);
////////			System.out.println(newCustomer.getuserName());
////////			System.out.println("Enter your Password");
////////			String password = scanner.next();
////////			System.out.println(password);
////////			if (password.equals(newCustomer.getpassWord())) {
////////			}
//////
////////		for (Customer customer : customerList) {
////////			if (customer.getuserName().equals(username)) {
////////				System.out.println("That username is already taken. Please choose another");
////////				boolean loop = true;
////////				while (loop) {
////////					System.out.println("Please enter a new username");
////////					String response = scanner.next();
////////					for (Customer client : customerList) {
////////						if (customer.getuserName().equals(username)) {
////////							System.out.println("That username is already taken. Please choose another");
////////							break;
////////						}
////////					}
////////				}
////////			}
////////			return client.selectAllCustomer();
////////		}
//////		System.out.println("What password would you like to use?");
//////		String passWord = scanner.nextLine();
//////		System.out.println("Enter you firstname");
//////		String firstname = scanner.nextLine();
//////		System.out.println("Enter you lastname");
//////		String lastname = scanner.nextLine();
//////		System.out.println("Enter your monthly Income");
//////		String income = scanner.nextLine();
//////		System.out.println("Enter your creditScore");
//////		String creditScore = scanner.nextLine();
//////		System.out.println("Enter your address");
//////		String address = scanner.nextLine();
//////		System.out.println("Enter your city");
//////		String city = scanner.nextLine();
//////		System.out.println("Enter your state");
//////		String state = scanner.nextLine();
//////		System.out.println("Enter your postalCode");
//////		String postalCode = scanner.nextLine();
//////		System.out.println("Enter you telePhoneNumber");
//////		String telePhoneNumber = scanner.nextLine();
//////		System.out.println("Enter your customerEmail");
//////		String customerEmail = scanner.nextLine();
//////
//////		Customer client = new Customer(firstname, lastname, Double.parseDouble(income),
//////				Integer.parseInt(creditScore), address, city, state, Integer.parseInt(postalCode),
//////				Integer.parseInt(telePhoneNumber), customerEmail);
//////		createCustomer(client);
//////		return customerList;
//////	}
//////		@Override
//////		public List<Customer> getAllCustomer(String username) {
//////			// TODO Auto-generated method stub
//////			return null;
//////		}
//////		@Override
//////		public int createCustomer(Customer client) {
//////			// TODO Auto-generated method stub
//////			return 0;
//////		}
//////		@Override
//////		public Customer getcustomerByusername(String username) {
//////			// TODO Auto-generated method stub
//////			return null;
//////		}
//////
//
////////		
//////	
//////
////////	@Override
////////	public int createCustomer(Customer c) {
////////		client.insertCustomer(c);
////////		return 0;
////////	}
////////
////////	@Override
////////	public Customer getcustomerByusername(String username) {
////////		return client.selectByusername(username);
////////
////////	}
////////}
//////private void createUsername() {
//
//try {
//        if (username != null) {
//        sql = "Select * from Customer_table Where username='" + user + "'";
//        rs = Statement.executeQuery(sql);
//
//        rs.next();
//        username = rs.getString("username");
//        password = rs.getString("password");
//
//    }
//} 
//catch (SQLException err) {
//    JOptionPane.showMessageDialog(this, err.getMessage());
//}
//@Override
//public int createCustomer(Customer client) {
//	// TODO Auto-generated method stub
//	return 0;
//}
//////

@Override
public int createCustomer(Customer client) {
	// TODO Auto-generated method stub
	return 0;
}
@Override
public List<Customer> getAllCustomer(String username) {
	// TODO Auto-generated method stub
	return null;
}


@Override
public List<Customer> selectAllCustomer() {
	// TODO Auto-generated method stub
	return client.selectAllCustomer();
}


@Override
public Customer getcustomerByusername(String userName) {
	// TODO Auto-generated method stub
	return client.selectByusername(userName);
}

@Override
public Customer getCustomerByuserName(String userName) {
	// TODO Auto-generated method stub
	return null;
}}