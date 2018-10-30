package question7;

import java.util.Comparator;

public class EmployeeNameComparator implements Comparator<Employee>{

	@Override
	public int compare(Employee employee1, Employee employee2) {
		String name1 = employee1.getName();
		String name2 = employee2.getName();
		
		if((name1.compareTo(name2))>0) {
			return 1;
		}else if((name1.compareTo(name2))<0) {
			return -1;
		}else {
			return 0;
		}
	}

}
