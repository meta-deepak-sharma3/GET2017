/**
 * 
 *  PF-Session1 Assignment1
 *  
 *  
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
			System.out.println("Enter the element");
			arr[i] = sc.nextInt();
			
			
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
		 /*
			index_start --> start index for longest 			sequence
			
			index_end --> end index for longest 				sequence
			
			length --> length of the longest sequence.


		*/
		 int start = 0, next = 1, length = 0;
		 
		 int index_start=start, index_end=next;
		 
		 while(next<input.length){
			
			
			 
			 if(input[next]<=input[next-1]){
				 
				
				 
				 start = next;
				 next = next+1;
				 
			 }
			 else{
			
			if (next-start+1>length){
					 index_start = start;
					 index_end = next;
					length = next-start+1;
					 
			}	 			

			 next++;
			 }
			
		 }
		 
		 return Arrays.copyOfRange(input, index_start, 				index_end+1); // to get a part of aray input.
		 
	 }

	
	
	
}