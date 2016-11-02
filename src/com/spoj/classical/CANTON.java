package com.spoj.classical;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class CANTON {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int t = Integer.parseInt(bf.readLine().trim());
		int term;
		int n;
		int diag;
		int r, c, a;
		int d = 1;

		for (int i = 0; i < t; i++) {

			term = Integer.parseInt(bf.readLine().trim());
			diag = (int) Math.ceil(((Math.ceil(Math.sqrt(1 + 4 * 2 * term))) - 1) / 2);
			a = (((diag - 1) * (diag)) / 2) + 1;
			n = term - a + 1;

			if (diag % 2 == 0) {
				r = 1 + n - 1;
				c = diag - n + 1;
			} else {
				r = diag - n + 1;
				c = 1 + n - 1;
			}
			bw.write("TERM " + term + " IS " + r + "/" + c);
			bw.newLine();

		}

		bw.flush();
		bw.close();
		bf.close();
	}
}
