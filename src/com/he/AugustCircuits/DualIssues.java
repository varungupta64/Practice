package com.he.AugustCircuits;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class DualIssues {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		boolean[] isPrime = preprocess();

		int t = Integer.parseInt(bf.readLine().trim());
		int n;
		String[] input;
		int[] arr;
		int result;

		for (int i = 0; i < t; i++) {

			n = Integer.parseInt(bf.readLine().trim());
			input = bf.readLine().trim().split(" ");
			arr = new int[n];

			for (int j = 0; j < n; j++) {
				arr[j] = Integer.parseInt(input[j]);
			}

			Arrays.sort(arr);

			result = -1;

			for (int j = n - 1; j >= 0; j--) {
				if (isPrime[arr[j]]) {
					result = arr[j] * arr[j];
					break;
				}
			}

			bw.write("" + result);
			bw.newLine();
		}
		bw.flush();
		bw.close();
		bf.close();

	}

	private static boolean[] preprocess() {
		boolean[] isPrime = new boolean[1001];
		boolean[] isVisited = new boolean[1001];
		isPrime[0] = false;
		isPrime[1] = false;
		isVisited[0] = true;
		isVisited[1] = true;

		int count = 1;

		for (int i = 2; i <= 1000; i++) {
			if (!isVisited[i]) {
				isVisited[i] = true;
				isPrime[i] = true;

				count = 2;
				while (count * i <= 1000) {
					isVisited[count * i] = true;
					count++;
				}

			}
		}

		return isPrime;
	}

}
