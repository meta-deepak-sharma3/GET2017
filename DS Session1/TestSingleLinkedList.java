package assignment1;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class TestSingleLinkedList {
	
	SingleLinkedList<Integer> linklist;
	@Before
	public void setUp() throws Exception {
		linklist = new SingleLinkedList<Integer>();
	}

	@Test
	public void testAddElement() {
		assertEquals(true, linklist.add(20));
		assertEquals(true, linklist.add(23));
		assertEquals(true, linklist.add(1, 25));
	}
	
	@Test
	public void testRemoveElement() {
		assertEquals(true, linklist.add(20));
		assertEquals(true, linklist.add(23));
		assertEquals(true, linklist.add(2, 25));
		assertEquals(true, linklist.add(24));
		assertEquals(0, linklist.removeByValue(20));
		assertEquals(1, linklist.removeByValue(25));
		assertEquals(24,(int)linklist.remove(1));
	}

	@Test
	public void testsize() {
		assertEquals(true, linklist.add(20));
		assertEquals(true, linklist.add(23));
		assertEquals(true, linklist.add(2, 25));
		
		assertEquals(0, linklist.removeByValue(20));
		assertEquals(1, linklist.removeByValue(25));
		
		assertEquals(1, linklist.size());
	}
	
	@Test
	public void testContains(){
		assertEquals(true, linklist.add(20));
		assertEquals(true, linklist.add(23));
		assertEquals(true, linklist.add(1, 25));
		
		assertEquals(true, linklist.contains(25));
	}

	@Test
	public void testsort(){
		assertEquals(true, linklist.add(30));
		assertEquals(true, linklist.add(23));
		assertEquals(true, linklist.add(25));
		assertEquals(true ,linklist.sort());
		
		assertEquals(23, (int)linklist.getElement(0));
		
		assertEquals(25, (int)linklist.getElement(1));
		
		assertEquals(30, (int)linklist.getElement(2));
	}
	
	@Test
	public void testIsEmpty(){
		assertEquals(true, linklist.add(30));
		assertEquals(true, linklist.add(23));
		assertEquals(0, linklist.removeByValue(30));
		assertEquals(0, linklist.removeByValue(23));
		assertEquals(true, linklist.isEmpty());
		
	}
}
