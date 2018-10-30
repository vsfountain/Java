package q7;

public class Employee implements Comparable<Employee>  {
	String name;
	String department;
	int age;

	Employee(String name, String department, int age) {
		this.name = name;
		this.department = department;
		this.age = age;
	}
	

	@Override
	public String toString() {
		return "\n\tEmployee [name=" + name + ", department=" + department + ", age=" + age + "]";
	}


	@Override
	//This is the natural method of comparison for employees
	public int compareTo(Employee o) {
		return this.age - o.age;
	}
}
