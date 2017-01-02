package com.cc.DEC16;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class KIRLAB {
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
			bw.write("" + maxRooms(0, n - 1, -1, arr));
			bw.newLine();
		}
		bw.flush();
		bw.close();
		bf.close();
	}

	private static int maxRooms(int start, int end, int current, int[] arr) {
		if (start > end) {
			return 0;
		}

		int inc;
		int exc;

		if (current == -1 || gcd(arr[start], arr[current]) > 1) {
			inc = 1 + maxRooms(start + 1, end, start, arr);
		} else {
			inc = -1;
		}
		
		exc = maxRooms(start + 1, end, current, arr);
		
		return Integer.max(inc, exc);
	}

	private static int gcd(int a, int b) {
		if (a == 0) {
			return b;
		}
		return gcd(b % a, a);
	}
}
