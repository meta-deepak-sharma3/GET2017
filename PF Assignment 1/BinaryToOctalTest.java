package PF_Session_1;

import static org.junit.Assert.*;

import org.junit.Test;

public class BinaryToOctalTest {

	@Test
	public void convertBinaryToOctalTest() {
		
		int expected_Output = 65;
		int actual_Output = BinaryToOctal.convertBinaryToOctal(110101);
		
		assertEquals(expected_Output, actual_Output);
		
	}

}
