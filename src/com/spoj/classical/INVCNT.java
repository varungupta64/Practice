package com.spoj.classical;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class INVCNT {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int t = Integer.parseInt(bf.readLine().trim());
		int n;
		int[] arr;

		for (int i = 0; i < t; i++) {

			bf.readLine();
			n = Integer.parseInt(bf.readLine().trim());
			arr = new int[n];

			for (int j = 0; j < n; j++) {
				arr[j] = Integer.parseInt(bf.readLine().trim());
			}

			int invCount = 0;

			arr = convertArray(arr, n);

			int[] BIT = new int[n + 1];
			for (int j = 1; j <= n; j++) {
				BIT[j] = 0;
			}

			for (int j = n - 1; j >= 0; j--) {
				// Get count of elements smaller than arr[i]
				invCount += getSum(BIT, arr[j] - 1);

				// Add current element to BIT
				updateBIT(BIT, n, arr[j], 1);
			}

			bw.write("" + invCount);
			bw.newLine();

		}

		bw.flush();
		bw.close();
		bf.close();
	}

	private static void updateBIT(int BITree[], int n, int index, int val) {
		// Traverse all ancestors and add 'val'
		while (index <= n) {
			// Add 'val' to current node of BI Tree
			BITree[index] += val;

			// Update index to that of parent in update View
			index += index & (-index);
		}
	}

	private static int getSum(int[] BITree, int index) {
		int sum = 0; // Initialize result

		// Traverse ancestors of BITree[index]
		while (index > 0) {
			// Add current element of BITree to sum
			sum += BITree[index];

			// Move index to parent node in getSum View
			index -= index & (-index);
		}
		return sum;
	}

	private static int[] convertArray(int[] arr, int n) {
		int[] copy = new int[n];

		for (int j = 0; j < n; j++) {
			copy[j] = arr[j];
		}

		Arrays.sort(copy);

		// convert array
		for (int j = 0; j < n; j++) {
			arr[j] = binarySearch(copy, n, arr[j]) + 1;
		}

		return arr;
	}

	private static int binarySearch(int[] copy, int n, int ele) {
		return binarySearchUtil(copy, 0, n - 1, ele);
	}

	private static int binarySearchUtil(int[] copy, int low, int high, int ele) {
		int mid = low + (high - low) / 2;
		if (copy[mid] == ele) {
			return mid;
		}

		if (ele > copy[mid]) {
			return binarySearchUtil(copy, mid + 1, high, ele);
		} else {
			return binarySearchUtil(copy, low, mid, ele);
		}
	}
}
