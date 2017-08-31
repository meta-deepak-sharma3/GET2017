package com.metacube.Assignment2;

/**
 * Class implementing Quick Sort
 * @author Deepak
 *
 */
public class QuickSort {

	 /** 
	  * Quick Sort function 
	  * @param input array
	  * @return sorted array
	  **/
    public static int[] sort(int[] arr)
    {
    	int length = arr.length;
    	
    	if(length == 0)
    		return new int[] {};
    	
        quickSort(arr, 0, length-1);
        return arr;
    }
    
    /**
     * Quicksort implementation
     * @param arr
     * @param low
     * @param high
     */
    public static void quickSort(int arr[], int low, int high) 
    {
        int i = low, j = high;
        int temp;
        int pivot = arr[(low + high) / 2];
 
        /** partition **/
        while (i <= j) 
        {
            while (arr[i] < pivot)
                i++;
            while (arr[j] > pivot)
                j--;
            if (i <= j) 
            {
                /** swap **/
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
 
                i++;
                j--;
            }
        }
 
        /** recursively sort lower half **/
        if (low < j)
            quickSort(arr, low, j);
        /** recursively sort upper half **/
        if (i < high)
            quickSort(arr, i, high);
    }

}
