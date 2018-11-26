package com.example.model;

import java.util.Date;

public class ErsReimbFeModel {

	int reimbursementId;
	double reimbursementAmount;
	Date reimbursementSubmittedDate;
	Date reimbursementResolvedDate;
	String reimbursementDescription;
	String reimbursementReceipt;
	ErsUser ersReimbursementUser;
	String reimbursementStatus;
	String reimbursementType;
	ErsUser reimbursementResolver;
	
	
	
	
	
	public ErsReimbFeModel(int reimbursementId, double reimbursementAmount, Date reimbursementSubmittedDate,
			Date reimbursementResolvedDate, String reimbursementDescription, String reimbursementReceipt,
			ErsUser ersReimbursementUser, String reimbursementStatus, String reimbursementType,
			ErsUser reimbursementResolver) {
		super();
		this.reimbursementId = reimbursementId;
		this.reimbursementAmount = reimbursementAmount;
		this.reimbursementSubmittedDate = reimbursementSubmittedDate;
		this.reimbursementResolvedDate = reimbursementResolvedDate;
		this.reimbursementDescription = reimbursementDescription;
		this.reimbursementReceipt = reimbursementReceipt;
		this.ersReimbursementUser = ersReimbursementUser;
		this.reimbursementStatus = reimbursementStatus;
		this.reimbursementType = reimbursementType;
		this.reimbursementResolver = reimbursementResolver;
	}
	public int getReimbursementId() {
		return reimbursementId;
	}
	public void setReimbursementId(int reimbursementId) {
		this.reimbursementId = reimbursementId;
	}
	public double getReimbursementAmount() {
		return reimbursementAmount;
	}
	public void setReimbursementAmount(double reimbursementAmount) {
		this.reimbursementAmount = reimbursementAmount;
	}
	public Date getReimbursementSubmittedDate() {
		return reimbursementSubmittedDate;
	}
	public void setReimbursementSubmittedDate(Date reimbursementSubmittedDate) {
		this.reimbursementSubmittedDate = reimbursementSubmittedDate;
	}
	public Date getReimbursementResolvedDate() {
		return reimbursementResolvedDate;
	}
	public void setReimbursementResolvedDate(Date reimbursementResolvedDate) {
		this.reimbursementResolvedDate = reimbursementResolvedDate;
	}
	public String getReimbursementDescription() {
		return reimbursementDescription;
	}
	public void setReimbursementDescription(String reimbursementDescription) {
		this.reimbursementDescription = reimbursementDescription;
	}
	public String getReimbursementReceipt() {
		return reimbursementReceipt;
	}
	public void setReimbursementReceipt(String reimbursementReceipt) {
		this.reimbursementReceipt = reimbursementReceipt;
	}
	public ErsUser getErsReimbursementUser() {
		return ersReimbursementUser;
	}
	public void setErsReimbursementUser(ErsUser ersReimbursementUser) {
		this.ersReimbursementUser = ersReimbursementUser;
	}
	public String getReimbursementStatus() {
		return reimbursementStatus;
	}
	public void setReimbursementStatus(String reimbursementStatus) {
		this.reimbursementStatus = reimbursementStatus;
	}
	public String getReimbursementType() {
		return reimbursementType;
	}
	public void setReimbursementType(String reimbursementType) {
		this.reimbursementType = reimbursementType;
	}
	public ErsUser getReimbursementResolver() {
		return reimbursementResolver;
	}
	public void setReimbursementResolver(ErsUser reimbursementResolver) {
		this.reimbursementResolver = reimbursementResolver;
	}
	@Override
	public String toString() {
		return "ErsReimbFeModel [reimbursementId=" + reimbursementId + ", reimbursementAmount=" + reimbursementAmount
				+ ", reimbursementDescription=" + reimbursementDescription + ", reimbursementReceipt="
				+ reimbursementReceipt + ", ersReimbursementUser=" + ersReimbursementUser + ", reimbursementStatus="
				+ reimbursementStatus + ", reimbursementType=" + reimbursementType + ", reimbursementResolver="
				+ reimbursementResolver + "]";
	}
	
	
	
	
	
	
}
