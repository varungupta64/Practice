package com.five.day;

public class MinCostPath_DP {

	public static void main(String[] args) {
		int cost[][] = { { 1, 2, 3 }, { 4, 1, 2 }, { 1, 5, 3 } };
		int m = cost.length;
		int n = cost[0].length;

		int[][] result = new int[m][n];		
		
		System.out.println(minCotsPath(cost, m - 1, n - 1, result));
	}

	private static int minCotsPath(int[][] cost, int m, int n, int[][] result) {
		result[0][0] = cost[0][0];
		
		for(int i=1;i<=n;i++){
			result[i][0] = cost[i][0] + result[i-1][0];
		}
		
		for(int i=1;i<=n;i++){
			result[0][i] = cost[0][i] + result[0][i-1];
		}
		
		for(int i=1;i<=m;i++){
			for(int j=1;j<=n;j++){
				result[i][j] = cost[i][j] + min(result[i-1][j],min(result[i][j-1],result[i-1][j-1]));
			}
		}
		
		return result[m][n];
	}

	private static int min(int i, int j) {
		return i<j?i:j;
	}

}
