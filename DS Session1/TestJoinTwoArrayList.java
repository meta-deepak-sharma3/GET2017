package assignment1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestJoinTwoArrayList {
	
	JoinTwoArrayList<Integer> list1;
	ArrayList<Integer> list2;
	@Before
	public void setUp() throws Exception {
		list1 = new JoinTwoArrayList<Integer>();
		list2 = new ArrayList<Integer>();
		
	}

	@Test
	public void test() {
		list1.add(20);
		list1.add(21);
		list1.add(22);
		list2.add(30);
		list2.add(31);
		list2.add(32);
		list1.joinTwoArrayList(list1, list2);
		int[] expected = {20,21,22,30,31,32};
		assertEquals(expected[0], (int)list1.getElement(0));
		assertEquals(expected[1], (int)list1.getElement(1));
		assertEquals(expected[2], (int)list1.getElement(2));
		assertEquals(expected[3], (int)list1.getElement(3));
		assertEquals(expected[4], (int)list1.getElement(4));
		assertEquals(expected[5], (int)list1.getElement(5));
	}

}
