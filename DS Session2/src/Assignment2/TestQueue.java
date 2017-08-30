package Assignment2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestQueue {
	Queue<Integer> queue;
	
	@Before
	public void setUp() throws Exception {
		queue = new Queue<Integer>();
		
	}
	
	@Test
	public void testDequeue() {
		for(int i =1;i<=5;i++) {
			queue.enqueue(i);
		}
		
		int fExpected = 1;
		assertEquals(fExpected, (int)queue.dequeue());
	}
	
	@Test
	public void testGetFront() {
		queue.makeEmpty();
		
		for(int i =1;i<=5;i++) {
			queue.enqueue(i);
		}
		
		int fExpected = 1;
		assertEquals(fExpected, (int)queue.getFront());
	}
	
	@Test
	public void testSize()
	{
	
		int fExpected = 0;
		assertEquals(fExpected, queue.size());
	}
	
}
