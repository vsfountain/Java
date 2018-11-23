package com.ers.model;
import java.util.Date;
import java.sql.Blob;
import java.sql.Timestamp;

public class Reimbursement {
	int rId;
	double amount;
	Timestamp reqTime; 
	Timestamp resTime;
	String description;
	Blob receipt;
	int author;
	int resolver;
	int status;
	int type;
	
	//constructor
	public Reimbursement(int rId, double amount, Timestamp reqTime, Timestamp resTime, String description, Blob receipt, int author,
			int resolver, int status, int type) {
		super();
		this.rId = rId;
		this.amount = amount;
		this.reqTime = reqTime;
		this.resTime = resTime;
		this.description = description;
		this.receipt = receipt;
		this.author = author;
		this.resolver = resolver;
		this.status = status;
		this.type = type;
	}

	


	public int getrId() {
		return rId;
	}




	public void setrId(int rId) {
		this.rId = rId;
	}




	public double getAmount() {
		return amount;
	}




	public void setAmount(double amount) {
		this.amount = amount;
	}




	public String getReqTime() {
		return ""+reqTime;
	}




	public void setReqTime(Timestamp reqTime) {
		this.reqTime = reqTime;
	}




	public String getResTime() {
		return ""+resTime;
	}




	public void setResTime(Timestamp resTime) {
		this.resTime = resTime;
	}




	public String getDescription() {
		return description;
	}




	public void setDescription(String description) {
		this.description = description;
	}




	public int getAuthor() {
		return author;
	}




	public void setAuthor(int author) {
		this.author = author;
	}




	public int getResolver() {
		return resolver;
	}




	public void setResolver(int resolver) {
		this.resolver = resolver;
	}




	public int getStatus() {
		return status;
	}




	public void setStatus(int status) {
		this.status = status;
	}




	public int getType() {
		return type;
	}




	public void setType(int type) {
		this.type = type;
	}




	@Override
	public String toString() {
		return "Reimbursement [rId=" + rId + ", amount=" + amount + ", reqTime=" + reqTime + ", resTime=" + resTime
				+ ", description=" + description + ", receipt=" + receipt + ", author=" + author + ", resolver="
				+ resolver + ", status=" + status + ", type=" + type + "]";
	}




		
	
	
}
