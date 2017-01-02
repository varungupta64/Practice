package com.cf.round386div2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine().trim());
		char[] s = bf.readLine().trim().toCharArray();
		char[] r = new char[n];

		int count = 0;
		int i = n - 1;
		int j = 0;
		for (int k = n - 1; k >= 0; k--) {
			if (count % 2 == 0) {
				r[i] = s[k];
				i--;
			} else {
				r[j] = s[k];
				j++;
			}
			count++;
		}
		System.out.println(String.valueOf(r));
		bf.close();
	}
}