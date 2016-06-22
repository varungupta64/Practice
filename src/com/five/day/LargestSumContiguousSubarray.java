package com.five.day;

public class LargestSumContiguousSubarray {

	public static void main(String[] args) {
		int a[] = { -2, -3, 4, -1, -2, 1, 5, -3 };
		// System.out.println(largestSumNonContiguous(a, 0, a.length - 1));
		System.out.println(largestSumContiguous(a, 0, a.length - 1));
	}

	private static int largestSumContiguous(int[] a, int start, int end) {
		int max = 0;
		int sum = 0;
		int n = 0;
		for (int i = start; i <= end; i++) {
			if (((n + a[i]) >= a[i]) && ((n + a[i]) > 0)) {
				n = n + a[i];
				sum = n;
				if (sum > max) {
					max = sum;
				}
			} else {
				if (sum > max) {
					max = sum;
				}
				n = 0;
				sum = 0;
			}
		}
		return max;
	}

	private static int largestSumNonContiguous(int[] a, int start, int end) {
		if (start > end) {
			return 0;
		}

		int include = a[start];
		int exclude = 0;

		return Integer.max(include + largestSumNonContiguous(a, start + 1, end),
				exclude + largestSumNonContiguous(a, start + 1, end));
	}

}
