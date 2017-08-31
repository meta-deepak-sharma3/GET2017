package com.metacube.Assignment1;

import java.util.Scanner;

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
		EmployeeCollection employeeCollection = createEmployeeCollection();

		// Sorting Begins
		// Natural Sorting
		System.out.println("---Natural Sorting-----");
		employeeCollection.sort();
		System.out.println(employeeCollection.employees);
		
		// Sorting By Name
		System.out.println("---Sorting By Name-----");
		employeeCollection.sortByName();
		System.out.println(employeeCollection.employees);
		
	}

	private static EmployeeCollection createEmployeeCollection() {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of employees to be added:");
		int numberOfEmployees = getIntegerInput(sc);
		EmployeeCollection employeesCollection = new EmployeeCollection();
		
		for(int i=0; i<numberOfEmployees; i++) {
			System.out.println("Enter the id for "+(i+1)+" Employee:");
			int id = getIntegerInput(sc);
			
			if(employeesCollection.getEmployeeFromId(id) == null) {
				System.out.println("Enter the name for "+(i+1)+" Employee:");
				String name = sc.next();
				System.out.println("Enter the address for "+(i+1)+" Employee:");
				String address = sc.next();
				employeesCollection.employees.add(new Employee(id, name, address));
			}
		}
		
		return employeesCollection;
	}

	/**
	 * getting integer input from the user
	 * @return integer value.
	 */
	private static int getIntegerInput(Scanner scan) {
		boolean flag = true;
		int number=-1;
		
		do {
			try{
				number = scan.nextInt();
				flag = true;
			}
			catch(Exception e)
			{
				System.out.println("1: Add element to Sorted Linked List");
				System.out.println("2: Print the Sorted Linked List");
				System.out.println("3: Exit");
				System.out.println("Please enter valid input");
				scan.next();
				flag = false;
			}
		}while(!flag || number<=0);
		return number;
	}
}
