package com.cf.round376div2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_Ed {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		boolean isPossible = true;
		int n = Integer.parseInt(bf.readLine().trim());
		int[] arr = new int[n];
		String[] input = bf.readLine().trim().split(" ");

		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(input[i]);
		}

		arr[n - 1] = arr[n - 1] % 2;

		for (int i = n - 2; i >= 0; i--) {
			if (arr[i + 1] == 1) {

				if (arr[i] == 0) {
					isPossible = false;
					break;
				} else {
					arr[i + 1]--;
					arr[i]--;
				}

			}

			arr[i] = arr[i] % 2;

		}

		if (arr[0] == 1) {
			isPossible = false;
		}

		if (isPossible) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}

	}
}
