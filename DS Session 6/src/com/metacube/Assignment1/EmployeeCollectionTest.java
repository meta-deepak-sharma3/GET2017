package com.metacube.Assignment1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class EmployeeCollectionTest {
	EmployeeCollection employeeCollection;
	@Before
	public void setUp() throws Exception {
		employeeCollection = new EmployeeCollection();
		employeeCollection.employees.add(new Employee(1, "Amit", "12-A Block"));
		employeeCollection.employees.add(new Employee(2, "Anil", "13-A Block"));
		employeeCollection.employees.add(new Employee(3, "Nikhil", "14-A Block"));
		employeeCollection.employees.add(new Employee(4, "Manu", "15-A Block"));
		employeeCollection.employees.add(new Employee(5, "Dev", "16-A Block"));
		employeeCollection.employees.add(new Employee(6, "Abhay", "17-A Block"));
	}
	
	/**
	 * Test method for natural sorting of employee collection
	 */
	@Test
	public void testNaturalSorting() {
		String fExpected = "[Employee:Id= 1|Name= Amit|Address= 12-A Block, Employee:Id= 2|Name= Anil|Address= 13-A Block, Employee:Id= 3|Name= Nikhil|Address= 14-A Block, Employee:Id= 4|Name= Manu|Address= 15-A Block, Employee:Id= 5|Name= Dev|Address= 16-A Block, Employee:Id= 6|Name= Abhay|Address= 17-A Block]";
		employeeCollection.sort();
		assertEquals(fExpected, employeeCollection.employees.toString());
	}
	
	/**
	 * Test method for sorting by name of employee collection.
	 */
	@Test
	public void testSortingByName() {
		String fExpected = "[Employee:Id= 6|Name= Abhay|Address= 17-A Block, Employee:Id= 1|Name= Amit|Address= 12-A Block, Employee:Id= 2|Name= Anil|Address= 13-A Block, Employee:Id= 5|Name= Dev|Address= 16-A Block, Employee:Id= 4|Name= Manu|Address= 15-A Block, Employee:Id= 3|Name= Nikhil|Address= 14-A Block]";
		employeeCollection.sortByName();
		assertEquals(fExpected, employeeCollection.employees.toString());
	}
}
