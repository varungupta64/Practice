package com.codechef.july2016.ltime38;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CHEFCLOS {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(bf.readLine().trim());
		int n, k, l;
		String[] input;
		int[] arr;
		int[][] gcd = new int[28][28];

		for (int i = 1; i <= 27; i++) {
			gcd[1][i] = 1;
		}

		for (int i = 1; i <= 27; i++) {
			gcd[i][1] = 1;
		}

		for (int i = 2; i <= 27; i++) {
			for (int j = 2; j <= 27; j++) {
				if (gcd[j][i] != 0) {
					gcd[i][j] = gcd[j][i];
				} else {
					gcd[i][j] = gcd(i, j);
				}
			}
		}

		for (int i = 0; i < t; i++) {
			input = bf.readLine().trim().split(" ");
			n = Integer.parseInt(input[0]);
			k = Integer.parseInt(input[1]);
			l = Integer.parseInt(input[2]);

			input = bf.readLine().trim().split(" ");
			arr = new int[n];

			for (int j = 0; j < n; j++) {
				arr[j] = Integer.parseInt(input[j]);
			}

			for (int j = 0; j < n-1; j++) {
				for (int m = j + 1; m < n; m++) {
					if(gcd[j][m] <= l){
						
					}else{
						break;
					}
				}
			}
		}
	}

	private static int gcd(int i, int j) {
		if (j == 0) {
			return i;
		}
		return gcd(j, i % j);
	}

}
