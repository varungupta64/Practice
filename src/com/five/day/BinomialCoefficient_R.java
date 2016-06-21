package com.five.day;

public class BinomialCoefficient_R {
	public static void main(String[] args) {
		int n = 5;
		int k = 2;

		System.out.println(bc(n, k));
	}

	private static int bc(int n, int k) {
		if (k == 0 || k == n) {
			return 1;
		}

		return bc(n - 1, k - 1) + bc(n - 1, k);
	}
}
