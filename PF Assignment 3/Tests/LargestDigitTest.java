package Tests;

import static org.junit.Assert.*;

import org.junit.Test;

import Assignments.LargestDigit;

public class LargestDigitTest {

	@Test
	public void largestDigitTest() {
		//Test Input 1: 1257369
		int fExpected1 = 9;
		//Test Input 2: 44
		int fExpected2 = 4;
		//Test Input 3: 2
		int fExpected3 = 2;
		//Test Input 4: 0
		int fExpected4 = 0;
		
		LargestDigit lg = new LargestDigit();
	
		assertEquals(fExpected1, lg.largestDigit(1257369));
		assertEquals(fExpected2, lg.largestDigit(44));
		assertEquals(fExpected3, lg.largestDigit(2));
		assertEquals(fExpected4, lg.largestDigit(0));
	}

}
