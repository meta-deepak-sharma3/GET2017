package Tests;

import static org.junit.Assert.*;

import org.junit.Test;

import Assignments.BinarySearch;
import Assignments.LinearSearch;

public class BinarySearchTest {

	int[] input1 = new int[]{2,5,8,9,10,55,77},
			 input2 = new int[]{2,5,8,9,10,11,55,77},
			 input3;
		int search1 = 77,
			search2 = 88,
			search3 = -5;
		BinarySearch bs = new BinarySearch();
		
		@Test
		public void testBinarySearch() {
			
			assertEquals(6, bs.search(input1 , 0 ,input1.length-1 ,  search1));		//test case when value is present in an array.
			assertEquals(-1, bs.search(input1 , 0 ,input1.length-1 ,  search2));		//test case when value is not present in an array.
			assertEquals(7, bs.search(input2 , 0 ,input2.length-1  , search1));		//test case when value is present in an array.
			assertEquals(-1, bs.search(input2 , 0 ,input2.length-1 , search2));		//test case when value is not present in an array.
		}
		
		public void falseTestBinarySearch(){
			assertEquals(5, bs.search(input1 , 0 ,input1.length , search3));		//test case when value is present in an array.
			assertEquals(-1, bs.search(input2 , 0 ,input2.length , search3));		//test case when value is not present in an array.
			assertEquals(-1, bs.search(input3 , 0 ,input3.length , search1));		//test case when wrong value is sent to array.
			assertEquals(5, bs.search(input3 , 0 ,input3.length , search2));		//test case when value is present in an array.
			assertEquals(-1, bs.search(input3 , 0 ,input3.length , search3));		//test case when value is not present in an array.
			
		}
}
