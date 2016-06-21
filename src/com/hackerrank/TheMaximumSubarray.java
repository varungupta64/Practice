package com.hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TheMaximumSubarray {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(bf.readLine().trim());

		for (int i = 0; i < t; i++) {

			long n = Long.parseLong(bf.readLine().trim());
			String[] input = bf.readLine().trim().split(" ");

			long incl = Integer.parseInt(input[0]);
			long excl = 0;

			System.out.println(max(incl + tms(1, input, n), tms(1, input, n)));

		}
	}

	private static long tms(int count, String[] input, long n) {
		if (count == n) {
			return 0;
		}

		long incl = Integer.parseInt(input[count]) + tms(count + 1, input, n);
		long excl = tms(count + 1, input, n);

		return max(incl, excl);
	}
	
	private static long tmsContiguos(int count, String[] input, long n) {
		if (count == n) {
			return 0;
		}

		long incl = Integer.parseInt(input[count]) + tms(count + 1, input, n);
		long excl = tms(count + 1, input, n);

		return max(incl, excl);
	}

	private static long max(long incl, long excl) {
		return incl > excl ? incl : excl;
	}

}
