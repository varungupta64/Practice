package com.spoj.classical;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class HANGOVER {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		double c;
		double count;
		double sum;

		while ((c = Double.parseDouble(bf.readLine().trim())) != 0) {

			count = 2;
			sum = 0;

			while (true) {

				sum += 1 / count++;
				if (sum >= c) {
					break;
				}
			}

			bw.write(((int) count - 2) + " card(s)");
			bw.newLine();

		}
		bw.flush();
		bw.close();
		bf.close();
	}

}
