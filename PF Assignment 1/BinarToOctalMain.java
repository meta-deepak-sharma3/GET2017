/**
 * PF-Session1 Assignment 1
 */

package PF_Session_1;

//import for pow() function
import java.lang.Math;
import java.util.Scanner;

//Main class
public class BinarToOctalMain {
  
	public static void main(String[] args)
  {
		Scanner sc = new Scanner(System.in);
		int number= sc.nextInt();  
		
		System.out.println(String.valueOf(BinaryToOctal.convertBinaryToOctal(number)));
  
  }
  
  
}

class BinaryToOctal{
	/*
	Taking a binary number into the groups of
	4 digit binary number and finding corresponding
	decimal equivalent for it and adding to the overall result
	 */		
	static int convertBinaryToOctal(int n){
		
		int j = 0, result = 0; //result: overall result
		while(n!=0){
			
			int rem = n%1000; //rem : group of 4 binary digit number	
			int i = 0,rem_To_Dec = 0; //rem_To_Dec:decimal equivalent for rem
			
			while(rem!=0){
				
				rem_To_Dec = (rem%10)*(int)Math.pow(2,i)+rem_To_Dec;
				
				rem = rem/10;
				i++;
			}
			
			result = rem_To_Dec*(int)Math.pow(10,j)+result;
			n = n/1000;
			j++;
		}
		
		return result;
	}
	
}