package q7;

import java.util.ArrayList;
import java.util.Collections;

public class EmplComp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Employee empl1 = new Employee("Sean", "Math", 23);
		Employee empl2 = new Employee("Colt", "Engineering", 31);
		ArrayList<Employee> list = new ArrayList<Employee>();
		list.add(empl1);
		list.add(empl2);
		Comparer comp = new Comparer();
		Collections.sort(list, comp);
		list.get(0).print();
		list.get(1).print();
	}

}
