/**
 * 
 * PF-Session1	
	Assignment5
 * 
 */

package PF_Session_1;

//Main Class
public class SortedArray_Main {
	
	
	public static void main(String[] args){
		
		//input array		
		int[] arr = {1,2,3,4,5};
		
		
		int result = SortedArray.sortedArray(arr);	
		
		System.out.println(String.valueOf(result));
			
		}
		
		
		
	}


class SortedArray{
	
	//method definition for Sorting Type
	public static int sortedArray(int[] input){
		
		if (isAscending(input)){
			
			return 1;
		}
		else if(isDescending(input)){
			
			return 2;
			
			
		}
		else{
			return 0;
		}
		
	}
	
	static boolean isAscending(int[] arr){
		
		for (int i=0;i<arr.length-1;i++){
			
			if(arr[i+1]<arr[i]){
				
				return false;
				
			}
		}
		
		return true;
	}
	
	static boolean isDescending(int[] arr){
		
		for (int i=0;i<arr.length-1;i++){
			
			if(arr[i+1]>arr[i]){
				
				return false;
				
			}
		}
		
		return true;
	}
	
}