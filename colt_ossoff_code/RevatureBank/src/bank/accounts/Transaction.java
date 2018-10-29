package bank.accounts;

import java.io.Serializable;

public class Transaction implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3420792938817369599L;
	private double amount;
	private int[] accounts;
	private String type;
	private int operator;
	private int id;
	public Transaction(int id, double amount, int[] accounts, String type, int operator) {
		super();
		this.setId(id);
		this.amount = amount;
		this.accounts = accounts;
		this.type = type;
		this.operator = operator;
	}
	private void setId(int id2) {}
	public String view() {
		String accs = "";
		if (accounts.length == 2) accs = accounts[0] + ", " + accounts[1];
		else accs = Integer.toString(accounts[0]);
		return "ID: " + id + "\nAccounts: " + accs + "\n" + type + " of $" + amount + "\nBy: " + operator + "\n";
	}
	public int getId() {
		return id;
	}
}
