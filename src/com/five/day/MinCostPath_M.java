package com.five.day;

public class MinCostPath_M {

	public static void main(String[] args) {
		int cost[][] = { { 1, 2, 3 }, { 4, 1, 2 }, { 1, 5, 3 } };
		int m = cost.length;
		int n = cost[0].length;

		int[][] result = new int[m + 1][n + 1];		
		
		System.out.println(minCotsPath(cost, m - 1, n - 1, result));
	}

	private static int minCotsPath(int[][] cost, int m, int n, int[][] result) {
		if(result[m][n]==0){
			if (m == 0 && n == 0) {
				result[0][0] = cost[0][0];
				return result[0][0];
			} else {		
				int i = Integer.MAX_VALUE;
				int j = Integer.MAX_VALUE;
				int k = Integer.MAX_VALUE;
				
				if (m > 0) {
					result[m-1][n] = minCotsPath(cost, m - 1, n, result);
					i = result[m-1][n];
				}
				if (n > 0) {
					result[m][n-1] = minCotsPath(cost, m, n - 1, result);
					j = result[m][n-1];
				}
				if (m > 0 && n > 0) {
					result[m-1][n-1] = minCotsPath(cost, m - 1, n - 1, result);
					k = result[m-1][n-1];
				}
				result[m][n] =  cost[m][n]+min(i, min(j, k));
			}
		}
		return result[m][n];
	}

	private static int min(int j, int k) {
		return j < k ? j : k;
	}
}
