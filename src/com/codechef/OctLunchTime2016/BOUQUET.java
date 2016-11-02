package com.codechef.OctLunchTime2016;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOUQUET {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int t = Integer.parseInt(bf.readLine().trim());
		long[] m = new long[3];
		long[] o = new long[3];
		long[] p = new long[3];
		String[] input;
		long max;
		long one, two, three;
		long four, five, six;

		for (int i = 0; i < t; i++) {

			input = bf.readLine().trim().split(" ");
			for (int j = 0; j <= 2; j++) {
				m[j] = Long.parseLong(input[j]);
			}

			input = bf.readLine().trim().split(" ");
			for (int j = 0; j <= 2; j++) {
				o[j] = Long.parseLong(input[j]);
			}

			input = bf.readLine().trim().split(" ");
			for (int j = 0; j <= 2; j++) {
				p[j] = Long.parseLong(input[j]);
			}

			one = m[0] + m[1] + m[2];
			if (one % 2 == 0 && one != 0) {
				one--;
			}

			two = o[0] + o[1] + o[2];
			if (two % 2 == 0 && two != 0) {
				two--;
			}

			three = p[0] + p[1] + p[2];
			if (three % 2 == 0 && three != 0) {
				three--;
			}

			four = m[0] + o[0] + p[0];
			if (four % 2 == 0 && four != 0) {
				four--;
			}

			five = m[1] + o[1] + p[1];
			if (five % 2 == 0 && five != 0) {
				five--;
			}

			six = m[2] + o[2] + p[2];
			if (six % 2 == 0 && six != 0) {
				six--;
			}

			max = Long.max(six, Long.max(five, Long.max(four, Long.max(three, Long.max(one, two)))));
			
			bw.write(""+max);
			bw.newLine();

		}
		
		bw.flush();
		bw.close();
		bf.close();
	}

}
