package com.cc.DEC16;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class ANKTRAIN {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int t = Integer.parseInt(bf.readLine().trim());
		int n, mod;

		for (int i = 0; i < t; i++) {
			n = Integer.parseInt(bf.readLine().trim());
			mod = n % 8;

			switch (mod) {
			case 0:
				bw.write((n - 1) + "SL");
				break;
			case 1:
				bw.write((n + 3) + "LB");
				break;
			case 2:
				bw.write((n + 3) + "MB");
				break;
			case 3:
				bw.write((n + 3) + "UB");
				break;
			case 4:
				bw.write((n - 3) + "LB");
				break;
			case 5:
				bw.write((n - 3) + "MB");
				break;
			case 6:
				bw.write((n - 3) + "UB");
				break;
			case 7:
				bw.write((n + 1) + "SU");
				break;
			}
			bw.newLine();
		}
		bw.flush();
		bw.close();
		bf.close();
	}
}
