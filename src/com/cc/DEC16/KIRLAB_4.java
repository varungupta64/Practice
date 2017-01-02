package com.cc.DEC16;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class KIRLAB_4 {
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
			if (n == 1) {
				bw.write("1");
			} else {
				bw.write("" + maxRooms(n - 1, arr));
			}
			bw.newLine();
		}
		bw.flush();
		bw.close();
		bf.close();
	}

	private static int maxRooms(int n, int[] arr) {
		int[] k = new int[n + 1];
		int gcd;

		for (int j = 1; j <= n; j++) {
			gcd = gcd(arr[0], arr[j]) > 1 ? 1 : 0;
			k[j] = gcd;
		}

		for (int i = 1; i <= n; i++) {
			for (int j = i + 1; j <= n; j++) {
				gcd = gcd(arr[i], arr[j]) > 1 ? 1 : 0;
				if (gcd > 0) {
					k[j] = Integer.max(gcd, Integer.max(k[j], gcd + k[i]));
				} else {
					k[j] = Integer.max(gcd, k[j]);
				}
			}
		}
		return max(k) + 1;
	}

	private static int max(int[] k) {
		int max = 0;
		for(int num : k){
			if(num > max){
				max = num;
			}
		}
		return max;
	}

	private static int gcd(int a, int b) {
		if (a == 0) {
			return b;
		}
		return gcd(b % a, a);
	}
}
