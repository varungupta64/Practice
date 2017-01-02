package com.cc.NOV16;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class CPERM_Ed {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int t = Integer.parseInt(bf.readLine().trim());
		long n;
		long result;
		for (int i = 0; i < t; i++) {
			n = Long.parseLong(bf.readLine().trim());
			if (n == 1) {
				result = 0;
			} else {
				result = expo(2, n - 1);
				// result = power2(n - 1);
				if (result != 0) {
					result -= 2;
				}
			}

			bw.write("" + result);
			bw.newLine();
		}
		bw.flush();
		bw.close();
		bf.close();
	}

	private static long expo(long a, long b) {
		long result = 1;

		while (b > 0) {
			if (b % 2 == 1) {
				result = (result * a) % 1000000007;
			}
			a = (a * a) % 1000000007;
			b /= 2;
		}
		return result % 1000000007;
	}

	/*
	 * private static int power2(int n) { if (n == 0) { return 1; } else if (n %
	 * 2 == 0) { int H = power2(n / 2); return (H * H) % 1000000007; } else {
	 * int H = power2((n - 1) / 2); return (H * H * 2) % 1000000007; } }
	 */
}
