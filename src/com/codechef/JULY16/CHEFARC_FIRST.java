package com.codechef.JULY16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CHEFARC_FIRST {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(bf.readLine().trim());

		for (int i = 0; i < t; i++) {
			String[] input = bf.readLine().trim().split(" ");
			int n = Integer.parseInt(input[0]);
			int m = Integer.parseInt(input[1]);
			int k1 = Integer.parseInt(input[2]);
			int k2 = Integer.parseInt(input[3]);

			int[][] arr = new int[n][m];
			String[] inp;

			for (int j = 0; j < n; j++) {
				inp = bf.readLine().trim().split(" ");
				for (int k = 0; k < m; k++) {
					arr[j][k] = Integer.parseInt(inp[k]);
				}
			}

			int res = calculateRoboSteps(arr, 0, 0, 0, m - 1, k1, k2, n, m);

			if (res != Integer.MAX_VALUE && res % 2 != 0) {
				res = (res / 2) + 1;
			}
			
			if(res == Integer.MAX_VALUE){
				res = -1;
			}
			
			System.out.println(res);
		}

	}

	private static int calculateRoboSteps(int[][] arr, int oneI, int oneJ, int twoI, int twoJ, int k1, int k2, int n,
			int m) {
		if (oneI == twoI && oneJ == twoJ) {
			return 0;
		}

		arr[oneI][oneJ] = 1;

		int w = Integer.MAX_VALUE;
		int x = Integer.MAX_VALUE;
		int y = Integer.MAX_VALUE;
		int z = Integer.MAX_VALUE;

		int w1 = 0;
		int x1 = 0;
		int y1 = 0;
		int z1 = 0;

		// for second constraint use for loop

		// right
		if (oneJ + k1 < m && arr[oneI][oneJ + k1] != 1) {
			w1 = calculateRoboSteps(arr, oneI, oneJ + k1, twoI, twoJ, k1, k2, n, m);
			if (w1 == Integer.MAX_VALUE) {
				w = w1;
			} else {
				w = 1 + w1;
			}
		}

		// up
		if (oneI - k1 >= 0 && arr[oneI - k1][oneJ] != 1) {
			x1 = calculateRoboSteps(arr, oneI - k1, oneJ, twoI, twoJ, k1, k2, n, m);
			if (x1 == Integer.MAX_VALUE) {
				x = x1;
			} else {
				x = 1 + x1;
			}
		}

		// down
		if (oneI + k1 < n && arr[oneI + k1][oneJ] != 1) {
			y1 = calculateRoboSteps(arr, oneI + k1, oneJ, twoI, twoJ, k1, k2, n, m);
			if(y1 == Integer.MAX_VALUE){
				y = y1;
			}else{
				y = 1 + y1;
			}
		}

		// left
		if (oneJ - k1 >= 0 && arr[oneI][oneJ - k1] != 1) {
			z1 = calculateRoboSteps(arr, oneI, oneJ - k1, twoI, twoJ, k1, k2, n, m);
			if(z == Integer.MAX_VALUE){
				z = z1;
			}else{
				z = 1 + z1;
			}
		}

		// backTrack
		arr[oneI][oneJ] = 0;

		return min(z, min(y, min(w, x)));
	}

	private static int min(int a, int b) {
		return a < b ? a : b;
	}
}
