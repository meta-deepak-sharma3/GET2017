package assignment1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestArrayList {
	
	ArrayList<Integer> arraylist;
	@Before
	public void setUp() throws Exception {
		 arraylist = new ArrayList<Integer>();
	}

	@Test
	public void testAddElement() {
		assertEquals(true, arraylist.add(20));
		assertEquals(true, arraylist.add(23));
		assertEquals(true, arraylist.add(1, 25));
	}
	
	@Test
	public void testRemoveElement() {
		assertEquals(true, arraylist.add(20));
		assertEquals(true, arraylist.add(23));
		assertEquals(true, arraylist.add(2, 25));
		
		assertEquals(0, arraylist.removeByValue(20));
		assertEquals(1, arraylist.removeByValue(25));
		assertEquals(23,(int)arraylist.remove(0));
	}

	@Test
	public void testsize() {
		assertEquals(true, arraylist.add(20));
		assertEquals(true, arraylist.add(23));
		assertEquals(true, arraylist.add(2, 25));
		
		assertEquals(0, arraylist.removeByValue(20));
		assertEquals(1, arraylist.removeByValue(25));
		
		assertEquals(1, arraylist.size());
	}
	
	@Test
	public void testContains(){
		assertEquals(true, arraylist.add(20));
		assertEquals(true, arraylist.add(23));
		assertEquals(true, arraylist.add(2, 25));
		
		assertEquals(true, arraylist.contains(25));
	}
	
	@Test
	public void testsort(){
		assertEquals(true, arraylist.add(30));
		assertEquals(true, arraylist.add(23));
		assertEquals(true, arraylist.add(2, 25));
		arraylist.sort();
		assertEquals(23, (int)arraylist.getElement(0));
		assertEquals(25, (int)arraylist.getElement(1));
		assertEquals(30, (int)arraylist.getElement(2));
		
	}

}
