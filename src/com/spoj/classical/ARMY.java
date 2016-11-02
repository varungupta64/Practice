package com.spoj.classical;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class ARMY {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int t = Integer.parseInt(bf.readLine().trim());
		String[] input;
		int ng, nm;
		int maxNg, maxNm;

		for (int i = 0; i < t; i++) {
			bf.readLine();
			input = bf.readLine().trim().split(" ");
			ng = Integer.parseInt(input[0]);
			nm = Integer.parseInt(input[1]);

			maxNg = 0;
			maxNm = 0;

			input = bf.readLine().trim().split(" ");
			for (int j = 0; j < ng; j++) {
				if (Integer.parseInt(input[j]) > maxNg) {
					maxNg = Integer.parseInt(input[j]);
				}
			}

			input = bf.readLine().trim().split(" ");
			for (int j = 0; j < nm; j++) {
				if (Integer.parseInt(input[j]) > maxNm) {
					maxNm = Integer.parseInt(input[j]);
				}
			}

			if (maxNm > maxNg) {
				bw.write("MechaGodzilla");
			} else {
				bw.write("Godzilla");
			}
			bw.newLine();

		}

		bw.flush();
		bw.close();
		bf.close();

	}

}
