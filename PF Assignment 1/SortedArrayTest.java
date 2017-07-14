package PF_Session_1;

import static org.junit.Assert.*;

import org.junit.Test;

public class SortedArrayTest {

	@Test
	public void sortedArrayTest() {
		
		int[] input = {1,2,3,4,5};
		
		int expected_output = 1;
		
		int actual_output = SortedArray.sortedArray(input);
		
		assertEquals(expected_output, actual_output);
		
	}

}
