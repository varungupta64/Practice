package com.cc.OCT16;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class FENWITER {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int t = Integer.parseInt(bf.readLine().trim());
		String[] input;
		int n;
		char[] l1, l2, l3;
		long numOfZero;
		long numOfOne;
		long numOfOneInL2;

		for (int i = 0; i < t; i++) {

			input = bf.readLine().trim().split(" ");
			n = Integer.parseInt(input[3]);
			l1 = input[0].toCharArray();
			l2 = input[1].toCharArray();
			l3 = input[2].toCharArray();
			numOfOne = 0;
			numOfZero = 0;
			numOfOneInL2 = 0;

			for (int j = l3.length - 1; j >= 0; j--) {
				if (l3[j] == '0' && numOfZero < 1) {
					numOfZero++;
				}

				if (numOfZero > 0 && l3[j] == '1') {
					numOfOne++;
				}
			}

			for (int j = l2.length - 1; j >= 0; j--) {
				if (l2[j] == '0' && numOfZero < 1) {
					numOfZero++;
				}

				if (numOfZero > 0 && l2[j] == '1') {
					numOfOne = numOfOne + n;
				}

				if (numOfZero <= 0 && l2[j] == '1') {
					numOfOneInL2 = numOfOneInL2 + n - 1;
				}
			}

			if (numOfZero > 0) {
				numOfOne += numOfOneInL2;
			}

			for (int j = l1.length - 1; j >= 0; j--) {
				if (l1[j] == '0' && numOfZero < 1) {
					numOfZero++;
				}

				if (numOfZero > 0 && l1[j] == '1') {
					numOfOne++;
				}
			}

			// to include one of Tl
			numOfOne++;

			bw.write("" + numOfOne);
			bw.newLine();
		}

		bw.flush();
		bw.close();
		bf.close();

	}
}
