/**
 *  PF-Session1 Assignment1
 */

package PF_Session_1;

import java.util.Arrays;
import java.util.Scanner;

//Main Class
public class LongestSequence_Main { 
	
	//main method
	public static void main(String args[])
	{

		int[] arr = new int[25];
		
		Scanner sc = new Scanner(System.in);
		
		for (int i=0;i<arr.length;i++){
			
			try{			
				System.out.println("Enter the element");
				arr[i] = sc.nextInt();

			}catch(InputMisMatchException e){
				System.out.println('Input Error: '+e.getMessage());

			}
			
			
		}
		
		 int results[] = LongestSequence.longestSequence(arr); //results will hold the longest sequence

		for(int i=0;i<results.length;i++){
			
			System.out.print(String.valueOf(results[i])+" ");
			
			
		}
		
	}

}

class LongestSequence{
	
	//method to return LongestSequence from the input
	 public static int[] longestSequence(int input[])
	 {
		 int start = 0, next = 1, length = 0; 
		 int index_Start=start, index_End=next;
		 
		 while(next<input.length){
			
			 if(input[next]<=input[next-1]){
				 
				 start = next;
				 next = next+1; 
			 }
			 
			 else{
			
				 if (next-start+1>length){
					 index_Start = start;
					 index_End = next;
					length = next-start+1;
					 
				 	}		 			

			 next++;
			 }
			
		 }
		 
		 return Arrays.copyOfRange(input, index_Start, index_End+1); // to get a part of aray input.
		 
	 }

}
