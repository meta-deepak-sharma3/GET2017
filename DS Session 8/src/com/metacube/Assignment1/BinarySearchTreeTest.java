package com.metacube.Assignment1;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Test class to test the methods of
 * BST
 * @author Deepak
 *
 */
public class BinarySearchTreeTest {
	
	/**
	 * test method for checking the BST is empty or not
	 */
	@Test
	public void testEmptyBinarySearchTree() {
		BinarySearchTree bst = new BinarySearchTree();
		Node<Integer> root = null;
		assertEquals(root, bst.getRoot());
	}
	
	/**
	 * Test method for testing non empty BST
	 * and testing for left most Node in BST
	 * i.e the smallest value in the array
	 */
	@Test
	public void testNonEmptyBinarySearchTree() {
		BinarySearchTree bst = new BinarySearchTree();
		bst.addNode(15);
		bst.addNode(2);
		bst.addNode(16);
		bst.addNode(6);
		bst.addNode(22);
		bst.addNode(1);
		bst.addNode(14);
		bst.addNode(20);
		
		int rootValueExpected = 15;
		int leftMostValueExpected = 1;
		
		assertEquals(rootValueExpected, (int)bst.getRoot().getElement());
		assertEquals(leftMostValueExpected, (int)bst.getLeftMostNode().getElement());
	}

}
