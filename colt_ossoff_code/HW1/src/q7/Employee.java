package q7;

public class Employee {

	public String name;
	public String department;
	public int age;
	
	public Employee(String name, String dept, int age) {
		this.name = name;
		this.department = dept;
		this.age = age;
	}
	public void print() {
		System.out.println("Name: " + name);
		System.out.println("Department: " + department);
		System.out.println("Age: " + age);
		System.out.println();
	}
}
