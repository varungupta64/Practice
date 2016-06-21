package com.practice;

public class MinCostPath_Recursive {
	public static void main(String[] args) {
		int[][] arr = new int[][] { { 1, 2, 3 }, { 4, 8, 2 }, { 1, 5, 3 } };
		int srcI = 0;
		int srcJ = 0;
		int i = 2;
		int j = 2;

		System.out.println(move(arr, srcI, srcJ, i, j));
	}

	public static int move(int[][] arr, int srcI, int srcJ, int destI, int destJ) {
		if (srcI == destI && srcJ == destJ) {
			return arr[srcI][srcJ];
		}

		int right = 999999999;
		int diag = 999999999;
		int down = 999999999;

		if (srcJ < destJ) {
			right = arr[srcI][srcJ] + move(arr, srcI, srcJ+1, destI, destJ);
		}		

		if (srcI < destI && srcJ < destJ) {
			diag = arr[srcI][srcJ] + move(arr, srcI+1, srcJ+1, destI, destJ);
		}

		if (srcI < destI) {
			down = arr[srcI][srcJ] + move(arr, srcI+1, srcJ, destI, destJ);
		}
		
		int sol = min(min(right,down),diag);
		return sol;
	}

	private static int min(int one, int two) {
		return one<two?one:two;
	}
}
