package com.codechef.july2016.ltime38;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class LUMPYBUS {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(bf.readLine().trim());
		int n;
		long p, q;
		String[] input;
		long[] arr;
		long result;

		for (int i = 0; i < t; i++) {

			result = 0;
			input = bf.readLine().trim().split(" ");
			n = Integer.parseInt(input[0]);
			p = Integer.parseInt(input[1]);
			q = Integer.parseInt(input[2]);

			input = bf.readLine().trim().split(" ");
			arr = new long[n];

			for (int j = 0; j < n; j++) {
				arr[j] = Long.parseLong(input[j]);
			}

			Arrays.sort(arr);

			long qnum;
			long num;

			for (int j = 0; j < n; j++) {

				num = arr[j];
				qnum = num / 2;

				if (q >= qnum) {
					q = q - qnum;
					num = num - 2 * qnum;
				}

				if (p >= num) {
					p = p - num;
					num = 0;
				}

				if (num == 0) {
					result++;
				}

				if (p == 0 && q == 0) {
					break;
				}

				if (num > p + q) {
					break;
				}

			}

			System.out.println(result);

		}

	}

}
