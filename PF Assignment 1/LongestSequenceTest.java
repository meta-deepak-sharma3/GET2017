package PF_Session_1;

import static org.junit.Assert.*;

import org.junit.Test;

public class LongestSequenceTest {

	@Test
	public void longestSequence() {
		int[] input = {1,2,3,2,3,4,5,3,4,2,2,3,4,5,6,7,8,1,2,4,5,6,7,8,9};
		
		int[] expected_Output = {1,2,4,5,6,7,8,9};
		int[] actual_Output = LongestSequence.longestSequence(input);
		
		assertArrayEquals(expected_Output, actual_Output);
	
	
	}

}
