package com.metacube.Assignment1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


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
	 * 
	 * @param id
	 * @return employee from given id
	 */
	public Employee getEmployeeFromId(int id) {
		for(Employee employee: employees) {
			if(employee.getId() == id) {
				return employee;
			}
		}
		return null;
	}
}