package com.codeforces.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FedorAndNewGame {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String[] input;
		input = bf.readLine().trim().split(" ");
		int n = Integer.parseInt(input[0]);
		int m = Integer.parseInt(input[1]);
		int k = Integer.parseInt(input[2]);
		int ans = 0;
		int inter;
		int differ;
		boolean isFriend;
		int bit;

		int[] arr = new int[m + 1];
		for (int i = 0; i <= m; i++) {
			arr[i] = Integer.parseInt(bf.readLine().trim());
		}

		for (int i = 0; i < m; i++) {
			isFriend = true;
			differ = 0;
			inter = arr[i] ^ arr[m];
			while (inter != 0) {
				bit = inter & 1;
				if (bit == 1) {
					differ++;
				}
				inter >>= 1;
				if (differ > k) {
					isFriend = false;
					break;
				}
			}

			if (isFriend) {
				ans++;
			}
		}

		System.out.println(ans);
	}
}
