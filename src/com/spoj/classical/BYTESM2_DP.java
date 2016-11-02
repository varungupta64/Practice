package com.spoj.classical;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Scanner;

public class BYTESM2_DP {
	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int t = Integer.parseInt(sc.nextLine());
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

			int topLeft, top, topRight;
			for (int j = 1; j < h; j++) {
				for (int k = 0; k < w; k++) {
					topLeft = 0;
					top = 0;
					topRight = 0;

					if (k != 0) {
						topLeft = arr[j][k] + arr[j - 1][k - 1];
					}

					top = arr[j][k] + arr[j - 1][k];

					if (k != w - 1) {
						topRight = arr[j][k] + arr[j - 1][k + 1];
					}

					arr[j][k] = Integer.max(Integer.max(topLeft, top), topRight);
				}
			}
			
			Arrays.sort(arr[h-1]);

			bw.write("" + arr[h-1][w-1]);
			bw.newLine();

		}

		bw.flush();
		bw.close();
	}
}
