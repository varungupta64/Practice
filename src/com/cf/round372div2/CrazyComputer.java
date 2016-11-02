package com.cf.round372div2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CrazyComputer {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String[] input = bf.readLine().trim().split(" ");
		int n = Integer.parseInt(input[0]);
		int c = Integer.parseInt(input[1]);

		int[] arr = new int[n];
		input = bf.readLine().trim().split(" ");
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(input[i]);
		}

		long count = 1;

		for (int i = 1; i < n; i++) {
			if (arr[i] - arr[i - 1] <= c) {
				count++;
			} else {
				count = 1;
			}
		}

		System.out.println(count);
	}

}
