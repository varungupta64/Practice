package com.codechef.Codigo2016;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CDGO1602 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(bf.readLine().trim());
		int multan, fultan, mc, fc;
		int n;
		String[] input;
		int[] arr;
		int total;
		boolean proceed;
		int req;

		for (int i = 0; i < t; i++) {
			multan = 0;
			fultan = 0;
			mc = 0;
			fc = 0;
			total = 0;

			n = Integer.parseInt(bf.readLine().trim());

			input = bf.readLine().trim().split(" ");
			multan = Integer.parseInt(input[0]);
			fultan = Integer.parseInt(input[1]);

			arr = new int[n];
			input = bf.readLine().trim().split(" ");
			for (int j = 0; j < n; j++) {
				arr[j] = Integer.parseInt(input[j]);
			}

			for (int j = 0; j < n; j++) {
				proceed = false;
				if (arr[j] % multan == 0) {
					mc++;
					proceed = true;
				}

				if (arr[j] % fultan == 0) {
					fc++;
					proceed = true;
				}

				if (proceed) {
					total++;
				}
			}

			req = (int) Math.ceil(0.7 * n);
			if (total >= req) {
				System.out.println("Yes");
				if (mc > fc) {
					System.out.println("Multan");
				} else if (mc < fc) {
					System.out.println("Fultan");
				} else {
					System.out.println("Both");
				}
			} else {
				System.out.println("No");
			}
		}
		bf.close();
	}

}
