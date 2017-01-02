package com.spoj.classical;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TRT_R {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(bf.readLine().trim());
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(bf.readLine().trim());
		}
		System.out.println(max(0, n-1, arr, 1));
	}

	private static int max(int start, int end, int[] arr, int age) {
		if (start > end) {
			return 0;
		}
		int top = arr[start]*age+max(start+1, end, arr, age+1);
		int bottom = arr[end]*age+max(start, end-1, arr, age+1);
		return Integer.max(top, bottom);
	}
}
