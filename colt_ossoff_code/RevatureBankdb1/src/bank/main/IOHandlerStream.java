package bank.main;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import bank.accounts.Account;
import bank.accounts.Transaction;
import bank.people.Customer;
import bank.people.Employee;

public class IOHandlerStream {
	private static String cFile = "./cuastomers.csv";
	private static String eFile = "./employees.csv";
	private static String aFile = "./accounts.csv";
	private static String tFile = "./transactions.csv";

	public static ArrayList<Customer> loadCustomers(ArrayList<Customer> customers){
		try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(cFile))) {
			customers = (ArrayList<Customer>) in.readObject();
		}catch (Exception e) {
			writeCustomers(customers);
			e.printStackTrace();
		}
		return customers;
	}
	public static ArrayList<Employee> loadEmployees(ArrayList<Employee> employees){
		try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(eFile))) {
			employees = (ArrayList<Employee>) in.readObject();
		}catch (Exception e) {
			writeEmployees(employees);
			e.printStackTrace();
		}
		System.out.println("Loading employees"+employees);
		return employees;
	}
	public static ArrayList<Account> loadAccounts(ArrayList<Account> accounts){
		try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(aFile))) {
			accounts = (ArrayList<Account>) in.readObject();
		}catch (Exception e) {
			writeAccounts(accounts);
			e.printStackTrace();
		}
		return accounts;
	}
	public static ArrayList<Transaction> loadTransactions(ArrayList<Transaction> transactions){
		try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(tFile))) {
			transactions = (ArrayList<Transaction>) in.readObject();
		}catch (Exception e) {
			writeTransactions(transactions);
			e.printStackTrace();
		}
		return transactions;
	}
	public static void writeCustomers(ArrayList<Customer> customers) {
		try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(cFile))) {
			out.writeObject(customers);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void writeEmployees(ArrayList<Employee> employees) {
		try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(eFile))) {
			System.out.println("Write employees " +employees);
			out.writeObject(employees);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void writeAccounts(ArrayList<Account> accounts) {
		try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(aFile))) {
			out.writeObject(accounts);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void writeTransactions(ArrayList<Transaction> transactions) {
		try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(tFile))) {
			out.writeObject(transactions);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
