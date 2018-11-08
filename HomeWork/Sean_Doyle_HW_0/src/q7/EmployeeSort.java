package q7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class EmployeeSort {
public static void main(String[] args) {
	List<Employee> emps = new ArrayList<>();
	//Adding several employee objects such that it is clear that the chosen sorting method is working properly
	emps.add( new Employee("gina", "home goods", 59));
	emps.add( new Employee("barb", "sporting goods", 37));
	emps.add( new Employee("billy", "sporting goods", 22));
	emps.add( new Employee("jake", "grocery", 31));
	System.out.println("This is my unsorted list: " + emps);

	EmployeeNameComparator enc = new EmployeeNameComparator();
	Collections.sort(emps, enc);
	System.out.println("This is my Name sorted list: " + emps);
	
	EmployeeDepartmentComparator edc = new EmployeeDepartmentComparator();
	Collections.sort(emps, edc);
	System.out.println("This is my Departement sorted list: " + emps);
	
	Collections.sort(emps);
	System.out.println("This is my Age sorted list: " + emps);
}

}
