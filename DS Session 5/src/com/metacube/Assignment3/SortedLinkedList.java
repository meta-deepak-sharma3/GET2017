package com.metacube.Assignment3;

/**
 * Implemetation of SortedLinkedList.
 */
public class SortedLinkedList {
	private Node<Integer> head;
	
	/**
	 * overriding default constructor
	 */
	public SortedLinkedList() {
		head = null;
	}
	
	/**
	 * insertion of node with recursion method.
	 * @param currentNode
	 * @param newNode
	 */
	public void insert(Node<Integer> currentNode, Node<Integer> newNode) {
		Node<Integer> temp = currentNode;
		if(temp == null) {
			newNode.setNext(temp);
			head = newNode;
		}else if(temp.getNext() == null || temp.getNext().getElement() >= newNode.getElement()) {
			newNode.setNext(temp.getNext());
			temp.setNext(newNode);
		}else {
			insert(temp.getNext(), newNode);
		}
	}
	
	/**
	 * @return: head of the linkedlist
	 */
	public Node<Integer> getHead(){
		return head;
	}
	
	/**
	 * printing the linked list starting from the head
	 *  till the end
	 */
	public void printLinkedList() {
		Node<Integer> temp = head;
		System.out.println();
		if(temp != null) {
			while(temp.getNext()!=null) {
				System.out.println(temp.getElement()+"-->");
				temp = temp.getNext();
			}
			System.out.print(temp.getElement());
		}
	}
}
