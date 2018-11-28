package com.reimbsys.model;

import java.sql.Blob;
import java.sql.Timestamp;

public class Reimbursement {

	protected int reimbId;
	protected Double amount;
	//protected LocalDate submitted;
	protected Timestamp submitted; 
	//protected LocalDate resolved;
	protected Timestamp resolved;
	protected String description;
	protected Blob receipt;
	protected int authorId;
	protected String author;
	protected int resolverId;
	protected String resolver;
	protected int statusId;
	protected String status;
	protected int typeId;
	protected String type;
	
	public Reimbursement() {
		
	}

	public int getReimbId() {
		return reimbId;
	}

	public Reimbursement(Double amount, String description, int authorId) {
		super();
		this.amount = amount;
		this.submitted = new Timestamp(System.currentTimeMillis());
		this.description = description;
		this.authorId = authorId;
	}

	public Reimbursement(int reimbId, Double amount, Timestamp submitted, String description, int authorId, String author,
			int statusId, String status, int typeId, String type) {
		super();
		this.reimbId = reimbId;
		this.amount = amount;
		this.submitted = submitted;
		this.description = description;
		this.authorId = authorId;
		this.author = author;
		this.statusId = statusId;
		this.status = status;
		this.typeId = typeId;
		this.type = type;
	}

	public Reimbursement(int reimbId, Double amount, Timestamp submitted, Timestamp resolved, String description,
			Blob receipt, int authorId, String author, int resolverId, String resolver, int statusId,
			String status, int typeId, String type) {
		super();
		this.reimbId = reimbId;
		this.amount = amount;
		this.submitted = submitted;
		this.resolved = resolved;
		this.description = description;
		this.receipt = receipt;
		this.authorId = authorId;
		this.author = author;
		this.resolverId = resolverId;
		this.resolver = resolver;
		this.statusId = statusId;
		this.status = status;
		this.typeId = typeId;
		this.type = type;
	}

	public void resolve() {
		this.resolved = new Timestamp(System.currentTimeMillis());
	}
	
	public void setReimbId(int reimbId) {
		this.reimbId = reimbId;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Timestamp getSubmitted() {
		return submitted;
	}

	public void setSubmitted(Timestamp submitted) {
		this.submitted = submitted;
	}

	public Timestamp getResolved() {
		return resolved;
	}

	public void setResolved(Timestamp resolved) {
		this.resolved = resolved;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Blob getReceipt() {
		return receipt;
	}

	public void setReceipt(Blob receipt) {
		this.receipt = receipt;
	}

	public int getAuthorId() {
		return authorId;
	}

	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getResolverId() {
		return resolverId;
	}

	public void setResolverId(int resolverId) {
		this.resolverId = resolverId;
	}

	public String getResolver() {
		return resolver;
	}

	public void setResolver(String resolver) {
		this.resolver = resolver;
	}

	public int getStatusId() {
		return statusId;
	}

	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getTypeId() {
		return typeId;
	}

	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Reimbursement [reimbId=" + reimbId + ", amount=" + amount + ", submitted=" + submitted + ", resolved="
				+ resolved + ", description=" + description + ", receipt=" + receipt + ", authorId=" + authorId
				+ ", author=" + author + ", resolverId=" + resolverId + ", resolver=" + resolver + ", statusId="
				+ statusId + ", status=" + status + ", typeId=" + typeId + ", type=" + type + "]";
	}
	
	
	
}
