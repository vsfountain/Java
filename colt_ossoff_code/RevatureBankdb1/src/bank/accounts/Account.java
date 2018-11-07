package bank.accounts;

import java.io.Serializable;
import java.util.ArrayList;

import bank.DAO.AccountDAO;


public class Account implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5399600845218046118L;
	private double balance;
	private int id;
	private ArrayList<Integer> owners = new ArrayList<Integer>();
	private boolean approved;
	private boolean cancelled;
	private ArrayList<Integer> transactions = new ArrayList<Integer>();

	public Account(double balance, ArrayList<Integer> owners) {
		super();
		this.balance = balance;
		this.approved = true;
		this.cancelled = false;
		this.owners = owners;
		String ap = (approved)? "t" : "f";
		String cn = (cancelled)? "t" : "f";
		AccountDAO.insert(balance, ap, cn);
		this.id = AccountDAO.getId();
	}

	public Account(double balance, int id, ArrayList<Integer> owners) {
		super();
		this.balance = balance;
		this.id = id;
		this.owners = owners;
	}

	public Account(double balance, int id, ArrayList<Integer> owners, boolean approved, boolean cancelled,
			ArrayList<Integer> tran) {
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
		AccountDAO.update(this.balance, this.approved, this.cancelled, id);
		return true;
	}

	public boolean isCancelled() {
		return cancelled;
	}

	public boolean withdraw(double amount, int transId) {
		if (balance > Math.abs(amount) && approved == true && cancelled == false) {
			balance -= Math.abs(amount);
			transactions.add(transId);
			return true;
		}
		return false;
	}

	public boolean deposit(double amount, int TransId) {
		if (approved == true && cancelled == false) {
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
		AccountDAO.update(this.balance, this.approved, this.cancelled, id);
	}

	public ArrayList<Integer> getOwners() {
		return owners;
	}

	/*public String view(ArrayList<Customer> c, ArrayList<Transaction> t, ArrayList<Account> a) {
		String customer = "";
		String transList = "";
		
		for (int o : owners)
			for (Customer cu : c)
				if (cu.getId() == o)
					customer += cu.toString();
		if (transactions.size() > 0)
			for (int o : transactions)
				for (Transaction tr : t)
					if (tr.getId() == o)
						transList += tr.view();
		return "Account: " + id + "\nBalance: " + balance + "\nOwned by: \n" + customer + "\nApproved: " + approved
				+ "\nTransaction History: \n" + transList + "\n";
	}*/

	@Override
	public String toString() {
		return "Account [balance=" + balance + ", id=" + id + ", owners=" + owners + ", approved=" + approved
				+ ", cancelled=" + cancelled + ", transactions=" + transactions + "]";
	}
}
