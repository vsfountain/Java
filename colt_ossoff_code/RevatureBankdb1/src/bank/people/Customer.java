package bank.people;

import java.io.Serializable;
import java.util.ArrayList;

import bank.DAO.AccountDAO;
import bank.DAO.CustomerDAO;
import bank.DAO.RelateAccCust;
import bank.DAO.RelateTransAcc;
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
	private ArrayList<Integer> accounts = new ArrayList<Integer>();

	/*public String view(ArrayList<Account> accs) {
		String list = "";
		for(int i: accounts)
			for(Account a: accs)
				if(i == a.getId())
					list += a.view(accs);
		return "Customer Name: " + name + "\nCustomer ID: " + id + "\nUsername: " + userName + "\nPassword: " + password + "\nAccounts:\n" + list;
	}*/

	public int getId() {
		return id;
	}

	public ArrayList<Integer> getAccounts() {
		return accounts;
	}

	public static Customer login(String username, String password) {
		Customer c = CustomerDAO.selectLogin(username.toLowerCase(), password.toLowerCase());
		ArrayList<Integer> a = RelateAccCust.selectByCust(c.getId());
		for(int i: a)
			c.addAccount(i);
		if(c != null) return c;
		return null;
	}

	@Override
	public String toString() {
		return "Customer [name=" + name + ", id=" + id + ", userName=" + userName + ", password=" + password
				+ ", accounts=" + accounts + "]";
	}

	public Customer(String name, int id, String userName, String password) {
		super();
		this.name = name.toLowerCase();
		this.id = id;
		this.userName = userName.toLowerCase();
		this.password = password.toLowerCase();
	}

	public Customer(String name, String userName, String password) {
		super();
		this.name = name.toLowerCase();
		this.userName = userName.toLowerCase();
		this.password = password.toLowerCase();
		CustomerDAO.insert(name.toLowerCase(), userName.toLowerCase(), password.toLowerCase());
		this.id = CustomerDAO.getCustId();
	}

	public Customer(String name, int id, String userName, String password, ArrayList<Integer> accs) {
		super();
		this.name = name.toLowerCase();
		this.id = id;
		this.userName = userName.toLowerCase();
		this.password = password.toLowerCase();
		this.accounts = accs;
	}
	public String getName() {
		return name;
	}

	public String viewAccountInfo() {
		String list = "\n";
		for (int a : this.accounts)
			list += AccountDAO.selectById(a).toString() + "\n\n";
		return (list.length() > 1) ? list : "Account does not exist.";
	}

	public String viewAccountBalance(int id) {
		Account a = AccountDAO.selectById(id);
			if (a.getId() == id && a.isApproved() && !a.isCancelled())
				return "The balance of account: " + a.getId() + " is $" + String.format("%.2f", a.getBalance()) + "\n\n";
		return "Account is cancelled or does not exist.";
	}
	public boolean withdraw(int id, double amount) {
		Account acc = AccountDAO.selectById(id);
		if(acc.isApproved() && !(acc.isCancelled())) {
			ArrayList<Integer> a = new ArrayList<Integer>();
			a.add(id);
			Transaction trans = new Transaction(amount,a,"withdrawal",this.id);
			RelateTransAcc.insert(trans.getId(), id);
			AccountDAO.withdraw(id, amount);
			return true;
		}
		return false;
	}
	public boolean deposit(int id, double amount) {
		Account acc = AccountDAO.selectById(id);
		if(acc.isApproved() && !(acc.isCancelled())) {
			ArrayList<Integer> r = new ArrayList<Integer>();
			r.add(id);
			Transaction trans = new Transaction(amount,r,"deposit",this.id);
			RelateTransAcc.insert(trans.getId(), id);
			Account a = AccountDAO.selectById(id);
			AccountDAO.update((Math.abs(amount) + a.getBalance()), a.isApproved(), a.isCancelled(), id);
			return true;
		}
		return false;
	}

	public boolean transfer(int fromAcc, int toAcc, double amount) {
		Account acc = AccountDAO.selectById(fromAcc);
		Account acc2 = AccountDAO.selectById(toAcc);
		if(
				(acc.isApproved() && !(acc.isCancelled())) && 
				(acc2.isApproved() && !(acc2.isCancelled()))
		  ) {
			ArrayList<Integer> r = new ArrayList<Integer>();
			r.add(fromAcc);
			r.add(toAcc);
			Transaction trans = new Transaction(amount,r, "transfer", this.id);
			RelateTransAcc.insert(trans.getId(), id);
			AccountDAO.withdraw(fromAcc, Math.abs(amount));
			Account a = AccountDAO.selectById(id);
			AccountDAO.update((Math.abs(amount) + a.getBalance()), a.isApproved(), a.isCancelled(), id);
			return true;
		}
		return false;
	}

	public Customer() {
		super();
	}

	public void addAccount(int accId) {
		accounts.add(accId);
		RelateAccCust.insert(accId, id);
	}
}
