package com.practice.model;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.practice.dao.AccountDao;
import com.practice.dao.CustomerDAO;

public class Main {

	
	public static ApplicationContext appContext=
			new ClassPathXmlApplicationContext("applicationContext.xml");
	
	public static CustomerDAO cDao = appContext.getBean("CustomerDAO", CustomerDAO.class);
	public static AccountDao aDao = appContext.getBean("AccountDAO", AccountDao.class);
		
	public static void main(String[] args) {
	
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Please enter the following details: ");
		System.out.println("UserName: ");
		String username = scan.next();
		System.out.println("Password: ");
		String password = scan.next();
		System.out.println("First name: ");
		String firstname = scan.next();
		System.out.println("Last name: ");
		String lastname = scan.next();
		System.out.println("Email: ");
		String email = scan.next();
		System.out.print("Enter Balance: ");
		int balance = scan.nextInt();
		
		
		Customer c = new Customer(username,password,firstname,lastname,email);
		Account a  = new Account(balance, c);
		cDao.insertCustomer(c);
		aDao.registerAccount(a);
		
	}

}
