package com.spoj.classical;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class PIGBANK_R {
	static final int max = 100000000;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		final String staticText = "The minimum amount of money in the piggy-bank is ";
		int t = Integer.parseInt(bf.readLine().trim());
		String[] input;
		int e, f, n;
		int[] p;
		int[] w;
		int result;
		while (t-- > 0) {
			input = bf.readLine().trim().split(" ");
			e = Integer.parseInt(input[0]);
			f = Integer.parseInt(input[1]);
			n = Integer.parseInt(bf.readLine().trim());
			p = new int[n];
			w = new int[n];
			for (int i = 0; i < n; i++) {
				input = bf.readLine().trim().split(" ");
				p[i] = Integer.parseInt(input[0]);
				w[i] = Integer.parseInt(input[1]);
			}
			result = minMoney(f - e, p, w, 0, n - 1);
			if (result == max) {
				bw.write("This is impossible.");
			} else {
				bw.write(staticText + result + ".");
			}
			bw.newLine();
		}
		bw.flush();
		bw.close();
		bf.close();
	}

	private static int minMoney(int weight, int[] p, int[] w, int current, int end) {
		if (weight == 0) {
			return 0;
		}
		if (weight < 0) {
			return -1;
		}
		if (current > end) {
			return -1;
		}
		int incMoveAhead = minMoney(weight - w[current], p, w, current + 1, end);
		int incStay = minMoney(weight - w[current], p, w, current, end);
		int exc = minMoney(weight, p, w, current + 1, end);
		if (incMoveAhead == -1) {
			incMoveAhead = max;
		} else {
			incMoveAhead += p[current];
		}

		if (incStay == -1) {
			incStay = max;
		} else {
			incStay += p[current];
		}

		if (exc == -1) {
			exc = max;
		}
		return Integer.min(exc, Integer.min(incStay, incMoveAhead));
	}
}