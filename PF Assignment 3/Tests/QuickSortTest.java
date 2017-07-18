package Tests;

import static org.junit.Assert.*;

import org.junit.Test;
import Assignments.*;

public class QuickSortTest {

	@Test
	public void QuickSortTest() {
		
		//Test Input 1
		int[] input1 = new int[]{};
		int[] fExpected1 = new int[]{};
		//Test Input 2
		int[] input2 = new int[]{2,5,8,9,10, 77, 55, 11};
		int[] fExpected2 = new int[]{2,5,8,9,10,11,55,77};
		
		QuickSort q = new QuickSort();
		q.quickSort(input1, 0, 0);
		q.quickSort(input2, 0, 7);
		
		assertArrayEquals(fExpected1, input1);
		assertArrayEquals(fExpected2, input2);
		
	}

}
