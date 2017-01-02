package com.spoj.classical;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class TRT_DP {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(bf.readLine().trim());
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(bf.readLine().trim());
		}
		long[][] dp = new long[n][n];
		for (long[] a : dp) {
			Arrays.fill(a, -1);
		}
		System.out.println(max(0, n - 1, arr, dp, n - 1));
	}

	private static long max(int start, int end, int[] arr, long[][] dp, int n) {
		if (start > end) {
			return 0;
		}
		if (dp[start][end] != -1) {
			return dp[start][end];
		}
		int age = 1 + n - end + start;
		long l = 0;
		long r = 0;
		if (start < n) {
			dp[start + 1][end] = max(start + 1, end, arr, dp, n);
			l = dp[start + 1][end];
		}

		if (end > 0) {
			dp[start][end - 1] = max(start, end - 1, arr, dp, n);
			r = dp[start][end - 1];
		}

		long top = arr[start] * age + l;
		long bottom = arr[end] * age + r;
		return Long.max(top, bottom);
	}
}
