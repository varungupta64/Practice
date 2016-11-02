package com.cc.OCT16;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class FENWITER_FOUR {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int t = Integer.parseInt(bf.readLine().trim());
		String[] input;
		int n;
		char[] l3;
		long numOfZero;
		long numOfOne;
		StringBuffer s;

		for (int i = 0; i < t; i++) {

			s = new StringBuffer("");
			input = bf.readLine().trim().split(" ");
			n = Integer.parseInt(input[3]);			
			s.append(input[0]);
			for (int j = 0; j < n; j++) {
				s.append(input[1]);
			}
			s.append(input[2]);
			l3 = s.toString().toCharArray();
			numOfOne = 0;
			numOfZero = 0;

			for (int j = l3.length - 1; j >= 0; j--) {
				if (l3[j] == '0' && numOfZero < 1) {
					numOfZero++;
				}

				if (numOfZero > 0 && l3[j] == '1') {
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
