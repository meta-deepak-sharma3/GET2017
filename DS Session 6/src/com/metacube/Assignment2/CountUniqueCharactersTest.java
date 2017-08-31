package com.metacube.Assignment2;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Test Class for testing CountUniqueCharacters Class
 * @author Deepak
 *
 */
public class CountUniqueCharactersTest {
	
	/**
	 * Test method for getting counting of unique characters in string
	 */
	@Test
	public void testCountUniqueCharacters() {
		CountUniqueCharacters countUniqueCharacters = new CountUniqueCharacters();
		
		// Expected Outputs
		int fExpected1 = 8;
		int fExpected2 = 5;
		int fExpected3 = 4;
		
		//Actual Outputs
		int fActual1 = countUniqueCharacters.countUniqueChars("Hello World");
		int fActual2 = countUniqueCharacters.countUniqueChars("World");
		int fActual3 = countUniqueCharacters.countUniqueChars("Hello");
		
		// Checking the equality between expected and actual outputs
		assertEquals(fExpected1, fActual1);
		assertEquals(fExpected2, fActual2);
		assertEquals(fExpected3, fActual3);
	}

}
