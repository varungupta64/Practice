package com.spoj.classical;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HOTELS {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String[] input = bf.readLine().trim().split(" ");
		int n = Integer.parseInt(input[0]);
		int m = Integer.parseInt(input[1]);
		int max = 0;
		int intermediate = 0;
		int start = 0;
		int end = 0;
		input = bf.readLine().trim().split(" ");
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(input[i]);
		}
		while (start < n && end < n) {
			if (arr[end] > m) {
				start = end + 1;
				end++;
				break;
			}
			intermediate += arr[end];
			while (intermediate > m && start < n) {
				intermediate -= arr[start];
				start++;
			}
			if (intermediate > max && intermediate <= m) {
				max = intermediate;
				if (max == m) {
					break;
				}
			}
			end++;
		}
		System.out.println(max);
	}
}
