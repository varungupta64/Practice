package com.spoj.classical;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class FARIDA {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int t = Integer.parseInt(bf.readLine().trim());
		String[] input;
		int n;
		long[] arr;
		for (int i = 1; i <= t; i++) {
			n = Integer.parseInt(bf.readLine().trim());
			input = bf.readLine().trim().split(" ");
			arr = new long[n];
			for (int j = 0; j < n; j++) {
				arr[j] = Long.parseLong(input[j]);
			}

			if (n == 0) {
				bw.write("Case "+i+": 0");
			} else {
				bw.write("Case "+i+": "+ maxCoins(arr, n - 1));
			}
			bw.newLine();
		}
		bw.flush();
		bw.close();
		bf.close();
	}

	private static long maxCoins(long[] arr, int n) {
		long[] dp = new long[n + 1];
		dp[0] = arr[0];

		if (n >= 1) {
			dp[1] = Long.max(dp[0], arr[1]);
		}

		for (int i = 2; i <= n; i++) {
			dp[i] = Long.max(dp[i - 1], arr[i] + dp[i - 2]);
		}
		return dp[n];
	}
}
