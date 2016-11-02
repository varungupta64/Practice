package com.cc.OCT16;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class CHEFKEY {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int t = Integer.parseInt(bf.readLine().trim());
		String[] input;
		int n, m, c;
		int result;
		int y;

		for (int i = 0; i < t; i++) {

			input = bf.readLine().trim().split(" ");
			n = Integer.parseInt(input[0]);
			m = Integer.parseInt(input[1]);
			c = Integer.parseInt(input[2]);
			result = 0;

			for (int x = 1; x <= c; x++) {
				if (c % x == 0) {
					y = c / x;

					if (x <= n && y <= m) {
						result++;
					}

				}
			}

			bw.write("" + result);
			bw.newLine();

		}

		bw.flush();
		bw.close();
		bf.close();
	}
}
