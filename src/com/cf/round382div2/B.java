package com.cf.round382div2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class B {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String[] input;
		input = bf.readLine().trim().split(" ");
		int n = Integer.parseInt(input[0]);
		double n1 = Double.parseDouble(input[1]);
		double n2 = Double.parseDouble(input[2]);
		double[] w = new double[n];
		input = bf.readLine().trim().split(" ");
		for (int i = 0; i < n; i++) {
			w[i] = Integer.parseInt(input[i]);
		}

		Arrays.sort(w);

		double one = Double.max(n1, n2);
		double two = Double.min(n1, n2);
		double sum1 = 0;
		double sum2 = 0;
		double result = 0;
		int index = n - 1;
		for (int i = 0; i < (int) two; i++) {
			sum2 += w[index];
			index--;
		}

		for (int i = 0; i < (int) one; i++) {
			sum1 += w[index];
			index--;
		}

		result = (sum2 / two) + (sum1 / one);
		
		System.out.println(result);
	}
}
