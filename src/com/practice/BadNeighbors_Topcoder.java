package com.practice;

public class BadNeighbors_Topcoder {
	public static void main(String[] args) {
		int[] arr = { 94, 40, 49, 65, 21, 21, 106, 80, 92, 81, 679, 4, 61,  
				  6, 237, 12, 72, 74, 29, 95, 265, 35, 47, 1, 61, 397,
				  52, 72, 37, 51, 1, 81, 45, 435, 7, 36, 57, 86, 81, 72 };
		int n = arr.length;

		System.out.println(max(maxDonation(arr, n, 0), maxDonation(arr, n, 1)));
	}

	private static int maxDonation(int[] arr, int n, int start) {
		int[] sol = new int[n - 1];
		if (n - 1 == 1) {
			return arr[start];
		}
		sol[0] = arr[start];
		sol[1] = arr[start + 1];
		if (n - 1 > 2) {
			sol[2] = sol[0] + arr[2];
		}
		for (int i = 3; i < n - 1; i++) {
			sol[i] = max(arr[i] + sol[i - 2], arr[i] + sol[i - 3]);
		}
		return max(sol[n - 2], sol[n - 3]);
	}

	private static int max(int i, int j) {
		return i > j ? i : j;
	}
}
