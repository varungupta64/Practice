package com.gfg.practice;

public class MinSumThreeConsecutive {
	public static void main(String[] args) {
		int[] arr = new int[] {1, 2, 3, 6, 7, 1, 8, 6, 2,7, 7, 1};
		System.out.println(findMinSum(arr));
	}

	private static int findMinSum(int[] arr) {
		int sum;
		int minSum = Integer.MAX_VALUE;
		for (int i = arr.length - 1; i >= arr.length - 3 && i >= 0; i--) {
			sum = findMinSumUtil(arr, i);
			if (sum < minSum) {
				minSum = sum;
			}
		}
		return minSum;
	}

	private static int findMinSumUtil(int[] arr, int index) {
		if (index == 0 || index == 1 || index == 2) {
			return arr[index];
		}

		return arr[index] + Integer.min(findMinSumUtil(arr, index - 3),
				Integer.min(findMinSumUtil(arr, index - 1), findMinSumUtil(arr, index - 2)));
	}
}
