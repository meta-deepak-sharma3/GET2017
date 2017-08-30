package com.metacube.Assignment1;

/**
 * Generic Class for creation Node 
 * to store in BST
 * @author Deepak
 *
 * @param <E>
 */
public class Node<E> {

	private E element;
	private Node<E> left;
	private Node<E> right;
	
	/**
	 * Parameterized Constructor
	 * @param element
	 */
	public Node(E element) {
		this.element = element;
		this.left = null;
		this.right = null;
	}
	
	/**
	 * get the value of the node
	 * @return
	 */
	public E getElement() {
		return element;
	}
	
	/**
	 * get the right node of the current node
	 * @return
	 */
	public Node<E> getRight() {
		return right;
	}
	
	/**
	 * set the right node for the current node.
	 * @param right
	 */
	public void setRight(Node<E> right) {
		this.right = right;
	}
	
	/**
	 * get the left node of the current node.
	 * @return
	 */
	public Node<E> getLeft() {
		return left;
	}
	
	/**
	 * set the left node for current Node
	 * @param left
	 */
	public void setLeft(Node<E> left) {
		this.left = left;
	}
	
	/**
	 * overriding the toString method of Object Class.
	 */
	public String toString(){
		return element.toString();
	}
}
