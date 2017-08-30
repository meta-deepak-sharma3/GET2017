package com.metacube.Assignment1;

/**
 * class for handling BST Operations and 
 * using it for insertion of array elements
 * @author Deepak
 *
 */
public class BinarySearchTree {
	private Node<Integer> root;
	
	/**
	 * Constructor for initializing the members
	 */
	public BinarySearchTree() {
		root = null;
	}
	
	/**
	 * method to add element of array in bst at leaf
	 * @param value
	 */
	public void addNode(int value) {
		this.root = addRec(this.getRoot(), value);
	}
	
	/**
	 * adds the new new value to BST 
	 * and returns the root of the BST
	 * after insertion
	 * @param currentNode
	 * @param value
	 * @return
	 */
	private Node<Integer> addRec(Node<Integer> currentNode, int value) {
		// TODO Auto-generated method stub
		if(currentNode == null) {
			this.root = new Node<Integer>(value);
			return this.getRoot();
		}
		
		if(currentNode.getElement()>value) {
			currentNode.setLeft(addRec(currentNode.getLeft(), value));
		}else {
			currentNode.setRight(addRec(currentNode.getRight(), value));
		}
		return currentNode;
	}

	/**
	 * get root of the BST
	 * @return
	 */
	public Node<Integer> getRoot(){
		return this.root;
	}
	
	/**
	 * to print the BST in INORDER format
	 * @param currentNode
	 */
	public void inOrder(Node<Integer> currentNode) {
		if(currentNode == null) {
			return;
		}
		
		inOrder(currentNode.getLeft());
		System.out.print(currentNode.getElement()+" ");
		inOrder(currentNode.getRight());
	}
	
	/**
	 * returns the left most node of the 
	 * bst from where the INORDER printing starts
	 * @return
	 */
	public Node<Integer> getLeftMostNode() {
		// TODO Auto-generated method stub
		Node<Integer> temp = this.getRoot();
		while(temp.getLeft()!=null) {
			temp = temp.getLeft();
		}
		return temp;
	}
}
