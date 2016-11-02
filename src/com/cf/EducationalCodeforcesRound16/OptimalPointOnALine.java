package com.cf.EducationalCodeforcesRound16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class OptimalPointOnALine {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine().trim());
		String[] input = bf.readLine().trim().split(" ");

		if (n <= 2) {
			System.out.println(input[0]);
		} else {

			int[] arr = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(input[i]);
			}

			Arrays.sort(arr);

			int min = Integer.MAX_VALUE;
			int minx = arr[0];
			int sum;
			
			for (int i = 1; i < n - 1; i++) {
				sum = Math.abs(arr[i] - arr[0]) + Math.abs(arr[n-1] - arr[i]);
				if(sum < min){
					min = sum;
					minx = arr[i];
				}
			}
			
			System.out.println(minx);
		}
	}
}
