package com.HE.GameOfCodes;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class ACoinGame {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		byte t = Byte.parseByte(bf.readLine().trim());
		int r, x, n, y, one, two;
		String[] input;

		for (byte i = 0; i < t; i++) {
			r = Integer.parseInt(bf.readLine().trim());

			for (int j = 0; j < r; j++) {
				input = bf.readLine().trim().split(" ");
				x = Integer.parseInt(input[0]);
				n = Integer.parseInt(input[1]);
				y = Integer.parseInt(input[2]);

				one = n / 2;
				two = n - one;

				if (x == y) {
					bw.write("" + one);
				} else {
					bw.write("" + two);
				}
				bw.newLine();
			}
		}
		bw.flush();
		bw.close();
		bf.close();
	}
}
