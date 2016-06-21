package com.five.day;

//// A Naive recursive solution for Rod cutting problem
public class RodCutting
{
         // A utility function to get the maximum of two integers
     static int max(int a, int b) { return (a > b)? a : b;}
       
     /* Returns the best obtainable price for a rod of length n and
        price[] as prices of different pieces */
     static int cutRod(int price[], int n)
     {
        if (n <= 0)
          return 0;
        int max_val = Integer.MIN_VALUE;
       
        // Recursively cut the rod in different pieces and compare different 
        // configurations
        for (int i = 0; i<n; i++)
              max_val = max(max_val, price[i] + cutRod(price, n-i-1));
       
        return max_val;
     }
       
     /* Driver program to test above functions */
     public static void main(String args[])
     {
         int arr[] = new int[]{1, 5, 8, 9, 10, 17, 17, 20};
         int size = arr.length;
         System.out.println("Maximum Obtainable Value is "+ cutRod(arr, size));
              
     }
}
