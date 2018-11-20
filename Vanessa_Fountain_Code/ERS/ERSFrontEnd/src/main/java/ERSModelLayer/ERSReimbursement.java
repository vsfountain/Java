 package ERSModelLayer;

import oracle.sql.BLOB;
import oracle.sql.DATE;

@SuppressWarnings("deprecation")
public class ERSReimbursement extends ERSUser{

	public ERSReimbursement(int userID, String userName, String first, String last, String email, int userRoleID) {
		super(userID, userName, first, last, email, userRoleID);
		// TODO Auto-generated constructor stub
	}
	private int reimbId;
	private int reimbAmount;
	private DATE reimbSubmitted;
	private DATE reimbResolved;
	private String reimbDescription;
	private BLOB reimbReceipt;
	private int reimbAuthor;
	private int reimbResolver;
	private int reimbStatusID;
	private int reimbTypeID;
	public ERSReimbursement(int userID, String userName, String first, String last, String email, int userRoleID,
			int reimbId, int reimbAmount, DATE reimbSubmitted, DATE reimbResolved, String reimbDescription,
			BLOB reimbReceipt, int reimbAuthor, int reimbResolver, int reimbStatusID, int reimbTypeID) {
		super(userID, userName, first, last, email, userRoleID);
		this.reimbId = reimbId;
		this.reimbAmount = reimbAmount;
		this.reimbSubmitted = reimbSubmitted;
		this.reimbResolved = reimbResolved;
		this.reimbDescription = reimbDescription;
		this.reimbReceipt = reimbReceipt;
		this.reimbAuthor = reimbAuthor;
		this.reimbResolver = reimbResolver;
		this.reimbStatusID = reimbStatusID;
		this.reimbTypeID = reimbTypeID;
	}
	public int getReimbId() {
		return reimbId;
	}
	public void setReimbId(int reimbId) {
		this.reimbId = reimbId;
	}
	public int getReimbAmount() {
		return reimbAmount;
	}
	public void setReimbAmount(int reimbAmount) {
		this.reimbAmount = reimbAmount;
	}
	public DATE getReimbSubmitted() {
		return reimbSubmitted;
	}
	public void setReimbSubmitted(DATE reimbSubmitted) {
		this.reimbSubmitted = reimbSubmitted;
	}
	public DATE getReimbResolved() {
		return reimbResolved;
	}
	public void setReimbResolved(DATE reimbResolved) {
		this.reimbResolved = reimbResolved;
	}
	public String getReimbDescription() {
		return reimbDescription;
	}
	public void setReimbDescription(String reimbDescription) {
		this.reimbDescription = reimbDescription;
	}
	public BLOB getReimbReceipt() {
		return reimbReceipt;
	}
	public void setReimbReceipt(BLOB reimbReceipt) {
		this.reimbReceipt = reimbReceipt;
	}
	public int getReimbAuthor() {
		return reimbAuthor;
	}
	public void setReimbAuthor(int reimbAuthor) {
		this.reimbAuthor = reimbAuthor;
	}
	public int getReimbResolver() {
		return reimbResolver;
	}
	public void setReimbResolver(int reimbResolver) {
		this.reimbResolver = reimbResolver;
	}
	public int getReimbStatusID() {
		return reimbStatusID;
	}
	public void setReimbStatusID(int reimbStatusID) {
		this.reimbStatusID = reimbStatusID;
	}
	public int getReimbTypeID() {
		return reimbTypeID;
	}
	public void setReimbTypeID(int reimbTypeID) {
		this.reimbTypeID = reimbTypeID;
	}
	@Override
	public String toString() {
		return "ERSReimbursement [reimbId=" + reimbId + ", reimbAmount=" + reimbAmount + ", reimbSubmitted="
				+ reimbSubmitted + ", reimbResolved=" + reimbResolved + ", reimbDescription=" + reimbDescription
				+ ", reimbReceipt=" + reimbReceipt + ", reimbAuthor=" + reimbAuthor + ", reimbResolver=" + reimbResolver
				+ ", reimbStatusID=" + reimbStatusID + ", reimbTypeID=" + reimbTypeID + "]";
	}

}
