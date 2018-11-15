import java.io.Serializable;
import java.util.Date;

//Author: Sean Doyle
//Date Created: 2018/10/24

//This class stores information about the transaction

public final class Transaction implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6839031742338121880L;
	private double amount;
	private int clientNum = -1;
	private int holder1;
	private int holder2 = -1;
	private String transType;
	private Date date;
	
	//This class is designed to be immutable
	Transaction(double amount, int clientNum, String transType) {
	//This constructor is designed for regular Transactions
		this.transType = transType;
		this.amount = amount;
		this.clientNum = clientNum;
		this.date = new Date();
	}
	
	Transaction(double amount, int clientNum, boolean notJoint) {
		//Used only once to denote that the account is held jointly
		this.transType = "Solo Held Account Creation";
		this.amount = amount;
		this.holder1 = clientNum;
		this.holder2 = -1;
		this.date = new Date();
	}
	Transaction(double amount, int clientNum, int jointNum) {
		//Used only once to denote that the account is held jointly
		this.transType = "Joint Held Account Creation";
		this.amount = amount;
		this.holder1 = clientNum;
		this.holder2 = jointNum;
		this.date = new Date();
	}

	@Override
	public String toString() {
		return "Transaction [amount=" + amount + ", clientNum=" + clientNum + ", holder1=" + holder1 + ", holder2="
				+ holder2 + ", transType=" + transType + ", date=" + date + "]";
	}
	

}
