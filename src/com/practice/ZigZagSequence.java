package com.practice;

public class ZigZagSequence {

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		int n = arr.length;
		int[][] zigzag = new int[n][2];
		for (int i = 0; i < zigzag.length; i++) {
			for (int j = 0; j < zigzag[0].length; j++) {
				zigzag[i][j] = 1;
			}
		}

		for (int i = 1; i < n; i++) {
			for (int j = 0; j < i; j++) {
				if (arr[i] > arr[j] && (zigzag[j][1] + 1) > zigzag[i][0]) {
					zigzag[i][0] = zigzag[j][1] + 1;
				}

				if (arr[i] < arr[j] && zigzag[j][0] + 1 > zigzag[i][0]) {
					zigzag[i][1] = zigzag[j][0] + 1;
				}
			}
		}

		System.out.println(max(zigzag[n - 1][0], zigzag[n - 1][1]));
	}

	private static int max(int i, int j) {
		return i > j ? i : j;
	}

}
