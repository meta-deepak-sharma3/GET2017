package com.metacube.Assignment2;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 * Utility Class for finding number of unique characters in given string
 * @author Deepak
 *
 */
public class CountUniqueCharacters {
	static Map<String, Integer> charCountMap;
	
	/**
	 * Constructor to initialize the HashMap
	 */
	public CountUniqueCharacters() {
		charCountMap = new HashMap<String, Integer>();
	}
	
	/**
	 * count the number of unique characters in string 
	 * and mapping string with the numberofcounts
	 * @param input
	 * @return
	 */
	public int countUniqueChars(String input) {
		Set<Character> uniqueChars = new HashSet<Character>();
		int length = input.length();
		for(int i=0; i<length; i++) {
			if(Character.isLetter(input.charAt(i))) {
				uniqueChars.add(input.charAt(i));
			}
		}
		return uniqueChars.size();
	}
	
	/**
	 * Main method
	 * @param args
	 */
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		CountUniqueCharacters countUniqueCharacters = new CountUniqueCharacters();
		boolean flag = true;
		do {	
			System.out.println("Enter your valid choice:");
			System.out.println("1: Find the number of occurence of characters for string");
			System.out.println("2: Exit");
			int choice = getIntegerInput(sc);
		
			switch(choice) {
				case 1:
					System.out.println("Enter the input string for which you need to find the number of unique characters");
					String input = sc.next();
					
					System.out.print("The number of unique characters in "+input+" is: ");
					System.out.println(countUniqueCharacters.countUniqueChars(input));
					break;
				case 2:
					flag = false;
					System.out.println("System Exiting");
					break;
				default:
					System.out.println("Choice is not valid..");
					flag = true;
			}
		}while(flag);
		sc.close();
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
