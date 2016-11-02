package com.codechef.JULY16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CHEFTET {

	static int max = 0;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(bf.readLine().trim());

		for (int i = 0; i < t; i++) {

			int n = Integer.parseInt(bf.readLine().trim());
			String[] bStr = bf.readLine().trim().split(" ");
			String[] aStr = bf.readLine().trim().split(" ");

			int[] b = new int[n];
			int[] a = new int[n];

			for (int j = 0; j < n; j++) {
				b[j] = Integer.parseInt(bStr[j]);
				a[j] = Integer.parseInt(aStr[j]);
			}

			if (n == 1) {
				System.out.println(a[0] + b[0]);
			} else {
				
				
			}

		}
	}

}
