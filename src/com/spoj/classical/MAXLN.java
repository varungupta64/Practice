package com.spoj.classical;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MAXLN {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int t = Integer.parseInt(bf.readLine().trim());
		double r;
		double s;

		for (int i = 1; i <= t; i++) {
			r = Double.parseDouble(bf.readLine().trim());
			s = 4 * r * r + 0.25;
			bw.write("Case " + i + ": " + s);
			bw.newLine();
		}

		bw.flush();
		bw.close();
		bf.close();
	}
}
