package question7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import question7.Employee;

public class Main {
	public static void main(String[] args) {
		
		List<Employee> employees = new ArrayList<>();
		
		employees.add(new Employee("Ross", 28, "paleontology"));
		employees.add(new Employee("Rachel", 25, "fashion"));
		employees.add(new Employee("Monica", 26, "culinary"));
		employees.add(new Employee("Phoebe", 26, "massage"));
		employees.add(new Employee("Joey", 27, "entertainment"));
		employees.add(new Employee("Chandler", 27, "finance"));	
		
		
		Collections.sort(employees); //command can handle any object that extends or implements comparable
		System.out.println("this is my list sorted by age: " +employees+ "\n");
		
		EmployeeDepartmentComparator edc = new EmployeeDepartmentComparator();
		Collections.sort(employees, edc); //command can handle any object that extends or implements comparable
		System.out.println("this is my list sorted by department: " +employees+ "\n");
		
		EmployeeNameComparator enc = new EmployeeNameComparator();
		Collections.sort(employees, enc); //command can handle any object that extends or implements comparable
		System.out.println("this is my list sorted by name: " +employees+ "\n");
		
	}
	
	
}
