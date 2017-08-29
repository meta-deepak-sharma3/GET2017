package com.metacube.Assignment1;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Class to test StringConcordance class
 * @author Deepak
 *
 */
public class StringConcordanceTest {

	@Test
	public void testGetStringConcordance() {
		StringConcordance sc = new StringConcordance();
		// Inputs 
		String input1 = "Hello";
		String input2 = "World";
		String input3 = "Hello World";
		
		// Expected Outputs
		String fExpected1 = "{e = [1], H = [0], l = [2, 3], o = [4], }";
		String fExpected2 = "{r = [2], d = [4], W = [0], l = [3], o = [1], }";
		String fExpected3 = "{r = [7], d = [9], e = [1], W = [5], H = [0], l = [2, 3, 8], o = [4, 6], }";
		
		assertEquals(fExpected1, sc.getStringConcordance(input1));
		assertEquals(fExpected2, sc.getStringConcordance(input2));
		assertEquals(fExpected3, sc.getStringConcordance(input3));
		
	}

}
