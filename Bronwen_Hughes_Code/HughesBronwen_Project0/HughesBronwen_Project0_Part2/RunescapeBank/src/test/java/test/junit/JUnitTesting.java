package test.junit;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.mockito.Mockito;

import com.bank.customer.model.Customer;
import com.bank.customer.service.CustomerService;
import com.bank.customer.service.CustomerServiceImpl;
import com.bank.employee.dao.EmployeeDAO;
import com.bank.employee.dao.EmployeeDAOImpl;
import com.bank.employee.model.Employee;
import com.bank.employee.service.EmployeeService;
import com.bank.employee.service.EmployeeServiceImpl;
import com.bank.main.customer.CustomerMainMenu;
import com.bank.main.employee.EmployeeMainMenu;
import com.bank.registration.dao.RegistrationDAO;
import com.bank.registration.dao.RegistrationDAOImpl;

public class JUnitTesting {
	static CustomerMainMenu test = Mockito.mock(CustomerMainMenu.class);
	static CustomerService customerService = Mockito.mock(CustomerServiceImpl.class);
	static EmployeeService employeeService = Mockito.mock(EmployeeServiceImpl.class);
	static EmployeeMainMenu employeeMMTest = Mockito.mock(EmployeeMainMenu.class);// = new EmployeeMainMenu();
	static Customer c = new Customer(3, "Kat", "csharp", "Bronwen", "Hughes", 4);
	static Employee e = new Employee(1, "Admin", "monkey", "Trevin", "Chester", true);
	static EmployeeDAO eDAO = Mockito.mock(EmployeeDAOImpl.class);
	static RegistrationDAO rDAO = Mockito.mock(RegistrationDAOImpl.class);

	@Test
	public void checkCustomer() {
		assertEquals(3, c.getId());
		assertEquals("Kat", c.getUsername());
		assertEquals("csharp", c.getPassword());
		assertEquals("Bronwen", c.getFirstName());
		assertEquals("Hughes", c.getLastName());
		assertEquals(4, c.getJointPartner());
	}

	@Test
	public void checkEmployee() {
		assertEquals(1, e.getId());
		assertEquals("Admin", e.getUsername());
		assertEquals("monkey", e.getPassword());
		assertEquals("Trevin", e.getFirstName());
		assertEquals("Chester", e.getLastName());
		assertEquals(true, e.isAdmin());
	}

	@Test
	public void checkEmployeeAdmin() {
		Mockito.when(employeeMMTest.adminConfirmation()).thenReturn(true);
		assertEquals(true, employeeMMTest.adminConfirmation());
	}

	@Test
	public void customerlogintest() {
		Mockito.when(customerService.getCustomerFromId(3)).thenReturn(new Customer(3, "z", "z", "z", "z", 4));
		Mockito.when(customerService.getCustomerFromId(3)).thenReturn(new Customer(3, "z", "z", "z", "z", 4));
		Mockito.when(test.checkCredentials("z", "z")).thenReturn(true);
		assertEquals(true, test.checkCredentials(customerService.getCustomerFromId(3).getUsername(),
				customerService.getCustomerFromId(3).getPassword()));
	}

	@Test
	public void employeelogintest() {
		Mockito.when(employeeService.getEmployeeFromUsername("Admin"))
				.thenReturn(new Employee(1, "Admin", "Password", "FirstName", "LastName", true));
		Mockito.when(employeeService.getEmployeeFromUsername("Admin"))
				.thenReturn(new Employee(1, "Admin", "Password", "FirstName", "LastName", true));
		Mockito.when(employeeMMTest.checkCredentials("Admin", "Password")).thenReturn(true);
		assertEquals(true,
				employeeMMTest.checkCredentials(employeeService.getEmployeeFromUsername("Admin").getUsername(),
						employeeService.getEmployeeFromUsername("Admin").getPassword()));
	}
}
