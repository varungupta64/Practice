package com.codechef.JULY16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CHEFTET_FIRST {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(bf.readLine().trim());

		for (int i = 0; i < t; i++) {

			int n = Integer.parseInt(bf.readLine().trim());
			String[] bStr = bf.readLine().trim().split(" ");
			String[] aStr = bf.readLine().trim().split(" ");

			int[] b = new int[n];
			int[] a = new int[n];

			for (int j = 0; j < n; j++) {
				b[j] = Integer.parseInt(bStr[j]);
				a[j] = Integer.parseInt(aStr[j]);
			}

			System.out.println(maxElementTetris(0, n - 1, b, a, 0, 0, b[0], n == 1 ? 0 : b[1]));

		}
	}

	private static int maxElementTetris(int start, int end, int[] b, int[] a, int prev, int carry, int up, int right) {
		int num = a[start] + carry;

		if (start == end && start == 0) {
			return num + up + right;
		}

		if (start == end) {
			if (prev == (num + up + right)) {
				return prev;
			} else {
				return -1;
			}
		}

		int w = -1;
		int x = -1;
		int y = -1;
		int z = -1;

		if (start > 0) {
			if (prev == num) {
				w = maxElementTetris(start + 1, end, b, a, num, up, right, start + 2 <= end ? b[start + 2] : 0);
			} else if (prev == num + up) {
				x = maxElementTetris(start + 1, end, b, a, num + up, 0, right, start + 2 <= end ? b[start + 2] : 0);
			} else if (prev == num + right) {
				y = maxElementTetris(start + 1, end, b, a, num + right, up, 0, start + 2 <= end ? b[start + 2] : 0);
			} else if (prev == num + up + right) {
				z = maxElementTetris(start + 1, end, b, a, num + up + right, 0, 0, start + 2 <= end ? b[start + 2] : 0);
			} else {
				return -1;
			}
		} else {
			// generate possible sequences
			w = maxElementTetris(start + 1, end, b, a, num, up, right, start + 2 <= end ? b[start + 2] : 0);
			x = maxElementTetris(start + 1, end, b, a, num + up, 0, right, start + 2 <= end ? b[start + 2] : 0);
			y = maxElementTetris(start + 1, end, b, a, num + right, up, 0, start + 2 <= end ? b[start + 2] : 0);
			z = maxElementTetris(start + 1, end, b, a, num + up + right, 0, 0, start + 2 <= end ? b[start + 2] : 0);
		}

		return max(z, max(y, max(w, x)));
	}

	private static int max(int a, int b) {
		return a > b ? a : b;
	}

}
