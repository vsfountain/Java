package q7;

import java.util.Comparator;

public class Comparer implements Comparator<Employee>{

	@Override
	public int compare(Employee o1, Employee o2) {
		// TODO Auto-generated method stub
		int names = o1.name.compareTo(o2.name);
		names = names/Math.abs(names);
		int depts = o1.department.compareTo(o2.department);
		depts = depts/Math.abs(depts);
		int age = (o1.age>o2.age) ? 1 : (o1.age<o2.age) ? -1 : 0;
		return names + depts + age;
	}
	
}
