package com.spoj.classical;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class FASHION {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int t = Integer.parseInt(bf.readLine().trim());
		int[] m;
		int[] w;
		int n;
		String[] input;
		int prod;

		for (int i = 0; i < t; i++) {

			prod = 0;
			n = Integer.parseInt(bf.readLine().trim());
			input = bf.readLine().trim().split(" ");

			m = new int[n];
			w = new int[n];

			for (int j = 0; j < n; j++) {
				m[j] = Integer.parseInt(input[j]);
			}

			input = bf.readLine().trim().split(" ");

			for (int j = 0; j < n; j++) {
				w[j] = Integer.parseInt(input[j]);
			}

			Arrays.sort(m);
			Arrays.sort(w);
			
			for (int j = 0; j < n; j++) {
				prod += m[j] * w[j];
			}

			bw.write("" + prod);
			bw.newLine();
		}
		bw.flush();
		bw.close();
		bf.close();
	}

}
