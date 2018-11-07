package bankofalexandria;

import java.util.List;

public interface CustomerDAO {
	// to put a customer into the database
	public void preparedInsertCustomer(String name, String u_name, String p_word);
	
	//to access customer information
	public List<Customer> selectAllCustomers();
	public Customer selectCustomerByCredentials(String u_name, String p_word);
	

}
