package com.cf.round382div2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class D {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine().trim());

		if (isPrime(n)) {
			System.out.println(1);
		} else if (n % 2 == 0) {
			System.out.println(2);
		} else if (isPrime(n - 2)) {
			System.out.println(2);
		} else {
			System.out.println(3);
		}
	}

	private static boolean isPrime(int n) {
		boolean isPrime = true;
		for (int i = 2; i <= Math.sqrt(n); i++) {
			if (n % i == 0) {
				isPrime = false;
				break;
			}
		}
		return isPrime;
	}
}
