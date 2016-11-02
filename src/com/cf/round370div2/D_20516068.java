package com.cf.round370div2;

import java.util.*;
import java.io.*;

public class D_20516068 {

	public static void main(String[] args) throws IOException {

		BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(f.readLine());

		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int t = Integer.parseInt(st.nextToken());

		f.close();

		long[][] dp = new long[2][k * t * 4 + 401];
		dp[0][k * t * 2 + 200] = 1;

		long mod = 1000000007;

		for (int i = 0; i < 2 * t; i++) {

			int cur = i % 2;
			int nxt = (i + 1) % 2;

			Arrays.fill(dp[nxt], 0);

			for (int j = 0; j <= k * t * 4 + 400; j++) {

				if (dp[cur][j] == 0) {
					continue;
				}

				dp[nxt][j + k + 1] -= dp[cur][j];
				if (dp[nxt][j + k + 1] < 0) {
					dp[nxt][j + k + 1] += mod;
				}
				if (dp[nxt][j + k + 1] >= mod) {
					dp[nxt][j + k + 1] -= mod;
				}

				dp[nxt][j - k] += dp[cur][j];
				if (dp[nxt][j - k] >= mod) {
					dp[nxt][j - k] -= mod;
				}

			}

			for (int j = 1; j <= k * t * 4 + 400; j++) {
				dp[nxt][j] += dp[nxt][j - 1];
				if (dp[nxt][j] >= mod) {
					dp[nxt][j] -= mod;
				}
			}

		}

		int ans = 0;
		for (int i = b - a + k * t * 2 + 201; i <= k * t * 4 + 400; i++) {
			ans += dp[0][i];
			if (ans >= mod) {
				ans -= mod;
			}
		}

		System.out.println(ans);

	}

}
