package com.codechef.JULY16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 
 * @author nagarro
 *
 *	Question interpretation wrong.
 */
public class WORKCHEF_FIRST {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int q = Integer.parseInt(bf.readLine().trim());

		for (int i = 0; i < q; i++) {

			String[] input = bf.readLine().trim().split(" ");
			long l = Long.parseLong(input[0]);
			long r = Long.parseLong(input[1]);
			int k = Integer.parseInt(input[2]);

			System.out.println(specialNumbers(l, r, k));
		}
	}

	private static long specialNumbers(long l, long r, int k) {
		long result = 0;
		long n = 1;
		int kval = 0;

		for (long i = l; i <= r; i = i + n) {
			kval = findValueAtKIndex(i, k);

			if (kval == 0) {
				continue;
			}

			n = getLoopIncrementSize(i, k);
			result += getMultiplesOfNInRange(kval, i, (i + n -1) < r ? (i + n - 1) : r);
		}

		return result;
	}

	private static long getLoopIncrementSize(long i, int k) {
		String num = String.valueOf(i).substring(k - 1);
		long result = (long) Math.pow(10, num.length() - 1);
		if (i % 10 != 0) {
			result = result - (i % result);
		}
		return result;
	}

	private static int getMultiplesOfNInRange(int n, double l, double r) {
		return (int) (Math.floor(r / n) - Math.ceil(l / n)) + 1;
	}

	private static int findValueAtKIndex(long i, int k) {
		String num = String.valueOf(i);
		if (num.length() < k) {
			return 0;
		}

		int div = Character.getNumericValue(num.charAt(k - 1));

		if (div == 0) {
			return 0;
		}

		return div;
	}
}