package com.codechef.AUG16;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class CHCHCL {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int t = Integer.parseInt(bf.readLine().trim());
		String[] input;
		int n, m, cut;

		for (int i = 0; i < t; i++) {
			input = bf.readLine().trim().split(" ");
			n = Integer.parseInt(input[0]);
			m = Integer.parseInt(input[1]);
			/*
			 * cut = n - 1 + m - 1; if (cut % 2 == 0) { bw.write("No"); } else {
			 * bw.write("Yes"); }
			 */
			cut = m * n;
			if (cut % 2 == 0) {
				bw.write("Yes");
			} else {
				bw.write("No");
			}
			bw.newLine();
		}
		bw.flush();
		bw.close();
		bf.close();
	}

}
