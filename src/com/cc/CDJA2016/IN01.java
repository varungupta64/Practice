package com.cc.CDJA2016;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class IN01 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] input;
		long l, r;
		long ele;
		int t = Integer.parseInt(bf.readLine().trim());

		for (int i = 0; i < t; i++) {
			input = bf.readLine().trim().split(" ");
			l = Long.parseLong(input[0]);
			r = Long.parseLong(input[1]);

			if (l > 9 || r < 9) {
				ele = 0;
			} else {
				ele = r - l + 1;
			}
			bw.write("" + ele);
			bw.newLine();
		}
		bw.flush();
		bw.close();
		bf.close();
	}

}
