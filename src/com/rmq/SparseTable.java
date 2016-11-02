package com.rmq;

import java.util.Arrays;

public class SparseTable {

	public static void main(String[] args) {
		int[] a = { 7, 2, 3, 0, 5, 10, 3, 12, 18 };
		int n = a.length;
		int k = (int) Math.floor(Math.log(n)/Math.log(2)) + 1;

		int[][] lookup = preprocess(a, n, k);
		print(lookup, n, k);
		System.out.println(RMQ(a, lookup, n, k, 1, 5));
		System.out.println(RMQ(a, lookup, n, k, 3, 5));
		System.out.println(RMQ(a, lookup, n, k, 0, 8));
		System.out.println(RMQ(a, lookup, n, k, 7, 8));
		System.out.println(RMQ(a, lookup, n, k, 8, 8));
		System.out.println(RMQ(a, lookup, n, k, 4, 6));
	}

	private static int RMQ(int[] a, int[][] lookup, int n, int k, int l, int r) {
		int len = r - l + 1;
		int pow = (int) Math.floor(Math.log(len)/Math.log(2));
		int leftover = len - (1 << pow);

		if(leftover>0){
			return a[(min(a[lookup[l][pow]],a[lookup[l+leftover][pow]],lookup[l][pow],lookup[l+leftover][pow]))];
		}
		return a[lookup[l][pow]];
	}

	private static void print(int[][] lookup, int n, int k) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < k; j++) {
				System.out.print(lookup[i][j] + " ");
			}
			System.out.println("");
		}
	}

	private static int[][] preprocess(int[] a, int n, int k) {
		int[][] lookup = new int[n][k];

		for (int i = 0; i < n; i++) {
			Arrays.fill(lookup[i], -1);
		}

		for (int i = 0; i < n; i++) {
			lookup[i][0] = i;
		}

		int size = 1;

		for (int j = 1; j < k; j++) {
			size = 1 << (j - 1);
			for (int i = 0; i <= n - (1 << j); i++) {
				lookup[i][j] = min(a[lookup[i][j - 1]], a[lookup[i + size][j - 1]], lookup[i][j - 1],
						lookup[i + size][j - 1]);
			}
		}
		return lookup;
	}

	private static int min(int i, int j, int lookup1, int lookup2) {
		return i < j ? lookup1 : lookup2;
	}

}
