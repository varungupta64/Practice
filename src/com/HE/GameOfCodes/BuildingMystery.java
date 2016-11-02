package com.HE.GameOfCodes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BuildingMystery {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(bf.readLine().trim());
		String[] input = bf.readLine().trim().split(" ");
		int[] height = new int[n];
		long max = 0, inter;

		for (int i = 0; i < n; i++) {
			height[i] = Integer.parseInt(input[i]);
		}

		int[] min = new int[n];
		min[n - 1] = height[n - 1];

		for (int i = n - 2; i >= 0; i--) {
			min[i] = Integer.min(height[i], height[i + 1]);
		}

		for (int i = 0; i < n; i++) {
			inter = (n - i) * min[i];
			if (inter > max) {
				max = inter;
			}
		}
		
		System.out.println(max);
	}
}
