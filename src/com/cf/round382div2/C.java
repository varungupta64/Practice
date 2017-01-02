package com.cf.round382div2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class C {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		long n = Long.parseLong(bf.readLine().trim());
		int rem = 0;
		long count = 0;

		while (true) {
			rem = (int) n % 2;
			n /= 2;
			count = count + 1 + rem;
			if (n == 1) {
				break;
			}
		}

		System.out.println(count);
	}
}
