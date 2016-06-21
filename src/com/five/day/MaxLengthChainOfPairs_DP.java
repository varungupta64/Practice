package com.five.day;

public class MaxLengthChainOfPairs_DP {

	public static void main(String[] args) {
		int[][] arr = new int[][] { { 5, 24 }, { 39, 60 }, { 15, 28 }, { 27, 40 }, { 50, 90 } };
		sortByFirstElement(arr, 0, arr.length - 1);
		printArray(arr);

		System.out.println(lis(arr, arr.length));
	}

	private static int lis(int[][] arr, int n) {
		int[] lis = new int[n];
		int result = 0;
		
		for(int i=0;i<n;i++){
			lis[i] = 1;
		}
		
		for(int i=1;i<n;i++){
			for(int j=0;j<i;j++){
				if(arr[i][0]>arr[j][1] && lis[j]+1 > lis[i]){
					lis[i] = lis[j] + 1;
				}
			}
			if(lis[i]>result){
				result = lis[i];
			}
		}
		
		return result;
	}

	static void sortByFirstElement(int[][] arr, int low, int high) {
		if (low < high) {
			int pi = partition(arr, low, high);

			sortByFirstElement(arr, low, pi - 1);
			sortByFirstElement(arr, pi + 1, high);
		}
	}

	static int partition(int[][] arr, int low, int high) {
		int pivot = arr[high][0];
		int i = low - 1;

		for (int j = 0; j <= high - 1; j++) {
			if (arr[j][0] <= pivot) {
				i++;

				int[] temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}

		int[] temp = arr[i + 1];
		arr[i + 1] = arr[high];
		arr[high] = temp;

		return i + 1;
	}

	static void printArray(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println("");
		}
	}
}
