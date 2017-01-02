package com.spoj.classical;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class AMR10G {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int t = Integer.parseInt(bf.readLine().trim());
		int n, k;
		String[] input;
		int[] arr;
		int min;
		for (int i = 0; i < t; i++) {
			input = bf.readLine().trim().split(" ");
			n = Integer.parseInt(input[0]);
			k = Integer.parseInt(input[1]);
			input = bf.readLine().trim().split(" ");
			arr = new int[n];
			for (int j = 0; j < n; j++) {
				arr[j] = Integer.parseInt(input[j]);
			}
			Arrays.sort(arr);

			if (k == 1) {
				bw.write("0");
			} else {
				min = Integer.MAX_VALUE;
				for (int j = 0; j <= n - k; j++) {
					if((arr[j+k-1]-arr[j])<min){
						min = arr[j+k-1]-arr[j];
					}
				}
				bw.write(""+min);
			}
			bw.newLine();
		}
		bw.flush();
		bw.close();
		bf.close();
	}
}
