package Tests;

import static org.junit.Assert.*;

import org.junit.Test;

import Assignments.TOH;

public class TOHTest {

	@Test
	public void testTOH() {
		//Test Case 1
		TOH toh = new TOH(3);
		System.out.println("Test 1");
		toh.printTOH("A", "B", "C", 3);//Input Parameter: Number of Rings
		//Test Case 2
		TOH toh1 = new TOH(2);
		System.out.println("Test 2");
		toh1.printTOH("A", "B", "C", 2);//Input Parameter: Number of Rings
		//Test Case 3
		TOH toh2 = new TOH(1);//Input Parameter: Number of Rings
		System.out.println("Test 3");
		toh2.printTOH("A", "B", "C", 1);
		
	}

}
