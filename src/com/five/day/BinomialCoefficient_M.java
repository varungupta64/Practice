package com.five.day;

public class BinomialCoefficient_M {

	public static void main(String[] args) {
		int n = 5;
		int k = 2;

		int[][] result = new int[n+1][k+1];

		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= k; j++) {
				result[i][j] = -1;
			}
		}

		System.out.println(bc(n, k, result));
	}

	private static int bc(int n, int k, int[][] result) {
		if (k == 0 || k == n) {
			result[n][k] = 1;
			return result[n][k];
		}

		if (result[n - 1][k - 1] < 0) {
			result[n - 1][k - 1] = bc(n - 1, k - 1, result);
		}

		if (result[n - 1][k] < 0) {
			result[n - 1][k] = bc(n - 1, k, result);
		}

		result[n][k] = result[n - 1][k - 1] + result[n - 1][k];

		return result[n][k];
	}

}
