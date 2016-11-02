package com.spoj.classical;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class ABSYS {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int t = Integer.parseInt(bf.readLine().trim());
		String[] input;
		String a, b, c;

		for (int i = 0; i < t; i++) {

			bf.readLine();
			input = bf.readLine().trim().split("=");
			c = input[1];

			input = input[0].split("\\+");
			a = input[0];
			b = input[1];

			if (c.contains("machula")) {
				c = String.valueOf(Integer.parseInt(a.trim()) + Integer.parseInt(b.trim()));
			} else if (a.contains("machula")) {
				a = String.valueOf(Integer.parseInt(c.trim()) - Integer.parseInt(b.trim()));
			} else if (b.contains("machula")) {
				b = String.valueOf(Integer.parseInt(c.trim()) - Integer.parseInt(a.trim()));
			}
			
			bw.write(a+" + "+b+" = "+c);
			bw.newLine();

		}
		bw.flush();
		bw.close();
		bf.close();
	}

}
