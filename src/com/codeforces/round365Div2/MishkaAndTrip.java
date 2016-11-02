package com.codeforces.round365Div2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MishkaAndTrip {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] input;
		int[] arr;
		int[] karr;
		int n, k, result;

		input = bf.readLine().trim().split(" ");
		n = Integer.parseInt(input[0]);
		k = Integer.parseInt(input[1]);

		input = bf.readLine().trim().split(" ");
		arr = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			arr[i] = Integer.parseInt(input[i - 1]);
		}

		result = arr[1] * arr[n];

		for (int i = 1; i < n; i++) {
			result += arr[i] * arr[i + 1];
		}

		input = bf.readLine().trim().split(" ");
		karr = new int[k + 1];

		for (int i = 1; i <= k; i++) {
			karr[i] = Integer.parseInt(input[i - 1]);
		}

		int index = n;
		int index1 = 1;
		for (int i = 1; i <= k; i++) {
			if (karr[i] == n) {
				index1 = 2;
			}
			for (int j = index1; j <= karr[i] - 2; j++) {
				result += arr[j] * arr[karr[i]];
			}
			if (karr[i] == 1) {
				index = n - 1;
			}
			for (int j = index; j >= karr[i] + 2; j--) {
				result += arr[j] * arr[karr[i]];
			}
		}

		for (int i = 1; i <= k - 1; i++) {
			result -= arr[karr[i]] * arr[karr[i + 1]];
		}

		System.out.println(result);
	}
}
