package bank.people;

import java.io.Serializable;
import java.util.ArrayList;

import bank.accounts.Account;
import bank.accounts.Transaction;

public class Employee implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6896924596785286419L;
	private boolean admin;
	private String name;
	private int id;
	private String username;
	private String password;
	public Employee(boolean admin, String name, int id, String username, String password) {
		super();
		this.admin = admin;
		this.name = name;
		this.id = id;
		this.username = username;
		this.password = password;
	}
	public static boolean approval(int accId, String appDec, ArrayList<Account> accounts) {
		for(Account a: accounts) {
			if (a.getId() == accId && appDec.equals("approved")) {
				a.approve(true);
				return true;
			} else if(a.getId() == accId && appDec.equals("declined")) {
				a.approve(false);
				return false;
			}
		}
		return false;
	}
	public static String viewAccountInfo(int id, ArrayList<Account> accounts, ArrayList<Customer> cust, ArrayList<Transaction> tran) {
		for(Account a: accounts)
			if (a.getId() == id)
				return a.view(cust, tran, accounts);
		return "Account does not exist.";
	}
	public static String viewAccountBalance(int id, ArrayList<Account> accounts) {
		for(Account a: accounts)
			if (a.getId() == id && a.isApproved() && !a.isCancelled())
				return "The balance of account: " + a.getId() + " is $" + String.format("%.2f",a.getBalance());
		return "Account does not exist.";
	}
	public static String viewCustInfo(int id, ArrayList<Customer> cust, ArrayList<Account> accounts) {
		for(Customer c: cust)
			if (c.getId() == id)
				return c.view(accounts);
		return "Customer not on file.";
	}
	public boolean cancelAcc(int accId, ArrayList<Account> accounts) {
		if(admin)
			for(Account a: accounts)
				if (a.getId() == id)
					return a.cancel();
		return false;
	}
	public Transaction withdraw(int id, double amount, ArrayList<Account> accounts) {
		int lastId = accounts.get(accounts.size()-1).getId();
		lastId++;
		Transaction trans = new Transaction(lastId,amount,new int[] {id},"withdrawal",this.id);
		if(admin)
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
		if(admin)
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
		if(admin)
			for(Account a: accounts)
				if (a.getId() == id)
					if(a.withdraw(amount, lastId))
						for(Account d: accounts)
							if (d.getId() == id)
								if(d.deposit(amount, lastId))
									return trans;
		return null;
	}
	public static String viewAllAcc(int custId, ArrayList<Customer> cust, ArrayList<Account> accounts, ArrayList<Transaction> tran) {
		String list = "\n";
		for(Customer c: cust)
			if(custId == c.getId()) {
				ArrayList<Integer> accs = c.getAccounts();
				for(int a: accs)
					for(Account ac: accounts)
						if(a == ac.getId())
							list += ac.view(cust, tran, accounts);
			}
		return list;
	}
	public boolean login(String username, String password) {
		if (username.equals(this.username) && password.equals(this.password))
			return true;
		return false;
	}

	public String getName() {
		return name;
	}
	@Override
	public String toString() {
		return "Employee [admin=" + admin + ", name=" + name + ", id=" + id + ", username=" + username + ", password="
				+ password + "]";
	}
	
}
