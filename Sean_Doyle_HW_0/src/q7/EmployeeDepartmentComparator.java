package q7;

import java.util.Comparator;

public class EmployeeDepartmentComparator implements Comparator<Employee>{

	@Override
	//This is one unnatural method of comparison for employees based on department
	public int compare(Employee e1, Employee e2) {
		String dept1 = e1.name;
		String dpet2 = e2.name;
		if (dept1.compareTo(dpet2)<0) {
			return 1;
		}else if (dept1.compareTo(dpet2)>0) {
			return -1;
		}else {
			return 0;
		}
	}

}
