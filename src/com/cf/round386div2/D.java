package com.cf.round386div2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class D {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String[] input = bf.readLine().trim().split(" ");
		int n = Integer.parseInt(input[0]);
		int k = Integer.parseInt(input[1]);
		int g = Integer.parseInt(input[2]);
		int b = Integer.parseInt(input[3]);

		if (k >= Integer.max(g, b)) {
			for (int i = 0; i < g; i++) {
				System.out.print("G");
			}
			for (int i = 0; i < b; i++) {
				System.out.print("B");
			}
		} else if (g == 0 || b == 0) {
			System.out.println("NO");
		} else {

			int g1 = g / k + g % k;
			int b1 = b / k + b % k;

			if (g1 > b1) {
				if (b >= g1 - 1) {
					for (int i = 0; i < g1; i++) {
						for (int j = 0; j < k; j++) {
							if (g > 0) {
								System.out.print("G");
							}
							g--;
						}
						if (i != g1 - 1) {
							System.out.print("B");
						}
					}
					for (int i = 0; i < b - (g1-1); i++) {
						System.out.print("B");
					}
				} else {
					System.out.println("NO");
				}
			} else if(g1 <= b1){
				if (g >= b1 - 1) {
					for (int i = 0; i < b1; i++) {
						for (int j = 0; j < k; j++) {
							if (b > 0) {
								System.out.print("B");
							}
							b--;
						}
						if (i != b1 - 1) {
							System.out.print("G");
						}
					}
					for (int i = 0; i < g - (b1-1); i++) {
						System.out.print("G");
					}
				} else {
					System.out.println("NO");
				}
			}

		}
		bf.close();
	}
}