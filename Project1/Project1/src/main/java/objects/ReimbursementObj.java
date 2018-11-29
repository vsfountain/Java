package objects;

import java.awt.Image;
import java.sql.Blob;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class ReimbursementObj {
	private int reimbID;
	private double reimbAmount;
	private Timestamp reimbSubmitted;
	private Timestamp reimbResolved;
	private String reimbDescription;
	private Blob reimbReceipt;
	private String reimbAuthor;
	private String reimbResolver;
	private String reimbStatusID;
	private String reimbTypeID;
	
	public ReimbursementObj() {
		super();
	}
	
	public ReimbursementObj(int reimbID, double reimbAmount, Timestamp reimbSubmitted, Timestamp reimbResolved,
			String reimbDescription, Blob reimbReceipt, String reimbAuthor, String reimbResolver, String reimbStatusID, String reimbTypeID){
		this.reimbID = reimbID;
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

	public int getReimbID() {
		return reimbID;
	}

	public void setReimbID(int reimbID) {
		this.reimbID = reimbID;
	}

	public double getReimbAmount() {
		return reimbAmount;
	}

	public void setReimbAmount(double reimbAmount) {
		this.reimbAmount = reimbAmount;
	}

	public String getReimbSubmitted() {
		return "" + reimbSubmitted;
	}

	public void setReimbSubmitted(Timestamp reimbSubmitted) {
		this.reimbSubmitted = reimbSubmitted;
	}

	public String getReimbResolved() {
		return "" + reimbResolved;
	}

	public void setReimbResolved(Timestamp reimbResolved) {
		this.reimbResolved = reimbResolved;
	}

	public String getReimbDescription() {
		return reimbDescription;
	}

	public void setReimbDescription(String reimbDescription) {
		this.reimbDescription = reimbDescription;
	}

	public Blob getReimbReceipt() {
		return reimbReceipt;
	}

	public void setReimbReceipt(Blob reimbReceipt) {
		this.reimbReceipt = reimbReceipt;
	}

	public String getReimbAuthor() {
		return reimbAuthor;
	}

	public void setReimbAuthor(String reimbAuthor) {
		this.reimbAuthor = reimbAuthor;
	}

	public String getReimbResolver() {
		return reimbResolver;
	}

	public void setReimbResolver(String reimbResolver) {
		this.reimbResolver = reimbResolver;
	}

	public String getReimbStatusID() {
		return reimbStatusID;
	}

	public void setReimbStatusID(String reimbStatusID) {
		this.reimbStatusID = reimbStatusID;
	}

	public String getReimbTypeID() {
		return reimbTypeID;
	}

	public void setReimbTypeID(String reimbTypeID) {
		this.reimbTypeID = reimbTypeID;
	}

	@Override
	public String toString() {
		return "ReimbursementObj [reimbID=" + reimbID + ", reimbAmount=" + reimbAmount + ", reimbSubmitted="
				+ reimbSubmitted + ", reimbResolved=" + reimbResolved + ", reimbDescription=" + reimbDescription
				+ ", reimbReceipt=" + reimbReceipt + ", reimbAuthor=" + reimbAuthor + ", reimbResolver=" + reimbResolver
				+ ", reimbStatusID=" + reimbStatusID + ", reimbTypeID=" + reimbTypeID + "]";
	}
	
}
