package com.hr.codeOf22;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MakingPolygons {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine().trim());
		String[] input = bf.readLine().trim().split(" ");
		int[] arr = new int[n];
		int cuts = 0;
		int sum = 0;

		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(input[i]);
		}

		if (n == 1) {

			cuts = 2;

		} else if (n == 2) {

			cuts = 1;

		} else {

			Arrays.sort(arr);

			for (int i = 0; i < n - 1; i++) {
				sum += arr[i];
			}

			if (arr[n - 1] >= sum) {
				cuts = (int) Math.ceil(arr[n - 1] / sum);
			}

		}

		System.out.println(cuts);
	}

}
