package com.spoj.classical;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class ACODE {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		char[] arr;
		long[] dp;
		String input;
		boolean isValidOne;
		boolean isValidTwo;
		boolean isInvalid;

		while (!(input = bf.readLine().trim()).equals("0")) {

			isValidOne = false;
			isValidTwo = false;
			isInvalid = false;
			arr = input.toCharArray();
			dp = new long[arr.length + 1];
			dp[0] = 1;

			if (arr.length == 1) {
				bw.write("1");
				bw.newLine();
				continue;
			}

			if (Character.getNumericValue(arr[0]) >= 1 && Character.getNumericValue(arr[0]) <= 26) {
				dp[1] = dp[0];
			}

			for (int i = 1; i < arr.length; i++) {
				isValidOne = false;
				isValidTwo = false;

				if (Character.getNumericValue(arr[i]) >= 1 && Character.getNumericValue(arr[i]) <= 26) {
					dp[i + 1] = dp[i];
					isValidOne = true;
				}

				if (Integer.parseInt(String.valueOf(arr[i - 1]) + String.valueOf(arr[i])) >= 10
						&& Integer.parseInt(String.valueOf(arr[i - 1]) + String.valueOf(arr[i])) <= 26) {

					dp[i + 1] += dp[i - 1];
					isValidTwo = true;
				}

				if (isValidOne || isValidTwo) {
					// do nothing
				} else {
					isInvalid = true;
					break;
				}

			}

			if (isInvalid) {
				bw.write("0");
				bw.newLine();
			} else {
				bw.write("" + dp[arr.length]);
				bw.newLine();
			}

		}

		bw.flush();
		bw.close();
		bf.close();

	}

}
