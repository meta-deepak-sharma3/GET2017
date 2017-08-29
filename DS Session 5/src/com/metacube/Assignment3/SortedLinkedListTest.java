package com.metacube.Assignment3;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * Test class for SortedLinkedList
 * @author Deepak
 *
 */
public class SortedLinkedListTest {
	SortedLinkedList sortedLinkedList;
	@Before
	public void setUp() throws Exception {
		sortedLinkedList = new SortedLinkedList();
	}

	@Test
	public void testSortedLinkedList() {
		Node<Integer> newNode1 = new Node<Integer>(2);
		Node<Integer> newNode2 = new Node<Integer>(1);
		Node<Integer> newNode3 = new Node<Integer>(4);
		Node<Integer> newNode4 = new Node<Integer>(6);
		
		sortedLinkedList.insert(sortedLinkedList.getHead(), newNode1);
		sortedLinkedList.insert(sortedLinkedList.getHead(), newNode2);
		sortedLinkedList.insert(sortedLinkedList.getHead(), newNode3);
		sortedLinkedList.insert(sortedLinkedList.getHead(), newNode4);
		
		assertEquals(2, (int)sortedLinkedList.getHead().getElement());
		
	}

}
