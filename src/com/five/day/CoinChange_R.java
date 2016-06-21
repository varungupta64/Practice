package com.five.day;

public class CoinChange_R {
	public static void main(String[] args) {
		int arr[] =  {2, 5, 3, 6};
		int m = arr.length;
		int n = 10;
		System.out.println(count(arr, m, n));
	}

	public static int count(int[] arr, int m, int n) {
		if(n==0){
			return 1;
		}else if(n < 0){
			return 0;
		}else if(m <= 0 && n>=1){
			return 0;
		}else{
			return count(arr, m-1, n)+count(arr, m, n-arr[m-1]);
		}
	}
}
