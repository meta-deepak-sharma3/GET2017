package com.metacube.Assignment3;

/**
 * Node class holding next node and element
 * @author Deepak
 *
 * @param <E>
 */
public class Node<E> {

	private E element;
	private Node<E> next;
	
	/**
	 * parameterized Constructor
	 * @param element
	 */
	public Node(E element) {
		this.element = element;
		this.next = null;
	}
	
	/**
	 * get value of the node
	 * @return
	 */
	public E getElement() {
		return element;
	}
	
	/**
	 * set the element in node
	 * @param element
	 */
	public void setElement(E element) {
		this.element = element;
	}
	
	/**
	 * get the next node of current object.
	 * @return
	 */
	public Node<E> getNext() {
		return next;
	}

	/**
	 * set the next node for the current object
	 * @param next
	 */
	public void setNext(Node<E> next) {
		this.next = next;
	}

	/**
	 * String format of the node
	 */
	public String toString(){
		return element.toString();
	}
}
