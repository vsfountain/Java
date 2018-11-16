package com.jwjibilian.model.user;

import java.util.ArrayList;

import com.jwjibilian.model.reimbursement.Reimbursement;

public class Admin extends User{

	public Admin() {
		super();
	}

	public Admin(int id, String userName, String password, String firstName, String lastname, String email,
			ArrayList<Reimbursement> reiburse) {
		super(id, userName, password, firstName, lastname, email, reiburse);
	}

	@Override
	public String toString() {
		return "Admin [reiburse=" + reiburse + ", Id=" + getId() + ", UserName=" + getUserName() 
								+ ", Password=" + getPassword() + ", FirstName=" + getFirstName() + ", Lastname="  
								+ getLastname() + ", Email=" + getEmail() + ", Reiburse=" + getReiburse() + "]";
	}

}
