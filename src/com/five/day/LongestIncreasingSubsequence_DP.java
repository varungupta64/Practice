package com.five.day;

public class LongestIncreasingSubsequence_DP {

	static int max = 1;
	
	public static void main(String[] args) {
		int[] arr = { 10, 22, 9, 33, 21, 50, 41, 60, 80 } ;
		int n = arr.length;
		int[] result = new int[n];
		for(int i=0;i<n;i++){
			result[i] = 1;
		}
		lis(arr,n,result);
		System.out.println(max);
	}

	private static void lis(int[] arr, int n, int[] result) {
		for(int i=1;i<n;i++){
			for(int j=0;j<i;j++){
				if(arr[i]>arr[j] && result[i]<result[j]+1){
					result[i] = 1 + result[j];
				}
			}
			if(result[i]>max){
				max = result[i];
			}
		}
	}

}
