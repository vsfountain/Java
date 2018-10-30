package question7;

import java.util.Comparator;

	public class EmployeeDepartmentComparator implements Comparator<Employee>{

		@Override
		public int compare(Employee employee1, Employee employee2) {
			String dept1 = employee1.getName();
			String dept2 = employee2.getName();
			
			if((dept1.compareTo(dept2))>0) {
				return 1;
			}else if((dept1.compareTo(dept2))<0) {
				return -1;
			}else {
				return 0;
			}
		}


	}
