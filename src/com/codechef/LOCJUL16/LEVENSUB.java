package com.codechef.LOCJUL16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LEVENSUB {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(bf.readLine().trim());
		String[] input;
		int n;
		int[] arr;
		int beforeOdd;
		int odd;
		int afterOdd;

		for (int i = 0; i < t; i++) {
			beforeOdd = 0;
			odd = 0;
			afterOdd = 0;

			n = Integer.parseInt(bf.readLine().trim());
			input = bf.readLine().trim().split(" ");
			arr = new int[n];

			for (int j = 0; j < n; j++) {
				arr[j] = Integer.parseInt(input[j]);
			}

			for (int j = 0; j < n; j++) {
				if (arr[j] % 2 == 0) {

					if (odd > 0) {
						afterOdd += 1;
					} else {
						beforeOdd += 1;
					}

				} else {

					if (odd > 0) {
						odd+=1;
						beforeOdd += odd + afterOdd;
						odd = 0;
						afterOdd = 0;
					} else {
						odd = 1;
					}

				}
			}

			System.out.println(max(beforeOdd,afterOdd));
		}
		bf.close();
	}

	private static int max(int beforeOdd, int afterOdd) {
		return beforeOdd>afterOdd?beforeOdd:afterOdd;
	}
}
