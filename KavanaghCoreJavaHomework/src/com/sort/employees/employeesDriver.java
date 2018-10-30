package com.sort.employees;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * program demonstrate sort a list collection by multiple attributes using a
 * comparator interface.
 *
 * @author Kristen
 *
 */
public class employeesDriver {

	public static void main(String[] args) {

		System.out.println("<===== SORTING BY ATTRIBUTES =====>");

		List<employees> listEmployees = new ArrayList<employees>();

		listEmployees.add(new employees("Craig", "Human Resources", 30));
		listEmployees.add(new employees("Anne", "Development", 25));
		listEmployees.add(new employees("Alex", "Sales", 30));

		System.out.println("*** Before sorting:");

		for (employees emp : listEmployees) {
			System.out.println(emp);
		}

		Collections.sort(listEmployees, new employeesComparator(
				new employeesComparator(), 
				new employeesComparator(),
				new employeesComparator()));


		System.out.println("\n*** After sorting:");

		for (employees emp : listEmployees) {
			System.out.println(emp);
		}

	}
}