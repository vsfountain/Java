package com.sort.employees;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
* comparator that is used to sort a list by multiple
* attributes.
* @author Kristen Kavanagh
*
*/
public class employeesComparator implements Comparator<employees> {

   private List<Comparator<employees>> listComparators;

    @SafeVarargs
   public employeesComparator(Comparator<employees>... comparators) {
       this.setListComparators(Arrays.asList(comparators));
   }


     public List<Comparator<employees>> getListComparators() {
		return listComparators;
	}


	public void setListComparators(List<Comparator<employees>> listComparators) {
		this.listComparators = listComparators;
	}


	@Override
   public int compare(employees emp1, employees emp2) {
       return (emp1.getAge()) - (emp2.getAge());
   } 

}
