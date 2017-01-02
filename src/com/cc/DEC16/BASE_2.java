package com.cc.DEC16;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BASE_2 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int t = Integer.parseInt(bf.readLine().trim());
		long n;
		while (t-- > 0) {
			n = Long.parseLong(bf.readLine().trim());
			if (n == 0) {
				bw.write("0");
			} else if (n == 1) {
				bw.write("INFINITY");
			} else {
				bw.write("" + (1 + calculateBase(n)));
			}
			bw.newLine();
		}
		bw.flush();
		bw.close();
		bf.close();
	}

	private static long calculateBase(long n) {
		long result = 0;
		for (int i = 3; i <= n; i++) {
			result += isBasePossible(i, n);
		}
		return result;
	}

	private static long isBasePossible(int base, long n) {
		long pow1 = (long) Math.ceil(Math.log(n) / Math.log(base));
		long pow2 = (long) Math.pow(base, pow1);

		if (pow2 > n) {
			pow2 /= base;
		}

		if (n - pow2 < pow2) {
			return 1;
		}
		return 0;
	}
}
