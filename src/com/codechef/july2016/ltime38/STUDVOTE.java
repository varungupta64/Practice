package com.codechef.july2016.ltime38;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class STUDVOTE {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String[] input;
		int[] auxarr;
		int n;
		int k;
		int result;
		int t = Integer.parseInt(bf.readLine().trim());
		for (int i = 0; i < t; i++) {
			result = 0;
			input = bf.readLine().trim().split(" ");
			n = Integer.parseInt(input[0]);
			k = Integer.parseInt(input[1]);

			auxarr = new int[n + 1];

			input = bf.readLine().trim().split(" ");

			for (int j = 1; j <= n; j++) {
				if (Integer.parseInt(input[j - 1]) == j && auxarr[Integer.parseInt(input[j - 1])] >= k) {
					result--;
				}

				if (++auxarr[Integer.parseInt(input[j - 1])] == k) {
					if (Integer.parseInt(input[j - 1]) == j) {
						auxarr[Integer.parseInt(input[j - 1])] = -200;
					} else {
						result++;
					}
				}
			}

			System.out.println(result);

		}
	}

}
