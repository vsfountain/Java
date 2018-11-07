package bankofalexandria;

import java.io.Serializable;

public class Customer implements Serializable {
	
	private static final long serialVersionUID = -8845219550102229944L;
	public String name;
	public String userName;
	public String password;
	public int userId;
	
	public Customer() {
		this.name = name;
		this.userName = userName;
		this.password = password;
		this.userId = userId;

	}
	
	/*Customer(String name, String userName, String password, int userId) {
		this.name = name;
		this.userName = userName;
		this.password = password;
		this.userId = userId;
	}*/
	public Customer(String name, String userName, String password, int userID) {
		this.name = name;
		this.userName = userName;
		this.password = password;
		this.userId = userID;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUserName() {
		return this.userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String toString() {
		return "name=" + name + ", userName=" + userName + ", password=" + password+ " ,userID= "+userId;
	}
	
	void viewAccountInfo(SoloAccount view) {
		System.out.println("Account ID: "+view.accountID);
		System.out.println("Account Balance: "+view.balance);
		System.out.println("Account Holder: "+view.getName()+ "| UserName: "+view.getUserName()+"| Password: "+view.getPassword());
		
	}
	void viewAccountInfo(JointAccount view) {
		System.out.println("Account ID: "+view.accountID);
		System.out.println("Account Balance: "+view.balance);
		//System.out.println("Account Holder: "+view.owner1.name+ "| UserName: "+view.owner1.userName+"| Password: "+view.owner1.password);
		//System.out.println("Account Holder: "+view.owner2.name+ "| UserName: "+view.owner2.userName+"| Password: "+view.owner2.password);
	}

	public int getAccountID() {
		// TODO Auto-generated method stub
		return 0;
	}
	

}

