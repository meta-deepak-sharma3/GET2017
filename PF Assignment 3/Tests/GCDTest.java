package Tests;

import static org.junit.Assert.*;

import org.junit.Test;

import Assignments.GCD;

public class GCDTest {

	@Test
	public void gcdTest() {
		//2,1 12, 8 100, 3
		
		int fExpected1 = 1;
		int fExpected2 = 4;
		int fExpected3 = 1;
		
		GCD g = new GCD();
		
		assertEquals(fExpected1, g.gcd(2,1));
		assertEquals(fExpected2, g.gcd(12,8));
		assertEquals(fExpected3, g.gcd(100,3));
	}

}
