package com.cc.NOV16;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class ALEXTASK {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int t = Integer.parseInt(bf.readLine().trim());
		int n;
		long[] arr;
		String[] input;
		long min;

		for (int i = 0; i < t; i++) {
			n = Integer.parseInt(bf.readLine().trim());
			input = bf.readLine().trim().split(" ");
			arr = new long[n];
			for (int j = 0; j < n; j++) {
				arr[j] = Long.parseLong(input[j]);
			}
			min = Long.MAX_VALUE;
			for (int j = 0; j < n - 1; j++) {
				for (int k = j+1; k < n; k++) {
					min = Long.min(lcm(arr[j], arr[k]), min);
				}
			}
			bw.write("" + min);
			bw.newLine();
		}
		bw.flush();
		bw.close();
		bf.close();
	}

	private static long lcm(long a, long b) {
		return (a * b) / gcd(a, b);
	}

	private static long gcd(long a, long b) {
		if (a == 0) {
			return b;
		} else if (b == 0) {
			return a;
		} else {
			return gcd(b, a % b);
		}
	}
}
