package com.cf.round368div2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.BitSet;

public class PersistentBookcase_ED {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] input = bf.readLine().trim().split(" ");

		int n = Integer.parseInt(input[0]);
		int m = Integer.parseInt(input[1]);
		int q = Integer.parseInt(input[2]);

		int[][] history = new int[n + 1][q + 1];
		boolean[][] arr = new boolean[n + 1][m + 1];
		// here history[0][q] is used to store total

		int op, shelf;
		// assuming that element which is removed is present in shelf position
		for (int i = 1; i <= q; i++) {
			input = bf.readLine().trim().split(" ");
			op = Integer.parseInt(input[0]);
			shelf = Integer.parseInt(input[1]);

			switch (op) {
			case 1:
				initialize(history, i - 1, i, n);
				history[shelf][i] += 1;
				history[0][i] += 1;
				break;
			case 2:
				initialize(history, i - 1, i, n);
				history[shelf][i] -= 1;
				history[0][i] -= 1;
				break;
			case 3:
				initialize(history, i - 1, i, n);
				history[0][i] -= history[shelf][i];
				history[shelf][i] = m - history[shelf][i];
				history[0][i] += history[shelf][i];
				break;
			case 4:
				initialize(history, shelf, i, n);
				break;
			}
			bw.write("" + history[0][i]);
			bw.newLine();
		}

		bw.flush();
		bw.close();
		bf.close();
	}

	private static void initialize(int[][] history, int index, int current, int n) {
		for (int j = 0; j <= n; j++) {
			history[j][current] = history[j][index];
		}
	}
}