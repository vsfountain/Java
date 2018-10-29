package Admin;

import java.util.ArrayList;

public class Bank extends Person implements AdminAccess{
	public Bank(String name, int pin, Integer ssn, int accessLevel) {
		
		super(name, pin, ssn, accessLevel);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected static final ArrayList<Person> CustomersOfBank = new ArrayList<Person>();
	//ArrayList<Person> CustomersOfBank = new ArrayList<Person>();
	void addNewCustomer(Person person){
		CustomersOfBank.add(person);
		System.out.println("adding new customer"+ CustomersOfBank);
	}
		
	boolean checkAccountInfo(Person person) {
		System.out.println(CustomersOfBank);
		for(Person person1:CustomersOfBank) {
			if(person1 == person) {
				return true;
				}
			}
		return false;
		}
	Person displayMenu() {
		return null;
		}
}
