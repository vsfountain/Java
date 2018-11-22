package com.ErsReimbursement.model;

import java.sql.Timestamp;
import java.util.Arrays;
/**
 * Model for reimbursement.
 * 
 * @author Kristen Kavanagh
 * @version 11/19/2018
 */
public class Reimbursement {
	
	private int remb_Id;
	private double remb_Amount;
	private Timestamp remb_Submitted;
	private Timestamp remb_Resolved;
	private String remb_Description;
	private int remb_Author;
	private String remb_Resolver;
	private int remb_Status_Id;
	private int remb_Type_Id;
	public Reimbursement(int remb_Id, double remb_Amount, Timestamp remb_Submitted, Timestamp remb_Resolved,
			String remb_Description, int remb_Author, String remb_Resolver, int remb_Status_Id,
			int remb_Type_Id) {
		super();
		this.remb_Id = remb_Id;
		this.remb_Amount = remb_Amount;
		this.remb_Submitted = remb_Submitted;
		this.remb_Resolved = remb_Resolved;
		this.remb_Description = remb_Description;
		this.remb_Author = remb_Author;
		this.remb_Resolver = remb_Resolver;
		this.remb_Status_Id = remb_Status_Id;
		this.remb_Type_Id = remb_Type_Id;
	}
	public int getRemb_Id() {
		return remb_Id;
	}
	public void setRemb_Id(int remb_Id) {
		this.remb_Id = remb_Id;
	}
	public double getRemb_Amount() {
		return remb_Amount;
	}
	public void setRemb_Amount(double remb_Amount) {
		this.remb_Amount = remb_Amount;
	}
	public Timestamp getRemb_Submitted() {
		return remb_Submitted;
	}
	public void setRemb_Submitted(Timestamp remb_Submitted) {
		this.remb_Submitted = remb_Submitted;
	}
	public Timestamp getRemb_Resolved() {
		return remb_Resolved;
	}
	public void setRemb_Resolved(Timestamp remb_Resolved) {
		this.remb_Resolved = remb_Resolved;
	}
	public String getRemb_Description() {
		return remb_Description;
	}
	public void setRemb_Description(String remb_Description) {
		this.remb_Description = remb_Description;
	}
	public int getRemb_Author() {
		return remb_Author;
	}
	public void setRemb_Author(int remb_Author) {
		this.remb_Author = remb_Author;
	}
	public String getRemb_Resolver() {
		return remb_Resolver;
	}
	public void setRemb_Resolver(String remb_Resolver) {
		this.remb_Resolver = remb_Resolver;
	}
	public int getRemb_Status_Id() {
		return remb_Status_Id;
	}
	public void setRemb_Status_Id(int remb_Status_Id) {
		this.remb_Status_Id = remb_Status_Id;
	}
	public int getRemb_Type_Id() {
		return remb_Type_Id;
	}
	public void setRemb_Type_Id(int remb_Type_Id) {
		this.remb_Type_Id = remb_Type_Id;
	}
	@Override
	public String toString() {
		return "Reimbursement [remb_Id=" + remb_Id + ", remb_Amount=" + remb_Amount + ", remb_Submitted="
				+ remb_Submitted + ", remb_Resolved=" + remb_Resolved + ", remb_Description=" + remb_Description
				+ ", remb_Author=" + remb_Author + ", remb_Resolver=" + remb_Resolver + ", remb_Status_Id="
				+ remb_Status_Id + ", remb_Type_Id=" + remb_Type_Id + "]";
	}
	
	
	
	}