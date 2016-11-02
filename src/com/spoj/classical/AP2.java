package com.spoj.classical;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class AP2 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int t = Integer.parseInt(bf.readLine().trim());
		long sum = 0;
		String[] input;
		long a, b, c;
		long n;
		long d;

		for (int i = 0; i < t; i++) {

			input = bf.readLine().trim().split(" ");
			sum = Long.parseLong(input[2]);
			b = Long.parseLong(input[0]);
			c = Long.parseLong(input[1]);

			n = (2 * sum) / (b + c);

			d = (c - b) / (n - 3 - 2);

			a = b - 2 * d;

			bw.write("" + n);
			bw.newLine();
			for (long j = 0; j < n; j++) {
				bw.write((a + j * d) + " ");
			}
			bw.newLine();
		}

		bw.flush();
		bw.close();
		bf.close();
	}
}
