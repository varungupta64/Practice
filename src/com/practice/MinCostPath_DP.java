package com.practice;

public class MinCostPath_DP {
	public static void main(String[] args) {
		int[][] arr = new int[][] { { 1, 2, 3 }, { 4, 8, 2 }, { 1, 5, 3 } };
		int srcI = 0;
		int srcJ = 0;
		int i = 2;
		int j = 2;

		System.out.println(move(arr, srcI, srcJ, i, j));
	}
	
	public static int move(int[][] arr, int srcI, int srcJ, int destI, int destJ) {
		return 0;
	}

	private static int min(int one, int two) {
		return one<two?one:two;
	}
}
