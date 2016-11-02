package com.five.day;

public class PermuteAllBacktracking {

	public static void main(String[] args) {
		char[] arr = "ABCD".toCharArray();
		permute(arr,0,arr.length-1);
	}

	private static void permute(char[] arr, int left, int right) {
		if(left==right){
			printArray(arr);
		}else{
			for(int i=left;i<=right;i++){
				swap(arr,left,i);
				permute(arr,left+1,right);
				swap(arr,i,left);
			}
		}
	}

	private static void swap(char[] arr, int left, int i) {
		char temp = arr[left];
		arr[left] = arr[i];
		arr[i] = temp;
	}

	private static void printArray(char[] arr) {
		for(int i=0;i<arr.length;i++){
			System.out.print(arr[i]);
		}
		System.out.println();
	}

}
