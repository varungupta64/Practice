package com.cf.round376div2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(bf.readLine().trim());
		String[] input = bf.readLine().trim().split(" ");
		int[] arr = new int[n];

		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(input[i]);
		}

		int diff;
		boolean isPossible = true;

		for (int i = 1; i < n; i++) {
			diff = Integer.min(arr[i], arr[i - 1]);

			arr[i] -= diff;
			arr[i - 1] -= diff;
		}

		for (int i = 0; i < n; i++) {
			if (arr[i] % 2 != 0) {
				isPossible = false;
				break;
			}
		}

		if (isPossible) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}
	}
}
