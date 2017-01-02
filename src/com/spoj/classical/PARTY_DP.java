package com.spoj.classical;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class PARTY_DP {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] input;
		int budget, n;
		int[] fee, fun;
		int[][] arr;
		int ans = -1;

		while (true) {
			input = bf.readLine().trim().split(" ");
			budget = Integer.parseInt(input[0]);
			n = Integer.parseInt(input[1]);
			fee = new int[n];
			fun = new int[n];
			arr = new int[n + 1][budget + 1];

			if (budget == 0 && n == 0) {
				break;
			} else {
				for (int i = 0; i < n; i++) {
					input = bf.readLine().trim().split(" ");
					fee[i] = Integer.parseInt(input[0]);
					fun[i] = Integer.parseInt(input[1]);
				}

				for (int i = 0; i <= n; i++) {
					for (int j = 0; j <= budget; j++) {
						if (i == 0 || j == 0) {
							arr[i][j] = 0;
						} else if (fee[i - 1] <= j) {
							arr[i][j] = Integer.max(fun[i - 1] + arr[i - 1][j - fee[i - 1]], arr[i - 1][j]);
						} else {
							arr[i][j] = arr[i - 1][j];
						}
					}
				}
				
				ans = -1;
				for (int j = 0; j <= budget; j++) {
					if(arr[n][j] == arr[n][budget]){
						ans = j;
						break;
					}
				}

				bw.write(ans + " " +arr[n][budget]);
				bw.newLine();

			}

			bf.readLine();
		}
		
		bw.flush();
		bw.close();
		bf.close();
	}
}
