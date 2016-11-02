package com.spoj.classical;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class AGGRCOW {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int t = Integer.parseInt(bf.readLine().trim());
		String[] input;
		int n, c;
		int[] x;

		for (int i = 0; i < t; i++) {
			input = bf.readLine().trim().split(" ");
			n = Integer.parseInt(input[0]);
			c = Integer.parseInt(input[1]);
			
			x = new int[n];
			for(int j=0;j<n;j++){
				x[j] = Integer.parseInt(bf.readLine().trim());
			}
			
			Arrays.sort(x);
			
			
		}

		bw.flush();
		bw.close();
		bf.close();
	}
}
