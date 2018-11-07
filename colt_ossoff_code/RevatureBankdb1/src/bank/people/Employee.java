package bank.people;

import java.io.Serializable;
import java.util.ArrayList;

import bank.DAO.AccountDAO;
import bank.DAO.CustomerDAO;
import bank.DAO.EmployeeDAO;
import bank.DAO.RelateAccCust;
import bank.DAO.RelateTransAcc;
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
		this.name = name.toLowerCase();
		this.id = id;
		this.username = username.toLowerCase();
		this.password = password.toLowerCase();
	}

	public Employee() {
		super();
	}

	public boolean approval(int accId, String appDec) {
		Account a = AccountDAO.selectById(accId);
		if (a.getId() == accId && appDec.equals("approved")) {
			a.approve(true);
			return true;
		} else if (a.getId() == accId && appDec.equals("declined")) {
			a.approve(false);
			return false;
		}
		return false;
	}

	public String viewAccountInfo(int id) {
		Account a = AccountDAO.selectById(id);
		if(a != null ) return a.toString();
		return "Account does not exist.";
	}

	public String viewAccountBalance(int id) {
		Account a = AccountDAO.selectById(id);
		if (a.getId() == id && a.isApproved() && !a.isCancelled())
			return "The balance of account: " + a.getId() + " is $" + String.format("%.2f", a.getBalance());
		return "Account does not exist.";
	}
	public String viewCustInfo(int id) {
		Customer c = CustomerDAO.selectById(id);
		ArrayList<Integer> a = RelateAccCust.selectByCust(id);
		for(int i: a)
			c.addAccount(i);
		if(c != null) return c.toString();
		return "Customer not on file.";
	}
	public boolean cancelAcc(int accId) {
		if(admin) {
			Account a = AccountDAO.selectById(accId);
			AccountDAO.update(a.getBalance(), a.isApproved(), true, accId);
			return true;
		}
		return false;
	}

	public boolean withdraw(int id, double amount) {
		ArrayList<Integer> a = new ArrayList<Integer>();
		a.add(id);
		Transaction trans = new Transaction(amount, a, "withdrawal", this.id);
		RelateTransAcc.insert(trans.getId(), id);
		if (admin) {
			Account acc = AccountDAO.selectById(id);
			if (acc.isApproved() && !(acc.isCancelled())) {
				AccountDAO.withdraw(id, amount);
				return true;
			}
		}
		return false;
	}

	public boolean deposit(int id, double amount) {
		ArrayList<Integer> r = new ArrayList<Integer>();
		r.add(id);
		Transaction trans = new Transaction(amount, r, "deposit", this.id);
		RelateTransAcc.insert(trans.getId(), id);
		if (admin) {
			Account a = AccountDAO.selectById(id);
			if (a.isApproved() && !(a.isCancelled())) {
				AccountDAO.update((Math.abs(amount) + a.getBalance()), a.isApproved(), a.isCancelled(), id);
				return true;
			}
		}
		return false;
	}

	public boolean transfer(int fromAcc, int toAcc, double amount) {
		ArrayList<Integer> r = new ArrayList<Integer>();
		r.add(fromAcc);
		r.add(toAcc);
		Transaction trans = new Transaction(amount, r, "transfer", this.id);
		RelateTransAcc.insert(trans.getId(), id);
		if (admin) {
			Account acc = AccountDAO.selectById(fromAcc);
			Account acc2 = AccountDAO.selectById(toAcc);
			if ((acc.isApproved() && !(acc.isCancelled())) && (acc2.isApproved() && !(acc2.isCancelled()))) {
				AccountDAO.withdraw(fromAcc, Math.abs(amount));
				Account a = AccountDAO.selectById(id);
				AccountDAO.update((Math.abs(amount) + a.getBalance()), a.isApproved(), a.isCancelled(), id);
				return true;
			}
		}
		return false;
	}

	public Employee(boolean admin, String name, String username, String password) {
		super();
		this.admin = admin;
		this.name = name.toLowerCase();
		this.username = username.toLowerCase();
		this.password = password.toLowerCase();
		String an = (admin)? "t": "f";
		EmployeeDAO.insert(name.toLowerCase(), username.toLowerCase(), password.toLowerCase(), an);
		this.id = EmployeeDAO.getId();
	}

	/*public static String viewAllAcc(int custId, ArrayList<Customer> cust, ArrayList<Account> accounts, ArrayList<Transaction> tran) {
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
	}*/
	public static Employee login(String username, String password) {
		Employee e = EmployeeDAO.selectLogin(username.toLowerCase(), password.toLowerCase());
		if(e != null ) return e;
		return null;
	}

	public boolean isAdmin() {
		return admin;
	}
	public int getId() {
		return id;
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
