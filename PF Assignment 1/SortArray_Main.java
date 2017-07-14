package PF_Session_1;

public class SortArray_Main {

	public static void main (String args[]) {
		int a[] = new int[]{2,5,7,9,12} , b[] = new int[] {1,2,4,5,7,11,12} , c[] = new int[25];
		SortArray sa = new SortArray();
		sa.sortArray(a,b,c);
	}  
	
}

class SortArray {
	
	int i =0, j =0, k;
	 int[] sortArray (int a[] , int b[] , int c[]) {
		 
		 for (k=0;k!=(a.length + b.length);k++) {
			 			 
			 if (a[i] == b[j]) {
				 c[k] = a[i];
				k++;
				c[k] = b[j];
				 
				 if(i<a.length-1 && j<b.length-1 ) {
				 i++;
				 j++;
				 }
				 
				 else {
					 i++;
					 j++;
					 break;
				 }
			 }
			 else if(a[i] < b[j]) {		
				 if(i<a.length) {
				 c[k] = a[i];
				 i++;
				 }
			 }
			 else {
				 
				 if(j<b.length) {
					 c[k] = b[j];
					 j++;
					 }
			 }
			 

			 if (i==a.length && j == b.length){
				 break;
			 }
			 
			 
			 
		 }
		 
		 for (k=0;k<(a.length + b.length);k++){
			 System.out.print(c[k]);
		 }
		 
		 
		 return c;
	 }
}