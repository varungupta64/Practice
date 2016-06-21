package com.five.day;

public class LCS_M {

	public static void main(String[] args) {
		String one = "ABCDEFGH";
		String two = "ABABEFGH";

		int[][] lcs = new int[one.length() + 1][two.length() + 1];

		for (int i = 0; i < one.length() + 1; i++) {
			for (int j = 0; j < two.length() + 1; j++) {
				lcs[i][j] = -1;
			}
		}

		System.out.println(lcs(one.toCharArray(), two.toCharArray(), one.length(), two.length(), lcs));
	}

	private static int lcs(char[] one, char[] two, int m, int n, int[][] lcs) {
		if (lcs[m][n] < 0) {
			if (m == 0 || n == 0) {
				lcs[m][n] = 0;
			} else if (one[m - 1] == two[n - 1]) {
				lcs[m][n] = 1 + lcs(one, two, m - 1, n - 1, lcs);
			} else {
				lcs[m][n] = max(lcs(one, two, m - 1, n, lcs), lcs(one, two, m, n - 1, lcs));
			}
		}
		return lcs[m][n];
	}

	private static int max(int lcs1, int lcs2) {
		return lcs1 > lcs2 ? lcs1 : lcs2;
	}

}
