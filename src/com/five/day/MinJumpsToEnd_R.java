package com.five.day;

public class MinJumpsToEnd_R {
	static int dest;

	public static void main(String[] args) {
		int[] arr = new int[] { 1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9 };
		dest = arr.length - 1;
		System.out.println(minJumps(0, arr[0], arr));
	}

	private static int minJumps(int start, int maxSteps, int[] arr) {
		if (start + maxSteps >= dest) {
			return 1;
		}

		if (maxSteps == 0) {
			return Integer.MAX_VALUE;
		}

		int res;
		int minHere = Integer.MAX_VALUE;

		for (int i = start + 1; i <= start + maxSteps; i++) {
			res = 1 + minJumps(i, arr[i], arr);
			if (res < minHere) {
				minHere = res;
			}
		}

		return minHere;
	}
}
