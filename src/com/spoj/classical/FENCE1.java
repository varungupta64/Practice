package com.spoj.classical;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class FENCE1 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		double l;
		double a;

		while ((l = Double.parseDouble(bf.readLine().trim())) != 0) {

			a = Math.round((l * l * 100.0) / (2 * Math.PI)) / 100.00;
			bw.write("" + a);
			bw.newLine();

		}

		bw.flush();
		bw.close();
		bf.close();
	}
}
