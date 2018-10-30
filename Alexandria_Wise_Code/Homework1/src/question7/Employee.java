package question7;

public class Employee implements Comparable<Employee>{

	private String name;
	private int age;
	private String department;
	
	public Employee() {
	}
	
	public Employee(String string, int i, String string2) {
		super();
		this.name = string;
		this.age = i;
		this.department = string2;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "\n Employee [name=" + name + ", age=" + age + ", department=" + department + "]";
	}

	@Override
	public int compareTo(Employee o) {
		return this.getAge()-o.getAge();
	}
	
	
}

