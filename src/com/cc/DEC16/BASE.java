package com.cc.DEC16;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BASE {
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
		long pow = 1;
		while ((pow *= base) <= n) {
		}
		pow = pow / base;
		if (n - pow < pow) {
			return 1;
		}
		return 0;
	}
}
