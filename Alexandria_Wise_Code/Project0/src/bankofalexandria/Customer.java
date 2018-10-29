package bankofalexandria;

import java.io.Serializable;

public class Customer implements Serializable {
	
	static String name;
	static String userName;
	static String password;
	
	Customer() {
	
	}
	Customer(String name, String userName, String password) {
		Customer.name = name;
		Customer.userName = userName;
		Customer.password = password;
	}
	public static String getName() {
		return name;
	}
	public static void setName(String name) {
		Customer.name = name;
	}
	public static String getUserName() {
		return userName;
	}
	public static void setUserName(String userName) {
		Customer.userName = userName;
	}
	public static String getPassword() {
		return password;
	}
	public static void setPassword(String password) {
		Customer.password = password;
	}
	@Override
	public String toString() {
		return "Customer Info [name=" + name + ", userName=" + userName + ", password=" + password + "]";
	}
	
	static void viewAccountInfo(SoloAccount view) {
		System.out.println("Account ID: "+view.accountID);
		System.out.println("Account Balance: "+view.balance);
		System.out.println("Account Holder: "+view.name+ "| UserName: "+view.userName+"| Password: "+view.password);
		
	}
	static void viewAccountInfo(JointAccount view) {
		System.out.println("Account ID: "+view.accountID);
		System.out.println("Account Balance: "+view.balance);
		System.out.println("Account Holder: "+view.owner1.name+ "| UserName: "+view.owner1.userName+"| Password: "+view.owner1.password);
		System.out.println("Account Holder: "+view.owner2.name+ "| UserName: "+view.owner2.userName+"| Password: "+view.owner2.password);
	}
	

}

