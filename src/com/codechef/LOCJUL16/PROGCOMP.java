package com.codechef.LOCJUL16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PROGCOMP {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// 97-122
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(bf.readLine().trim());
		int[] arr = new int[125];
		int[] fact = new int[100001];
		String input;
		int distinctNum;
		long result;

		fact[0] = 1;
		for (int i = 1; i <= 100000; i++) {
			fact[i] = i * fact[i - 1];
		}

		for (int i = 0; i < t; i++) {

			distinctNum = 0;
			result = 1;

			for (int j = 0; j < 125; j++) {
				arr[j] = 0;
			}

			input = bf.readLine().trim();

			for (int j = 0; j < input.length(); j++) {

				if (arr[input.charAt(j)] == 0) {
					arr[input.charAt(j)] = 1;
					distinctNum++;
				} else {
					arr[input.charAt(j)] += 1;
				}

			}

			result = fact(distinctNum);

			for (int j = 97; j <= 122; j++) {
				result *= fact[arr[j]];
			}

			System.out.println(result);

		}

	}

	private static long fact(int i) {
		if (i == 0 || i == 1) {
			return 1;
		}
		return i * fact(i - 1);
	}

}
