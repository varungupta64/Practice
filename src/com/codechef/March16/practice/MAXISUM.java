package com.codechef.March16.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MAXISUM {

	static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws NumberFormatException, IOException {
		int t = Integer.parseInt(getInput());

		for (int i = 0; i < t; i++) {

			String[] input = getInput().split(" ");
			int n = Integer.parseInt(input[0]);
			long k = Long.parseLong(input[1]);

			String[] input1 = getInput().split(" ");
			String[] input2 = getInput().split(" ");

			int[] a = new int[n];
			int[] b = new int[n];

			for (int j = 0; j < n; j++) {
				a[j] = Integer.parseInt(input1[j]);
			}

			for (int j = 0; j < n; j++) {
				b[j] = Integer.parseInt(input2[j]);
			}

			System.out.println(getMaxInteraction(a, b, n, k));
		}

	}

	private static long getMaxInteraction(int[] a, int[] b, int n, long k) {
		long sum = 0;
		for (int i = 0; i < n; i++) {
			sum += a[i] * b[i];
		}
		
		long maxSum = 0;
		long intermediateSum = 0;
		
		for(int i=0;i<n;i++){
			intermediateSum = sum + k*b[i];
			if(maxSum<intermediateSum){
				maxSum = intermediateSum;
			}
			intermediateSum = sum - k*b[i];
			if(maxSum<intermediateSum){
				maxSum = intermediateSum;
			}
		}
		return maxSum;
	}

	private static String getInput() throws IOException {
		return bf.readLine().trim();
	}
}
