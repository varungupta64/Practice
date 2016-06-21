package com.codechef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ACBALL {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(bf.readLine().trim());

		for (int i = 0; i < t; i++) {

			char[] one = bf.readLine().trim().toCharArray();
			char[] two = bf.readLine().trim().toCharArray();

			int n = one.length;
			char[] three = new char[n];

			for (int j = 0; j < n; j++) {
				if (one[j] == two[j] && one[j] == 'B') {
					three[j] = 'W';
				} else if (one[j] == two[j] && one[j] == 'W') {
					three[j] = 'B';
				} else {
					three[j] = 'B';
				}
			}

			System.out.println(three);
		}
	}

}
