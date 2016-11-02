package com.spoj.classical;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class COINS {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String input;
		int n;

		long[] dp = preprocess();

		while ((input = bf.readLine()) != null) {
			n = Integer.parseInt(input.trim());
			bw.write("" + getAnswer(n, dp));
			bw.newLine();
		}

		bw.flush();
		bw.close();
		bf.close();

	}

	private static long getAnswer(int n, long[] dp) {
		if (n <= 10000) {
			return dp[n];
		} else {
			return Long.max(n, getAnswer(n / 2, dp) + getAnswer(n / 3, dp) + getAnswer(n / 4, dp));
		}
	}

	private static long[] preprocess() {
		long[] dp = new long[1000001];
		long sum;
		dp[0] = 0;
		for (int i = 1; i <= 1000000; i++) {
			sum = dp[i / 2] + dp[i / 3] + dp[i / 4];
			if (i > sum) {
				dp[i] = i;
			} else {
				dp[i] = sum;
			}
		}
		return dp;
	}

}
