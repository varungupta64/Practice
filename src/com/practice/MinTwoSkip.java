package com.practice;

public class MinTwoSkip {
	public static void main(String[] args) {
		int[] arr = new int[] { 10, 5, 7, 10 };
		System.out
				.println("Minimum time to finish tasks without skipping two consecutive : " + minTime(arr, arr.length));
	}

	private static int minTime(int[] arr, int n) {
		if (n <= 0) {
			return 0;
		}

		int incl = arr[0];
		int excl = 0;

		for (int i = 1; i < n; i++) {
			int newIncl = arr[i] + min(incl, excl);
			int newExcl = incl;

			incl = newIncl;
			excl = newExcl;
		}
		return min(incl, excl);
	}

	private static int min(int incl, int excl) {
		return incl < excl ? incl : excl;
	}
}
