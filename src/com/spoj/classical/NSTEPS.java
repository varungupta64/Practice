package com.spoj.classical;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class NSTEPS {

	static int d = 4;
	static int a1 = 0;
	static int a2 = 1;
	static int a3 = 2;
	static int a4 = 3;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] input;
		int n = Integer.parseInt(bf.readLine().trim());
		int x, y;
		int result;

		for (int i = 0; i < n; i++) {

			input = bf.readLine().trim().split(" ");
			x = Integer.parseInt(input[0]);
			y = Integer.parseInt(input[1]);

			result = findNum(x, y);

			if (result == -1) {
				bw.write("No Number");
			} else {
				bw.write("" + result);
			}
			bw.newLine();

		}
		bw.flush();
		bw.close();
		bf.close();
	}

	private static int findNum(int x, int y) {
		int result = -1;

		if (x - y == 0) {

			if (x % 2 == 0) {
				result = a1 + (x / 2) * d;
			} else {
				result = a2 + ((x-1) / 2) * d;
			}

		} else if (x - y == 2) {

			if (y % 2 == 0) {
				result = a3 + (y / 2) * d;
			} else {
				result = a4 + ((y-1) / 2) * d;
			}

		}
		return result;
	}
}
