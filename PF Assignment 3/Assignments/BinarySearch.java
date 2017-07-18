package Assignments;

import java.util.Arrays;
import java.util.Scanner;

public class BinarySearch {
	int len , key;
	Scanner sc = new Scanner(System.in);
	int[] input;
	
	
	public BinarySearch(int w) {
		int i, k;
		System.out.print("Enter length of input array");
		len = sc.nextInt();
		input = new int[len];
		System.out.print("Enter elements of input array");
		for(i=0;i<len;i++){
			input[i] = sc.nextInt();			//taking input 
		} 
		System.out.print("Enter number you wish to search");
		key = sc.nextInt();
		
		if(isSorted(input)) {
			k = search(input , 0 , len, key);
                        if(k== -1){
                            System.out.println("Number does not exist in input array");
                        }
                        System.out.println("Position :" + k);
		}
		else {
			Arrays.sort(input);
			System.out.println("Sorting Input Array");
			for(int a=0;a<input.length;a++){
				System.out.println(input[a]);
            }
			k = search(input , 0 , len , key);
            if(k== -1){
            	System.out.println("Number does not exist in input array");
            }
            System.out.println("Position :" + (k+1));
		}
						
	}
	
	public BinarySearch() {
		
	}
	
	public Boolean isSorted(int[] input){
		Boolean flag= true;
		
        for (int i=0;i<input.length-1;i++){
        	if(input[i+1]<input[i]){
        		return false;
        	}
		}
		return true;
	}
        
    public int search(int[] input , int start , int end , int key){
        int mid = (start + end)/2;
        
        if(end<start){
        	return -1;
        }
        if(input[mid] == key){
            return mid;
        }
        
        if(input[mid]>key){
            return search(input, start, mid-1, key);
        }
        
        if(input[mid]<key){
            return search(input, mid+1, end, key);
        }
        return -1;
    }
}
