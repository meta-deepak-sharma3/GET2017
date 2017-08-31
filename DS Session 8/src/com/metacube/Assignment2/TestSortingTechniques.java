package com.metacube.Assignment2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * Test class for Sorting Technique
 * @author Deepak
 *
 */
public class TestSortingTechniques {
	int[] arr1, arr2, arr3, arr4;
	
	/**
	 * Initial Setup for test methods
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		arr1 = new int[] {};
		arr2 = new int[]{7, 6, 3, 2};
		arr3 = new int[] {1, 4, 2, 2};
		arr4 = new int[] {4, 4, 4, 1, 8, 7, 6, 6, 6};
	
	}
	
	/**
	 * test method for bubblesort
	 */
	@Test
	public void testBubbleSort() {
		int[] fExpected1 = new int[] {};
		int[] fExpected2 = new int[] {2, 3, 6, 7};
		int[] fExpected3 = new int[] {1, 2, 2, 4};
		int[] fExpected4 = new int[] {1, 4, 4, 4, 6, 6, 6, 7, 8};
		
		assertArrayEquals(fExpected1, BubbleSort.sort(arr1));
		assertArrayEquals(fExpected2, BubbleSort.sort(arr2));
		assertArrayEquals(fExpected3, BubbleSort.sort(arr3));
		assertArrayEquals(fExpected4, BubbleSort.sort(arr4));
	}
	
	/**
	 * test method for count sort.
	 */
	@Test
	public void testCountSort() {
		int[] fExpected1 = new int[] {};
		int[] fExpected2 = new int[] {2, 3, 6, 7};
		int[] fExpected3 = new int[] {1, 2, 2, 4};
		int[] fExpected4 = new int[] {1, 4, 4, 4, 6, 6, 6, 7, 8};
		
		assertArrayEquals(fExpected1, CountSort.sort(arr1));
		assertArrayEquals(fExpected2, CountSort.sort(arr2));
		assertArrayEquals(fExpected3, CountSort.sort(arr3));
		assertArrayEquals(fExpected4, CountSort.sort(arr4));
	}
	
	/**
	 * test method for quick sort
	 */
	@Test
	public void testQuickSort() {
		int[] fExpected1 = new int[] {};
		int[] fExpected2 = new int[] {2, 3, 6, 7};
		int[] fExpected3 = new int[] {1, 2, 2, 4};
		int[] fExpected4 = new int[] {1, 4, 4, 4, 6, 6, 6, 7, 8};
		
		assertArrayEquals(fExpected1, QuickSort.sort(arr1));
		assertArrayEquals(fExpected2, QuickSort.sort(arr2));
		assertArrayEquals(fExpected3, QuickSort.sort(arr3));
		assertArrayEquals(fExpected4, QuickSort.sort(arr4));
	}
	
	/**
	 * test method for radix sort.
	 */
	@Test
	public void testRadixSort() {
		int[] fExpected1 = new int[] {};
		int[] fExpected2 = new int[] {2, 3, 6, 7};
		int[] fExpected3 = new int[] {1, 2, 2, 4};
		int[] fExpected4 = new int[] {1, 4, 4, 4, 6, 6, 6, 7, 8};
		
		assertArrayEquals(fExpected1, RadixSort.sort(arr1));
		assertArrayEquals(fExpected2, RadixSort.sort(arr2));
		assertArrayEquals(fExpected3, RadixSort.sort(arr3));
		assertArrayEquals(fExpected4, RadixSort.sort(arr4));
	}

}
