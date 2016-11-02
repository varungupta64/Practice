package com.codechef.CYPH2016;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HITBIT {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(bf.readLine().trim());
		String[] input;
		long l;
		long r;
		long k;
		long num;
		long sum;
		long intermediate;

		for (int i = 0; i < t; i++) {
			sum = 0;
			input = bf.readLine().trim().split(" ");
			l = Long.parseLong(input[0]);
			r = Long.parseLong(input[1]);
			k = Long.parseLong(input[2]);

			num = 1 << (k - 1);

			for (long j = l; j <= r; j++) {
				intermediate = num & j;
				if (intermediate == num) {
					sum += j;
				}
			}
			
			System.out.println(sum);

		}
	}

}
