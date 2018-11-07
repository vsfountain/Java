package bank.main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import bank.accounts.Account;
import bank.accounts.Transaction;
import bank.people.Customer;
import bank.people.Employee;

public class IOHandler {
	private File cFile = new File("cuastomers.csv");
	private File eFile = new File("employees.csv");
	private File aFile = new File("accounts.csv");
	private File tFile = new File("transactions.csv");
	private Scanner customerFile;
	private Scanner employeeFile;
	private Scanner accountFile;
	private Scanner transactionFile;
	public ArrayList<Customer> loadCustomers(){
		ArrayList<Customer> customer = new ArrayList<Customer>();
		try {
			customerFile = new Scanner(cFile);
			while(customerFile.hasNext()) {
				String[] line = customerFile.nextLine().split(",");
				ArrayList<Integer> accounts = new ArrayList<Integer>();
				for(String i: line[4].split("|"))
						accounts.add(Integer.parseInt(i));
				Customer c = new Customer(line[0],Integer.parseInt(line[1]),line[2],line[3],accounts);
				customer.add(c);
			}
			customerFile.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return customer;
	}
	public ArrayList<Employee> loadEmployeess(){
		ArrayList<Employee> employee = new ArrayList<Employee>();
		try {
			employeeFile = new Scanner(eFile);
			while(employeeFile.hasNext()) {
				String[] line = employeeFile.nextLine().split(",");
				Employee e = new Employee(Boolean.parseBoolean(line[0]),line[1],Integer.parseInt(line[2]),line[3],line[4]);
				employee.add(e);
			}
			customerFile.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return employee;
	}
	public ArrayList<Account> loadAccounts(){
		ArrayList<Account> account = new ArrayList<Account>();
		try {
			accountFile = new Scanner(aFile);
			while(accountFile.hasNext()) {
				String[] line = accountFile.nextLine().split(",");
				ArrayList<Integer> owners = new ArrayList<Integer>();
				for(String i: line[2].split("|"))
						owners.add(Integer.parseInt(i));
				ArrayList<Integer> tran = new ArrayList<Integer>();
				for(String i: line[5].split("|"))
					tran.add(Integer.parseInt(i));
				Account a = new Account(Double.parseDouble(line[0]),Integer.parseInt(line[1]),owners,Boolean.parseBoolean(line[3]),Boolean.parseBoolean(line[4]),tran);
				account.add(a);
			}
			customerFile.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return account;
	}
	public ArrayList<Transaction> loadTransactions(){
		ArrayList<Transaction> transaction = new ArrayList<Transaction>();
		try {
			transactionFile = new Scanner(tFile);
			while(transactionFile.hasNext()) {
				String[] line = transactionFile.nextLine().split(",");
				int[] accounts = new int[2];
				String[] ac = line[2].split("|");
				if(ac.length == 2) {
					accounts[0] = Integer.parseInt(ac[0]);
					accounts[1] = Integer.parseInt(ac[1]);
				} else {
					accounts[0] = Integer.parseInt(ac[0]);
				}
				Transaction t = new Transaction(Integer.parseInt(line[1]),Double.parseDouble(line[0]),accounts,line[3],Integer.parseInt(line[4]));
				transaction.add(t);
			}
			customerFile.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return transaction;
	}
}
