package com.cc.DEC16;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class KIRLAB_2 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int t = Integer.parseInt(bf.readLine().trim());
		int n;
		String[] input;
		int[] arr;

		for (int i = 0; i < t; i++) {
			n = Integer.parseInt(bf.readLine().trim());
			input = bf.readLine().trim().split(" ");
			arr = new int[n];
			for (int j = 0; j < n; j++) {
				arr[j] = Integer.parseInt(input[j]);
			}
			bw.write("" + maxRooms(n - 1, arr));
			bw.newLine();
		}
		bw.flush();
		bw.close();
		bf.close();
	}

	private static int maxRooms(int n, int[] arr) {
		int[][] k = new int[n + 1][n + 1];
		int gcd;
		int max = 0;

		for (int j = 1; j <= n; j++) {
			gcd = gcd(arr[0], arr[j]) > 1 ? 1 : 0;
			k[0][j] = gcd;
			if (k[0][j] > max) {
				max = k[0][j];
			}
		}

		for (int i = 1; i <= n; i++) {
			for (int j = i + 1; j <= n; j++) {
				gcd = gcd(arr[i], arr[j]) > 1 ? 1 : 0;
				k[i][j] = gcd;
				if (gcd > 0) {
					for (int l = 0; l < i; l++) {

						k[i][j] = Integer.max(k[i][j], gcd + k[i - l - 1][i]);

						if (k[i][j] > max) {
							max = k[i][j];
						}

					}
				}
			}
		}
		return max + 1;
	}

	private static int gcd(int a, int b) {
		if (a == 0) {
			return b;
		}
		return gcd(b % a, a);
	}
}
