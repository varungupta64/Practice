package com.hackerearth.codemonk;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class ChanduAndHisGirlfriend {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int t, n;
		String[] input;
		int[] arr;

		t = Integer.parseInt(bf.readLine().trim());

		for (int i = 0; i < t; i++) {
			n = Integer.parseInt(bf.readLine().trim());
			input = bf.readLine().trim().split(" ");
			arr = new int[n];

			for (int j = 0; j < n; j++) {
				arr[j] = Integer.parseInt(input[j]);
			}

			sort(arr, 0, n - 1);
			for(int j=0;j<n;j++){
				bw.write(arr[j]+" ");
			}
			bw.newLine();
		}
		bw.flush();
		bw.close();
		bf.close();
	}

	private static void sort(int[] arr, int low, int high) {
		int partition;
		if (low < high) {
			partition = low + (high - low) / 2;
			sort(arr, low, partition);
			sort(arr, partition + 1, high);
			merge(arr, low, partition, high);
		}
	}

	private static void merge(int[] arr, int low, int partition, int high) {
		int firstIndex = 0;
		int secondIndex = 0;
		int oneSize = partition - low + 1;
		int twoSize = high - partition - 1 + 1;

		int[] one = new int[oneSize];
		int[] two = new int[twoSize];

		for (int i = 0; i < oneSize; i++) {
			one[i] = arr[low + i];
		}

		for (int i = 0; i < twoSize; i++) {
			two[i] = arr[partition + 1 + i];
		}

		while (firstIndex < oneSize && secondIndex < twoSize) {
			if (one[firstIndex] > two[secondIndex]) {
				arr[low] = one[firstIndex];
				firstIndex++;
			} else {
				arr[low] = two[secondIndex];
				secondIndex++;
			}
			low++;
		}

		while (firstIndex < oneSize) {
			arr[low++] = one[firstIndex++];
		}

		while (secondIndex < twoSize) {
			arr[low++] = two[secondIndex++];
		}
	}
}
