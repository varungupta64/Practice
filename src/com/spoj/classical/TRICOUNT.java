package com.spoj.classical;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TRICOUNT {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(bf.readLine().trim());
		for (int i = 0; i < t; i++) {
			long n = Long.parseLong(bf.readLine().trim());

			System.out.println((((n) * (n + 2) * (2 * n + 1)) / 8));

			/*
			 * long l = 1 + (n - 1) * 2; long sum = ((n * (1 + l)) / 2) + (((n -
			 * 1) * (1 + l - 2)) / 2); System.out.println(sum);
			 */
		}
	}
}
