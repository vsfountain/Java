package com.jwjibilian.model.user;

import java.util.ArrayList;

import com.jwjibilian.model.reimbursement.Reimbursement;

public class Client extends User{



	public Client() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Client(int id, String userName, String password, String firstName, String lastname, String email,
			ArrayList<Reimbursement> reiburse) {
		super(id, userName, password, firstName, lastname, email, reiburse);
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Client [reiburse=" + reiburse + ", Id" + getId() + ", UserName=" + getUserName()
				+ ", Password=" + getPassword() + ", FirstName" + getFirstName() + ", Lastname="
				+ getLastname() + ", Email=" + getEmail() + ", Reiburse" + getReiburse() + "]";
	}
}
