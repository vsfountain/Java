package com.ErsReimbursement.model;
/**
	 * Bean for reimbursement status.
	 * 
	 * @author Kristen Kavanagh 
	 * @version 11/14/2018
	 *
	 */
	public class ReimbursementStatus {
	
		private int id;
		
		private String name;
		
		public ReimbursementStatus() { super(); }
		
		public ReimbursementStatus(int id, String name) {
			super();
			this.id = id;
			this.name = name;
		}
		
		public int getId() { return id;	}
		public void setId(int id) {	this.id = id; }
		
		public String getName() { return name; }
		public void setName(String name) { this.name = name; }
	}


		
		
	
