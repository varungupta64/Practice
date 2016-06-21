package com.five.day;

import java.util.Arrays;

public class Bitonic_DP {
	public static void main(String[] args) {
		int[] arr = new int[]{1, 3,5,7,6,4,2};
		int len = arr.length;
		System.out.println(bitonic(arr,len));
	}
	
	private static int bitonic(int[] a, int n) {
		int[] lis = new int[n];
		int[] lds = new int[n];
		
		Arrays.fill(lis, 1);
		Arrays.fill(lds, 1);
		
		for(int i=1;i<n;i++){
			for(int j=0;j<i;j++){
				if(a[i]>a[j] && 1+lis[j]>lis[i]){
					lis[i] = 1 + lis[j];
				}
			}
		}
		
		for(int i=n-2;i>=0;i--){
			for(int j=n-1;j>i;j--){
				if(a[i]>a[j] && lds[j]+1>lds[i]){
					lds[i] = lds[j] + 1;
				}
			}
		}
		
		int max = Integer.MIN_VALUE;
		int res;
		
		for(int i=0;i<n;i++){
			res = lis[i] + lds[i];
			if(res > max){
				max = res - 1;
			}
		}
		
		return max;
	}
	
	
}
