package com.codeforces.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RaisingBacteria {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine().trim());
		int inter;
		int ans = 0;
		while (n > 0) {
			inter = n & 1;
			if (inter == 1) {
				ans++;
			}
			n >>= 1;
		}
		System.out.println(ans);
	}
}
