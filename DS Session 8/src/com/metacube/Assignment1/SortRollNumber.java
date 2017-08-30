package com.metacube.Assignment1;

import java.util.Scanner;

/**
 * Main class for assigning the 
 * roll number list to BST
 * and calling the BST in INORDER format.
 * @author Deepak
 *
 */
public class SortRollNumber {
	
	/**
	 * Main method.
	 * @param args
	 */
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		BinarySearchTree bst = new BinarySearchTree();
		System.out.println("Enter the number of students: ");
		int numberOfStudents = getIntegerInput(sc);
		int[] rollNumberList = new int[numberOfStudents];
		System.out.println("Enter the disorderly roll number for "+numberOfStudents+" Students: ");
		
		for(int i=0;i<numberOfStudents;i++) {
			System.out.println("Enter the roll number for student "+(i+1));
			rollNumberList[i] = getIntegerInput(sc);
		}
		
		// Before Sorting
		System.out.println("Before Sorting...");
		System.out.print("[ ");
		for(int i=0;i<numberOfStudents;i++) {
			System.out.print(rollNumberList[i]+" ");
		}
		System.out.println("]");
		
		// Adding the array elements into BST.
		for(int i=0;i<numberOfStudents;i++) {
			bst.addNode(rollNumberList[i]);
		}
		
		/* Printing the BST in INORDER format
		*i.e sorting the array in increasing order;
		*/
		System.out.println("After Sorting....");
		System.out.print("[ ");
		bst.inOrder(bst.getRoot());
		System.out.println("]");
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
				flag = true;
			}
			catch(Exception e)
			{
				System.out.println("Please enter valid input");
				scan.next();
				flag = false;
			}
		}while(!flag || number<=0);
		return number;
	}

}
