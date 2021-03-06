package com.cc.DEC16;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BASE_3 {
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
			} else if (n == 2) {
				bw.write("1");
			} else if (n == 3) {
				bw.write("2");
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
		long index;
		if (n % 2 == 0) {
			result = n / 2;
		} else {
			result = (n + 1) / 2;
		}
		//index = n - result;
		index = (long)Math.sqrt(n);
		for (int i = 3; i <= index; i++) {
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
			//System.out.println(n + " " + base);
			return 1;
		}
		return 0;
	}
}
