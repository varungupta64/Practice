package com.spoj.classical;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class PARTY {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] input;
		int budget, n;
		int[] fee, fun;

		while (true) {
			input = bf.readLine().trim().split(" ");
			budget = Integer.parseInt(input[0]);
			n = Integer.parseInt(input[1]);
			fee = new int[n];
			fun = new int[n];

			if (budget == 0 && n == 0) {
				break;
			} else {
				for (int i = 0; i < n; i++) {
					input = bf.readLine().trim().split(" ");
					fee[i] = Integer.parseInt(input[0]);
					fun[i] = Integer.parseInt(input[1]);
				}
				System.out.println(maxFun(budget, 0, n - 1, fee, fun));
			}
			bf.readLine();
		}
	}

	private static int maxFun(int budget, int start, int end, int[] fee, int[] fun) {
		if (budget < 0) {
			return -fun[start-1];
		}
		
		if (budget == 0) {
			return 0;
		}

		if (start > end) {
			return 0;
		}

		int inc = fun[start] + maxFun(budget - fee[start], start + 1, end, fee, fun);
		int exc = maxFun(budget, start + 1, end, fee, fun);
		return Integer.max(inc, exc);
	}
}
