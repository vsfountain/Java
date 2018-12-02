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
//System.out.println("dlkfjsdlkf");
//System.out.println(customerList);

//boolean loop = true;
//while (loop) {	
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

Customer clientCreate = new Customer(fiRstname, lastname, Double.parseDouble(income),
	Integer.parseInt(creditscore), address, City, State, Integer.parseInt(postalcode),
	Integer.parseInt(telephonenumber), customeremail,username,password );
CustomerService.createCustomer(clientCreate);




}}//}
else if (response.equals("Login")) {
System.out.println("Please enter your username");
String userName = scanner.next();

CustomerService CustomerService = new CustomerServiceImpl();
Customer newCustomer = CustomerService.getcustomerByusername(userName);
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


@Override
public int createCustomer(Customer c) {
	// TODO Auto-generated method stub
	
	
	return client.insertCustomer(c);
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