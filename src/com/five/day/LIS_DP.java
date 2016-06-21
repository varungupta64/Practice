package com.five.day;

public class LIS_DP {

	public static void main(String[] args) {
		int arr[] = { 10, 8, 9, 33, 21, 50, 41, 20 ,80};
        int n = arr.length;
        
        System.out.println(lis(arr,n));
	}

	private static int lis(int[] arr, int n) {
		int max = 1;
		int index = 0;
		for(int i=1;i<n;i++){
			if(arr[i] > arr[index]){
				max++;
			}
			index = i;
		}
		return max;
	}

}
