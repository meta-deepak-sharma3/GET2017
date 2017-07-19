package Tests;

import static org.junit.Assert.*;

import org.junit.Test;

import Assignments.Permutation;

public class PermutationTest {

	@Test
	public void testPermutation() {
		Permutation p = new Permutation();
		Permutation p1 = new Permutation();
		Permutation p2 = new Permutation();
		Permutation p3 = new Permutation();
		//Test 1
		System.out.println("Test 1");
		p.permute("AABC".toCharArray());
		//Test 2
		System.out.println("Test 2");
		p1.permute("AA".toCharArray());
		//Test 3
		System.out.println("Test 3");
		p2.permute("ABC".toCharArray());
		//Test 4
		System.out.println("Test 4");
		p3.permute("ABCA".toCharArray());
	}

}
