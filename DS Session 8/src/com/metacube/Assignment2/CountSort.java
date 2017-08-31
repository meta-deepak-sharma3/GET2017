package com.metacube.Assignment2;

/**
 * Class implementing Counting Sort.
 * @author Deepak
 *
 */
public class CountSort {

	public static int N = 20;
    public static int[] sequence = new int[N];
    private static final int MAX_RANGE = 1000000;
    
    /**
     * sort method for Counting sort
     * @param arr input integer array
     * @return sorted integer array
     */
    public static int[] sort(int[] arr) 
    {
        int N = arr.length;
        if (N == 0)
            return new int[] {};
        
        int max = arr[0], min = arr[0];
        for (int i = 1; i < N; i++) 
        {
            if (arr[i] > max)
                max = arr[i];
            if (arr[i] < min)
                min = arr[i];
        }
        int range = max - min + 1;
 
        if (range > MAX_RANGE) 
        {
            System.out.println("\nError : Range too large for sort");
            return null;
        }
 
        int[] count = new int[range];
        for (int i = 0; i < N; i++)
            count[arr[i] - min]++;
        for (int i = 1; i < range; i++)
            count[i] += count[i - 1];
        int j = 0;
        for (int i = 0; i < range; i++)
            while (j < count[i])
                arr[j++] = i + min;
        
        return arr;
    }

}