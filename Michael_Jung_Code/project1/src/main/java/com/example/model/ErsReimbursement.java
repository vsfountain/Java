package com.example.model;

import java.util.Date;

public class ErsReimbursement {

	int reimbursementId;
	double reimbursementAmount;
	Date reimbursementSubmittedDate;
	Date reimbursementResolvedDate;
	String reimbursementDescription;
	String reimbursementReceipt;
	int reimbursementErsUserId;
	int reimbursementStatusId;
	int reimbursementTypeId;
	int reimbursementResolverId;
	
		
	public ErsReimbursement(int reimbursementId, double reimbursementAmount, Date reimbursementSubmittedDate,
			Date reimbursementResolvedDate, String reimbursementDescription, String reimbursementReceipt,
			int reimbursementErsUserId, int reimbursementStatusId, int reimbursementTypeId,
			int reimbursementResolverId) {
		super();
		this.reimbursementId = reimbursementId;
		this.reimbursementAmount = reimbursementAmount;
		this.reimbursementSubmittedDate = reimbursementSubmittedDate;
		this.reimbursementResolvedDate = reimbursementResolvedDate;
		this.reimbursementDescription = reimbursementDescription;
		this.reimbursementReceipt = reimbursementReceipt;
		this.reimbursementErsUserId = reimbursementErsUserId;
		this.reimbursementStatusId = reimbursementStatusId;
		this.reimbursementTypeId = reimbursementTypeId;
		this.reimbursementResolverId = reimbursementResolverId;
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
	public int getReimbursementErsUserId() {
		return reimbursementErsUserId;
	}
	public void setReimbursementErsUserId(int reimbursementErsUserId) {
		this.reimbursementErsUserId = reimbursementErsUserId;
	}
	public int getReimbursementStatusId() {
		return reimbursementStatusId;
	}
	public void setReimbursementStatusId(int reimbursementStatusId) {
		this.reimbursementStatusId = reimbursementStatusId;
	}
	public int getReimbursementTypeId() {
		return reimbursementTypeId;
	}
	public void setReimbursementTypeId(int reimbursementTypeId) {
		this.reimbursementTypeId = reimbursementTypeId;
	}
	public int getReimbursementResolverId() {
		return reimbursementResolverId;
	}
	public void setReimbursementResolverId(int reimbursementResolverId) {
		this.reimbursementResolverId = reimbursementResolverId;
	}
	@Override
	public String toString() {
		return "ErsReimbursement [reimbursementId=" + reimbursementId + ", reimbursementAmount=" + reimbursementAmount
				+ ", reimbursementSubmittedDate=" + reimbursementSubmittedDate + ", reimbursementResolvedDate="
				+ reimbursementResolvedDate + ", reimbursementDescription=" + reimbursementDescription
				+ ", reimbursementReceipt=" + reimbursementReceipt + ", reimbursementErsUserId="
				+ reimbursementErsUserId + ", reimbursementStatusId=" + reimbursementStatusId + ", reimbursementTypeId="
				+ reimbursementTypeId + ", reimbursementResolverId=" + reimbursementResolverId + "]";
	}
	
	
	
	
	
	
}
