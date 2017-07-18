package Assignments;

import java.util.Scanner;

/*class for linear search*/
public class LinearSearch{
	int len , key , k;
	Scanner sc = new Scanner(System.in);
	int[] input;
	
	public LinearSearch() {
		// TODO Auto-generated constructor stub
	}
	
	LinearSearch(int t) {
		int i;
		System.out.print("Enter length of input array");
		len = sc.nextInt();
		input = new int[len];
		System.out.print("Enter elements of input array");
		for(i=0;i<len;i++){
			input[i] = sc.nextInt();			//taking input 
		} 
		System.out.print("Enter number you wish to search");
		key = sc.nextInt();
		k = search(input , 0 , key);
                System.out.println("Number found on index " + (k+1));
	}
	
	/*function used for searching number in array*/
	public int search(int[] input, int pos, int key) {
//		System.out.print(pos);
//		System.out.println(input.length);
		if(pos >= input.length) {
			System.out.println("Number not found");
			return -1;						//if number not found
		}
		if(input[pos]==key){
		//System.out.print("Number found on index" + (pos+1));
		return pos;
		}
		return search(input , ++pos , key);				//calling function recursively
	}
	
}
