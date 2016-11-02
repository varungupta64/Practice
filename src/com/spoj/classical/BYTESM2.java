package com.spoj.classical;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class BYTESM2 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int t = Integer.parseInt(sc.nextLine().trim());
		String[] input;
		int h, w;
		int[][] arr;

		for (int i = 0; i < t; i++) {

			h = Integer.parseInt(sc.next().trim());
			w = Integer.parseInt(sc.next().trim());

			arr = new int[h][w];

			for (int j = 0; j < h; j++) {				
				for (int k = 0; k < w; k++) {
					arr[j][k] = Integer.parseInt(sc.next().trim());
				}
			}

			int maxStones = 0;

			for (int j = 0; j < w; j++) {
				maxStones = Integer.max(maxStones, findMaxStones(arr, 0, j, h - 1, w - 1, arr[0][j]));
			}

			bw.write("" + maxStones);
			bw.newLine();

		}

		bw.flush();
		bw.close();
	}

	private static int findMaxStones(int[][] arr, int row, int col, int h, int w, int initial) {
		if (row == h) {
			return initial;
		}

		int downLeft = 0;
		int down = 0;
		int downRight = 0;

		if (col != 0) {
			downLeft = findMaxStones(arr, row + 1, col - 1, h, w, initial + arr[row + 1][col - 1]);
		}

		down = findMaxStones(arr, row + 1, col, h, w, initial + arr[row + 1][col]);

		if (col != w) {
			downRight = findMaxStones(arr, row + 1, col + 1, h, w, initial + arr[row + 1][col + 1]);
		}

		return Integer.max(downLeft, Integer.max(down, downRight));
	}
}
