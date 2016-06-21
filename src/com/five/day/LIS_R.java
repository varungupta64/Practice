package com.five.day;

public class LIS_R {

	static int maxRef = 1;
	
	public static void main(String[] args) {
		int arr[] = { 10, 8, 9, 33, 21, 50, 41, 20 ,80};
        int n = arr.length;
        
        System.out.println(lis(arr,n));
	}

	private static int lis(int[] arr, int n) {
		_lis(arr,n);
		return maxRef;
	}

	private static int _lis(int[] arr, int n) {
		if(n == 1){
			return 1;
		}
		
		int res,maxEndingHere = 1;
		
		for(int i = 1;i<n;i++){
			res = _lis(arr, i);
			if(arr[i-1]<arr[n-1] && maxEndingHere < res + 1){
				maxEndingHere = res + 1;
			}
		}
		
		if(maxEndingHere > maxRef){
			maxRef = maxEndingHere;
		}
		
		return maxEndingHere;
	}

}
