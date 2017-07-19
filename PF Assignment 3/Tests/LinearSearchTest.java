package Tests;

import static org.junit.Assert.*;

import org.junit.Test;

import Assignments.LinearSearch;

public class LinearSearchTest {

	int[] input1 = new int[]{2,5,8,9,10,77,55},
			 input2 = new int[]{2,5,8,9,10,77,55,11},
			 input3;
		int search1 = 77,
			search2 = 88,
			search3 = -5;
		LinearSearch ls = new LinearSearch();
		
		@Test
		public void testLinearSearch() {
			
			assertEquals(5, ls.search(input1 , 0 , search1));		//test case when value is present in an array.
			assertEquals(-1, ls.search(input1 , 0 , search2));		//test case when value is not present in an array.
			assertEquals(5, ls.search(input2 , 0 , search1));		//test case when value is present in an array.
			assertEquals(-1, ls.search(input2 , 0 , search2));		//test case when value is not present in an array.
		}
		
		public void falseTestLinearSearch(){
			assertEquals(5, ls.search(input1 , 0  ,search3));		//test case when value is present in an array.
			assertEquals(-1, ls.search(input2 , 0 , search3));		//test case when value is not present in an array.
			assertEquals(-1, ls.search(input3 , 0 , search1));		//test case when wrong value is sent to array.
			assertEquals(5, ls.search(input3 , 0 , search2));		//test case when value is present in an array.
			assertEquals(-1, ls.search(input3 , 0 , search3));		//test case when value is not present in an array.
			
		}
}
