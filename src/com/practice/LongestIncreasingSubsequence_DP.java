package com.practice;

public class LongestIncreasingSubsequence_DP {
	public static void main(String[] args) {
		int[] arr = new int[] { 10, 22, 9, 33, 21, 50, 41, 60, 80 };
		int max = 0;
		int[] lis = new int[arr.length];
		lis[0] = 1;

		for (int i = 1; i < arr.length; i++) {
			int mxm = arr[i];
			lis[i] = 1;
			int greatest = 1;
			for (int j = i - 1; j >= 0; j--) {
				if (mxm > arr[j]) {
					lis[i] = 1 + lis[j];
				}
				if(lis[i]>greatest){
					greatest = lis[i];
				}
			}
			lis[i] = greatest;
			if (lis[i] > max) {
				max = lis[i];
			}
		}

		System.out.println("Longest Increasing Subsequence is : " + max);
	}
}
