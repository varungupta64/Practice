package com.codechef.Codigo2016;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CDGO1601 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(bf.readLine().trim());
		int n, l, b;
		String[] input;
		int a;
		int inter;

		for (int i = 0; i < t; i++) {
			n = Integer.parseInt(bf.readLine().trim());
			input = bf.readLine().trim().split(" ");
			l = Integer.parseInt(input[0]);
			b = Integer.parseInt(input[1]);
			a = l * b;
			while (n > 0 && a > 0) {
				if (l > b) {
					inter = b * b;
					l = l - b;
				} else {
					inter = l * l;
					b = b - l;
				}
				a -= inter;
				n--;
			}

			if (a == 0) {
				System.out.println("No");
			} else {
				System.out.println("Yes " + a);
			}

		}
	}

}
