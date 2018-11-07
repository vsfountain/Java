package com.app.account;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class AccountList implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7571605448451250235L;

	private static AccountList instance;

	public static ArrayList<Account> accountList = new ArrayList<>();

	public void addAccount(Account account) {
		accountList.add(account);
		//System.out.println(accountList.toString());
		printTo();
	}

	private AccountList() {
		repopulate();
	}

	public static AccountList getInstance() {
		if (instance == null) {
			instance = new AccountList();
		}
		return instance;
	}

	@Override
	public String toString() {
		return "AccountList [accountList=" + accountList + "]";
	}
	
	public static void printTo() {
		System.out.println("READING FROM ARRAY!  " + accountList);
		String fileName = "./AccountList.txt";
		try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName))) {
			out.writeObject(accountList);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void repopulate() {
		System.out.println("WRITING TO ARRAY" + accountList);
		String fileName = "./AccountList.txt";

		try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName))) {
			accountList = (ArrayList<Account>) in.readObject();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
			System.out.println("Finally: " + accountList);
		}
	}
	
}
