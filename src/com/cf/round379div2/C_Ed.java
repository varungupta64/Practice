package com.cf.round379div2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class C_Ed {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String[] input;

		input = bf.readLine().trim().split(" ");
		long n = Long.parseLong(input[0]);
		int m = Integer.parseInt(input[1]);
		int k = Integer.parseInt(input[2]);

		input = bf.readLine().trim().split(" ");
		long x = Long.parseLong(input[0]);
		long s = Long.parseLong(input[1]);

		long[] arr1 = new long[m];
		long[] cost1 = new long[m];
		input = bf.readLine().trim().split(" ");
		for (int i = 0; i < m; i++) {
			arr1[i] = Long.parseLong(input[i]);
		}
		input = bf.readLine().trim().split(" ");
		for (int i = 0; i < m; i++) {
			cost1[i] = Long.parseLong(input[i]);
		}

		long[] arr2 = new long[k];
		long[] cost2 = new long[k];
		input = bf.readLine().trim().split(" ");
		for (int i = 0; i < k; i++) {
			arr2[i] = Long.parseLong(input[i]);
		}
		input = bf.readLine().trim().split(" ");
		for (int i = 0; i < k; i++) {
			cost2[i] = Long.parseLong(input[i]);
		}

		long min = n * x;
		long result;

		for (int i = 0; i < m; i++) {
			if (cost1[i] <= s) {
				result = arr1[i] * (n
						- ((binarySearch(cost2, s - cost1[i]) == -1) ? 0 : arr2[binarySearch(cost2, s - cost1[i])]));
				min = Long.min(result, min);
			} else {
				continue;
			}
		}
		
		for (int i = 0; i < k; i++) {
			if(cost2[i] <= s){
				result = (n-arr2[i])*x;
				min = Math.min(result, min);
			}
		}

		System.out.println(min);
	}

	private static int binarySearch(long[] cost2, long l) {
		return binarySearchUtil(cost2, l, 0, cost2.length - 1);
	}

	private static int binarySearchUtil(long[] cost2, long l, int start, int end) {
		while (start <= end) {
			int mid = (start + end) / 2;
			if (cost2[mid] <= l && (mid == end || cost2[mid + 1] > l)) {
				return mid;
			} else if (cost2[mid] <= l) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		return -1;
	}
}
