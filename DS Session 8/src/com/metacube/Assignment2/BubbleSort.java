package com.metacube.Assignment2;

/**
 * Class implementing Bubblesort
 * @author Deepak
 *
 */
public class BubbleSort {
	
	/**
	 * sort method for BubbleSort
	 * @param arr input integer array
	 * @return sorted integer array
	 */
	public static int[] sort(int[] arr) {
		// TODO Auto-generated method stub
		int n = arr.length;  
        int temp = 0;  
        for(int i=0; i < n; i++){  
        	for(int j=1; j < (n-i); j++){  
        		if(arr[j-1] > arr[j]){  
        			//swap elements  
        			temp = arr[j-1];  
        			arr[j-1] = arr[j];  
        			arr[j] = temp;  
        		}    
        	}  
        }
        
        return arr;
	}

}
