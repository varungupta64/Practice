package com.five.day;

public class MinCostPath_R {
	public static void main(String[] args) {
		int cost[][] = { { 1, 2, 3 }, { 4, 8, 2 }, { 1, 5, 3 } };
		int m = cost.length;
		int n = cost[0].length;
		System.out.println(minCotsPath(cost, m-1, n-1));
	}

	private static int minCotsPath(int[][] cost, int m, int n) {
		if (m == 0 && n == 0) {
			return cost[0][0];
		} else {
			int i = Integer.MAX_VALUE;
			int j = Integer.MAX_VALUE;
			int k = Integer.MAX_VALUE;

			if (m > 0) {
				i = minCotsPath(cost, m - 1, n);
			}
			if (n > 0) {
				j = minCotsPath(cost, m, n - 1);
			}
			if (m > 0 && n > 0) {
				k = minCotsPath(cost, m - 1, n - 1);
			}
			return cost[m][n]+min(i, min(j, k));
		}
	}

	private static int min(int j, int k) {
		return j < k ? j : k;
	}
}
