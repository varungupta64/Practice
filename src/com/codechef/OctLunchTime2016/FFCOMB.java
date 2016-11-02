package com.codechef.OctLunchTime2016;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class FFCOMB {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int t = Integer.parseInt(bf.readLine().trim());
		String[] input;
		int n, m;
		int[] c;

		for (int i = 0; i < t; i++) {

			input = bf.readLine().trim().split(" ");
			n = Integer.parseInt(input[0]);
			m = Integer.parseInt(input[1]);
			c = new int[n + 1];
			input = bf.readLine().trim().split(" ");
			for (int j = 1; j <= n; j++) {
				c[j] = Integer.parseInt(input[j - 1]);
			}

			for (int j = 0; j < m; j++) {

				input = bf.readLine().trim().split(" ");
				
			}

		}
	}
}
