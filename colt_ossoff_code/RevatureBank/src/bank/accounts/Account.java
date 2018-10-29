package bank.accounts;

import java.io.Serializable;
import java.util.ArrayList;

import bank.people.Customer;

public class Account implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5399600845218046118L;
	private double balance;
	private int id;
	private ArrayList<Integer> owners;
	private boolean approved;
	private boolean cancelled;
	//private String type;
	private ArrayList<Integer> transactions;
	public Account(double balance, int id, ArrayList<Integer> owners) {
		super();
		this.balance = balance;
		this.id = id;
		this.owners = owners;
	}
	public Account(double balance, int id, ArrayList<Integer> owners,boolean approved,boolean cancelled, ArrayList<Integer> tran) {
		super();
		this.balance = balance;
		this.id = id;
		this.owners = owners;
		this.approved = approved;
		this.cancelled = cancelled;
		this.transactions = tran;
	}
	public boolean cancel() {
		cancelled = true;
		return true;
	}
	public boolean isCancelled() {
		return cancelled;
	}
	public boolean withdraw(double amount, int transId) {
		if (balance > Math.abs(amount) && approved == true) {
			balance -= Math.abs(amount);
			transactions.add(transId);
			return true;
		}
		return false;
	}
	public boolean deposit(double amount, int TransId) {
		if(approved == true) {
			balance += Math.abs(amount);
			transactions.add(TransId);
			return true;
		}
		return false;
	}
	public double getBalance() {
		return balance;
	}
	public int getId() {
		return id;
	}
	public boolean isApproved() {
		return approved;
	}
	public void approve(boolean approved) {
		this.approved = approved;
	}
	public ArrayList<Integer> getOwners() {
		return owners;
	}
	public String view(ArrayList<Account> a) {
		return "Account: " + id + "\nBalance: " + balance + "\nApproved: " + approved + "\nTransaction History: \n";
	}
	public String view(ArrayList<Customer> c, ArrayList<Transaction> t, ArrayList<Account> a) {
		String customer = "";
		String transList = "";
		for(int o: owners)
			for(Customer cu: c)
				if(cu.getId() == o)
					customer += cu.view(a);
		for(int o: transactions)
			for(Transaction tr: t)
				if(tr.getId() == o)
					transList += tr.view();
		return "Account: " + id + "\nBalance: " + balance + "\nOwned by: \n" + customer + "\nApproved: " + approved
				+ "\nTransaction History: \n" + transList + "\n";
	}
}
