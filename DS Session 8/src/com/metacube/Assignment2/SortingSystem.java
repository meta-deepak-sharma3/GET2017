package com.metacube.Assignment2;

import java.util.Scanner;

/**
 * Main Class implementing Sorting System
 * @author Deepak
 *
 */
public class SortingSystem {
	
	/**
	 * Main Method
	 * @param args
	 */
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome to the Sorting System...");
		
		int numberOfElements = 0;
		int[] numbers = new int[numberOfElements];
	
		boolean flag = true;
		do {
			System.out.println("1: For New Integer array");
			System.out.println("2: For Comparison Sort");
			System.out.println("3: For Linear Sort");
			System.out.println("4: For Printing the array");
			System.out.println("5: For Exit");
			System.out.println("Enter your choice: ");
			int choice = getIntegerInput(sc);
			
			switch(choice) {
			case 1:
				System.out.println("Enter the number of integer elements:");
				numberOfElements = getIntegerInput(sc);
				numbers = new int[numberOfElements];
				
				//Enter the integer elements for the numbers
				for(int i=0; i<numberOfElements; i++) {
					System.out.println("Enter the "+(i+1)+" element: ");
					numbers[i] = getIntegerInput(sc);
				}
				break;
			case 2:
				// BubbleSort or QuickSort
				if(numbers.length <=10) {
					System.out.println("Bubble Sort taking place...");
					numbers = BubbleSort.sort(numbers);
				}
				else {
					System.out.println("Quicksort Sort taking place...");
					numbers = QuickSort.sort(numbers);
				}
				break;
			
			case 3:
				//CountSort or RadixSort
				int max = max(numbers);
				int maxElementDigits = countNumberOfDigits(max);
				
				if(maxElementDigits >= 3) {
					System.out.println("RadixSort taking place....");
					numbers = RadixSort.sort(numbers);
				
				}else {
					System.out.println("QuickSort taking place.....");
					numbers = CountSort.sort(numbers);
				}
				break;
				
			case 4:
				System.out.println("The updated array is: ");
				printArray(numbers);
				break;
				
			case 5:
				flag = false;
				System.out.println("System.exiting");
				System.exit(0);
				break;
				
			default:
				System.out.println("Enter a valid choice: ");
				flag = true;
			}
		}while(flag);
	}
	
	/**
	 * Utility method to print the array
	 * @param numbers
	 */
	private static void printArray(int[] numbers) {
		// TODO Auto-generated method stub
		int length = numbers.length;
		System.out.println();
		for(int i=0; i<length; i++) {
			System.out.print(numbers[i]+" ");
		}
		
		System.out.println();
	}
	
	/**
	 * utility method to find the number of digits 
	 * in a number
	 * @param number
	 * @return
	 */
	private static int countNumberOfDigits(int number) {
		// TODO Auto-generated method stub
		int count = 0;
		while(number > 0) {
			count +=1;
			number /= 10;
		}
		return count;
	}
	
	/**
	 * utility method to find the maximum
	 * in the give input array
	 * @param numbers input integer array
	 * @return
	 */
	private static int max(int[] numbers) {
		// TODO Auto-generated method stub
		int length = numbers.length;
		int max = numbers[0];
		
		for(int i=1; i<length; i++) {
			if(numbers[i] > max) {
				max = numbers[i];
			}
		}
		
		return max;
	}

	/**
     * get the integer input from the user
     * @param scan
     * @return
     */
    private static int getIntegerInput(Scanner scan) {
		// TODO Auto-generated method stub
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
