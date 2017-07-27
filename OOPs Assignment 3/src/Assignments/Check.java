package Assignments;

public class Check {
	public static boolean contains(int[] arr, int key){
		for(int i=0;i<arr.length;i++){
			if(arr[i]==key){
				return true;
			}
			
		}
		return false;
	}
}
