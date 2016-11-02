package com.spoj.classical;

import java.util.Scanner;

public class HPYNOS {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Boolean[] lookup = new Boolean[811];
		lookup[0] = false;
		lookup[1] = true;

		int isHappyNum = isHappyNum(n, squareOfDigits(n), lookup, 0);

		System.out.println(isHappyNum);

	}

	private static int isHappyNum(int src, int n, Boolean[] lookup, int count) {
		if (n == 1) {
			return count + 1;
		} else if (lookup[n] == Boolean.FALSE) {
			return -1;
		} else {
			lookup[n] = false;
			return isHappyNum(src, squareOfDigits(n), lookup, count + 1);
		}
	}

	private static int squareOfDigits(int n) {
		if (n == 0) {
			return 0;
		}
		return (n % 10) * (n % 10) + squareOfDigits(n / 10);
	}
}
