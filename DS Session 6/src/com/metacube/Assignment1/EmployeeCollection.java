package com.metacube.Assignment1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Class to perform operation on Employee Collection.
 * @author Deepak
 *
 */
public class EmployeeCollection {
	List<Employee> employees;
	
	/**
	 * Constructor
	 */
	public EmployeeCollection(){
		employees = new ArrayList<Employee>();
	}
	
	/**
	 * Performs the Natural Sorting on the collectio
	 * of employees
	 */
	public void sort() {
		Collections.sort(employees);
	}
	
	/**
	 * Sort the employee collection on the basis of their names
	 */
	public void sortByName() {
		Collections.sort(employees, new Comparator<Object>() {
            @Override
            public int compare(Object first, Object second) {
               Employee employeeOne = (Employee) first;
               Employee employeeTwo = (Employee) second;
               return(employeeOne.getName().compareTo(employeeTwo.getName()));
            }
        });
	}
	
	/**
	 * returns the unique collection of employees
	 * on the basis of their ids
	 * @return
	 */
	public Set<Employee> getUniqueEmployees(){
		Map<Integer,Employee> uniqueEmployeeMapList = new HashMap<Integer,Employee>();
		for(Employee employee: employees) {
			uniqueEmployeeMapList.put(employee.getId(), employee);
		}
		Set<Employee> uniqueAccs = new HashSet<Employee>(uniqueEmployeeMapList.values());    
		return uniqueAccs;
	}
}