package com.rmq;

import java.util.Arrays;

public class LookupTable {
	public static void main(String[] args) {
		int[] a = { 7, 2, 3, 0, 5, 10, 3, 12, 18 };
		int n = a.length;
		int[][] lookup = new int[n][n];
		for (int i = 0; i < n; i++) {
			Arrays.fill(lookup[i], -1);
		}

		for (int i = 0; i < n; i++) {
			lookup[i][i] = i;
			for (int j = i + 1; j < n; j++) {
				if (a[j] < a[lookup[i][j - 1]]) {
					lookup[i][j] = j;
				} else {
					lookup[i][j] = lookup[i][j - 1];
				}
			}
		}

		// display
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(lookup[i][j] + " ");
			}
			System.out.println("");
		}
		
		//Minimum
		System.out.println(a[lookup[5][7]]);

	}
}
