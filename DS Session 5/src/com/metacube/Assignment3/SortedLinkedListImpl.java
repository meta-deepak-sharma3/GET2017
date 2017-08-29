package com.metacube.Assignment3;

import java.util.Scanner;

/**
 * Utility class to implement the SortedLinkedList class
 * @author Deepak
 *
 */
public class SortedLinkedListImpl {
	/**
	 * main method
	 * @param args
	 */
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		SortedLinkedList sortedLinkedList = new SortedLinkedList();
		boolean flag = true;
		do {	
			System.out.println("Enter your valid choice:");
			System.out.println("1: Add element to Sorted Linked List");
			System.out.println("2: Print the Sorted Linked List");
			System.out.println("3: Exit");
			int choice = getIntegerInput(sc);
		
			switch(choice) {
				case 1:
					int element = getIntegerInput(sc);
					Node<Integer> newNode = new Node<Integer>(element);
					sortedLinkedList.insert(sortedLinkedList.getHead(), newNode);
					break;
				case 2:
					sortedLinkedList.printLinkedList();
					break;
				case 3:
					flag = false;
					System.out.println("System Exiting");
					break;
				default:
					flag = true;
			}
		}while(flag);
		
	}

	/**
	 * getting integer input from the user
	 * @return integer value.
	 */
	private static int getIntegerInput(Scanner scan) {
		boolean flag = true;
		int number=-1;
		
		do {
			try{
				number = scan.nextInt();
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
				System.out.println("Please enter valid input");
				flag = false;
			}
		}while(!flag || number<=0);
		return number;
	}

}
