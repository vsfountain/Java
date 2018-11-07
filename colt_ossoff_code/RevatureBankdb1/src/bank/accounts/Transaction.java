package bank.accounts;

import java.io.Serializable;
import java.util.ArrayList;

import bank.DAO.RelateTransAcc;
import bank.DAO.TransactionDAO;

public class Transaction implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3420792938817369599L;
	private double amount;
	private ArrayList<Integer> accounts;
	private String type;
	private int operator;
	private int id;
	public Transaction(int id, double amount, ArrayList<Integer> accounts, String type, int operator) {
		super(); 
		this.id = id;
		this.amount = amount;
		this.accounts = accounts;
		this.type = type;
		this.operator = operator;
	}
	public Transaction(double amount, ArrayList<Integer> accounts, String type, int operator) {
		super();
		this.amount = amount;
		this.accounts = accounts;
		this.type = type;
		this.operator = operator;
		this.id = TransactionDAO.insert(operator, type, amount);
		for(int a: accounts)
			RelateTransAcc.insert(this.id, a);
	}
	public String view() {
		String accs = "";
		if (accounts.size() == 2) accs = accounts.get(0) + ", " + accounts.get(1);
		else accs = Integer.toString(accounts.get(0));
		return "ID: " + id + "\nAccounts: " + accs + "\n" + type + " of $" + amount + "\nBy: " + operator + "\n";
	}
	public int getId() {
		return id;
	}
}
