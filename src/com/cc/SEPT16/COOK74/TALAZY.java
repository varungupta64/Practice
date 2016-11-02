package com.cc.SEPT16.COOK74;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class TALAZY {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int t = Integer.parseInt(bf.readLine().trim());
		long n, b, m;
		String[] input;
		long result;
		long inter;

		for (int i = 0; i < t; i++) {
			result = 0;
			input = bf.readLine().trim().split(" ");
			n = Long.parseLong(input[0]);
			b = Long.parseLong(input[1]);
			m = Long.parseLong(input[2]);

			while (n > 0) {

				if (n % 2 == 0) {
					inter = n / 2;
				} else {
					inter = (n + 1) / 2;
				}

				result += inter * m + b;
				m = 2 * m;
				n = n - inter;

			}

			result -= b;
			bw.write("" + result);
			bw.newLine();
		}

		bw.flush();
		bw.close();
		bf.close();
	}

}
