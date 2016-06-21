package com.five.day;

public class LongestIncreasingSubsequence_R {

	static int max = 1;
	
	public static void main(String[] args) {
		int[] arr = { 10, 22, 9, 33, 21, 50, 41, 60, 80 } ;
		int n = arr.length;
		int partial = lis(arr,n);
		System.out.println(max);
	}

	private static int lis(int[] arr, int n) {
		if(n <= 1){
			return 1;
		}
		
		int maxHere = Integer.MIN_VALUE;
		int res;
		
		for(int i=1;i<n;i++){
			res = 1 + lis(arr, i);
			if(arr[n-1]>arr[i-1] && res>maxHere){
				maxHere = res;
			}
		}
		
		if(maxHere > max){
			max = maxHere;
		}
		
		return maxHere;
	}

}
