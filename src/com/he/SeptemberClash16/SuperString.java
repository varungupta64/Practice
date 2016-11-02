package com.he.SeptemberClash16;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class SuperString {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int t = Integer.parseInt(bf.readLine().trim());
		int n, k;
		String[] input;
		String inp;
		char[] arr;

		for (int i = 0; i < t; i++) {
			input = bf.readLine().trim().split(" ");
			n = Integer.parseInt(input[0]);
			k = Integer.parseInt(input[1]);
			inp = bf.readLine().trim();
			arr = inp.toCharArray();

			if (n == 1) {
				bw.write(arr[0] + "");
			} else if (k == 1) {
				String a = inp.substring(0, 1);
				for (int j = 1; j <= n - 1; j++) {
					if(a.compareTo(inp.substring(j)) >= 1){
						a = inp.substring(j);
					}
				}
				bw.write(a);
			} else {
				char min = 'z';
				for (int j = 0; j <= n - 1; j++) {
					if (arr[j] < min) {
						min = arr[j];
					}
				}
				bw.write("" + min);
			}
			bw.newLine();
		}
		bw.flush();
		bw.close();
		bf.close();
	}
}
