package q07;

import java.util.Comparator;

public class EmployeeSort implements Comparator<Employee> {

	public static void main(String[] args) {
		Employee x1 = new Employee("Ha", "acc", 25);
		Employee x2 = new Employee("Ha", "acc", 24);
		EmployeeSort sorter = new EmployeeSort();
		System.out.println(sorter.compare(x1,x2));
		if(sorter.compare(x1,x2)  < 0) {
			System.out.println(x1+" "+x2);
		} else {
			System.out.println(x2+" "+x1);
		}
		
	}

	@Override
	public int compare(Employee o1, Employee o2) {
		int toReturn = 0;
		int nameComp = o1.getName().compareTo(o2.getName());
		int departmentComp = o1.getDepartment().compareTo(o2.getDepartment());
		
		if (nameComp != 0) {
			toReturn = nameComp;
			System.out.println("name");
		} else if (departmentComp != 0) {
			toReturn = departmentComp;
			System.out.println("depart");
		} else if(o1.getAge() > o2.getAge()) {
			System.out.println("age 1");
			toReturn = 1;
		} else if (o1.getAge()< o2.getAge()) {
			System.out.println("age 2");
			toReturn = -1;
		}
		return toReturn;
	}
}

class Employee {

	private String name;
	private String department;
	private int age;

	public Employee(String name, String department, int age) {
		this.name = name;
		this.department = department;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	public String toString() {
		return this.name +" " + this.department + " " + this.age;
	}
	

}