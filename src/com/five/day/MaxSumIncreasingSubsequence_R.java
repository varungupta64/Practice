package com.five.day;

public class MaxSumIncreasingSubsequence_R {
	static int maxSum = 0;
	
	public static void main(String[] args) {
		int[] arr = {1, 101, 2, 3, 100, 4, 5};
		int n = arr.length;
		msis(arr,n);
		System.out.println(maxSum);
	}

	private static int msis(int[] arr, int n) {
		if(n==1){
			return arr[n-1]; 
		}
		
		int maxSumHere = arr[n-1];
		int res;
		
		for(int i=1;i<n;i++){
			res = msis(arr,i);
			if(arr[n-1]>arr[i-1] && arr[n-1]+res>maxSumHere){
				maxSumHere = arr[n-1] + res;
			}
		}
		
		if(maxSumHere>maxSum){
			maxSum = maxSumHere;
		}
		return maxSumHere;
	}
}
