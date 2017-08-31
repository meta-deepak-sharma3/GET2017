package com.metacube.GuestHouse;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MyHashTableTest {
	MyHashTable<Integer, Integer> hashTable = new MyHashTable<Integer, Integer>();
	
	/**
	 * Initial steps to be performed before every test methods to be executed.
	 * 
	 */
	@Before
	public void setUp() throws Exception {
			
		hashTable.insertValue(1, 23);
		hashTable.insertValue(2, 24);
		hashTable.insertValue(3, 26);
		hashTable.insertValue(4, 28);
		hashTable.insertValue(5, 30);
	}
	
	/**
	 * Test for getValue method of MyHashTable
	 * Positive Test
	 */
	@Test
	public void testPositiveGetValue() {
		int fExpected = 23;
		assertEquals(fExpected, (int)hashTable.getValue(1));
	}
	
	/**
	 * Test for getValue method of MyHashTable
	 * Negative Test
	 */
	@Test
	public void testNegativeGetValue() {
		int fExpected = 24;
		assertNotEquals(fExpected, (int)hashTable.getValue(2));
	}

}
