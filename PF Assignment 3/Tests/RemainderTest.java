package Tests;

import static org.junit.Assert.*;

import org.junit.Test;

import Assignments.Remainder;

public class RemainderTest {

	@Test
	public void remTest() {
		//Test Input 1
		int number1 = 3;
		int number2 = 5;
		int fExpected1 = 3;
		//Test Input 2
		int number3 = 5;
		int number4 = 5;
		int fExpected2 = 0;
		//Test Input 3
		int number5 = 25;
		int number6 = 4;
		int fExpected3 = 1;
		//Test Input 4
		int number7 = 5;
		int number8 = 0;
		int fExpected4 = -1;
		
		
		Remainder q = new Remainder();
		
		assertEquals(fExpected1, q.rem(number1, number2));
		assertEquals(fExpected2, q.rem(number3, number4));
		assertEquals(fExpected3, q.rem(number5, number6));
		assertEquals(fExpected4, q.rem(number7, number8));
	}

}
