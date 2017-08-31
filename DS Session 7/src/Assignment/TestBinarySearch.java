/**
 * Aim :  Write a program the binary search function and its loop invariants in a way 
 * so that it will always find the leftmost occurrence of x in the array
*/
package Assignment;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class TestBinarySearch {

	BinarySearch binarySearch;
	int[] array1,array2;
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		
		binarySearch = new BinarySearch();
		array1 = new int[]{1,2,3,4,5,6};
		array2 = new int[]{4,4,4,4,4,4};
		
	}

	/**
	 * Test method for {@link assignment.BinarySearch#searchElement(int[], int, int, int, int)}.
	 */
	@Test
	public void testSearchElement() {
		
		assertEquals(0, binarySearch.searchElement(array1, 0, 5, 1,-1));
		assertEquals(0, binarySearch.searchElement(array2, 0, 5, 4,-1));
		assertEquals(5, binarySearch.searchElement(array1, 0, 5, 6,-1));
		assertEquals(-1, binarySearch.searchElement(array1, 0, 5, 43,-1));
		
	}

}