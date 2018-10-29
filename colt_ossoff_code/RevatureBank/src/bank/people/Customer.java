package bank.people;

import java.io.Serializable;
import java.util.ArrayList;

import bank.accounts.Account;
import bank.accounts.Transaction;

public class Customer implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4393069640381764085L;
	private String name;
	private int id;
	private String userName;
	private String password;
	private ArrayList<Integer> accounts;

	public String view(ArrayList<Account> accs) {
		String list = "";
		for(int i: accounts)
			for(Account a: accs)
				if(i == a.getId())
					list += a.view(accs);
		return "Customer Name: " + name + "\nCustomer ID: " + id + "\nUsername: " + userName + "\nPassword: " + password + "\nAccounts:\n" + list;
	}

	public int getId() {
		return id;
	}

	public ArrayList<Integer> getAccounts() {
		return accounts;
	}

	public boolean login(String username, String password) {
		if (username.equals(userName) && password.equals(this.password))
			return true;
		return false;
	}

	public Customer(String name, int id, String userName, String password) {
		super();
		this.name = name;
		this.id = id;
		this.userName = userName;
		this.password = password;
	}

	public Customer(String name, int id, String userName, String password, ArrayList<Integer> accs) {
		super();
		this.name = name;
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.accounts = accs;
	}
	public String viewAccountInfo(ArrayList<Account> accounts, ArrayList<Customer> cust, ArrayList<Transaction> tran) {
		String list = "\n";
		for (int a : this.accounts)
			for (Account ac : accounts)
				if (ac.getId() == a)
					list += ac.view(cust, tran, accounts);
		return (list.length() > 1) ? list : "Account does not exist.";
	}

	public static String viewAccountBalance(int id, ArrayList<Account> accounts) {
		for (Account a : accounts)
			if (a.getId() == id && a.isApproved() && !a.isCancelled())
				return "The balance of account: " + a.getId() + " is $" + String.format("%.2f", a.getBalance());
		return "Account does not exist.";
	}
	public Transaction withdraw(int id, double amount, ArrayList<Account> accounts) {
		int lastId = accounts.get(accounts.size()-1).getId();
		lastId++;
		Transaction trans = new Transaction(lastId,amount,new int[] {id},"withdrawal",this.id);
			for(Account a: accounts)
				if (a.getId() == id)
					if(a.withdraw(amount, lastId))
						return trans;
		return null;
	}
	public Transaction deposit(int id, double amount, ArrayList<Account> accounts) {
		int lastId = accounts.get(accounts.size()-1).getId();
		lastId++;
		Transaction trans = new Transaction(lastId,amount,new int[] {id},"deposit",this.id);
			for(Account a: accounts)
				if (a.getId() == id)
					if(a.deposit(amount, lastId))
						return trans;
		return null;
	}
	public Transaction transfer(int fromAcc, int toAcc, double amount, ArrayList<Account> accounts) {
		int lastId = accounts.get(accounts.size()-1).getId();
		lastId++;
		Transaction trans = new Transaction(lastId,amount,new int[] {fromAcc,toAcc},"transfer",this.id);
			for(Account a: accounts)
				if (a.getId() == id)
					if(a.withdraw(amount, lastId))
						for(Account d: accounts)
							if (d.getId() == id)
								if(d.deposit(amount, lastId))
									return trans;
		return null;
	}
	public void addAccount(int accId) {
		accounts.add(accId);
	}
}
