package com.metacube.Assignment1;

import java.util.Set;

/**
 * Utility Class to perform operation on
 * EmployeeCollection class
 * @author Deepak
 *
 */
public class EmployeeCollectionImpl {
	
	/**
	 * Main method
	 */
	public static void main(String args[]) {
		EmployeeCollection employeeCollection = new EmployeeCollection();
		employeeCollection.employees.add(new Employee(1, "Amit", "12-A Block"));
		employeeCollection.employees.add(new Employee(2, "Anil", "13-A Block"));
		employeeCollection.employees.add(new Employee(3, "Nikhil", "14-A Block"));
		employeeCollection.employees.add(new Employee(4, "Manu", "15-A Block"));
		employeeCollection.employees.add(new Employee(5, "Dev", "16-A Block"));
		employeeCollection.employees.add(new Employee(6, "Abhay", "17-A Block"));
		
		// Sorting Begins
		// Natural Sorting
		System.out.println("---Natural Sorting-----");
		employeeCollection.sort();
		System.out.println(employeeCollection.employees);
		
		// Sorting By Name
		System.out.println("---Sorting By Name-----");
		employeeCollection.sortByName();
		System.out.println(employeeCollection.employees);
		
		// Getting unique Collections for Employee Collections
		System.out.println("Unique Collection.....");
		Set<Employee> uniqueEmployees = employeeCollection.getUniqueEmployees();
		System.out.println(uniqueEmployees);
		
	}

}
