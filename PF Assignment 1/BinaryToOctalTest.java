package PF_Session_1;

import static org.junit.Assert.*;

import org.junit.Test;

public class BinaryToOctalTest {

	@Test
	public void convertBinaryToOctalTest() {
		
		int expected_output = 65;
		int actual_output = BinaryToOctal.convertBinaryToOctal(110101);
		
		assertEquals(expected_output, actual_output);
		
	}

}
