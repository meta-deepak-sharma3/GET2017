package com.metacube.Printer;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * Test Class to test Heap operations properly
 * @author Deepak
 *
 */
public class TestPrinter {
	MyHeap heap; //testing for heap of capacity 3
	Job j1;
	Job j2;
	
	/**
	 * operations used for every other test methods.
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		heap = new MyHeap(2);
		j1 = new Job("A", 1);
		j2 = new Job("B", 3);
	}
	
	/**
	 * test method to test for adding the job to the
	 * printer
	 */
	@Test
	public void testAddingJob() {
		assertEquals(true, heap.insert("A", 1));
		assertEquals(true, heap.insert("B", 2));
		System.out.println(heap.capacity);
		assertEquals(false, heap.insert("C", 3));
	}
	
	/**
	 * Test method to test for 
	 * popping out the job with highest priority
	 */
	@Test
	public void testRemoveJob(){
		 heap.insert(j1.getName(), j1.getPriority());
		 heap.insert(j2.getName(), j2.getPriority());
		 Job j3 = heap.remove();
		 assertEquals(3, j3.getPriority());		
	}
}
