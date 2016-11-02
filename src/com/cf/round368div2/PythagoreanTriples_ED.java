package com.cf.round368div2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PythagoreanTriples_ED {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		long a = Long.parseLong(bf.readLine().trim());

		if (a <= 2) {
			System.out.println(-1);
		} else {
			long b, c;
			if (a % 2 == 0) {

				b = (long) Math.pow(a / 2, 2) - 1;
				c = b + 2;

			} else {

				b = ((long) Math.pow(a, 2) - 1) / 2;
				c = b + 1;

			}

			System.out.println(b + " " + c);
		}
		bf.close();
	}

}
