package com.app.account;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class EmployeeList {

	private static EmployeeList instance;
	public static ArrayList<Employee> employeeList = new ArrayList<>();

	private EmployeeList() {
		repopulate();
	}

	public static EmployeeList getInstance() {
		if (instance == null) {
			instance = new EmployeeList();
		}
		return instance;
	}

	public void addEmployee(Employee employee) {
		employeeList.add(employee);
		printTo();
	}

	@Override
	public String toString() {
		return "EmployeeList [employeeList=" + employeeList + "]";
	}

	
	public static void printTo() {
		System.out.println("READING FROM ARRAY!  " + employeeList);
		String fileName = "./EmployeeList.txt";
		try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName))) {
			out.writeObject(employeeList);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void repopulate() {
		System.out.println("WRITING TO ARRAY" + employeeList);
		String fileName = "./EmployeeList.txt";

		try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName))) {
			employeeList = (ArrayList<Employee>) in.readObject();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println("Finally: " + employeeList);
		}
	}
}
