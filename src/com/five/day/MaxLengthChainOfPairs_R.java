package com.five.day;

public class MaxLengthChainOfPairs_R {

	static int maxRef = 1;

	public static void main(String[] args) {
		int[][] arr = new int[][] { { 5, 24 }, { 39, 60 }, { 15, 28 }, { 27, 40 }, { 50, 90 } };
		sortByFirstElement(arr, 0, arr.length - 1);
		printArray(arr);

		lis(arr, arr.length);
		System.out.println(maxRef);
	}

	private static int lis(int[][] arr, int n) {
		if (n == 1) {
			return 1;
		}

		int maxEndingHere = 1;
		int res;

		for (int i = 1; i < n; i++) {
			res = lis(arr, i);
			if (arr[n-1][0] > arr[i-1][1] && res + 1 > maxEndingHere) {
				maxEndingHere = 1 + res;
			}
		}

		if (maxEndingHere > maxRef) {
			maxRef = maxEndingHere;
		}
		return maxEndingHere;
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
