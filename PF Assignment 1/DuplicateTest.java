package PF_Session_1;

import static org.junit.Assert.*;
import PF_Session_1.*;

import org.junit.Test;

public class DuplicateTest {

	
	@Test
	public void removeDuplicateTest() {
		
		int[] given = {2,5,4,6,3,8,5,9,3,3,6,3,9,0};
		int[] result = {2,5,4,6,3,8,9,0};
	
		Duplicate dp2 = new Duplicate();
		
		assertArrayEquals(result, dp2.removeDuplicate(given));
		
	}

}
