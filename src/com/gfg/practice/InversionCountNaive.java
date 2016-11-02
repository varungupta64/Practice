package com.gfg.practice;

public class InversionCountNaive {

	public static void main(String[] args) {
		int[] arr = {12, 11, 13, 5, 6, 7};
		System.out.println(getInversionCount(arr));
	}

	private static int getInversionCount(int[] arr) {
		int inv = 0;
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if(arr[i] > arr[j]){
					inv++;
				}
			}
		}
		return inv;
	}

}
