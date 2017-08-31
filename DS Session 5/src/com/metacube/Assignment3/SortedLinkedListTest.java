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
	
	/**
	* Test method to test the head of the linkedlist
	*/
	@Test
	public void testGetHead() {
		Node<Integer> newNode1 = new Node<Integer>(2);
		Node<Integer> newNode2 = new Node<Integer>(1);
		Node<Integer> newNode3 = new Node<Integer>(4);
		Node<Integer> newNode4 = new Node<Integer>(6);
		
		sortedLinkedList.insert(newNode1);
		sortedLinkedList.insert(newNode2);
		sortedLinkedList.insert(newNode3);
		sortedLinkedList.insert(newNode4);
		
		assertEquals(1, (int)sortedLinkedList.getHead().getElement());
		
	}
	
	/**
	* Test method to test the last of the linkedlist
	*/
	@Test
	public void testGetLast() {
		Node<Integer> newNode1 = new Node<Integer>(2);
		Node<Integer> newNode2 = new Node<Integer>(1);
		Node<Integer> newNode3 = new Node<Integer>(4);
		Node<Integer> newNode4 = new Node<Integer>(6);
		
		sortedLinkedList.insert(newNode1);
		sortedLinkedList.insert(newNode2);
		sortedLinkedList.insert(newNode3);
		sortedLinkedList.insert(newNode4);
		
		assertEquals(6, (int)sortedLinkedList.getLast().getElement());
		
	}
	
	/**
	* Test method to test the third element of the linkedlist
	*/
	@Test
	public void testGetThirdNode() {
		Node<Integer> newNode1 = new Node<Integer>(2);
		Node<Integer> newNode2 = new Node<Integer>(1);
		Node<Integer> newNode3 = new Node<Integer>(4);
		Node<Integer> newNode4 = new Node<Integer>(6);
		
		sortedLinkedList.insert(newNode1);
		sortedLinkedList.insert(newNode2);
		sortedLinkedList.insert(newNode3);
		sortedLinkedList.insert(newNode4);
		
		assertEquals(4, (int)sortedLinkedList.getHead().getNext().getNext().getElement());
		
	}

}
