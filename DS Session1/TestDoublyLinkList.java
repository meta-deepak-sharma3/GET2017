package assignment1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestDoublyLinkList {
	DoublyLinkList<Integer> dlist;
	@Before
	public void setUp() throws Exception {
		dlist = new DoublyLinkList<Integer>();
	}

	@Test
	public void testAdd() {
		assertEquals(true, dlist.add(20));
		assertEquals(true, dlist.add(21));
		assertEquals(true, dlist.add(0, 22));
	}
	
	@Test
	public void testContains(){
		assertEquals(true, dlist.add(20));
		assertEquals(true, dlist.add(21));
		assertEquals(true, dlist.add(0, 22));
		assertEquals(true, dlist.contains(22));
	}
	
	@Test
	public void testSize(){
		assertEquals(true, dlist.add(20));
		assertEquals(true, dlist.add(21));
		assertEquals(true, dlist.add(0, 22));
		assertEquals(3, dlist.size());
	}
	
	@Test
	public void testRemove(){
		assertEquals(true, dlist.add(20));
		assertEquals(true, dlist.add(21));
		assertEquals(true, dlist.add(0, 22));
		
		assertEquals(0, dlist.removeByValue(22));
		assertEquals(21, (int)dlist.remove(1));
	}
	
	@Test
	public void testReverse(){
		assertEquals(true, dlist.add(20));
		assertEquals(true, dlist.add(21));
		assertEquals(true, dlist.add(0, 22));
		dlist.reverse();
		assertEquals(22, (int)dlist.getElement(2));
		assertEquals(20, (int)dlist.getElement(1));
		assertEquals(21, (int)dlist.getElement(0));
	}
}
