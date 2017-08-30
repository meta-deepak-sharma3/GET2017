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
	*insertion of node n sorted linkedlist
	* @param newNode
	*/
	public void insert(Node<Integer> newNode){
		this.head = insertRec(this.getHead(), newNode);
	}
	
	/**
	 * insertion of node with recursion method.
	 * @param currentNode
	 * @param newNode
	 */
	public Node<Integer> insertRec(Node<Integer> currentNode, Node<Integer> newNode) {
		if ( ( currentNode == null ) || !( currentNode.getElement() < newNode.getElement())){
        		newNode.setNext(currentNode);
			return newNode;
    		}
		
    		currentNode.setNext(insertRec( currentNode.getNext(), newNode));
    		return currentNode;
	}
	
	/**
	 * @return: head of the linkedlist
	 */
	public Node<Integer> getHead(){
		return head;
	}
	
	/**
	 * @return: last of the linkedlist
	 */
	public Node<Integer> getLast(){
		if(head == null)
			return null;
		Node<Integer> temp = head;
		while(temp.getNext()!=null){
			temp = temp.getNext();
		}
		return temp;
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
