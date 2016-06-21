package com.hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Candies {

	static int result;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine().trim());
		int[] ans = new int[n];
		int[] input = new int[n];
		input[0] = Integer.parseInt(bf.readLine().trim());
		ans[0] = 1;
		result = 1;

		for (int i = 1; i < n; i++) {
			input[i] = Integer.parseInt(bf.readLine().trim());
			candiesNum(i, input, ans);
		}

		System.out.println(result);
	}

	private static void candiesNum(int index, int[] input, int[] ans) {
		if (input[index] > input[index - 1]) {
			ans[index] = ans[index - 1] + 1;
			result += ans[index];
		} else if (input[index] == input[index - 1]) {
			ans[index] = 1;
			result += ans[index];
		} else {
			ans[index] = 1;
			result += ans[index];
			int i = index - 1;
			while ((i>=0) && (input[i+1] < input[i]) && (ans[i + 1] == ans[i])) {
				ans[i] = ans[i] + 1;
				result ++;
				i--;
			}
		}
	}

}