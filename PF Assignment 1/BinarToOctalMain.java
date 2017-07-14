

/**
 * PF-Session1 Assignment 1
 * 
 * 
 * 
 */

package PF_Session_1;

//import for pow() function
import java.lang.Math;

//Main class
public class BinarToOctalMain {
  

	
	public static void main(String[] args)
  {
	  int number=110101;
	  
	  System.out.println(String.valueOf(BinaryToOctal.convertBinaryToOctal(number)));
  
  }
  
  
}

class BinaryToOctal{
	
static int convertBinaryToOctal(int n){
		/*
			Taking a binary number into the groups of
			4 digit binary number and finding corresponding
			decimal equivalent for it and adding to the 				overall result
		*/		


		int j = 0, result = 0; //result: overall result
		while(n!=0){
			
			int rem = n%1000; //rem : group of 4 binary 							digit number
			
			int i = 0,rem_to_dec = 0; //rem_to_dec:decimal 							equivalent for rem
			
			while(rem!=0){
				
				rem_to_dec = (rem%10)*(int)Math.pow(2,i)+rem_to_dec;
				
				rem = rem/10;
				i++;
			}
			
			result = rem_to_dec*(int)Math.pow(10,j)+result;
			n = n/1000;
			j++;
		}
		
		return result;
	}

	
	
}