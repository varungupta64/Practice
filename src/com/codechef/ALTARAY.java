package com.codechef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ALTARAY {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(bf.readLine().trim());

		for (int i = 0; i < t; i++) {

			int n = Integer.parseInt(bf.readLine().trim());
			String[] input = bf.readLine().trim().split(" ");
			int[] arr = new int[n];
			for (int j = 0; j < n; j++) {
				arr[j] = Integer.parseInt(input[j]);
			}

			printArray(alternatingArray(arr, n));
			if (i != t - 1) {
				System.out.println("");
			}
		}
	}

	private static void printArray(int[] alternatingArray) {
		for (int i = 0; i < alternatingArray.length; i++) {
			System.out.print(alternatingArray[i] + " ");
		}
	}

	private static int[] alternatingArray(int[] arr, int n) {
		int[] result = new int[n];
		result[n - 1] = 1;
		for (int i = n - 2; i >= 0; i--) {
			if (arr[i] * arr[i + 1] < 1) {
				result[i] = 1 + result[i + 1];
			} else {
				result[i] = 1;
			}
		}

		return result;
	}

}
