package com.bank.main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;

import com.bank.accounts.Account;
import com.bank.users.User;

public class DataFileIO {

	public static Map<String, User> readUserState() {
		String userFile = "src\\Users.txt";
		//String accountFile = "src\\Accounts.txt";
		Map<String, User> allUsers = new HashMap<>();
		//Map<String, Account> allAccounts = new HashMap<>();
		
		//read all data from files
		//users file
		try(ObjectInputStream objInpStr = new ObjectInputStream(new FileInputStream(userFile))) {
			allUsers = (Map<String, User>) objInpStr.readObject();
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		return allUsers;
	}
	
	public static Map<String, Account> readAccountState() {
		//String userFile = "src\\Users.txt";
		String accountFile = "src\\Accounts.txt";
		//Map<String, User> allUsers = new HashMap<>();
		Map<String, Account> allAccounts = new HashMap<>();
		
		//read all data from files
		//users file
		try(ObjectInputStream objInpStr = new ObjectInputStream(new FileInputStream(accountFile))) {
			allAccounts = (Map<String, Account>) objInpStr.readObject();
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		return allAccounts;
	}
	
/*	public static void readState(Map<String, User> allUsers, Map<String, Account> allAccounts) {
		String userFile = "src\\Users.txt";
		String accountFile = "src\\Accounts.txt";
		
		//read all data from files
		//users file
		try(ObjectInputStream objInpStr = new ObjectInputStream(new FileInputStream(userFile))) {
			allUsers = (Map<String, User>) objInpStr.readObject();
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		//accounts file
		try(ObjectInputStream objInpStr = new ObjectInputStream(new FileInputStream(accountFile))) {
			allAccounts = (Map<String, Account>) objInpStr.readObject();
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}*/
	
	public static void writeState(Map<String, User> allUsers, Map<String, Account> allAccounts) {
		String userFile = "src\\Users.txt";
		String accountFile = "src\\Accounts.txt";
		
		//save all data to files before exit
		//users file
		try(ObjectOutputStream objOutStr =new ObjectOutputStream(new FileOutputStream(userFile))) {
			objOutStr.writeObject(allUsers);

		}catch(IOException e) {
			e.printStackTrace();
		}
		//accounts file
		try(ObjectOutputStream objOutStr =new ObjectOutputStream(new FileOutputStream(accountFile))) {
			objOutStr.writeObject(allAccounts);

		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}
