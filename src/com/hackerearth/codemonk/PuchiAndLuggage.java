package com.hackerearth.codemonk;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class PuchiAndLuggage {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int t = Integer.parseInt(bf.readLine().trim());
		int n;
		int[] arr, sorted;
		int result;

		for (int i = 0; i < t; i++) {
			n = Integer.parseInt(bf.readLine().trim());
			arr = new int[n];
			sorted = new int[n];
			for (int j = 0; j < n; j++) {
				arr[j] = Integer.parseInt(bf.readLine().trim());
				sorted[j] = arr[j];
			}

			Arrays.sort(sorted);

			for (int j = 0; j < n; j++) {
				result = binarySearch(sorted, 0, n - 1 - j, arr[j]);

				for (int k = result; k < n - 1 - j; k++) {
					sorted[k] = sorted[k + 1];
				}

				sorted[n - 1 - j] = Integer.MAX_VALUE;
				bw.write("" + result + " ");
			}

			bw.newLine();
		}
		bw.flush();
		bw.close();
		bf.close();
	}

	private static int binarySearch(int[] sorted, int start, int end, int ele) {
		int mid = (start + end) / 2;
		if (sorted[mid] == ele) {

			if (mid == 0) {
				return mid;
			}

			if (sorted[mid - 1] < ele) {
				return mid;
			}

		}

		if (ele > sorted[mid]) {
			return binarySearch(sorted, mid + 1, end, ele);
		} else {
			return binarySearch(sorted, start, mid - 1, ele);
		}
	}

}
