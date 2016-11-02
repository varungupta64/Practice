package com.cf.round370div2;

import java.io.*;
import java.util.*;

public class D_20559183 {
	static int k, m, n, M = 1000000007;
	static int[] ss, tt;
	static void update(int[] aa, int l, int r) {
		for (int i = l; i <= r; i++)
			ss[i] = ((i == l ? 0 : ss[i - 1]) + aa[i]) % M;
		for (int i = l; i <= r; i++)
			tt[i] = (int) (((i == l ? 0 : tt[i - 1]) + (long) i * aa[i]) % M);
	}
	static long query(int i, int l, int r, boolean left) {
		int j = left ? Math.max(i - 2 * k, l) : Math.min(i + 2 * k, r);
		long p, q;
		if (left) {
			p = j == 0 ? tt[i] : (tt[i] - tt[j - 1] + M) % M;
			q = j == 0 ? ss[i] : (ss[i] - ss[j - 1] + M) % M;
			int d = 2 * k + 1 - i;
			q = d >= 0 ? q * d % M : M - q * (-d) % M;
			return (p + q) % M;
		} else {
			p = i == 0 ? tt[j] : (tt[j] - tt[i - 1] + M) % M;
			q = i == 0 ? ss[j] : (ss[j] - ss[i - 1] + M) % M;
			int d = 2 * k + 1 + i;
			q = q * d % M;
			return (q - p + M) % M;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		int t = Integer.parseInt(st.nextToken());
		if (Math.abs(a - b) > 2 * k * t) {
			if (a > b) {
				long g = 1;
				for (int i = 0; i < t; i++)
					g = g * (2 * k + 1) % M * (2 * k + 1) % M;
				System.out.println(g);
			} else
				System.out.println(0);
			return;
		}
		m = 2 * k * t;
		n = m + m + 1;
		ss = new int[n];
		tt = new int[n];
		int[] dp = new int[n];
		dp[m] = 1;
		for (int s = 1; s <= t; s++) {
			int l = m - 2 * k * s;
			int r = m + 2 * k * s;
			update(dp, l, r);
			for (int i = l; i <= r; i++)
				if (i <= m)
					dp[i] = (int) ((query(i, l, r, true) + query(i, l, r, false) - (long) dp[i] * (2 * k + 1) % M + M) % M);
				else
					dp[i] = dp[m + m - i];
		}
		int sum = 0;
		for (int i = m - (a - b) + 1; i < n; i++)
				sum = (sum + dp[i]) % M;
		System.out.println(sum);
	}
}