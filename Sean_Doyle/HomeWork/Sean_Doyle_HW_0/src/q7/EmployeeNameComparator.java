package q7;

import java.util.Comparator;

public class EmployeeNameComparator implements Comparator<Employee>{

	@Override
	//This is one unnatural method of comparison for employees based on name
	public int compare(Employee e1, Employee e2) {
		String name1 = e1.name;
		String name2 = e2.name;
		if (name1.compareTo(name2)>0) {
			return 1;
		}else if (name1.compareTo(name2)<0) {
			return -1;
		}else {
			return 0;
		}
	}

}
