package com.spoj.classical;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TRT_Greedy {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(bf.readLine().trim());
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(bf.readLine().trim());
		}
		int age = 1;
		int i = 0;
		int j = n - 1;
		int max = 0;
		while (i <= j) {
			if (arr[i]*age > arr[j]*age) {
				max += age * arr[j];
				j--;
			} else {
				max += age * arr[i];
				i++;
			}
			age++;
		}
		System.out.println(max);
	}
}
