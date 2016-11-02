package com.cf.round370div2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class A_MemoryandCrow {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(bf.readLine().trim());
		int count = 0;
		String[] input = bf.readLine().trim().split(" ");
		int[] arr = new int[n];
		int[] result = new int[n];

		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(input[i]);
		}

		result[n - 1] = arr[n - 1];

		for (int i = n - 2; i >= 0; i--) {
			result[i] = arr[i] + arr[i + 1];
		}

		for (int i = 0; i < n; i++) {
			bw.write("" + result[i] + " ");
		}

		bw.flush();
		bw.close();
		bf.close();
	}

}
