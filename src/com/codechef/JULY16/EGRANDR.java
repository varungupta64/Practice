package com.codechef.JULY16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class EGRANDR {

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
			Arrays.sort(arr);

			if (arr[0] == 2 || arr[n - 1] != 5) {
				System.out.println("No");
			} else {

				int a = indexOf(arr, 4);
				int b = indexOf(arr, 5);

				int threeNum = 0;
				int fiveNum = 0;

				if (a > -1) {
					threeNum = a;
				} else if (arr[0] == 3) {
					a = b;
					threeNum = b;
				}

				if (b > -1) {
					fiveNum = n - b;
				}

				if (fiveNum >= threeNum) {
					System.out.println("Yes");
				} else {
					System.out.println("No");
				}
			}

		}

	}

	private static int indexOf(int[] arr, int num) {
		int first = 0;
		int last = arr.length - 1;
		int middle = (first + last) / 2;

		while (first <= last) {
			if (arr[middle] == num && (middle - 1 < 0 || arr[middle - 1] != num)) {
				return middle;
			} else if (arr[middle] >= num) {
				last = middle - 1;
			} else {
				first = middle + 1;
			}

			middle = (first + last) / 2;
		}
		return -1;
	}

}
