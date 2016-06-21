package com.practice;

public class LongestIncreasingSubsequence_Recursive {
	static int maxLis = 0;
	
	public static void main(String[] args) {
		int arr[] = { 10, 22, 9, 33, 21, 50, 41, 60 };
        int n = arr.length;
        System.out.println("Length of lis is "
                           + lis(arr, n) + "\n");
	}

	private static int lis(int[] arr, int n) {
		maxLis = 1;
		
		_lis(arr,n);
		
		return maxLis;
	}
	
	private static int _lis(int[] arr, int n){
		if(n==1){
			return 1;
		}
		
		int res,maxEndHere = 1;
		
		
		return 0;
	}
}
