package com.project1.userinfo;

public class User {
	public int userid;
	public String username;
	public String password;
	public String firstname;
	public String lastname;
	public String email;
	public int roleid;
	
	public User() {
		// TODO Auto-generated constructor stub
	}

	public User(int userid, String username, String password, String firstname, String lastname, String email,
			int roleid) {
		super();
		this.userid = userid;
		this.username = username;
		this.password = password;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.roleid = roleid;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getRoleid() {
		return roleid;
	}

	public void setRoleid(int roleid) {
		this.roleid = roleid;
	}

	@Override
	public String toString() {
		return "User [userid=" + userid + ", username=" + username + ", password=" + password + ", firstname="
				+ firstname + ", lastname=" + lastname + ", email=" + email + ", roleid=" + roleid + "]";
	}
	
	
}
